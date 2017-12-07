package com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit;

import android.net.ParseException;
import android.util.Log;

import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.adapter.rxjava2.HttpException;


/**
 * Created by ljh on 17-10-20.
 */

public class ExceptionHandler {

    private static String TAG = "Exception";
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static void handleException(Throwable e) {
        ResponeThrowable ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ResponeThrowable(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }

            Log.e(TAG, ex.message);
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new ResponeThrowable(resultException, resultException.code);
            ex.message = resultException.message;
            Log.e(TAG, ex.message);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ResponeThrowable(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";
            Log.e(TAG, ex.message);
        } else if (e instanceof ConnectException) {
            ex = new ResponeThrowable(e, ERROR.NETWORD_ERROR);
            ex.message = "连接失败";
            Log.e(TAG, ex.message);
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ResponeThrowable(e, ERROR.SSL_ERROR);
            ex.message = "证书验证失败";
            Log.e(TAG, ex.message);
        } else if (e instanceof ConnectTimeoutException){
            ex = new ResponeThrowable(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            Log.e(TAG, ex.message);
        } else if (e instanceof java.net.SocketTimeoutException) {
            ex = new ResponeThrowable(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            Log.e(TAG, ex.message);
        }
        else {
            ex = new ResponeThrowable(e, ERROR.UNKNOWN);
            ex.message = "未知错误";
            Log.e(TAG, ex.message);
        }
    }


    /**
     * 约定异常
     */
    class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = 1006;
    }

    public static class ResponeThrowable extends Exception {
        public int code;
        public String message;

        public ResponeThrowable(Throwable throwable, int code) {
            super(throwable);
            this.code = code;

        }
    }

    public class ServerException extends RuntimeException {
        public int code;
        public String message;
    }
}
package com.leedopoem.ljh.friendlyteacher.login;

import com.leedopoem.ljh.friendlyteacher.base.BasePresenter;
import com.leedopoem.ljh.friendlyteacher.base.BaseView;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class LoginContract {
    interface View extends BaseView<LoginContract.Presenter> {
        void showProgressBar();
        void loginError();
        void loginSuccess();
    }

    interface Presenter extends BasePresenter {
        void login(String uid, String passward);
    }
}

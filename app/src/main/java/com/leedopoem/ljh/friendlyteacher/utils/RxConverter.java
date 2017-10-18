package com.leedopoem.ljh.friendlyteacher.utils;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ljh on 17-9-28.
 */

public class RxConverter {
    public static <T> Observable convert(T o){
        return Observable.just(o).subscribeOn(Schedulers.io());
    }
}

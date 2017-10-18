package com.leedopoem.ljh.friendlyteacher.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by ljh on 17-10-17.
 */

public class ActivityUtils {
    public static void addFragmentToActivity(FragmentManager fragmentManager,Fragment fragment,
                                             int fragmentId){
        if ((fragmentManager==null)||(fragment==null)) throw new RuntimeException();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentId,fragment);
        fragmentTransaction.commit();
    }
}

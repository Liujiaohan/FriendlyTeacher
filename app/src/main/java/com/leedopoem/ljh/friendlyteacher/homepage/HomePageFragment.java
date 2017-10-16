package com.leedopoem.ljh.friendlyteacher.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.leedopoem.ljh.friendlyteacher.entity.Lecture;

import java.util.List;

/**
 * Created by ljh on 17-10-3.
 */

public class HomePageFragment extends Fragment implements HomePageContract.View {
    private static final String FRAGMENT_ID="FRAGMENT_ID";
    private HomePageContract.Presenter mPresenter;


    public static HomePageFragment newInstance(String fragmentId){
        Bundle argument=new Bundle();
        argument.putString(FRAGMENT_ID,fragmentId);
        HomePageFragment fragment=new HomePageFragment();
        fragment.setArguments(argument);
        return fragment;
    }

    @Override
    public void setPresenter(HomePageContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void showLecturesMissing() {
    }

    @Override
    public void showLectures(List<Lecture> lectures) {
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }
}

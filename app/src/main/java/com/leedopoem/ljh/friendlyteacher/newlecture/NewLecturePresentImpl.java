package com.leedopoem.ljh.friendlyteacher.newlecture;

import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class NewLecturePresentImpl implements NewLectureContract.Presenter {

    private NewLectureContract.View mView;

    public NewLecturePresentImpl(NewLectureContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void publishLecture() {
        Lecture newLecture = mView.getContentLecture();

    }

    @Override
    public void confirmBack() {

    }
}

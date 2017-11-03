package com.leedopoem.ljh.friendlyteacher.page.newlecture;

import com.leedopoem.ljh.friendlyteacher.base.BasePresenter;
import com.leedopoem.ljh.friendlyteacher.base.BaseView;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class NewLectureContract {
    interface View extends BaseView<NewLectureContract.Presenter> {
        void showProgressbar();
        void confirmBack();
        Lecture getContentLecture();
}

    interface Presenter extends BasePresenter {
        void publishLecture();
        void confirmBack();
    }
}
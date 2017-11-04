package com.leedopoem.ljh.friendlyteacher.homepage.fragment.recommend;

import com.leedopoem.ljh.friendlyteacher.base.BasePresenter;
import com.leedopoem.ljh.friendlyteacher.base.BaseView;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

import java.util.List;

/**
 * Created by ljh on 17-10-3.
 */

public class RecommendContract {
    interface View extends BaseView<Presenter>{
        void showLecturesMissing();
        void showLectures(List<Lecture> lectures);
    }

    interface Presenter extends BasePresenter{
        void loadRecommendLecture();
        void addNewLecture();
        void openLectureDetails(Lecture lecture);
    }
}

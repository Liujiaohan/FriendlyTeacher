package com.leedopoem.ljh.friendlyteacher.homepage;

import com.leedopoem.ljh.friendlyteacher.base.BasePresenter;
import com.leedopoem.ljh.friendlyteacher.base.BaseView;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.enums.LectureType;

import java.util.List;

/**
 * Created by ljh on 17-10-3.
 */

public class HomePageContract {
    interface View extends BaseView<Presenter>{
        void showLecturesMissing();
        void showLectures(List<Lecture> lectures);
    }

    interface Presenter extends BasePresenter{
        void loadRecommendLecture();
        void loadLectureByType(LectureType lectureType);
        void publishLecture(Lecture lecture);
        void communicateModule();
        void userInformationCenter();
    }
}

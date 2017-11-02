package com.leedopoem.ljh.friendlyteacher.homepage.fragment.personal;

import com.leedopoem.ljh.friendlyteacher.base.BasePresenter;
import com.leedopoem.ljh.friendlyteacher.base.BaseView;
import com.leedopoem.ljh.friendlyteacher.data.entity.PersonalInfo;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class PersonalConstract {
    interface View extends BaseView<PersonalConstract.Presenter> {
        void showPersonalInfo(PersonalInfo info);
    }

    interface Presenter extends BasePresenter {
        void loadPersenalInfo();
    }
}

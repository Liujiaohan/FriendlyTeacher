package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.personal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.PersonalMainPageInfo;
import com.leedopoem.ljh.friendlyteacher.page.personalsetting.PersonalMessageSettingActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class PersonalFragment extends Fragment implements PersonalConstract.View ,View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private PersonalConstract.Presenter personalPresenter;
    private TextView UserNameText;
    private TextView IntroductionText;
    private TextView NoticedNumText;
    private TextView FansNumText;
    private TextView PublishedLectureNumText;
    private TextView StudingLectureNumText;
    private TextView CollectedLectureNumText;
    private Button SettingBtn;
    private RelativeLayout PublishedLectureBtn;
    private RelativeLayout StudingLectureBtn;
    private RelativeLayout CollectedLectureBtn;
    private CardView AboutusBtn;
    private Context context;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SettingBtn.setOnClickListener(this);
        PublishedLectureBtn.setOnClickListener(this);
        StudingLectureBtn.setOnClickListener(this);
        CollectedLectureBtn.setOnClickListener(this);
        AboutusBtn.setOnClickListener(this);
    }

    public PersonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = inflater.getContext();
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        UserNameText = view.findViewById(R.id.personal_username);
        IntroductionText = view.findViewById(R.id.personal_introduction);
        NoticedNumText = view.findViewById(R.id.personal_noticed);
        FansNumText = view.findViewById(R.id.personal_fansnum);
        PublishedLectureNumText = view.findViewById(R.id.personal_publishlecturenum);
        StudingLectureNumText = view.findViewById(R.id.personal_studylecturenum);
        CollectedLectureNumText = view.findViewById(R.id.personal_collectedlecturenum);
        SettingBtn = view.findViewById(R.id.personal_setting_btn);
        PublishedLectureBtn = view.findViewById(R.id.personal_btn_mylecture);
        StudingLectureBtn = view.findViewById(R.id.personal_btn_mystudyinglecture);
        CollectedLectureBtn = view.findViewById(R.id.personal_btn_collect);
        AboutusBtn = view.findViewById(R.id.personal_btn_aboutus);
        return view;
    }

    @Override
    public void setPresenter(PersonalConstract.Presenter presenter) {
        this.personalPresenter = presenter;

    }

    @Override
    public void showPersonalInfo(PersonalMainPageInfo info) {
        UserNameText.setText(info.getUserName());
        IntroductionText.setText(info.getIntroduction());
        NoticedNumText.setText(info.getNoticedNum());
        FansNumText.setText(info.getFansNum());
        PublishedLectureNumText.setText(info.getPublishedLectureNum());
        StudingLectureNumText.setText(info.getStudingLectureNum());
        CollectedLectureNumText.setText(info.getCollectedLectureNum());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_setting_btn: {
                /*Log.i(TAG,"setting")*/;
                Intent intent = new Intent(context, PersonalMessageSettingActivity.class);
                context.startActivity(intent);
                /*Log.i(TAG,"setting");*/
                break;
            }
            case R.id.personal_btn_mylecture:{
                /*Log.i(TAG,"lecture")*/;
                break;
            }
            case R.id.personal_btn_mystudyinglecture: {

                break;
            }
            case R.id.personal_btn_collect: {
                break;
            }
            case R.id.personal_btn_aboutus : {
                break;
            }
        }
    }
}

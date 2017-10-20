package com.leedopoem.ljh.friendlyteacher.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.base.MyApplication;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.homepage.adapter.RecommendLecturesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljh on 17-10-3.
 */

public class HomePageFragment extends Fragment implements HomePageContract.View  {
    private static final String FRAGMENT_ID="FRAGMENT_ID";
    private HomePageContract.Presenter mPresenter;
    private RecyclerView mLectureRecyclerList;
    private FloatingActionButton mFab;
    private RecommendLecturesAdapter mAdapter;

    public static HomePageFragment newInstance(String fragmentId){
        Bundle argument=new Bundle();
        argument.putString(FRAGMENT_ID,fragmentId);
        HomePageFragment fragment=new HomePageFragment();
        fragment.setArguments(argument);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获得初始化控件
        View root =inflater.inflate(R.layout.fragment_homepage,container);
        mLectureRecyclerList=root.findViewById(R.id.recommend_lectures_list);
        mFab=root.findViewById(R.id.fab_homePage);
        mAdapter=new RecommendLecturesAdapter(new ArrayList<Lecture>(), new RecommendLecturesAdapter.OnItemClickListener() {
            @Override
            public void onLectureClick() {
                mPresenter.openLectureDetails();
            }

            @Override
            public void onStared() {
            }
        });

        //fab跳转到新界面
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addNewLecture();
            }
        });

        //recyclerView设置adapter
        mLectureRecyclerList.setLayoutManager(new LinearLayoutManager(MyApplication.INSTANCE));
        mLectureRecyclerList.setAdapter(mAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mAdapter.replaceData(lectures);
        Log.i("TAG", "showLectures: "+lectures.toString());
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

package com.leedopoem.ljh.friendlyteacher.homepage.fragment.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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

public class RecommendFragment extends Fragment implements RecommendContract.View  {
    private static final String FRAGMENT_ID="FRAGMENT_ID";

    private RecommendContract.Presenter mPresenter;
    private RecyclerView mLectureRecyclerList;
    private FloatingActionButton mFab;
    private RecommendLecturesAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean isRefresh=false;

    public static RecommendFragment newInstance(String fragmentId){
        Bundle argument=new Bundle();
        argument.putString(FRAGMENT_ID,fragmentId);
        RecommendFragment fragment=new RecommendFragment();
        fragment.setArguments(argument);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //获得初始化控件
        View root =inflater.inflate(R.layout.fragment_homepage,container,false);
        mLectureRecyclerList=root.findViewById(R.id.recommend_lectures_list);
        swipeRefreshLayout=root.findViewById(R.id.swipeRefresh_recommend);
        mFab=root.findViewById(R.id.fab_homePage);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mAdapter=new RecommendLecturesAdapter(new ArrayList<Lecture>(),
                new RecommendLecturesAdapter.OnItemClickListener() {
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

        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isRefresh){
                    mPresenter.loadRecommendLecture();
                }
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setPresenter(RecommendContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void showLecturesMissing() {
    }

    @Override
    public void showLectures(List<Lecture> lectures) {
        isRefresh=false;
        swipeRefreshLayout.setRefreshing(false);
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

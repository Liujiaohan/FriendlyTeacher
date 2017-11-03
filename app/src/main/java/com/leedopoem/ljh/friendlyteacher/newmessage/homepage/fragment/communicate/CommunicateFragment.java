package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.communicate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.LeaveWord;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.adapter.LeaveWordsAdapter;

import java.util.List;


public class CommunicateFragment extends Fragment implements CommunicateContract.View{
    private static final String FRAGMENT_ID="FRAGMENT_ID";

    private CommunicateContract.Presenter mPresenter;
    private RecyclerView mLectureRecyclerList;
    private FloatingActionButton mFab;
    private LeaveWordsAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean isRefresh=false;

    public static CommunicateFragment newInstance(String fragmentId){
        Bundle argument=new Bundle();
        argument.putString(FRAGMENT_ID,fragmentId);
        CommunicateFragment fragment=new CommunicateFragment();
        fragment.setArguments(argument);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //获得初始化控件
        View root =inflater.inflate(R.layout.fragment_communicate,container,false);
//        mLectureRecyclerList=root.findViewById(R.id.recommend_lectures_list);
//        swipeRefreshLayout=root.findViewById(R.id.swipeRefresh_recommend);
//        mFab=root.findViewById(R.id.fab_communicate);
//        mAdapter=new LeaveWordsAdapter(new ArrayList<LeaveWord>(),
//                new LeaveWordsAdapter.OnItemClickListener() {
//                    @Override
//                    public void onLectureClick() {
//                        mPresenter.openLeaveWordsDetails();
//                    }
//
//                    @Override
//                    public void onStared() {
//                    }
//                });
//
//        //fab跳转到新界面
//        mFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mPresenter.addLeaveWord();
//            }
//        });
//
//        //recyclerView设置adapter
//        mLectureRecyclerList.setLayoutManager(new LinearLayoutManager(MyApplication.INSTANCE));
//        mLectureRecyclerList.setAdapter(mAdapter);
//
//        //下拉刷新
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                if (!isRefresh){
//                    mPresenter.loadLeaveWords();
//                }
//            }
//        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    public void setPresenter(CommunicateContract.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void showLecturesMissing() {
    }

    @Override
    public void showLeaveWords(List<LeaveWord> leaveWords) {
        isRefresh=false;
//        swipeRefreshLayout.setRefreshing(false);
//        mAdapter.replaceData(leaveWords);
        Log.i("TAG", "showLectures: "+leaveWords.toString());
    }
}

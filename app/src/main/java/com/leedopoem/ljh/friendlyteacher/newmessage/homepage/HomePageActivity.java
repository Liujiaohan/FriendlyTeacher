package com.leedopoem.ljh.friendlyteacher.newmessage.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.base.BaseActivity;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.communicate.CommunicateFragment;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.communicate.CommunicatePresenter;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.personal.PersonalFragment;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.recommend.RecommendFragment;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.recommend.RecommendPresenter;
import com.leedopoem.ljh.friendlyteacher.utils.ActivityUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljh on 17-10-19.
 */

public class HomePageActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private RecommendPresenter mRecommendPresenter;
    private RecommendFragment mRecommendFragment;
    private CommunicatePresenter mCommunicatePresenter;
    private CommunicateFragment mCommunicateFragment;
    private PersonalFragment mPersonalFragment;
    private LectureRepository mRepository;
    private ViewPager viewPage;
    private ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mRepository=new LectureRepository(this);

        initUI();
    }

    private void initUI() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
      //  viewPage= (ViewPager) findViewById(R.id.home_viewPage);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        setSupportActionBar(toolbar);

//        viewPage.addOnPageChangeListener(this);
//        viewPage.setOffscreenPageLimit(3);
//        viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager());
        mRecommendFragment= RecommendFragment.newInstance("recommend_fragment");
        mRecommendPresenter=new RecommendPresenter(this,mRepository,mRecommendFragment);
        mCommunicateFragment=CommunicateFragment.newInstance("communicate_fragment");
        mCommunicatePresenter=new CommunicatePresenter(mRepository,mCommunicateFragment);
        mPersonalFragment=new PersonalFragment();
//
//        viewPageAdapter.addFragment(mRecommendFragment);
//        viewPageAdapter.addFragment(mCommunicateFragment);
//        viewPageAdapter.addFragment(mPersonalFragment);
//
//        viewPage.setAdapter(viewPageAdapter);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                mRecommendFragment,R.id.container);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_navigation:
                      //  viewPage.setCurrentItem(0);
                        ActivityUtils.replaceFragment(getSupportFragmentManager(),
                                mRecommendFragment,R.id.container);
                        break;
                    case R.id.chat_navigation:
                        //viewPage.setCurrentItem(1);
                        ActivityUtils.replaceFragment(getSupportFragmentManager(),
                                mCommunicateFragment,R.id.container);
                        break;
                    case R.id.personal_navigation:
                        //viewPage.setCurrentItem(2);
                        ActivityUtils.replaceFragment(getSupportFragmentManager(),
                                mPersonalFragment,R.id.container);
                        break;
                }
                Log.i("HomeActivity", "onNavigationItemSelected: "+item.getOrder());
                return true;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class ViewPageAdapter extends FragmentPagerAdapter{
        List<Fragment> list=new ArrayList<>();
        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        public void addFragment(Fragment f){
            list.add(f);
        }


    }
}

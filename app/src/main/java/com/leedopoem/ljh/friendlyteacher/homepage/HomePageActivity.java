package com.leedopoem.ljh.friendlyteacher.homepage;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;

/**
 * Created by ljh on 17-10-19.
 */

public class HomePageActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private HomePageContract.Presenter mPresenter;
    private HomePageFragment mFragment;
    private LectureRepository mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_personal_homepage);
        /*toolbar= (Toolbar) findViewById(R.id.toolbar);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        setSupportActionBar(toolbar);

        mFragment=HomePageFragment.newInstance("homepage_fragment");
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),mFragment,R.id.homepage_fragment_container);

        mRepository=new LectureRepository(this);
        mPresenter=new HomePagePresenter(mRepository,mFragment);*/
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}

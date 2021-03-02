    package com.example.study;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.FragmentPagerAdapter;
    import androidx.viewpager.widget.ViewPager;

    import android.os.Bundle;

    import com.google.android.material.tabs.TabLayout;

    public class MainActivity extends AppCompatActivity {

        // FragmentPagerAdapter => Fragment Manager 에서 관리하는 Fragment 를 나타내주는 것
        /*
        FragmentPagerAdapter => 제한된 페이지 개수들의 항목들에 적합 (fragment의 개수가 정해져있고 그 수가 많지 않을 때 사용)
        FragmentStatePagerAdapter => 페이지 수를 알 수 없거나 페이지의 수가 많을 때 적합
         */
        private FragmentPagerAdapter fragmentPagerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // 뷰페이저 세팅
            // getSupportFragmentManager => 메인 액티비티에 새로 추가할 메소드로 프래그먼트 매니저를 이용해 프래그먼트를 전환하는 메소드
            ViewPager viewPager = findViewById(R.id.viewPager);
            fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            // setAdapter => viewPaper에 fragmentPaperAdapter를 적용하는 것
            // setupWithViewPager => tabLayout과 viewPager은 연동시키는 것
           TabLayout tabLayout = findViewById(R.id.tab_layout);
            viewPager.setAdapter(fragmentPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);



        }
    }

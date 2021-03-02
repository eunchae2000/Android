package com.example.study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        /*
        super = 자식 클래스에서 상속받은 부모 클래스의 멤버변수를 참조할때 사용합니다.
        super() = 자식 클래스가 자신을 생성할 때 부모 클래스의 생성자를 불러 초기화 할때 사용됩니다. (기본적으로 자식 클래스의 생성자에 추가됩니다.)
        this = 현재 클래스의 인스턴스를 의미합니다. 즉, 현재 클래스의 멤버변수를 지정할때 사용합니다.
        this() = 아래와 같이 현재 클래스의 클래스 변수 부모와 동일한 이름의 파라미터가 들어올 경우, 명확히 구분해 줄 수 있습니다.
         */
        super(fm);
    }

    // 현재 어떤 Item인지 알려주는 부분
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragMonday.newInstance();
            case 1:
                return FragTuesday.newInstance();
            case 2:
                return FragWednesday.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    // getPageTitle => 이부분을 override로 구현하면 position이 Monday, Tuesday, Wednesday로 설
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            default:
                return null;
        }
    }
}

    package com.example.study;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;

    import android.os.Bundle;
    import android.view.MenuItem;

    import com.google.android.material.bottomnavigation.BottomNavigationView;

    //BottomNavigationView = 안드로이드 하단를 구성하는 것

    public class MainActivity extends AppCompatActivity {
        /*
        FragmentManager => 프래그먼트 관리 (프래그먼트와 액티비티를 서로를 이어주는 역할
        Transaction => 어떤 대상에 대해 추가, 제거, 변경 등의 작업들이 발생하는것을 묶어서 얘기하는 것
        FragmentManger는 액티비티가 사용자의 입력 이벤트에 따라 프래그먼트를 추가 및 삭제 그리고 교체 등의 작업들을 수행 할 수 있게 하고
        행해진 transaction의 상태를 Fragment Backstack을 통해 저장
         */
        private BottomNavigationView bottomNavigationView;
        private FragmentManager fragment;
        private FragmentTransaction transaction;
        private frag1 frag1;
        private frag2 frag2;
        private frag3 frag3;
        private frag4 frag4;
        private frag5 frag5;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // setOnNavigationItemReselectedListener는 Navigation 아이템이 선택되었을 때 수행
            bottomNavigationView = findViewById(R.id.bottomNavi);
            bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                // void -> boolean
                // onNavigationItemReselected 통해서 bottomNavigation을 실행
                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.action_airplane:
                            setFrag(0);
                            break;
                        case R.id.action_airport:
                            setFrag(1);
                            break;
                        case R.id.action_bt:
                            setFrag(2);
                            break;
                        case R.id.action_call:
                            setFrag(3);
                            break;
                        case R.id.action_run:
                            setFrag(4);
                            break;
                }
                // boolean 값으로 입력해야 되기 때문에 return -> return true
                    return;
                }
            });
            frag1 = new frag1();
            frag2 = new frag2();
            frag3 = new frag3();
            frag4 = new frag4();
            frag5 = new frag5();
            setFrag(0);
        }

        private void setFrag(int n) {
            /*
            Fragment 객체는 getSupportFragmentManager 메소드를 호출하면 시작            Transaction 객체는 beginTransaction 메소드를 호출하면 시작, commit 메소드를 호출하면 실핼
             */
            fragment = getSupportFragmentManager();
            transaction = fragment.beginTransaction();

            //
            switch (n){
                case 0:
                    // transaction.replace => 현재 화면에서 보이는 아이콘을 클릭하면 정해진 아이콘이 할당된 값을 가지는 화면으로 이동
                    // commit => 정해진 화면으로 이동하는 것을 실행
                    transaction.replace(R.id.main_frame, frag1);
                    transaction.commit();
                    break;
                case 1:
                    transaction.replace(R.id.main_frame, frag2);
                    transaction.commit();
                    break;
                case 2:
                    transaction.replace(R.id.main_frame, frag3);
                    transaction.commit();
                    break;
                case 3:
                    transaction.replace(R.id.main_frame, frag4);
                    transaction.commit();
                    break;
                case 4:
                    transaction.replace(R.id.main_frame, frag5);
                    transaction.commit();
                    break;
            }
        }

    }

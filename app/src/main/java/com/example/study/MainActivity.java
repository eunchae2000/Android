    package com.example.study;

    import androidx.appcompat.app.AppCompatActivity;


    import android.media.MediaPlayer;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        /*
        종료 버튼 실행 = onBackPressed
         */
        
        private long backbtnTime = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        // 뒤로가기 버튼 처리
        @Override
        public void onBackPressed() {
            long curTime = System.currentTimeMillis();
            long gapTime = curTime - backbtnTime;

            // 뒤로가기 버튼을 2초안에 두 번이상 누르면 종료 (첫 번째와 두 번째 버튼을 2초안에 누르면 종료됨)
            if(0<= gapTime && 2000>=gapTime){
                super.onBackPressed();
            }

            // 뒤로가기 버튼을 한 번 누르고 2초 안에 한번 더 누르지 않으면 Toast 메세지 출력
            else{
                backbtnTime = curTime;
                Toast.makeText(this, "한번 더 누르면 종료 됩니다.", Toast.LENGTH_SHORT).show();
            }

        }
    }

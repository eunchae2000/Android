    package com.example.study;

    import androidx.appcompat.app.AppCompatActivity;


    import android.media.MediaPlayer;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;


    public class MainActivity extends AppCompatActivity {
        
        Button btn_play;
        Button btn_stop;

        MediaPlayer mediaPlayer;

        // 액티비티가 종료될 때 이곳을 실행
        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (mediaPlayer != null){
                mediaPlayer.release();  // release = 해제
                // release는 MediaPlayer 호출시 사용을 권장
                mediaPlayer = null;
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btn_play = findViewById(R.id.btn_play);
            btn_stop = findViewById(R.id.btn_stop);

            // 재생 버튼을 눌렸을 때
            btn_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song1);
                    mediaPlayer.start();
                }
            });
            
            // 정지 버튼을 눌렸을 때
            btn_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // isPlaying은 지금 재생중인지 확인하는 것
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                }
            });


        }

    }

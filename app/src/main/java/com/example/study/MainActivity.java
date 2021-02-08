    package com.example.study;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        /*
        onCreate(@Nullable Bundle savedInstanceState) 메소드

        => 액티비티가 최조 생성될 때 호출되는 메소(초기화 작업이 진행)
        onCreate는 매개변수로 Bundle savedInstanceState를 받음
        액티비티가 실행되면서 onCreate가 호출되면서 Bundle의 객체를 전달받음

        Bundle => 동적상태의 데이터를 저장하고 복원하는 클래스
         */
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setTitle("영화 선호도 투표");

            final int voteCount[] = new int[9];
            for(int i = 0; i<9; i++)
                voteCount[i] += 0;

            ImageView imageView[] = new ImageView[9];

            int imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

            final String imgName[] = {"괴물", "웰컴투 동막골", "흑성탈출", "아저씨", "아바타", "매트릭스", "AI", "글래디에이터", "레옹"};

            for(int i = 0; i<imageId.length; i++){
                final int index;
                index = i;
                imageView[index] = (ImageView)findViewById(imageId[index]);

                imageView[index].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        voteCount[index]++;
                        Toast.makeText(getApplicationContext(), "표", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            Button btnFinish = (Button) findViewById(R.id.btnResult);
            btnFinish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    Intent
                    intent는 다른 액티비티로 전환할 때 사용
                    getApplicationContext()는 this와 비슷한 개념으로
                    getApplicationContext는 application을 가리키는 것이고 this는 activity를 가리키는 것이라고 생각
                     */
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    /*
                    putExtra(key, value)
                    putExtra는 Intent에 속하며 intent를 이용해 다른 화면으로 전환될 때 putExtra(key, value) key값을 전달받아 value값으로 반환하면 출력하는 것
                    다른 액티비티로 이동하면서 putExtra의 key값을 통해서 vlaue값을 다른 액티비티에 출력

                    그리고 버튼을 누르면 startActivity(intent) or startActivityForResult(intent)가 수행되며 메인 액티비티 위에 다른 액티비티가 실행
                     */
                    intent.putExtra("VoteCount", voteCount);
                    intent.putExtra("ImageName", imgName);
                    startActivity(intent);
                }
            });
        }
    }
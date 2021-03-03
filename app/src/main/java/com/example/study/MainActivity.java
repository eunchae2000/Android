    package com.example.study;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        private RadioGroup rg_gender;
        private RadioButton rb_women, rb_man;
        private Button btn_result;
        private String str_result;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            rg_gender = findViewById(R.id.rg_gender);       // 라디오 버튼을 담고 있는 그룹
            rb_man = findViewById(R.id.rb_man);             // 라디오 버튼
            rb_women = findViewById(R.id.rb_women);         // 라디오 버튼
            btn_result = findViewById(R.id.btn_result);     // 결과 값을 출력하라는 신호를 보낼 버튼

            rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // 라디오 버튼들의 상태 값의 변경됨을 감지
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if(i == R.id.rb_man){
                        Toast.makeText(MainActivity.this, "남자 라디오 버튼", Toast.LENGTH_SHORT).show();
                        str_result = rb_man.getText().toString();       // 라디오 버튼의 text값을 String에 담아 줌
                    }else if(i == R.id.rb_women){
                        Toast.makeText(MainActivity.this, "여자 라디오 버튼", Toast.LENGTH_SHORT).show();
                        str_result = rb_women.getText().toString();     // 라디오 버튼의 text 값을 String에 담아 줌
                    }
                }
            });

            btn_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(str_result != null){     // str_result가 빈 값이 아니라면
                        Toast.makeText(MainActivity.this, str_result, Toast.LENGTH_SHORT).show();
                    }else{                      //  str_result가 빈 값이라면
                        Toast.makeText(MainActivity.this, "라디오 버튼을 시작해주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

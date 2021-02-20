    package com.example.study;

    import androidx.annotation.NonNull;
    import androidx.annotation.RequiresApi;
    import androidx.appcompat.app.AppCompatActivity;

    import android.hardware.Camera;
    import android.media.MediaRecorder;
    import android.os.Build;
    import android.os.Bundle;
    import android.view.SurfaceControl;
    import android.view.SurfaceHolder;
    import android.view.SurfaceView;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.Spinner;
    import android.widget.TextView;
    import android.widget.inline.InlineContentView;

    public class MainActivity extends AppCompatActivity {

        /*
        Spinner => 스피너는 값 집합에서 하나의 값을 선택할 수 있는 빠른 방법을 제공

        기본 상태의 스피너는 현재 선택된 값을 표시.
        스피너를 터치하면 기타 모든 사용 가능한 값을 포함하는 드롭다운 메뉴가 표시되며, 여기서 새 값을 선택할 수 있음.
         */

        private Spinner spinner;
        private TextView tv_result;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            spinner = (Spinner)findViewById(R.id.spinner);
            tv_result = (TextView)findViewById(R.id.tv_result);

            // spinner 이벤트 처리 = setOnItemSelectedListener 이용
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                // 드롭다운이 선택되었을 때
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // position으로 몇 번째 것이 선택되었는지 변수에 String 값으로 저장
                    tv_result.setText(parent.getItemAtPosition(position).toString());
                }

                // 드롭다운이 선택되지 않았을 때
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

    }

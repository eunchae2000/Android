    package com.example.study;

    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.app.SearchManager;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setTitle("암시적 인텐트 예제");

            Button btnDial= (Button)findViewById(R.id.call_btn);
            Button btnWeb = (Button)findViewById(R.id.web_btn);
            Button btnGoogle = (Button)findViewById(R.id.map_btn);
            Button btnSearch = (Button)findViewById(R.id.search_btn);
            Button btnSns = (Button)findViewById(R.id.msg_btn);

            /*
            URI => 인터넷에 있는 자원을 나타내는 유일한 주, 인터넷에서 요구되는 기본 조건
            URL => 정형화된 리소스 위치표

            Intent => 화면 간 이동과 데이터 전달
             */
            btnDial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 전화걸기
                    // ACTION_DIAL => 데이터에 있는 다이얼넘버로 전화 요청을 하라는 액션
                    Uri uri = Uri.parse("tel: 010-1234-5678");
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                }
            });
            btnWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 웹페이지로 이동
                    // ACTION_VIEW => 사용자에게 데이터를 보여달라는 액션
                    Uri uri = Uri.parse("http://www.google.co.kr");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            btnGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 웹페이지로 이동
                    // ACTION_VIEW => 사용자에게 데이터를 보여달라는 액션
                    Uri uri = Uri.parse("http://maps.google.com/maps?q="+ 35.144135+","+129.010624);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 검색하기
                    // ACTION_WEB_SEARCH => 검색을 요청하는 액션
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "동서대학교");
                    startActivity(intent);
                }
            });
            btnSns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 메세지 보내기
                    // ACTION_SENDTO => 데이터에 표시된 누군가에게 메세지를 보내라는 액션
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "안녕하세요");
                    intent.setData(Uri.parse("smsta:" + Uri.encode("010-1234-5678")));
                    startActivity(intent);
                }
            });
        }
    }
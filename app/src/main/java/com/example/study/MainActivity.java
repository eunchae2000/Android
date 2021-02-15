    package com.example.study;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.BroadcastReceiver;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.os.Bundle;
    import android.view.View;

    /* Broadcast Receiver() 종류

    - 정적 등록: AndroidManifest.xml 파일에 <receiver> 이라는 태그로 등록하여 AndroidManifest에 <receiver> 로 등록시
    이름은 BroadcastReceiver 클래스를 상속한 클래스의 이름으로 지정한다. 내부에 <intent-filter> 태그로 action을
    정의하는데 해당 action으로 지정된 메세지를 수신하겠다는 의미 => 앱이 실행이지 않을 때도 메세지를 받으면 메세지에 대한 동작이 가능하다.

    - 동적 등록: context가 유효할 때만 동작함. 엑티비티 Context로 BroadcastReceiver를 등록한다면 Activity 가 Destroy될 때까지 Receiver는 유효.
    */

    public class MainActivity extends AppCompatActivity {

        private BroadCast broadcast;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            broadcast = new BroadCast();
        }

        @Override
        protected void onResume() {
            super.onResume();
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_POWER_CONNECTED);
            filter.addAction(BroadCast.MyAction);
            registerReceiver(broadcast, filter);
        }

        public void sendMyBroadCast(View view){
            Intent intent = new Intent(BroadCast.MyAction);
            sendBroadcast(intent);
        }
    }

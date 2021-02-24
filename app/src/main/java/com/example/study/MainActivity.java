    package com.example.study;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.content.IntentFilter;
    import android.net.NetworkInfo;
    import android.net.wifi.WifiManager;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        public static TextView tv_state;
        private NetworkReceiver receiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv_state = findViewById(R.id.tv_state);

            // BroadCast Receiver 등록!
            // Intent => 다른 앱 컴포넌트에 어떤 행동을 요구할 때 사용하는 메시징 오브젝트
            // Network 상태를 확인 = NetworkReceiver
            IntentFilter filter = new IntentFilter();
            receiver = new NetworkReceiver();
            filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
            registerReceiver(receiver, filter);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            // BroadCast Receiver 해제
            unregisterReceiver(receiver);
        }
    }

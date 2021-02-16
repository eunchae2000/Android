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
    import android.widget.Button;
    import android.widget.inline.InlineContentView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }

    }

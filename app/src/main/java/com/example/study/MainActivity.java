    package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

        EditText et_save;
        String shared = "file";

        // 값을 불러오는 부분
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            et_save = (EditText)findViewById(R.id.et_save);

            SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
            String value = sharedPreferences.getString("coco", "");
            et_save.setText(value);
        }

        // 불러온 값을 저장하는 부분
        @Override
        protected void onDestroy(){
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("coco", value);
        editor.commit();
    }
}
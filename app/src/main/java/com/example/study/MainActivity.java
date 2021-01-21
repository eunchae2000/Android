    package com.example.study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

    public class MainActivity extends AppCompatActivity {

        Button btn1, btn2, btn3, btn4;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            btn1 = (Button)findViewById(R.id.btn1);
            btn2 = (Button)findViewById(R.id.btn2);
            btn3 = (Button)findViewById(R.id.btn3);
            btn4 = (Button)findViewById(R.id.btn4);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment1 fragment1 = new Fragment1();
                    transaction.replace(R.id.fram, fragment1);
                    transaction.addToBackStack(null);
                    transaction.commit();       // 새로고침과 같은 기능
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment2 fragment2 = new Fragment2();
                    transaction.replace(R.id.fram, fragment2);
                    transaction.addToBackStack(null);
                    transaction.commit();       // 새로고침과 같은 기능
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment3 fragment3 = new Fragment3();
                    transaction.replace(R.id.fram, fragment3);
                    transaction.addToBackStack(null);
                    transaction.commit();       // 새로고침과 같은 기능
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment4 fragment4 = new Fragment4();
                    transaction.replace(R.id.fram, fragment4);
                    transaction.addToBackStack(null);
                    transaction.commit();       // 새로고침과 같은 기능
                }
            });

        }
    }
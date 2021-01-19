    package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;
    ImageView img_test;

    private Button btn_move;
    private EditText et_test;
    private String str;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        List <String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        data.add("coco");
        data.add("popo");
        data.add("nono");
        adapter.notifyDataSetChanged();

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);
//        btn_move = (Button)findViewById(R.id.btn_move);
//        et_test = (EditText)findViewById(R.id.et_test);
        img_test = (ImageView)findViewById(R.id.img_test);


        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", str);
                startActivity(intent);  // 액티비티 이동
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("coco");
            }
        });

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"채채랑 태태", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
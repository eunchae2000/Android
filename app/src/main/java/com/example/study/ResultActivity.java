package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("투표 결과");

        Intent intent = getIntent();    // MainActivity에서 선언한 intent를 받아주겠다는 의미
        int[] voteResult = intent.getIntArrayExtra("VoteCount");    // VoteCount의 값을 int형으로 가져옴
        String[] imageName = intent.getStringArrayExtra("ImageName");   // ImageName의 값을 string형으로 가져

        TextView textView[] = new TextView[imageName.length];
        RatingBar ratingBar[] = new RatingBar[imageName.length];

        int textViewId[] = {R.id.textView0, R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8};
        int ratingBarId[] = {R.id.rating_bar0, R.id.rating_bar1, R.id.rating_bar2, R.id.rating_bar3, R.id.rating_bar4, R.id.rating_bar5, R.id.rating_bar6, R.id.rating_bar7, R.id.rating_bar8};

        for(int i = 0; i<voteResult.length; i++){
            textView[i] = (TextView)findViewById(textViewId[i]);
            ratingBar[i] = (RatingBar)findViewById(ratingBarId[i]);
        }

        for(int i = 0; i<voteResult.length; i++){
            textView[i].setText(imageName[i]);
            ratingBar[i].setRating((float)voteResult[i]);
        }

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

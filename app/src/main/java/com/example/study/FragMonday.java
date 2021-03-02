package com.example.study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragMonday extends Fragment {
    private View view;

    // 새로운 인스턴스 선언
    public static FragMonday newInstance(){
        FragMonday fragMonday = new FragMonday();
        return fragMonday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflater(inflate) => xml로 정의된 view를 실제 객체화 시키는 용도이다
        // infalter 사용법 => view = inflater.inflate()
        view = inflater.inflate(R.layout.frag_monday, container, false);

        return  view;
    }
}

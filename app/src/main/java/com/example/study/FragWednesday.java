package com.example.study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragWednesday extends Fragment {

    private View view;

    // 새로운 인스턴스 선언
    public static FragTuesday newInstance(){
        FragTuesday fragTuesday = new FragTuesday();

        return fragTuesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_wednesday, container, false);

        return view;
    }
}

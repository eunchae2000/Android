package com.example.study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.CustomViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
         onCreateViewHolder => 뷰홀더가 새로 만들어질 때 호출, 각 아이템을 위해 정의한 xml 레이아웃을 이용해 뷰 객체를 만듬
         여기서 RecyclerView에서 사용할 레이아웃을 설정하는 함수입니다.
         사용할 layout을 layoutInflater를 이용하여 호출합니다.
         */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        /*
        onBindViewHolder => 뷰홀더가 재사용될 때 호출되므로 뷰객체는 기존 것을 그대로 사용하고 데이터만 바꿈
        아이템에 데이터를 넣는 부분
        holder과 position을 통해 아이템에 데이터를 넣음
         */

        /*
        - Glide 이용하여 이미지 보여주기
        전달된 position 파라미터를 이용해 ArrayList에서 객체를 꺼내어 설정 할 수 있음
         */
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
        holder.tv_userName.setText(arrayList.get(position).getUserName());
    }

    // 어댑터에서 관리하는 아이템의 개수 반환
    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{
        /*
        RecyclerView.ViewHolder 클래스를 상속하여 정의된 CustomViewHolder 클래스의 생성자에는 뷰 객체가 전달
        전달 받은 객체를 부모 클래스 변수에 담아둠
        */

        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_userName;

        public  CustomViewHolder(@NonNull View itemView){
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_userName = itemView.findViewById(R.id.tv_userName);
        }
    }
}

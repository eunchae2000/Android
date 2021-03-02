    package com.example.study;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.os.Bundle;
    import android.util.Log;

    import com.google.firebase.database.DataSnapshot;
    import com.google.firebase.database.DatabaseError;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;
    import com.google.firebase.database.ValueEventListener;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private ArrayList<User> arrayList;
        private FirebaseDatabase database;
        private DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recyclerview);     // recyclerView 아이디 연결
            recyclerView.setHasFixedSize(true);     // setHasFixedSize Ture는 recyclerView의 크키가 변경되지 않게 하는것 => 크기 일정
            layoutManager = new LinearLayoutManager(this);      // LinearLayoutManager => 수평(Horizontal) 또는 수직(Vertical) 방향, 일렬(Linear)로 아이템 뷰 배치
            recyclerView.setLayoutManager(layoutManager);       // LinearLayoutManager 지정해준 것을 recyclerView에 적용
            arrayList = new ArrayList<>();      // ArrayList 선언

            database = FirebaseDatabase.getInstance();      // getInstance()는 특정 메소를 통해서 인스턴스를 생성하는 방식 => 보통은 싱글톤(singleton) 패턴을 적용한 경우
            // 기본적인 싱글톤(singleton)의 방식은 이 싱글톤의 인스턴스가 필요할 때 getInstance가 호출되어 인스턴스를 생성 후 반환하는 방식

            databaseReference = database.getReference("User");      // databaseReference 를 매개체 삼아 저장하고 읽어오는 방식 => 현재 데이터베이스에 접근
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                /*
                - databaseReference.addListenerForSingleValueEvent(new ValueEventListener()
                한 번만 호출되고 즉시 삭제되는 콜백이 필요한 경우에 사용.
                한 번 로드된 후 자주 변경되지 않거나 능동적으로 수신 대기할 필요가 없는 데이터에 유용
                이 메소드는 한번 호출된 후 다시 호출되지 않는다.
                 */
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    arrayList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        // getValue는 snapshot이 가리키고 있는 데이터를 자바 객체 형태로 반환
                        User user = snapshot.getValue(User.class);
                        arrayList.add(user);
                    }
                    adapter.notifyDataSetChanged();     // notifyDataSetChanged => adapter에 리스트가 바뀌었다는 걸 알림
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e("MainActivity", String.valueOf(databaseError.toException()));

                }
            });
            adapter = new CustomAdapter(arrayList, this);
            recyclerView.setAdapter(adapter);

        }
    }

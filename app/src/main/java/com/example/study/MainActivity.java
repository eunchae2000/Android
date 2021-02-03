    package com.example.study;

    import android.content.Context;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Message;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.MotionEvent;
    import android.view.SubMenu;
    import android.view.View;
    import android.view.inputmethod.InputMethod;
    import android.view.inputmethod.InputMethodManager;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        final static int Line = 1;
        final static int Circle = 2;
        final static int Rect = 3;
        static int current_shape = Line;
        static int curren_color = Color.RED;
        static Paint.Style current_style = Paint.Style.STROKE;

        // 클래스를 생성하기 위해서는 onCreate는 반드시 오버라이드를 해야됨

        /*
         Bundle은 여러가지의 타입의 값을 저장하는 Map 클래스
         Activity를 생성할 때 Bundle savedInstanceState 객체를 가지고 와서, 액티비티를 중단할 때 savedInstanceState 메서드를 호출하여 임시적으로 데이터를 저장
         즉 전에 저장된 데이터가 있으면, 그 데이터를 가지고 Activity를 다시 생성
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // super는 상위 클래스에 현재 작업 내용을 전달하여 상위클래스와의 소통을 하는 것
            super.onCreate(savedInstanceState);
            setContentView(new DrawingView(this));
            setTitle("그림판");
        }

        /*
        onCreateOptionsMenu() 함수
        Activity가 시작할 때 한번만 호출되는 함수이기 때문에 Menu와 관련된 초기 설정과 같은 작업이 이루어 지는 함수
         */
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            super.onCreateOptionsMenu(menu);
            menu.add(0, 1, 0, "선 그리기");
            menu.add(0, 2, 0, "원 그리기");
            SubMenu subMenu1 = menu.addSubMenu("사각형 그리기");
            subMenu1.add(0, 3, 0, "fill");
            subMenu1.add(0, 7, 0, "stroke");

            SubMenu subMenu = menu.addSubMenu("색상 선택");
            subMenu.add(0, 4, 0, "Red");
            subMenu.add(0, 5, 0, "Blue");
            subMenu.add(0, 6, 0, "Green");

            return true;
        }

        /*
         onOptionsItemSelected() 함수
         MenuItem이 선택되었을 때 호출되는 함수, switch ~ case 문을 통해 선택된 MenuItem의 ID를 이용해서 Toast 메세지의 Text를 지정하고 있음
        */
        // @Nonnull = null 값을 넣을 시 경고하는 것
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case 1:
                    current_shape = Line;
                    return true;
                case 2:
                    current_shape = Circle;
                    current_style = Paint.Style.STROKE;
                    return true;
                case 3:
                    current_shape = Rect;
                    current_style = Paint.Style.FILL;
                    return true;
                case 4:
                    current_shape = Color.RED;
                    return true;
                case 5:
                    current_shape = Color.BLUE;
                    return true;
                case 6:
                    current_shape = Color.GREEN;
                    return true;
                case 7:
                    current_shape = Rect;
                    current_style = Paint.Style.STROKE;
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        /*
        View() 클래스
        View는 button, image, table, lable 등 다양한 뷰에서 최고 상위 클래스를 가지는 것이 View 클래스
         */

        private static class DrawingView extends View{
            int startX = -1;
            int startY = -1;
            int stopX = -1;
            int stopY = -1;

            /*
             context는 새로 생성된 객체가 지금 어떤 일이 일어나고 있는지를 알 수 있도록 하는 것으로,
             Activity와 Application에 대한 정보를 얻기 위해서 context를 사용
             */
            public DrawingView(Context context){
                super(context);
            }

            /*
            onTouchEvent() 함수
            화면을 터치하면 호출되는 콜백 메소드, onTouchEvent() 함수는 인자로 MotionEvent 를 가지고 있어 매개변수에 getAction()메소드를 사용하여 MotionEvent 상수들과 비교
            */
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX = (int)event.getX();
                        startY = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        stopX = (int)event.getX();
                        stopY = (int)event.getY();
                        this.invalidate();
                        break;
                }
                return true;
            }

            /*
            onDraw() 함수
            View 클래스에서 상속받아 onDraw 콜백 메소드를 정의, 화면을 다시 그릴 필요가 있을 때 자동적으로 호출
            이 안에 그림을 그리는 Canvas 클래스와 Paint 클래스를 사용
             */

            /*
            Canvas 클래스
            그림을 그리는 캔버스에 해당되는 Bitmap 객체를 가짐
             */

            /*
            Paint 클래스
            색상, 선 스타일, 채우기 스타일, 폰트, 앤티엘리어싱 여부 들의 그리기 속성을 가진 클래스
            Canvas 메소드에서 Paint 객체를 마지막 매개 변수로 호출하는 특징을 가짐
             */
            public void onDraw(Canvas canvas){
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStrokeWidth(5);
                paint.setStyle(current_style);
                paint.setColor(curren_color);

                switch (current_shape){
                    case Line:
                        canvas.drawLine(startX, startY, stopX, stopY, paint);
                        break;
                    case Circle:
                        int radius = (int)Math.sqrt(Math.pow(stopX-startX, 2) + Math.pow(stopY-startY, 2));
                        canvas.drawCircle(startX, startY, radius, paint);
                        break;
                    case Rect:
                        canvas.drawRect(startX, startY, stopX, stopY, paint);
                        break;
                }
            }
        }
    }
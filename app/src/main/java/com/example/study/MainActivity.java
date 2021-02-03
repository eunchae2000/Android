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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new DrawingView(this));
            setTitle("그림판");
        }

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

        private static class DrawingView extends View{
            int startX = -1;
            int startY = -1;
            int stopX = -1;
            int stopY = -1;

            public DrawingView(Context context){
                super(context);
            }

            @Override
            public boolean onTouchEvent(MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX = (int)event.getX();
                        startY = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                    case  MotionEvent.ACTION_UP:
                        stopX = (int)event.getX();
                        stopY = (int)event.getY();
                        this.invalidate();
                        break;
                }
                return true;
            }

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
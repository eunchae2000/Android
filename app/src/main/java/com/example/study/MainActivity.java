    package com.example.study;

    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Message;
    import android.view.MotionEvent;
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

        EditText edit1, edit2;
        Button btnAdd, btnSub, btnMul, btnDiv;
        TextView textResult;
        String num1;
        String num2;
        double result;

        Button[] numButtons = new Button[10];
        int[] numBtnIDs = { R.id.button0, R.id.button1, R.id.button2,
                R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9 };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setTitle("Simple");

            edit1 = (EditText)findViewById(R.id.input1);
            edit2 = (EditText)findViewById(R.id.input2);

            btnAdd = (Button) findViewById(R.id.buttonAdd);
            btnSub = (Button) findViewById(R.id.buttonSub);
            btnMul = (Button) findViewById(R.id.buttonMul);
            btnDiv = (Button) findViewById(R.id.buttonDiv);
            textResult = (TextView) findViewById(R.id.textResult);

            for (int i = 0; i<numBtnIDs.length; i++){
                numButtons[i] = (Button)findViewById(numBtnIDs[i]);
            }
            for (int i=0; i<numBtnIDs.length; i++){
                final int index;
                index = i;
                numButtons[index].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edit1.isFocused() == true) {
                            num1 = edit1.getText().toString()
                                    + numButtons[index].getText().toString();
                            edit1.setText(num1);
                        } else if (edit2.isFocused() == true) {
                            num2 = edit2.getText().toString()
                                    + numButtons[index].getText().toString();
                            edit2.setText(num2);
                        } else {
                            Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            btnAdd.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("결과 : " + Double.toString(result));

                    InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    return false;
                }
            });

            btnAdd.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("결과 : " + Double.toString(result));

                    InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    return false;
                }
            });

            btnAdd.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("결과 : " + Double.toString(result));

                    InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    return false;
                }
            });

            btnAdd.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("결과 : " + Double.toString(result));

                    InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    return false;
                }
            });
        }

    }
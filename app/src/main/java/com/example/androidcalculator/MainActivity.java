package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> numbersList;
    private List<String> operators;
    private String currNum;
    private Boolean newTask;

    private EditText numField;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnSum;
    private Button btnDiv;
    private Button btnMultiply;
    private Button btnMin;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersList = new LinkedList<>();
        operators = new LinkedList<>();
        currNum = "";
        newTask = false;

        numField = findViewById(R.id.editTextNumber);

        btn0 = findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(0);
            }
        });

        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(1);
            }
        });

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(2);
            }
        });

        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(3);
            }
        });

        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(4);
            }
        });

        btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(5);
            }
        });

        btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(6);
            }
        });

        btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(7);
            }
        });

        btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(8);
            }
        });

        btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumDigit(9);
            }
        });

        btnSum = findViewById(R.id.button_sum);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("+");
            }
        });

        btnMin = findViewById(R.id.button_min);
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("-");
            }
        });

        btnDiv = findViewById(R.id.button_div);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("/");
            }
        });

        btnMultiply = findViewById(R.id.button_mltpl);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperator("*");
            }
        });

        btnResult = findViewById(R.id.button_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    Integer value = numbersList.get(0);

                    for (int i = 0; i < operators.size(); i++) {
                        // it could be not if-else, but it's simplest thing I could manage fast
                        if (operators.get(i).equals("+")) {
                            value += numbersList.get(i + 1);
                        } else if (operators.get(i).equals("-")) {
                            value -= numbersList.get(i + 1);
                        } else if (operators.get(i).equals("*")) {
                            value *= numbersList.get(i + 1);
                        } else {
                            if (numbersList.get(i + 1) != 0) {
                                value /= numbersList.get(i + 1);
                            } else {
                                numField.setText("00000000000000");
                            }
                        }
                    }

                    numField.setText(value.toString());
                } catch (Exception ex){
                    // pass
                }
                numbersList.clear();
                operators.clear();
                currNum = "";
                newTask = true;
            }
        });

    }

    private void setNumDigit(Integer digit) {
        if (newTask){
            numField.setText("");
        }
        newTask = false;
        currNum += digit.toString();
        numField.setText(currNum);
    }

    private void setOperator(String oper) {
        numbersList.add(Integer.parseInt(numField.getText().toString()));
        operators.add(oper);
        currNum = "";
    }
}
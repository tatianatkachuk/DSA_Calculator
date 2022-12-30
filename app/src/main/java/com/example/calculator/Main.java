package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    TextView resText;
    double nums[];
    int num = 0;
    String ops[];
    String selectedNumber;

    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button resta, suma, mult, div, equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resText = findViewById(R.id.textView2);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button10);

        resta = findViewById(R.id.buttonResta);
        suma = findViewById(R.id.buttonSuma);
        mult = findViewById(R.id.buttonMult);
        div = findViewById(R.id.buttonDiv);

        equal = findViewById(R.id.buttonRes);
        clear = findViewById(R.id.buttonDel);

        nums = new double[10];
        ops = new String[10];
        selectedNumber = "";

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressNumber(view,"0");
            }
        });

        // OPS
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressResta(view);
            }
        });
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressSuma(view);
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressMult(view);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressDiv(view);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resButton(view);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton(view);
            }
        });

    }
    /////////////////Number/////////////////
    public void pressNumber(View view, String res) {
        writeSelection(res);
    }

    /////////////////Ops/////////////////
    public void pressSuma(View view) {
        nums[num] = Double.parseDouble(selectedNumber);
        ops[num] = "+";
        num +=1;
        writeSelection("+");
        selectedNumber = "";
    }
    public void pressResta(View view) {
        nums[num] = Double.parseDouble(selectedNumber);
        ops[num] = "-";
        num +=1;
        writeSelection("-");
        selectedNumber = "";
    }
    public void pressMult(View view) {
        nums[num] = Double.parseDouble(selectedNumber);
        ops[num] = "x";
        num +=1;
        writeSelection("x");
        selectedNumber = "";
    }
    public void pressDiv(View view) {
        nums[num] = Double.parseDouble(selectedNumber);
        ops[num] = "/";
        num +=1;
        writeSelection("/");
        selectedNumber = "";
    }

    /////////////////Result/////////////////
    public void resButton(View view){
        nums[num] = Double.parseDouble(selectedNumber);
        int i;
        double result = 0;
        if (ops[0] == "+")
            result = nums[0] + nums[1];
        else if (ops[0] == "-")
            result = nums[0] - nums[1];
        else if (ops[0] == "x")
            result = nums[0] * nums[1];
        else if (ops[0] == "/")
            result = nums[0] / nums[1];

        Log.d("RESULT", String.valueOf(result));
        resText.setText(String.valueOf(result));
    }

    public void clearButton(View view){
        num = 0;
        nums = new double[10];
        ops = new String[10];
        selectedNumber = "";
        resText.setText("");
    }

    public void writeSelection(String res){
        if (selectedNumber.equals("") && nums[0]==0)
        {
            resText.setText(res);
        }
        else{
            resText.setText(resText.getText() + res);
        }
        selectedNumber = selectedNumber + res;
    }
}
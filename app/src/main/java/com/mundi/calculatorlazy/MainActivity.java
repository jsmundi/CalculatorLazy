// JT Mundi CS 458

package com.mundi.calculatorlazy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Input and result view
    private EditText input;
    private TextView result;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button buttonDivide;
    private Button buttonDot;
    private Button buttonPercent;
    private Button buttonBracket;
    private Button buttonSign;
    private Button buttonClear;

    private ImageButton buttonDelete;
    private ImageButton buttonMultiply;
    private ImageButton buttonSubtract;
    private ImageButton buttonAdd;
    private Button buttonEqual;

    float inputVal1 = 0;
    float inputVal2 = 0;
    boolean addBool, subBool, mulBool, divBool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize input and result fields
        result = (TextView) findViewById(R.id.result);
        input = (EditText) findViewById(R.id.input);



        //Initialize Button 0 - 10
        this.button0 = findViewById(R.id.but0);
        this.button1 = findViewById(R.id.but1);
        this.button2 = findViewById(R.id.but2);
        this.button3 = findViewById(R.id.but3);
        this.button4 = findViewById(R.id.but4);
        this.button5 = findViewById(R.id.but5);
        this.button6 = findViewById(R.id.but6);
        this.button7 = findViewById(R.id.but7);
        this.button8 = findViewById(R.id.but8);
        this.button9 = findViewById(R.id.but9);

        // Initialize Operand buttons
        this.buttonDivide = findViewById(R.id.butDivide);
        this.buttonDot = findViewById(R.id.butDot);
        this.buttonPercent = findViewById(R.id.percent);
        this.buttonBracket = findViewById(R.id.butBrackets);
        this.buttonSign = findViewById(R.id.butsin);
        this.buttonClear = findViewById(R.id.butClear);

        // Initialize Operand buttons with image
        this.buttonAdd = findViewById(R.id.butPlus);
        this.buttonSubtract = findViewById(R.id.butMinus);
        this.buttonMultiply = findViewById(R.id.butMulti);
        this.buttonDelete = findViewById(R.id.butDelete);
        this.buttonEqual = findViewById(R.id.butEqual);


        setListenButton(button0, "0");
        setListenButton(button1, "1");
        setListenButton(button2, "2");
        setListenButton(button3, "3");
        setListenButton(button4, "4");
        setListenButton(button5, "5");
        setListenButton(button6, "6");
        setListenButton(button7, "7");
        setListenButton(button8, "8");
        setListenButton(button9, "9");
        setListenButton(buttonDot, ".");

        setListenClearButton();

        setListenAddButton();
        setListenMulButton();
        setListenSubButton();
        setListenEqualButton();
        setListenDelButton();
        setListenDivButton();

    }

    //Add the text value of pressed button to input
    private void setListenButton(Button x, final String y) {
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + y);
            }
        });
    }


    //Clear the input and result field
    private void setListenClearButton()
    {
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                result.setText("");
            }
        });
    }

    //Add the input and on equal parse another value
    private void setListenAddButton() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (input == null) {
                    input.setText("");
                } else {
                    inputVal1 = Float.parseFloat(input.getText() + "");
                    addBool = true;
                    input.setText(null);
                }
            }
        });
    }

    //Multiply the input and on equal parse another value
    private void setListenMulButton() {
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input == null) {
                    input.setText("");
                } else {
                    inputVal1 = Float.parseFloat(input.getText() + "");
                    mulBool = true;
                    input.setText(null);
                }
            }
        });
    }

    //Subtract the input and on equal parse another value
    private void setListenSubButton() {
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input == null) {
                    input.setText("");
                } else {
                    inputVal1 = Float.parseFloat(input.getText() + "");
                    subBool = true;
                    input.setText(null);
                }
            }
        });
    }

    //Divide the input and on equal parse another value
    private void setListenDivButton() {
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input == null) {
                    input.setText("");
                } else {
                    inputVal1 = Float.parseFloat(input.getText() + "");
                    divBool = true;
                    input.setText(null);
                }
            }
        });
    }

    //Delete previous input value
    private void setListenDelButton()
    {
        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(input.getText().toString().isEmpty()){

                }else{
                    input.getText().delete(input.getText().toString().length() - 1, input.getText().toString().length());
                }
            }

        });
    }

    //Create an equal when equal button preseed. Add, Subtract, Divide, Multiply
    private void setListenEqualButton() {
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputVal2 = Float.parseFloat(input.getText() + "");

                if (addBool == true) {
                    input.setText(inputVal1 + inputVal2 + "");
                    result.setText(inputVal1 + "+" + inputVal2);
                    addBool = false;
                }


                if (subBool == true) {
                    input.setText(inputVal1 - inputVal2 + "");
                    result.setText(inputVal1 + "-" + inputVal2);
                    subBool = false;
                }

                if (mulBool == true) {
                    input.setText(inputVal1 * inputVal2 + "");
                    result.setText(inputVal1 + "x" + inputVal2);
                    mulBool = false;
                }

                if(divBool == true){
                    input.setText(inputVal1 / inputVal2 + "");
                    result.setText(inputVal1 + "/" + inputVal2);
                    mulBool = false;
                }

            }
        });
    }

}

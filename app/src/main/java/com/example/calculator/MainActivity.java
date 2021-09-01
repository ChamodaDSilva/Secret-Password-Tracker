package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button plus;
    Button subtraction;
    Button minus;
    Button devide;
    Button mulitiplication;
    Button poli;
    Button dot;
    Button equal;
    Button c;
    TextView result;
    double num1;
    double num2=0;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to remove title and navigation bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        //
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        plus=findViewById(R.id.plus);
        subtraction=findViewById(R.id.substract);
        minus=findViewById(R.id.minus);
        devide=findViewById(R.id.devide);
        mulitiplication=findViewById(R.id.multiplication);
        poli=findViewById(R.id.poli);
        dot=findViewById(R.id.dot);
        equal=findViewById(R.id.equal);
        c=findViewById(R.id.c);
        result=findViewById(R.id.Result);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"1";
                result.setText(newText);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"2";
                result.setText(newText);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"3";
                result.setText(newText);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"4";
                result.setText(newText);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"5";
                result.setText(newText);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"6";
                result.setText(newText);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"7";
                result.setText(newText);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"8";
                result.setText(newText);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"9";
                result.setText(newText);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+"0";
                result.setText(newText);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText=result.getText()+".";
                result.setText(newText);
            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().length()!=0) {
                    String newText = result.getText().toString();
                    newText = newText.substring(0, newText.length() - 1);
                    result.setText(newText);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = result.getText().toString();
                if(newText.charAt(0) == '-'){
                    result.setText(newText.substring(1,newText.length()));
                }else{
                    result.setText("-"+newText);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(result.getText().toString());
                result.setText("");
                operation="+";
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(result.getText().toString());
                result.setText("");
                operation="-";
            }
        });
        mulitiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(result.getText().toString());
                result.setText("");
                operation="*";
            }
        });
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(result.getText().toString());
                result.setText("");
                operation="/";
            }
        });
        poli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(result.getText().toString());
                double value = num1 / 100;
                result.setText(String.valueOf(value));
            }
        });



        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2=Double.parseDouble(result.getText().toString());


                //made change activity got correct password - 4281
                if(num2==4281){
                    startActivity(new Intent(getApplicationContext(),MainMenu.class));
                }


                switch (operation) {
                    case "+": {
                        double value = num1 + num2;
                        result.setText(String.valueOf(value));
                        break;
                    }
                    case "-": {
                        double value = num1 - num2;
                        result.setText(String.valueOf(value));
                        break;
                    }
                    case "*": {
                        double value = num1 * num2;
                        result.setText(String.valueOf(value));
                        break;
                    }
                    case "/":
                        if (num2 == 0) {
                            result.setText("E");
                        } else {
                            double value = num1 / num2;
                            result.setText(String.valueOf(value));
                        }
                        break;
                }
            }
        });


    }
}
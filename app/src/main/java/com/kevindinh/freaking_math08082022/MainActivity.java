package com.kevindinh.freaking_math08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtA, txtOperator, txtB, txtC, txtMark;
    Button btnCorrect, btnWrong, btnPlay;
    int Result, Mark;
    String OperatorSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int numberA = random.nextInt(10);
                int numberB = random.nextInt(10);
                int numberC = random.nextInt(10);
                txtA.setText(numberA + "");
                txtB.setText(numberB + "");
                txtC.setText(numberC + "");

                Random Operator = new Random();
                int OperatorRandom = Operator.nextInt(4);
                switch (OperatorRandom) {

                    case 0:
                        OperatorSign = "+";
                        Result = numberA + numberB;
                        txtOperator.setText(OperatorSign);
                        break;
                    case 1:
                        OperatorSign = "-";
                        Result = numberA - numberB;
                        txtOperator.setText(OperatorSign);
                        break;
                    case 2:
                        OperatorSign = "*";
                        Result = numberA * numberB;
                        txtOperator.setText(OperatorSign);
                        break;
                    case 3:
                        OperatorSign = "/";
                        Result = numberA / numberB;
                        txtOperator.setText(OperatorSign);
                        break;
                    default:
                        OperatorSign = "";
                }
                if (Result == numberC){
                    btnCorrect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Mark = Mark + 1;
                            txtMark.setText(Mark + "");
                        }
                    });
                    btnWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        txtMark.setText("Gameover");
                        }
                    });
                } else {
                    btnCorrect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtMark.setText("Gameover");
                        }
                    });
                    btnWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Mark = Mark + 1;
                            txtMark.setText(Mark + "");
                        }
                    });

                }

            }
        });
    }
        private void AnhXa(){
            txtA = (TextView) findViewById(R.id.textViewA);
            txtOperator = (TextView) findViewById(R.id.textViewOperator);
            txtB = (TextView) findViewById(R.id.textViewB);
            txtC = (TextView) findViewById(R.id.textViewC);
            txtMark = (TextView) findViewById(R.id.textViewMark);

            btnCorrect = (Button) findViewById(R.id.buttonCorrect);
            btnWrong = (Button) findViewById(R.id.buttonWrong);
            btnPlay = (Button) findViewById(R.id.buttonPlay);
        }

}
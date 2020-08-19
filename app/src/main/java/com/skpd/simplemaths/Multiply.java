package com.skpd.simplemaths;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.skpd.simplemaths.util.CommonUtil;
import com.skpd.simplemaths.util.MathFunctions;

import java.util.Random;

public class Multiply extends AppCompatActivity implements MathBase{

    private MathFunctions mathFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        setTitle("Multiplication");

        TextView txtVWelcomeMsg = findViewById(R.id.add_welcome_msg);
        txtVWelcomeMsg.setText(new StringBuffer().append("Welcome ")
        .append(getIntent().getStringExtra(MainActivity.USER_NAME))
        .append(" !"));

        TextView txtVSymbol=findViewById(R.id.add_symbol);
        txtVSymbol.setText("X");
        mathFunctions = new MathFunctions();
        generateNumbers();
    }

    private void generateNumbers() {

        Random random = new Random();
        //random.nextInt(max - min + 1) + min

        int firstNum = random.nextInt(20)+1;
        int secondNum = random.nextInt(12)+1;

        TextView txtVFirstNum = findViewById(R.id.add_number1);
        TextView txtVSecondNum = findViewById(R.id.add_number2);

        txtVFirstNum.setText(""+firstNum);
        txtVSecondNum.setText(""+secondNum);
    }

    @Override
    public void checkAnswer(View view) {

        TextView txtVUserAns = findViewById(R.id.add_user_answer);
        String str_userAnswer=txtVUserAns.getText().toString();
        long userAnswer= Long.parseLong((str_userAnswer==null || str_userAnswer.equals(""))?"0":str_userAnswer);


        TextView txtVResultMsg= findViewById(R.id.add_result_msg);
        long correctAnswer = calculate();

        if (correctAnswer==userAnswer) {
            txtVResultMsg.setText("Correct Answer !!");
            txtVResultMsg.setTextColor(ContextCompat.getColor(this,R.color.colorGreenForAlert));
        } else {
            txtVResultMsg.setText("Incorrect Answer, try again !");
            txtVResultMsg.setTextColor(ContextCompat.getColor(this,R.color.colorRedForAlert));
        }
        CommonUtil.hideKeyboard(this, txtVResultMsg);
    }

    @Override
    public void nextSum(View view) {
        generateNumbers();
        ((TextView)findViewById(R.id.add_user_answer)).setText("");

    }

    @Override
    public void showAnswer(View view) {
        long correctAnswer = calculate();
        TextView txtVResultMsg= findViewById(R.id.add_result_msg);
        txtVResultMsg.setText("Correct Answer is : "+correctAnswer);
        txtVResultMsg.setTextColor(ContextCompat.getColor(this,R.color.colorGreenForAlert));
    }

    @Override
    public long calculate() {
        TextView txtVFirstNum = findViewById(R.id.add_number1);
        TextView txtVSecondNum = findViewById(R.id.add_number2);
        long firstNum = Long.parseLong(txtVFirstNum.getText().toString());
        long secondNum = Long.parseLong(txtVSecondNum.getText().toString());
        long answer = mathFunctions.multiple(firstNum,secondNum);
        return answer;
    }


}

package com.skpd.simplemaths;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.skpd.simplemaths.util.CommonUtil;
import com.skpd.simplemaths.util.MathFunctions;

import java.util.Random;

public class SubtractionActivity extends AppCompatActivity implements MathBase {

    public static final String BLANK_SPACE=" ";
    private MathFunctions mathFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        setTitle("Subtraction");

        mathFunctions = new MathFunctions();

        TextView txt_welcome_msg = findViewById(R.id.add_welcome_msg);

        txt_welcome_msg.setText(new StringBuilder().append( getString(R.string.add_welcome_msg_1))
                .append(BLANK_SPACE)
                .append(getIntent().getStringExtra(MainActivity.USER_NAME))
                .append(BLANK_SPACE)
                .append(getString(R.string.add_welcome_msg_2)).toString());


        TextView txt_view_symbol = findViewById(R.id.add_symbol);
        txt_view_symbol.setText("-");


        generateNumbers();
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
        int firstNum = (int) Long.parseLong(txtVFirstNum.getText().toString());
        long secondNum = Long.parseLong(txtVSecondNum.getText().toString());
        long answer = mathFunctions.subtract(firstNum, (int) secondNum);
        Log.i("User Answer:",String.valueOf(answer));
        return answer;
    }

    private void generateNumbers() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);
        Random random = new Random();
        int firstNum = random.nextInt(1000)+1;
        Log.i("first number:",String.valueOf(firstNum));
        int secondNum = random.nextInt(1000)+1;
        Log.i("second number:",String.valueOf(secondNum));

        if (firstNum > secondNum){
            txt_view_number1.setText(""+firstNum);
            txt_view_number2.setText(""+secondNum);
        } else{
            txt_view_number1.setText(""+secondNum);
            txt_view_number2.setText(""+(firstNum));
        }
    }
}

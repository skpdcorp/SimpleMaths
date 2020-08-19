package com.skpd.simplemaths;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.skpd.simplemaths.util.CommonUtil;
import com.skpd.simplemaths.util.MathFunctions;

import java.util.Random;

public class Addition extends AppCompatActivity implements MathBase {

    public static final String BLANK_SPACE=" ";
    private MathFunctions mathFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        setTitle("Addition");

        mathFunctions = new MathFunctions();

        TextView txt_welcome_msg = findViewById(R.id.add_welcome_msg);

        txt_welcome_msg.setText(new StringBuilder().append( getString(R.string.add_welcome_msg_1))
                .append(BLANK_SPACE)
                .append(getIntent().getStringExtra(MainActivity.USER_NAME))
                .append(BLANK_SPACE)
                .append(getString(R.string.add_welcome_msg_2)).toString());


        TextView txt_view_symbol = findViewById(R.id.add_symbol);
        txt_view_symbol.setText("+");


       generateNumbers();


    }

    private void generateNumbers() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);
        Random random = new Random();
        int firstNum = random.nextInt(100)+1;
        int seconfNum = random.nextInt(100)+1;

        txt_view_number1.setText(""+firstNum);
        txt_view_number2.setText(""+seconfNum);
    }




    private int calculateAddition() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);


        int number1 = Integer.parseInt(txt_view_number1.getText().toString());
        int number2 = Integer.parseInt(txt_view_number2.getText().toString());

        //Log.i("Number1:",String.valueOf(number1));
        //Log.i("Number2:",String.valueOf(number2));

        int sum = number1+number2;
        //Log.i("Sum:",String.valueOf(sum));
        return  sum;
    }

    /*private int calculateSubtraction() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);


        int number1 = Integer.parseInt(txt_view_number1.getText().toString());
        int number2 = Integer.parseInt(txt_view_number2.getText().toString());

        //Log.i("Number1:",String.valueOf(number1));
        //Log.i("Number2:",String.valueOf(number2));

        int sum = number1-number2;
        Log.i("Sum:",String.valueOf(sum));
        return  sum;
    }
    private int calculateDivision() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);


        int number1 = Integer.parseInt(txt_view_number1.getText().toString());
        int number2 = Integer.parseInt(txt_view_number2.getText().toString());

        //Log.i("Number1:",String.valueOf(number1));
        //Log.i("Number2:",String.valueOf(number2));

        int sum = number1/number2;
        //Log.i("Sum:",String.valueOf(sum));
        return  sum;
    }
*/






    @Override
    public void checkAnswer(View view) {
        int sum = calculateAddition();
        //Log.i("Sum:",String.valueOf(sum));
        TextView txt_view_user_answer=findViewById(R.id.add_user_answer);

        String str_userAnswer=txt_view_user_answer.getText().toString();

        int user_answer= Integer.parseInt((str_userAnswer==null || str_userAnswer.equals(""))?"0":str_userAnswer);
        //Log.i("User Answer:",String.valueOf(user_answer));

        TextView txt_view_result = findViewById(R.id.add_result_msg);
        if (sum==user_answer) {

            txt_view_result.setText("Correct Answer !!");
            txt_view_result.setTextColor(ContextCompat.getColor(this,R.color.colorGreenForAlert));
        } else {
            txt_view_result.setText("Incorrect Answer, try again !");
            txt_view_result.setTextColor(ContextCompat.getColor(this,R.color.colorRedForAlert));


        }
        CommonUtil.hideKeyboard(this, txt_view_result);
    }

    @Override
    public void nextSum(View view) {
        generateNumbers();
        ((TextView)findViewById(R.id.add_user_answer)).setText("");
    }

    @Override
    public void showAnswer(View view) {
        int sum = calculateAddition();
        //Log.i("Sum:",String.valueOf(sum));
        TextView txt_view_result=findViewById(R.id.add_result_msg);
        txt_view_result.setText("Correct Answer is : "+sum);
        CommonUtil.hideKeyboard(this, txt_view_result);
    }

    @Override
    public long calculate() {
        TextView txt_view_number1= findViewById(R.id.add_number1);
        TextView txt_view_number2= findViewById(R.id.add_number2);


        int number1 = Integer.parseInt(txt_view_number1.getText().toString());
        int number2 = Integer.parseInt(txt_view_number2.getText().toString());

        //Log.i("Number1:",String.valueOf(number1));
        //Log.i("Number2:",String.valueOf(number2));

        long answer = mathFunctions.add(number1,number2);
        //Log.i("Sum:",String.valueOf(sum));
        return  answer;
    }
}

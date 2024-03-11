package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstNumber;
    private EditText editSecondNumber;
    private TextView textSeeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstNumber = findViewById(R.id.editFirstNumber);
        editSecondNumber = findViewById(R.id.editSecondNumber);
        textSeeResult = findViewById(R.id.textSeeResult);
    }

    public void plus(View view) {
        calculateAndShowResult('+');
    }

    public void minus(View view) {
        calculateAndShowResult('-');
    }

    public void multiply(View view) {
        calculateAndShowResult('*');
    }

    public void divide(View view) {
        calculateAndShowResult('/');
    }

    private void calculateAndShowResult(char operator) {
        try {
            double number1 = Double.parseDouble(editFirstNumber.getText().toString());
            double number2 = Double.parseDouble(editSecondNumber.getText().toString());
            double result = 0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                        textSeeResult.setText(String.valueOf(result));
                    } else {
                        textSeeResult.setText("Cannot divide by zero");
                    }
                    return;
            }

            textSeeResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            textSeeResult.setText("Invalid input");
        }
    }
}

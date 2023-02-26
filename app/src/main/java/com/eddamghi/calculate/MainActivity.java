package com.eddamghi.calculate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
    }
    @SuppressLint("SetTextI18n")
    private void updateText(String stringToAdd) {
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);
        String rightString = oldString.substring(cursorPosition);
        display.setText(String.format("%s%s%s", leftString, stringToAdd, rightString));
        display.setSelection(cursorPosition + stringToAdd.length());

    }
    public void zero(View view) {
        updateText(getResources().getString(R.string.zero));
    }
    public void one(View view) {
        updateText(getResources().getString(R.string.one));
    }
    public void two(View view) {
        updateText(getResources().getString(R.string.two));
    }
    public void three(View view) {
        updateText(getResources().getString(R.string.three));
    }
    public void four(View view) {
        updateText(getResources().getString(R.string.four));
    }
    public void five(View view) {
        updateText(getResources().getString(R.string.five));
    }
    public void six(View view) {
        updateText(getResources().getString(R.string.six));
    }
    public void seven(View view) {
        updateText(getResources().getString(R.string.seven));
    }
    public void eight(View view) {
        updateText(getResources().getString(R.string.eight));
    }
    public void nine(View view) {
        updateText(getResources().getString(R.string.nine));
    }
    public void plus(View view) {
        updateText(getResources().getString(R.string.plus));
    }
    public void minus(View view) {
        updateText(getResources().getString(R.string.minus));
    }
    public void multiply(View view) {
        updateText(getResources().getString(R.string.multiply));
    }
    public void divide(View view) {
        updateText(getResources().getString(R.string.divide));
    }
    public void dot(View view) {
        updateText(getResources().getString(R.string.dot));
    }
    public void equal(View view) {
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");
        userExp = userExp.replaceAll(getResources().getString(R.string.minus), "-");
        userExp = userExp.replaceAll(getResources().getString(R.string.squareRoot), "sqrt(");

        Expression expression = new Expression(userExp);
        String result = String.valueOf(expression.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void clear(View view) {
        display.setText("");
    }
    public void back(View view) {
        int cursorPosition = display.getSelectionStart();
        int textLength = display.getText().length();
        if (cursorPosition != 0 && textLength != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            display.setText(selection);
            display.setSelection(cursorPosition - 1);
    }
    }
    public void percent(View view) {
        display.setText(display.getText() + "%");
    }
    public void sin(View view) {
        display.setText(display.getText() + "sin(");
    }
    public void cos(View view) {
        display.setText(display.getText() + "cos(");
    }
    public void tan(View view) {
        display.setText(display.getText() + "tan(");
    }
    public void log(View view) {
        display.setText(display.getText() + "log(");
    }
    public void ln(View view) {
        display.setText(display.getText() + "ln(");
    }
    public void squareRoot(View view) {
        display.setText(display.getText() + "√");
    }
    public void factorial(View view) {
        display.setText(display.getText() + "!");
    }
    public void pi(View view) {
        display.setText(display.getText() + "pi");
    }
    public void e(View view) {
        display.setText(display.getText() + "e");
    }
    public void openBracket(View view) {
        display.setText(display.getText() + "(");
    }
    public void closeBracket(View view) {
        display.setText(display.getText() + ")");
    }
    public void oneDividedByX(View view) {
        display.setText(display.getText() + "1/");
    }
    public void xSquared(View view) {
        display.setText(display.getText() + "^2");
    }
    public void xPowerY(View view) {
        display.setText(display.getText() + "^");
    }
    public void xSquareRootY(View view) {
        display.setText(display.getText() + "^(1/");
    }


}

package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    CalcData calcData = new CalcData();
    TextInputEditText screen;
    TextView testResult;
    TextView testCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        screen = findViewById(R.id.digit_screen);
        testResult = findViewById(R.id.test_result);
        testCurrent = findViewById(R.id.test_current);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:
                Intent intent = new Intent(MainActivity.this,
                        SettingsActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearAll(View view) {
        calcData.clear();
        screen.setText("0.0");
    }

    public void takePercent(View view) {
    }

    public void toMemory(View view) {
    }

    public void doAction(View view) {

        switch (view.getId()) {
            case R.id.button_equal:
                calcData.setLastOperator(CalcData.OPERATORS.EQUAL);
                break;
            case R.id.button_plus:
                calcData.setLastOperator(CalcData.OPERATORS.PLUS);
                break;
            case R.id.button_minus:
                calcData.setLastOperator(CalcData.OPERATORS.MINUS);
                break;
            case R.id.button_divide:
                calcData.setLastOperator(CalcData.OPERATORS.DIVIDE);
                break;
            case R.id.button_multiply:
                calcData.setLastOperator(CalcData.OPERATORS.MULTIPLY);
                break;
            case R.id.button_persent:
                calcData.setLastOperator(CalcData.OPERATORS.PERCENT);
                break;
        }

        showTests();

        screen.setText(calcData.getStingResult());
    }

    public void addNumber(View view) {
        int number = 0;
        switch (view.getId()) {
            case R.id.button_1:
                number = 1;
                break;
            case R.id.button_2:
                number = 2;
                break;
            case R.id.button_3:
                number = 3;
                break;
            case R.id.button_4:
                number = 4;
                break;
            case R.id.button_5:
                number = 5;
                break;
            case R.id.button_6:
                number = 6;
                break;
            case R.id.button_7:
                number = 7;
                break;
            case R.id.button_8:
                number = 8;
                break;
            case R.id.button_9:
                number = 9;
                break;
        }

        screen.setText(calcData.addNumber(number));
        showTests();
    }

    public void showTests() {
        testResult.setText("result: "+calcData.getStingResult());
        testCurrent.setText("current: "+calcData.getStingCurrent());

    }

    public void addPoint(View view) {
        calcData.setPoint();
    }
}
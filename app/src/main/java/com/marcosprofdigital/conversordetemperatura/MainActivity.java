package com.marcosprofdigital.conversordetemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;
    Button mButton;
    RadioButton mRadioButtonFahrenheit, mRadioButtonKelvin;

    private boolean isEmptyValue(){
        return TextUtils.isEmpty(mEditText.getText().toString());
    }

    private double calculateFahrenheit(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
//        double tempF = (tempC * 9/5) + 32;
//        return tempF;
        return (tempC * 9/5) + 32;
    }

    private double calculateKelvin(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
//        double tempK = tempC + 273.15;
//        return tempK;
        return tempC + 273.15;
    }

    public String getResult(){
//        String result = "0";
        String result;
        if(mRadioButtonKelvin.isChecked()){
            //result = Double.toString(calculateKelvin()) + "K";
            result = calculateKelvin() + "K";
        } else {
            //result = Double.toString(calculateFahrenheit()) + "F";
            result = calculateFahrenheit() + "F";
        }
        return result;
    }

    private void showResult(){
        if(isEmptyValue()){
            Toast.makeText(this,"Digite algo", Toast.LENGTH_SHORT).show();
            return;
        }
        mTextView.setText(getResult());
        mEditText.setText("");
    }

    public class ClickMyButton implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            showResult();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutput);

        mButton = findViewById(R.id.buttonCalculate);
        mButton.setOnClickListener(new ClickMyButton());

        mRadioButtonFahrenheit=findViewById(R.id.radioButtonFahrenheit);
        mRadioButtonFahrenheit.setChecked(true);

        mRadioButtonKelvin = findViewById(R.id.radioButtonKelvin);
    }
}
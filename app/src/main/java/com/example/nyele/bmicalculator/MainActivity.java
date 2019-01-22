package com.example.nyele.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText heightSaved;

    public static String MyPREFERENCES = "MyPrefs";
    public static String Height = "height";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getApplicationContext().getSharedPreferences(Height, MODE_PRIVATE);
        String hSaved = sharedPreferences.getString(Height, null);
        EditText heightIn = (EditText) findViewById(R.id.height);
        heightIn.setText(hSaved);
    }

    public void calculateBMI(View view){
        Intent intent = new Intent();
        EditText heightIn = (EditText) findViewById(R.id.height);
        EditText weightIn = (EditText) findViewById(R.id.weight);
        String hin = heightIn.getText().toString();

        //sharedPreferences = getApplicationContext().getSharedPreferences(Height, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Height, hin);
        editor.commit();

        String win = weightIn.getText().toString();
        double height = Double.valueOf(hin);
        height = height/100;
        double weight = Double.valueOf(win);
        double BMI = weight / (height*height);
        TextView updateText = (TextView)findViewById(R.id.result);
        updateText.setText(""+BMI);

        weightIn.setText("");
        String hSaved = sharedPreferences.getString(Height, null);
        heightIn.setText(hSaved);
    }
}

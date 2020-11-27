package com.example.arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int counter;
    int a;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = getIntent().getIntExtra("counter", 0);
        setContentView(R.layout.activity_main);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Random rand = new Random();
        do {
            a =  rand.nextInt(100);
            b = rand.nextInt(100);
        }
        while (b>a);
        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView result = (TextView) findViewById(R.id.score);
        EditText editText = (EditText) findViewById(R.id.editText);

        result.setText(String.valueOf(counter));
        textView.setText(String.valueOf(a) + "-" + String.valueOf(b) + "=");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Ввежите значение", Toast.LENGTH_LONG).show();
                }else if (Integer.parseInt(editText.getText().toString())==(a-b)){
                    Intent intent = new Intent(MainActivity.this, Sucseed.class);
                    intent.putExtra("counter", ++counter);
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(MainActivity.this, Fall.class);
                    intent.putExtra("answer", a-b);
                    startActivity(intent);
                }
            }
        });
    }
}
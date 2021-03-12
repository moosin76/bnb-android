package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
 //   implements View.OnClickListener
{

    TextView text;
    EditText edit;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();
                text.setText(str);
                Toast.makeText(MainActivity.this, "클릭", Toast.LENGTH_SHORT).show();
            }
        });


        // implements View.OnClickListener 방식
        // btn.setOnClickListener(this);
    }

    // implements View.OnClickListener 방식
    /*
    @Override
    public void onClick(View v) {
        Log.d("BTN", "버튼 클릭" );
        if(v.getId() == R.id.btn) {
            Toast.makeText(this, "implements View.OnClickListener", Toast.LENGTH_SHORT).show();
        }
    }
    */

    // XML onClick 속성 방식
/*
    public void OnBtnClickHandler(View view) {
        Toast.makeText(this, "클릭", Toast.LENGTH_LONG).show();
    }
*/
}
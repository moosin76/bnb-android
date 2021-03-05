package kr.ezcode.app0101;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        TextView text2 = findViewById(R.id.text2);

        text.setText("바꿨어");
        text.setClickable(false);
        text.setBackgroundColor(Color.LTGRAY);

        EditText edit = findViewById(R.id.edit);
        edit.setFocusable(false);


    }
}
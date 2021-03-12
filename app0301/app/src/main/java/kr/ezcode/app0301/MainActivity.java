package kr.ezcode.app0301;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView text = findViewById(R.id.text1);
//        text.setText("변경되었어요");
//        text.setTextColor(Color.argb(100,255,0,0));
//        text.setTextSize(70.5f);
//        text.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
    }
}
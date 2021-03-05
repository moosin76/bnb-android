package kr.ezcode.app1101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGood = (Button) findViewById(R.id.good);
        btnGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textPoll = (TextView) findViewById(R.id.question);
                textPoll.setText("Good!!^^");
            }
        });

        Button btnBad = (Button) findViewById(R.id.bad);
        btnBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textPoll = (TextView) findViewById(R.id.question);
                textPoll.setText("Bad~~ㅠㅠ");
            }
        });
    }
}
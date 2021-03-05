package kr.ezcode.app1102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGood = findViewById(R.id.good);
        btnGood.setOnClickListener(this);

        Button btnBad = findViewById(R.id.bad);
        btnBad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textPoll = findViewById(R.id.question);
        switch (v.getId()) {
            case R.id.good:
                textPoll.setText("Good!!^^");
                break;
            case R.id.bad:
                textPoll.setText("Bad~~ㅠㅠ");
                break;
        }
    }
}
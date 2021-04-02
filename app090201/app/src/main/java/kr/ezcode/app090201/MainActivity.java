package kr.ezcode.app090201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        ButtonListener buttonListener = new ButtonListener();
        btn1.setOnClickListener(buttonListener);
        btn2.setOnClickListener(buttonListener);
    }

    public class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1 :
                    Toast.makeText(
                        MainActivity.this,
                        "버튼 1 클릭됨",
                        Toast.LENGTH_SHORT
                    ).show();
                    break;
                case R.id.button2 :
                    Toast.makeText(
                        MainActivity.this,
                        "버튼 2 클릭됨",
                        Toast.LENGTH_SHORT
                    ).show();
                    break;
            }
        }
    }
}
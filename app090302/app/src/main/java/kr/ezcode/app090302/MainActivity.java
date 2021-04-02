package kr.ezcode.app090302;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                btn1Clicked();
                break;
            case  R.id.btn2:
                btn2Clicked();
                break;
        }
    }

    public void btn1Clicked() {
        Toast.makeText(
                MainActivity.this,
                "버튼 1 클릭됨",
                Toast.LENGTH_SHORT
        ).show();
    }
    public void btn2Clicked() {
        Toast.makeText(
                MainActivity.this,
                "버튼 2 클릭됨",
                Toast.LENGTH_SHORT
        ).show();
    }
}
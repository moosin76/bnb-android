package kr.ezcode.app0905;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(v -> Toast.makeText(
            MainActivity.this,
            "버튼 2 클릭됨",
            Toast.LENGTH_SHORT
        ).show());
    }
    public void btn1Handler(View v) {
        Toast.makeText(
            MainActivity.this,
            "버튼 1 클릭됨",
            Toast.LENGTH_SHORT
        ).show();
    }
}
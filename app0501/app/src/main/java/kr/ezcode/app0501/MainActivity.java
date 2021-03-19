package kr.ezcode.app0501;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) btn.getLayoutParams();
        params.gravity = Gravity.RIGHT;
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.weight = 5;
        btn.setLayoutParams(params);
        btn.setGravity(Gravity.LEFT);
    }
}
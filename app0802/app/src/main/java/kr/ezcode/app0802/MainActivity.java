package kr.ezcode.app0802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast mToast = null;
    int count;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.shortMsg).setOnClickListener(mClickListener);
        findViewById(R.id.longMsg).setOnClickListener(mClickListener);
        findViewById(R.id.count).setOnClickListener(mClickListener);
        findViewById(R.id.customView).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.shortMsg:
                    Toast.makeText(MainActivity.this, "Short Time Message", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.longMsg:
                    Toast.makeText(getApplicationContext(), "Long Time Message", Toast.LENGTH_LONG).show();
                    break;
                case R.id.count:
                    str = "Count = " + count++;
                    if(mToast != null) {
                        mToast.cancel();
                    }
                    mToast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    mToast.show();
                    break;
                case R.id.customView:
                    LinearLayout linear = (LinearLayout)View.inflate(MainActivity.this, R.layout.toast_view, null);
                    Toast t2 = new Toast(MainActivity.this);
                    t2.setView(linear);
                    t2.show();
                    break;
            }
        }
    };
}
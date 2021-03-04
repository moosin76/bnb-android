package kr.ezcode.app0902;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View vw = new View(this);

        TouchListenerClass touchListener = new TouchListenerClass();

        vw.setOnTouchListener(touchListener); // 리스너 등록
        setContentView(vw);
    }

    public class TouchListenerClass implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Touch Event Received!", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}
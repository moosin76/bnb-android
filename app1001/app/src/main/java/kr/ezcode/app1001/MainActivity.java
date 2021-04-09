package kr.ezcode.app1001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View vw = new MyView(this);
        vw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(
                        MainActivity.this,
                        "No. 1 Listener : Touch Event Received",
                        Toast.LENGTH_SHORT
                    ).show();
                    return true;
                }
                return false;
            }
        });

        setContentView(vw);
    }

    protected class MyView extends View{

        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(
                        MainActivity.this,
                        "No. 2 Listener : Touch Event Received",
                        Toast.LENGTH_SHORT
                ).show();
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(
                    MainActivity.this,
                    "No. 3 Listener : Touch Event Received",
                    Toast.LENGTH_SHORT
            ).show();
            //  return true;
        }
        return false;
    }
}
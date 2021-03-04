package kr.ezcode.app0903;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View vw = new View(this);
        vw.setOnTouchListener(this);
        setContentView(vw);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(this, "Touch Event Recived!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
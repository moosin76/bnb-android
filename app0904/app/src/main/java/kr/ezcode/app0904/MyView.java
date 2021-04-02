package kr.ezcode.app0904;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View
        implements View.OnTouchListener {
    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(
                getContext(),
                "Touch Event Received!",
                Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        return false;
    }
}

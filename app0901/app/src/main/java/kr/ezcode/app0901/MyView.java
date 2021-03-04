package kr.ezcode.app0901;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(getContext(), "Touch Event Received",Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

}

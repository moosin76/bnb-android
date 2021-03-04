package kr.ezcode.app0801;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TestView extends View {
    public TestView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);
        Paint pnt = new Paint();
        pnt.setColor(Color.RED);
        canvas.drawRect(120, 100, 320, 500, pnt);
    }
}

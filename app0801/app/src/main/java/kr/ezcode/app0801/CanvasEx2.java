package kr.ezcode.app0801;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class CanvasEx2 extends View {

    public CanvasEx2(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);

        Paint pnt = new Paint();
        pnt.setColor(Color.BLACK);
        pnt.setTextSize(80);

        canvas.drawOval(new RectF(10,10,200,120), pnt);
        canvas.drawText("Basic Text", 210, 70, pnt);

        pnt.setAntiAlias(true);
        canvas.drawOval(new RectF(10,130,200,240), pnt);
        canvas.drawText("Antialias Text", 210, 190, pnt);
        pnt.setStrokeCap(Paint.Cap.BUTT);



    }
}

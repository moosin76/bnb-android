package kr.ezcode.app0801;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class CanvasEx3 extends View {
    public CanvasEx3(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(0,0,0);
        Paint pnt = new Paint();

        // 캡모양
        pnt.setColor(Color.RED);
        pnt.setStrokeWidth(10);
        canvas.drawLine(30,30,180,30, pnt);

        pnt.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(30,70,180,70, pnt);

        pnt.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(30,110,180,110, pnt);

        // 모서리 모양
        pnt.setColor(Color.CYAN);
        pnt.setStrokeWidth(15);
        pnt.setStyle(Paint.Style.STROKE);
        pnt.setStrokeJoin(Paint.Join.MITER);
        canvas.drawRect(30, 150, 70, 185, pnt);

        pnt.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawRect(100, 150, 140, 185, pnt);

        pnt.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(170, 150, 210, 185, pnt);

        // 원스타일
        pnt.setColor(Color.GREEN);
        pnt.setStrokeWidth(10);
        pnt.setAntiAlias(true);

        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(40, 250, 30, pnt);

        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(120, 250, 30, pnt);

        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200, 250, 30, pnt);

        // 노란색 채우고 초록생 외각선
        pnt.setColor(Color.YELLOW);
        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(40,330,30,pnt);

        pnt.setColor(Color.GREEN);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(40,330,30,pnt);

        // 녹색 채우고 노란색 외각선
        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(120,330,30,pnt);
        pnt.setColor(Color.YELLOW);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(120,330,30,pnt);
    }
}

package kr.ezcode.app0801;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CanvasEx extends View {
    public CanvasEx(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint pnt = new Paint();

        canvas.drawColor(Color.LTGRAY); //전체 배경색을 지정

        pnt.setColor(Color.RED); // 빨강색 선택
        canvas.drawRect(10,80,80,200, pnt); // 사각형 그리기

        pnt.setColor(Color.BLACK); // 검정색 선택
        canvas.drawPoint(30, 30, pnt); // 점 그리기
        canvas.drawLine(40,150,150,150, pnt); // 선그리기

        pnt.setColor(0x800000ff); // 16진수 형태의 색상 선택 반투명 파랑색
        canvas.drawCircle(80,80,50, pnt); // 원그리기

        pnt.setColor(Color.GREEN); // 녹색 선택
        pnt.setTextSize(5-0);
        canvas.drawText("Canvas Text Finish", 100, 100, pnt); // 문자열 그리기

    }
}

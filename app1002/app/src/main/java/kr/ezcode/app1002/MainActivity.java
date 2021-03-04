package kr.ezcode.app1002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyView vw;
    public class Vertex {
        float x;
        float y;
        boolean draw;

        Vertex(float ax, float ay, boolean ad) {
            x = ax;
            y= ay;
            draw = ad;
        }
    }

    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);
        setContentView(vw);
        arVertex = new ArrayList<Vertex>();
    }

    public class MyView extends View {
        Paint pnt;
        public MyView(Context context) {
            super(context);
            pnt = new Paint();
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(3);
            pnt.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int i;
            canvas.drawColor(Color.LTGRAY);

            for(i=0; i<arVertex.size(); i++) {
                if(arVertex.get(i).draw) {
                    canvas.drawLine(
                        arVertex.get(i-1).x,
                        arVertex.get(i-1).y,
                        arVertex.get(i).x,
                        arVertex.get(i).y,
                        pnt
                    );
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE) {
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate(); // 새로 고침 : onDraw함수 호출
                return true;
            }
            return false;
        }
    }
}


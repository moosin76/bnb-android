package kr.ezcode.app1003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView vw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);
        vw.setFocusable(true); // 입력받을수 있음
        vw.setFocusableInTouchMode(true); // 화면 터치 모드에서도 입력을 받음
        setContentView(vw);
    }

    class MyView extends View {
        float mX, mY, mR, mL;
        int mColor;
        public MyView(Context context) {
            super(context);
            mX = 190;
            mY = 250;
            mR = 290;
            mL = 350;
            mColor = Color.RED;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            Paint pnt = new Paint();
            pnt.setColor(mColor);
            pnt.setAntiAlias(true);
            canvas.drawRect(mX, mY, mR,mL, pnt);
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            super.onKeyDown(keyCode, event);
            if(event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_LEFT :
                        mX -= 5;
                        mR -= 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT :
                        mX += 5;
                        mR += 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_UP :
                        mY -= 5;
                        mL -= 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN :
                        mY += 5;
                        mL += 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_A :
                        if(mColor == Color.RED) {
                            mColor = Color.BLACK;
                        } else {
                            mColor = Color.RED;
                        }
                        invalidate();
                        return true;
                }
            }
            return false;

        }
    }
}
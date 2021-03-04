package kr.ezcode.app0801;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        TestView tv = new TestView(this);
        setContentView(tv);
 */
        View canvasEx = new CanvasEx3(this);
        setContentView(canvasEx);
    }
}
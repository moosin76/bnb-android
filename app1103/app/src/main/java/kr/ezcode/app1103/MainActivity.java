package kr.ezcode.app1103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int value = 0;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.text);
        mHandler.sendEmptyMessage(0); // 핸들러에 빈 메세지를 보냄
    }

    // 핸들러 생성
    Handler mHandler = new Handler() {
        // 핸들러에 메세지가 보내졌을때 실행되는 메소드
        public void handleMessage(Message msg) {
            value++;
            mText.setText("Timer Value = "+ value);
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };
}
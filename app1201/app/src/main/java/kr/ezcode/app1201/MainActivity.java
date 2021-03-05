package kr.ezcode.app1201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        // SubActivity 인텐트 생성
        Intent intent = new Intent(this, SubActivity.class);
        // Intent 보로 액티비티를 시작
        // SubActivity가 AndroidManifest.xml에 등록이 되어 있어야 시작할 수 있다
        startActivity(intent);
    }
}
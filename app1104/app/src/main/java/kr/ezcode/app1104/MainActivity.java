package kr.ezcode.app1104;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    static  final String TAG = "MYAPP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "1. onCreate 호출됨!" );
        // 프로그램 처음에 시작할때 한번만 호출된다
        // 초기화 어떤 로직을 작성

    }
    @Override
    protected void onStart() {
        super.onStart();
        // 버튼을 가져와서 리스너를 달아서 하는 로직을 작성
        Log.d(TAG, "2. onStart 호출됨!" );
    }
    @Override
    protected void onResume() {
        // DB에 있는 데이터를 요기서 불러온다.
        Log.d(TAG, "3. onResume 호출됨!" );
        super.onResume();
    }

    @Override
    protected void onPause() {
        // 현재 상태를 DB에 저장한다.
        Log.d(TAG, "4. onPause 호출됨!" );
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "5. onStop 호출됨!" );
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // 프로그램 종료할때 한번 어떤걸 한다.
        Log.d(TAG, "6. onDestroy 호출됨!" );
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "5->2. onRestart 호출됨!" );
        super.onRestart();
    }
}
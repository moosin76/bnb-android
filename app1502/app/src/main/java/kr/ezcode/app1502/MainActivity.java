package kr.ezcode.app1502;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v) {
        // 어떤 작업을 수행한다...
        try {
            Thread.sleep(500); // 0.5초 멈춤
            boolean errorOccur = true; // 에러가 발생햇다고 가정
            // 서버에 요청 오는 시간 .... 그 결과가 에러가 났다라고 가정

            if(errorOccur) {
                new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("There is insufficient memory to continue This program will exit.")
                    .setPositiveButton("Exit", null)
                    .show();

                finish();
            }
            Toast.makeText(this, "The program was completed", Toast.LENGTH_LONG).show();

            // 정상적인 흐름의 코드
//            if(errorOccur) {
//                new AlertDialog.Builder(this)
//                    .setTitle("Error")
//                    .setMessage("There is insufficient memory to continue This program will exit.")
//                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    })
//                    .show();
//                // 그냥 실행된다.
//            } else {
//                Toast.makeText(this, "The program was completed", Toast.LENGTH_LONG).show();
//            }

        }catch (Exception e) {

        }
    }
}
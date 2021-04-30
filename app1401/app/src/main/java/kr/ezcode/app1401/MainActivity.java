package kr.ezcode.app1401;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("알림")
                    .setMessage("사용자에게 보내는 메세지")
//                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("긍정", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "긍정", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("부정", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "부정", Toast.LENGTH_SHORT).show();
                        }
                    })
//                    .setNeutralButton("중립", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(MainActivity.this, "중립", Toast.LENGTH_SHORT).show();
//                        }
//                    })
                    .setCancelable(false)
                    .show();
                //AlertDialog dialog = builder.create();
                //dialog.show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("단순 다이얼로그")
                    .setMessage("닫거 버튼 한개만 있음")
                    .setNegativeButton("close", null);
                builder.setCancelable(false).show();
//                AlertDialog dialog = builder.create();
//                dialog.show();
            }
        });
    }
}
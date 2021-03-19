package kr.ezcode.app0602;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img0, img1, img2;
    Button prev, next;
    int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img0 = findViewById(R.id.img1);
        img1 = findViewById(R.id.img2);
        img2 = findViewById(R.id.img3);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( idx == 0 ) {  // 2
                    return;
                }
                idx = idx -1; // + 1
                switch (idx) {
                    case 0 :
                        img0.setVisibility(View.VISIBLE);
                        img1.setVisibility(View.GONE);
                        break;
                    case 1:
                        img1.setVisibility(View.VISIBLE);
                        img2.setVisibility(View.GONE);
                        break;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idx == 2) {
                    return;
                }
                idx = idx + 1;
                switch (idx) {
                    case 1 :
                        img0.setVisibility(View.GONE);
                        img1.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        img1.setVisibility(View.GONE);
                        img2.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}
package kr.ezcode.app1301;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arGeneral = new ArrayList<String>();
        arGeneral.add("APPLE");
        arGeneral.add("BANANA");
        arGeneral.add("ORANGE");
        arGeneral.add("MANGO");


        // 아답터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_checked, // 레이아웃 모양 안드로이드 기본 제공
            arGeneral // 데이터
        );

        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter); // 아답터를 적용
    }
}
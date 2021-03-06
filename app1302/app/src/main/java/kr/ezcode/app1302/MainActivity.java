package kr.ezcode.app1302;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
            this,
            R.array.mobile, // values의 arrays.xml의 mobile 배열
            android.R.layout.simple_list_item_1 // 레이아웃
        );
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}
package kr.ezcode.app0401;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText edit;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();
                text.setText(str + " 버튼 눌렸음");
                edit.setText("");
            }
        });

    }

    /*
    public void buttonHandler(View v) {
        String str = edit.getText().toString();
        text.setText(str);
        edit.setText("");
    }
    */
}
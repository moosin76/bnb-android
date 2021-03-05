package kr.ezcode.app1501;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final static int SAMPLE_DIALOG = 0;
    final static int QUESTION_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(SAMPLE_DIALOG);
            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(QUESTION_DIALOG);
            }
        });
    }

    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case SAMPLE_DIALOG :
                return new AlertDialog.Builder(MainActivity.this)
                        .setTitle("MESSAGE")
                        .setMessage("Sample Dialog Test is success!!")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("Close", null)
                        .create();
            case QUESTION_DIALOG :
                return new AlertDialog.Builder(MainActivity.this)
                        .setTitle("QUESTION")
                        .setMessage("Do you like the programming?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("Yes", null)
                        .setNegativeButton("No", null)
                        .create();

        }
        return null;
    }

    @SuppressWarnings("deprecation")
    protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id) {
            case SAMPLE_DIALOG:
                break;
            case QUESTION_DIALOG:
                Calendar calendar = Calendar.getInstance();
                String stime = String.format("Time %d:%d:%d",
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        calendar.get(Calendar.SECOND)
                );
                dialog.setTitle(stime);
                break;
        }
    }




}
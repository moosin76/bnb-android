package kr.ezcode.app1203;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoPermissions.Companion.loadAllPermissions(this, 101);

        Button callBtn = findViewById(R.id.callBtn);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText telText = findViewById(R.id.telText);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+telText.getText()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(
            this,
            requestCode,
            permissions,
            this
        );
    }

    @Override
    public void onDenied(int i, String[] strings) {
        Toast.makeText(
            this,
            "Permissions denied : "+ strings.length,
            Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(
            this,
            "Permissions granted : "+ strings.length,
            Toast.LENGTH_SHORT
        ).show();
    }
}
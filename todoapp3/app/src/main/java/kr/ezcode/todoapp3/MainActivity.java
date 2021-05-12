package kr.ezcode.todoapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    ListView listView;
    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.todoList);
        dbHelper = new DatabaseHelper(this);

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_task:
                EditText taskEdit = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("할일 추가")
                        .setMessage("할일을 입력하세요.")
                        .setView(taskEdit);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO 입력받은 TEXT를 디비에 저장하자
                        String title = taskEdit.getText().toString();
                        // 입력이 안됬으면 디비에 넣지 말자
                        if(title.isEmpty()) {
                            Toast.makeText(MainActivity.this,
                                    "할일을 입력하세요.", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        String sql = "INSERT INTO tasks (title, checked) VALUES ('"+ title+"', 0 )";
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        db.execSQL(sql);
                        db.close();
                        Toast.makeText(MainActivity.this,
                                title + " 등록했습니다.",
                                Toast.LENGTH_SHORT).show();
                        // TODO 화면을 새로고침
                        updateUI();
                    }
                }).setNegativeButton("Cancle", null);
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateUI() {
        // TODO 디비에서 목록을 가져온다.
        String sql = "SELECT * FROM tasks ORDER BY checked ASC";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<TodoItem> list = new ArrayList<>();

        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int check = cursor.getInt(2);
            Log.d("MYAPP", id + " " + title + " " + check);
            TodoItem item = new TodoItem(id, title, check);
            list.add(item);
        }
        cursor.close();
        db.close();


        if(adapter == null) {
            adapter = new TodoAdapter(this, list, dbHelper);
            listView.setAdapter(adapter);
        } else {
            adapter.setTodoList(list);
            adapter.notifyDataSetChanged();
        }
    }
}
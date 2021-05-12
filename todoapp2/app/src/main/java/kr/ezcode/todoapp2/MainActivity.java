package kr.ezcode.todoapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

        dbHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.todoList);

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
                        .setView(taskEdit)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO 텍스트에 쓴거를 디비에 저장한다.
                                String title = taskEdit.getText().toString();
                                String sql = "INSERT INTO tasks (title, checked)" +
                                        " VALUES ('"+ title +"', 0)";
                                SQLiteDatabase db =  dbHelper.getWritableDatabase();
                                db.execSQL(sql);
                                db.close();
                                Toast.makeText(
                                        MainActivity.this,
                                        "할일을 등록했어요.",
                                        Toast.LENGTH_SHORT
                                ).show();
                                // TODO 화면을 다시 그린다.
                                updateUI();
                            }
                        }).setNegativeButton("Cancle", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // 화면을 새로그린다.
    public void updateUI() {
        // TODO DB에서 목록을 가져와 아답터에 등록한다.
        ArrayList<TodoItem> todoList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM tasks ORDER BY checked ASC";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int checked = cursor.getInt(2);
            TodoItem item = new TodoItem(id, title, checked);
            todoList.add(item);
        }
        cursor.close();
        db.close();

        if(adapter == null) {
            adapter = new TodoAdapter(this, todoList, dbHelper);
            listView.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(todoList);
            adapter.notifyDataSetChanged();
        }
    }

}
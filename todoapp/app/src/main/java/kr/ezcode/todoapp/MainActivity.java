package kr.ezcode.todoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private ListView todoList;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        todoList = findViewById(R.id.todoList);

        updateUI();
    }

    // 메뉴 생성
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 메뉴 선택
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_task:
                final EditText taskEdit = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("할일 추가")
                        .setMessage("다음 할일은 무엇인가요?")
                        .setView(taskEdit);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = taskEdit.getText().toString();
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(DatabaseHelper.TaskEntry._TITLE, task);
                        values.put(DatabaseHelper.TaskEntry._CHECK, 0);
                        db.insertWithOnConflict(DatabaseHelper.TaskEntry.TABLE,null,values, SQLiteDatabase.CONFLICT_REPLACE);
                        db.close();
                        Toast.makeText(MainActivity.this, task+" 등록하였습니다.", Toast.LENGTH_SHORT).show();
                        updateUI();
                    }
                }).setNegativeButton("Cancle", null);
                builder.create().show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // UI를 새로 고침
    public void updateUI() {
        ArrayList<TodoItem> taskList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TaskEntry.TABLE +
                " ORDER BY " + DatabaseHelper.TaskEntry._CHECK + " ASC ",null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int check = cursor.getInt(2);

            TodoItem item = new TodoItem(id, title, check);
            taskList.add(item);
        }
        if(adapter == null) { // 처음실행시 아답터를 세팅
            adapter = new TodoAdapter(this, taskList, dbHelper);
            todoList.setAdapter(adapter);
        } else {
            adapter.clear(); // 모든 목록을 삭제
            adapter.addAll(taskList); // 모든 아이템리스트를 등록
            adapter.notifyDataSetChanged(); // 변경을 알림
        }
        cursor.close();
        db.close();
    }

}
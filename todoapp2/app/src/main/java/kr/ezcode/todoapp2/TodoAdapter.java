package kr.ezcode.todoapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<TodoItem> todoList;
    DatabaseHelper dbHelper;

    public TodoAdapter(Context ctx, ArrayList<TodoItem> todoList, DatabaseHelper dbHelper) {
        this.ctx = ctx;
        this.todoList = todoList;
        this.dbHelper = dbHelper;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public TodoItem getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        todoList.clear();
    }

    public void addAll(ArrayList<TodoItem> todoList) {
        this.todoList.addAll(todoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.todo_item, null);

        TextView title = view.findViewById(R.id.title);
        ImageButton checked = view.findViewById(R.id.check);
        ImageButton remove = view.findViewById(R.id.remove);

        TodoItem item = getItem(position);

        title.setText(item.getTitle());
        if(item.getChecked() == 1) { // 완료된 상태
            title.setTextColor(Color.LTGRAY); // 텍스트 색상 흐리게
            checked.setColorFilter(Color.LTGRAY); // 체크버튼 색상 흐리게
            // 텍스트 가운데 줄 쫘~
            title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            // 삭제 하는거
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(item); // 삭제
                }
            });
        } else { // 완료된 상태
            remove.setColorFilter(Color.LTGRAY); // 삭제버튼 흐리게
        }

        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem(item); // 체크를 변경하는거
            }
        });
        return view;
    }

    void updateItem(TodoItem item) {
        int checked = item.getChecked() == 0 ? 1 : 0;
        String msg = item.getTitle() + (checked==1 ? " 완료" : " 미완료")  + " 하였습니다.";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "UPDATE tasks SET checked=" + checked +
                " WHERE id=" + item.getId();
        db.execSQL(sql);
        db.close();
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        ((MainActivity)ctx).updateUI(); // 화면 갱신
    }

    void removeItem(TodoItem item) {
        String msg = item.getTitle() + " 삭제하였습니다.";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "DELETE FROM tasks WHERE id=" + item.getId();
        db.execSQL(sql);
        db.close();
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        ((MainActivity)ctx).updateUI();
    }
}

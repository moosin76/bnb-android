package kr.ezcode.todoapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {
    public static String TAG = "MY APDAPTER";
    private Context ctx;
    private ArrayList<TodoItem> todoList;
    private DatabaseHelper dbHelper;

    public TodoAdapter(Context context, ArrayList<TodoItem> todoList, DatabaseHelper dbHelper) {
        this.ctx = context;
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
        TodoItem item = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.todo_item, null);

        TextView title = view.findViewById(R.id.title);
        title.setText(item.getTitle());
        ImageButton check = view.findViewById(R.id.check);
        ImageButton remove = view.findViewById(R.id.remove);

        if(item.getCheck() == 1) { // 완료된 목록
            check.setColorFilter(Color.LTGRAY);
            title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            title.setTextColor(Color.LTGRAY);
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemRemove(item);
                }
            });
        } else {
            remove.setColorFilter(Color.LTGRAY);
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCheck(item);
            }
        });
        return view;
    }

    void itemCheck(TodoItem item) {
        int complete = item.getCheck() == 0 ? 1 : 0;
        String msg = item.getTitle() + (complete == 1 ? " 완료" : " 미완료") + " 처리 하였습니다.";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "UPDATE " + DatabaseHelper.TaskEntry.TABLE
                + " SET " + DatabaseHelper.TaskEntry._CHECK + "=" + complete
                + " WHERE " + DatabaseHelper.TaskEntry._ID + "=" + item.getId();
        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();

        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        ((MainActivity)ctx).updateUI();
    }

    void itemRemove(TodoItem item) {
        String msg = item.getTitle() + " 삭제하였습니다.";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "DELETE FROM " + DatabaseHelper.TaskEntry.TABLE
                + " WHERE " + DatabaseHelper.TaskEntry._ID + "=" + item.getId();
        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        ((MainActivity)ctx).updateUI();

    }
}

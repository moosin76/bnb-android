package kr.ezcode.todoapp3;

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

    public void setTodoList(ArrayList<TodoItem> list) {
        todoList.clear();
        todoList.addAll(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.todo_item, null);
        TodoItem item = getItem(position);

        TextView title = view.findViewById(R.id.title);
        ImageButton check = view.findViewById(R.id.check);
        ImageButton remove = view.findViewById(R.id.remove);

        title.setText(item.getTitle());
        if(item.getChecked() == 1) { // 할일을 다 한거
            check.setColorFilter(Color.LTGRAY);
            title.setTextColor(Color.LTGRAY);
            // 취소선 긋기
            title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO DB에서 삭제할꺼임침
                    String sql = "DELETE FROM tasks WHERE id=" + item.getId();
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL(sql);
                    db.close();
                    Toast.makeText(ctx, item.getTitle()+" 삭제하였습니다.", Toast.LENGTH_SHORT).show();
                    // TODO 화면 새로고침
                    ((MainActivity)ctx).updateUI();
                }
            });
        } else { // 아직 안한거
            remove.setColorFilter(Color.LTGRAY);
        }

//        Log.d("MYAPP", item.getTitle());

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "";
                String msg = "";
                if(item.getChecked() == 1) { // 체크 되었을때는
                    // TODO 체크를 해제할꺼고
                    sql = "UPDATE tasks SET checked=0 WHERE id="+item.getId();
                    msg = item.getTitle() + " 체크 해제 하였습니다.";
                } else { // 체크가 안되어 있으면
                    sql = "UPDATE tasks SET checked=1 WHERE id="+item.getId();
                    msg = item.getTitle() + " 체크 하였습니다.";
                }
                // TODO DB에 업데이트 한다.
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(sql);
                db.close();

                // 메시지 보여주기
                Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();

                // TODO 화면 새로고침
                ((MainActivity)ctx).updateUI();
            }
        });

        return view;
    }
}

package kr.ezcode.todoapp3;

public class TodoItem {
    int id;
    String title;
    int checked;

    public TodoItem(int id, String title, int checked) {
        this.id = id;
        this.title = title;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getChecked() {
        return checked;
    }
}

package kr.ezcode.todoapp;

public class TodoItem {
    int id;
    String title;
    int check;

    public TodoItem(int id, String title, int check) {
        this.id = id;
        this.title = title;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCheck() {
        return check;
    }

}

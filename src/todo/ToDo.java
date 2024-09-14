package todo;

import java.util.Date;
import java.util.Scanner;

public class ToDo {
    private String title;
    private boolean completedAt;

    public ToDo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(boolean completedAt) {
        this.completedAt = completedAt;
    }
}

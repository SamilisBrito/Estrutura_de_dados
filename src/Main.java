import browserHistory.History;
import todo.ToDoList;
import undo.Undo;

public class Main {
    public static void main(String[] args) {
        ToDoList test = new ToDoList();
        History history1 = new History();
        Undo undo = new Undo();
        history1.menu();
        test.menu();
        undo.menu();

    }
}
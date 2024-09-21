import browserHistory.History;
import doublyLinkedList.DoublyLinkedList;
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

        DoublyLinkedList<String> teste = new DoublyLinkedList<String>();
        teste.add("oi");
        teste.add("olá");
        teste.add("eaí?");
        teste.changeElementByIndex("beleza?", 0);
        System.out.println(teste.getSize());
        System.out.println("Peguei " + teste.getByIndex(1));
        teste.print();


    }
}
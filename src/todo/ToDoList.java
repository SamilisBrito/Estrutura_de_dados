package todo;

import simplyLinkedList.SimplyLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoList {
    private SimplyLinkedList<ToDo> todoList;

    public ToDoList() {
        this.todoList = new SimplyLinkedList<ToDo>();
    }

    Scanner scanner = new Scanner(System.in);

    private void print() {
        System.out.printf("%" + 20 + "s%n", "***ToDo***");

        if (this.todoList.getSize() == 0) {
            System.out.println("Ainda não tem nenhum item, adicione");
            return;
        }

        for (int i = 0; i < this.todoList.getSize(); i++) {
            String state = this.todoList.getByIndex(i).getCompletedAt() ? "Concluído" : "Não concluído";
            System.out.printf("[%d] Title: %s -> Estado: %s %n", i, this.todoList.getByIndex(i).getTitle(), state);
        }

        System.out.printf("-".repeat(40) + "%n");

    }

    private void addItem(String title) {
        this.todoList.add(new ToDo(title));
    }

    private void removeItem(int index) {
        if (index > this.todoList.getSize() - 1 || index < 0) {
            System.out.printf("Opção %d não existe%n", index);
            return;
        }
        this.todoList.remove(index);
    }

    private void complete(int option) {
        if (option > this.todoList.getSize() - 1 || option < 0) {
            System.out.printf("Opção %d não existe%n", option);
            return;
        }
        this.todoList.getByIndex(option).setCompletedAt(true);
    }

    public void menu() {
        int option = 6;
        while (option != 0) {
            int index;
            print();
            System.out.printf("%n[1] - Adicionar item%n");
            System.out.println("[2] - Remover item");
            System.out.println("[3] - Concluir item");
            System.out.println("[0] - Sair");

            boolean inputValido = false;
            while (!inputValido) {
                try {
                    System.out.print("Opção: ");
                    option = scanner.nextInt();
                    scanner.nextLine();
                    inputValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    scanner.nextLine();
                }
            }

            switch (option) {
                case 1:
                    System.out.printf("Qual a tarefa? ");
                    String title = scanner.nextLine();
                    addItem(title);
                    break;
                case 2:
                    System.out.println("Qual o index? ");
                    index = scanner.nextInt();
                    removeItem(index);
                    break;
                case 3:
                    System.out.println("Qual o index? ");
                    index = scanner.nextInt();
                    complete(index);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inexistente");
            }
        }
    }

}

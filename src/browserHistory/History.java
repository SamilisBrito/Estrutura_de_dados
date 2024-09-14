package browserHistory;

import simplyLinkedList.SimplyLinkedList;
import todo.ToDo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class History {
    private int maxSize = 5;
    String urlRemoved = "";
    private SimplyLinkedList<String> history;
    Scanner scanner = new Scanner(System.in);

    public History() {
        this.history = new SimplyLinkedList<>();
    }

    private void print() {
        System.out.printf("%n%" + 20 + "s%n", "***Histórico***");

        if (this.history.getSize() == 0) {
            System.out.println("Ainda não tem nenhum histórico, navegue");
            return;
        }

        for (int i = 0; i < this.history.getSize(); i++) {
            System.out.printf("[%d] %s %n", i, this.history.getByIndex(i));
        }

        if (urlRemoved != "") {
        System.out.printf("-".repeat(40) + "%n");
            System.out.printf("Url \"%s\" removida por atingir tamanho máximo de %d itens no armazenamento do histórico %n", urlRemoved, maxSize);
        }
        System.out.printf("-".repeat(40) + "%n");

    }

    private void addItem(String url) {

        if (this.history.getSize() == 5) {
            urlRemoved = this.history.getByIndex(0);
            this.history.remove(0);
        }
        this.history.add(url);

    }

    public void menu() {
        int option = 6;
        while (option != 0) {
            print();
            System.out.printf("%n[1] - Adicionar url%n");
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
                    System.out.printf("Qual a url? ");
                    String url = scanner.nextLine();
                    addItem(url);
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

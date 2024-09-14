package undo;

import simplyLinkedList.SimplyLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Undo {
    private SimplyLinkedList<String> data;
    Scanner scanner = new Scanner(System.in);


    public Undo() {
        this.data = new SimplyLinkedList<String>();
    }

    private void print() {
        System.out.printf("%n%" + 20 + "s%n", "***Texto***");

        if (this.data.getSize() == 0) {
            System.out.println("Ainda não tem nenhum texto, escreva");
            return;
        }

        for (int i = 0; i < this.data.getSize(); i++) {
            System.out.print(this.data.getByIndex(i) + " ");
        }
        System.out.println("");
        System.out.printf("-".repeat(40) + "%n");

    }

    private void addItem(String item) {
        this.data.add(item);
    }


    private void undo(int index) {
        this.data.remove(index);
    }

    public void menu() {
        int option = 6;
        while (option != 0) {
            print();
            System.out.printf("%n[1] - Adicionar texto%n");
            System.out.printf("[2] - Ctrl + z%n");
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
                    System.out.printf("Escreva a palavra: ");
                    String url = scanner.nextLine();
                    addItem(url);
                    break;
                case 2:
                    undo(this.data.getSize()-1);
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

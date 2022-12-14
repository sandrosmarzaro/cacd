package br.edu.ifes.cacd;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Digrafo G;

    public static void main(String[] args) {
        processDigraph(args);
        mainMenu();
    }

    public static void processDigraph(String[] args) {
        In in = new In(args[0]);
        G = new Digrafo(in);
    }

    public static void mainMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            clearConsole();
            System.out.println("\nCACD - Citações de Artigos Científicos em Dígrafos");
            System.out.println("-".repeat(50));
            System.out.println("1 - Algoritmo de Menor Caminho");
            System.out.println("2 - Algoritmo de Todos os Caminhos");
            System.out.println("3 - Algoritmo de Top Artigos");
            System.out.println("4 - Algoritmo de Top Autores");
            System.out.println("5 - Escolher Dígrafo");
            System.out.println("0 - Sair");
            System.out.println("-".repeat(50));
            System.out.print("Escolha uma opção: ");
            try {
                option = scanner.nextInt();
            }
            catch (Exception e) {
                option = -1;
            }
            finally {
                processOption(scanner, option);
            }
        } while (option != 0);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void processOption(Scanner scanner, int option) {
        switch (option) {
            case 0 -> exitMenu(scanner);
            case 1 -> AlgoritimoMenorQtdArtigosLidos.run(scanner, G);
            case 2 -> AlgoritmoTodosCaminhos.run(scanner, G);
            case 3 -> AlgoritmoTopArtigos.run(scanner, G);
            case 4 -> AlgoritmoTopAutores.run(scanner, G);
            case 5 -> chooseDigraph(scanner);
            default -> invalidOptionMenu();
        }
    }

    public static void exitMenu(Scanner scanner) {
        clearConsole();
        System.out.println("-".repeat(50));
        System.out.println("Obrigado por utilizar o CACD!");
        System.out.println("-".repeat(50));
        try (scanner) {
            Thread.sleep(1250);
        } catch (Exception e) {
            System.out.println("Erro ao aguardar!");
        } finally {
            clearConsole();
        }
    }

    public static void invalidOptionMenu() {
        clearConsole();
        System.out.println("-".repeat(50));
        System.out.println("Opção inválida!");
        System.out.println("-".repeat(50));
        try {
            Thread.sleep(1250);
        } catch (Exception e) {
            System.out.println("Erro ao aguardar!");
        }
    }

    private static void chooseDigraph(Scanner scanner) {
        Main.clearConsole();
        System.out.println("Escolha um dígrafo:");
        System.out.println("-".repeat(50));
        File folder = new File("./");
        File[] listOfFiles = folder.listFiles();
        try {
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(i + 1 + " - " + listOfFiles[i].getName());
                }
            }
        }
        catch (Exception e) {
            System.out.println("Erro ao listar arquivos!");
        }
        System.out.println("0 - Voltar");
        System.out.println("-".repeat(50));
        System.out.print("Opção: ");
        int option = scanner.nextInt();
        if (option != 0) {
            assert listOfFiles != null;
            try {
                Main.processDigraph(new String[]{listOfFiles[option - 1].getName()});
            }
            catch (Exception e) {
                System.out.println("Erro ao processar dígrafo!");
            }
        }
    }
}

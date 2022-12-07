package br.edu.ifes.cacd;

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
            case 0:
                exitMenu(scanner);
                break;
            case 1:
                AlgoritimoMenorQtdArtigosLidos.run(scanner, G);
                break;
            case 2:
                AlgoritmoTodosCaminhos.run(scanner, G);
                break;
            case 3:
                AlgoritmoTopArtigos.run(scanner, G);
                break;
            case 4:
                AlgoritmoTopAutores.run(scanner, G);
                break;
            default:
                invalidOptionMenu();
                break;
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
}

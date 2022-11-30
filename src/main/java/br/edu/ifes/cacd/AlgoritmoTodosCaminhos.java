package br.edu.ifes.cacd;

import java.util.Scanner;

public class AlgoritmoTodosCaminhos {

    private boolean[] noCaminho;
    private Pilha<Integer> caminho;
    private static int numeroDeCaminhos;

    public AlgoritmoTodosCaminhos(Digrafo G, int vo, int vd) {
        noCaminho = new boolean[G.V()];
        caminho = new Pilha<>();
        numeroDeCaminhos = 0;
        dfs(G, vo, vd);
    }

    public void dfs(Digrafo G, int vo, int vd) {
        caminho.empilha(vo);
        noCaminho[vo] = true;
        if (vo == vd) {
            imprimeCaminhoAtual();
            numeroDeCaminhos++;
        }
        else {
            for (Aresta a : G.adj(vo)) {
                int x = a.getV2();
                if (!noCaminho[x]) {
                    dfs(G, x, vd);
                }
            }
        }
        caminho.desempilha();
        noCaminho[vo] = false;
    }

    public void imprimeCaminhoAtual() {
        Pilha<Integer> pilhaInvertida = new Pilha<>();
        for (int v : caminho) {
            pilhaInvertida.empilha(v);
        }
        if (pilhaInvertida.tamanho() >= 1) {
            System.out.print(pilhaInvertida.desempilha());
        }
        while (!pilhaInvertida.isEmpty()) {
            System.out.print("->" + pilhaInvertida.desempilha());
        }
        System.out.println();
    }

    public static void run(Scanner scanner, Digrafo G) {
        int option;
        do {
            Main.clearConsole();
            System.out.println("-".repeat(50));
            System.out.print("Digite o vértice de origem: ");
            int vo = scanner.nextInt();

            Main.clearConsole();
            System.out.println("-".repeat(50));
            System.out.print("Digite o vértice de destino: ");
            int vd = scanner.nextInt();

            Main.clearConsole();
            System.out.printf("\nb) Todos os caminhos entre %d e %d\n", vo, vd);
            System.out.println("-".repeat(50));

            AlgoritmoTodosCaminhos todosCaminhos = new AlgoritmoTodosCaminhos(G, vo, vd);

            System.out.println("-".repeat(50));
            System.out.printf("# Caminhos = %d\n", numeroDeCaminhos);
            System.out.println("-".repeat(50));
            System.out.println("\n1 - Continuar\t\t\t0 - Voltar");
            System.out.println("-".repeat(50));
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }
}

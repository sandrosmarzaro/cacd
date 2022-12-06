package br.edu.ifes.cacd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlgoritmoTopAutores {

    public static void run(Scanner scanner, Digrafo G) {
        int option;
        do {
            Main.clearConsole();
            System.out.println("d) Top Autores");
            System.out.println("-".repeat(50));

            Map<Integer, Integer> autoresPorQtdCitacoes  = new HashMap<>();

            for (int artigoLido = 0; artigoLido < G.V(); artigoLido++) {
                for (Aresta aresta : G.adj(artigoLido)) {
                    int artigoCitado = aresta.getV2();
                    int autorCitado = G.vertices().get(artigoCitado);
                    if (!autoresPorQtdCitacoes.containsKey(autorCitado)) {
                        autoresPorQtdCitacoes.put(autorCitado, 1);
                    }
                    else {
                        int qtdCitacoes = autoresPorQtdCitacoes.get(autorCitado);
                        autoresPorQtdCitacoes.put(autorCitado, qtdCitacoes + 1);
                    }
                }
            }
            autoresPorQtdCitacoes.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);

            System.out.println("-".repeat(50));
            System.out.println("1 - Calcular Novamente\t\t0 - Voltar");
            System.out.println("-".repeat(50));
            System.out.print("Opção: ");
            option = scanner.nextInt();
        } while (option != 0);
    }
}

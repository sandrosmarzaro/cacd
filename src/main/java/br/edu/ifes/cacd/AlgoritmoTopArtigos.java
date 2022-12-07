package br.edu.ifes.cacd;

import java.util.Scanner;

public class AlgoritmoTopArtigos {

    public static void run(Scanner scanner,Digrafo G) {
        int option;
        
        do{
            Main.clearConsole();
            System.out.println("c) Top Artigos");
            System.out.println("-----------------------------------------");

            int[] quantRefArtigos = new int[G.V()];

            for (int artigoLido = 0; artigoLido < G.V(); artigoLido++) {
                for (Aresta aresta : G.adj(artigoLido)) {
                    int referencia = aresta.getV2();
                    quantRefArtigos[referencia]++;
                }
            }

            for(int x = 0; x < quantRefArtigos.length; x++){
                System.out.printf("Artigo[%d] : %d\n", x, quantRefArtigos[x]);
            }

            System.out.println("-----------------------------------------");
            System.out.println("1 - Calcular Novamente\t\t0 - Voltar");
            System.out.println("-----------------------------------------");
            System.out.print("Opção: ");
            option = scanner.nextInt();
        }while(option != 0);
    }
}


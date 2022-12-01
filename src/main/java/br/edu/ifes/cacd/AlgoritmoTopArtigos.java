package br.edu.ifes.cacd;

public class AlgoritmoTopArtigos {

    public static void run(Scanner scanner, Digrafo G) {
        int option;

        Main.clearConsole();
        System.out.println("c) Top Artigos");
        System.out.println("-".repeat(50));

        int[] quantRefArtigos = new int[G.V()];

        for (int artigoLido = 0; artigoLido < G.V(); artigoLido++) {
            for (Aresta aresta : G.adj(artigoLido)) {
                int referencia = aresta.getV2();
                quantRefArtigos[referencia]++;
            }
        }

        for(int x = 0; x < quantRefArtigos.lenght(); x++){
            System.out.printf("Artigo[%d] : %d", x, quantRefArtigos[x]);
        }
    }
}


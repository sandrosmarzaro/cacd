package br.edu.ifes.cacd;

import java.util.Scanner;

public class AlgoritimoMenorQtdArtigosLidos {

    private static final int INFINITY = Integer.MAX_VALUE;
    private final boolean[] marcado;
    private final int[] arestaPara;
    private final int[] distanciaPara;

    
    public AlgoritimoMenorQtdArtigosLidos(Digrafo G, int vo) {
        marcado = new boolean[G.V()];
        distanciaPara = new int[G.V()];
        arestaPara = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distanciaPara[v] = INFINITY;
        }
        bfs(G, vo);
    }

    private void bfs(Digrafo G, int vo) {
        Fila<Integer> f = new Fila<Integer>();
        f.enfileira(vo);
        marcado[vo] = true;
        distanciaPara[vo] = 0;
        while (!f.isEmpty()) {
            int v = f.desenfileira();
            for (Aresta a : G.adj(v)) {
                int x = a.getV2();
                if (!marcado[x]) {
                    arestaPara[x] = v;
                    distanciaPara[x] = distanciaPara[v] + 1;
                    marcado[x] = true;
                    f.enfileira(x);
                }
            }
        }
    }

    public boolean temCaminhoPara(int v) {
        return marcado[v];
    }

    public int distanciaPara(int v) {
        return distanciaPara[v];
    }

    public Iterable<Integer> caminhoPara(int v) {
        if (!temCaminhoPara(v)) {
            return null;
        }
        Pilha<Integer> caminho = new Pilha<Integer>();
        int x;
        for (x = v; distanciaPara[x] != 0; x = arestaPara[x]) {
            caminho.empilha(x);
        }
        caminho.empilha(x);
        return caminho;
    }

    public static void run(Scanner scanner, Digrafo G) {
        int option;
        
        do{
            Main.clearConsole();
            System.out.println("-----------------------------------------");
            System.out.print("Digite o vértice de origem: ");
            int vo = scanner.nextInt();

            Main.clearConsole();
            System.out.println("-----------------------------------------");
            System.out.print("Digite o vértice de destino: ");
            int vd = scanner.nextInt();

            AlgoritimoMenorQtdArtigosLidos algoritmoBFS = new AlgoritimoMenorQtdArtigosLidos(G, vo);

            if(algoritmoBFS.temCaminhoPara(vd)){
                System.out.printf("%d para %d (%d):  ", vo, vd, algoritmoBFS.distanciaPara(vd));
                for(int x : algoritmoBFS.caminhoPara(vd)){
                    if (x == vo){
                            System.out.print(x);
                        }else{
                            System.out.print("->" + x);
                        }
                }
                System.out.println();
                } else {
                    System.out.printf("%d para %d (-):  não conectado\n", vo, vd);
                }
            
            System.out.println("-----------------------------------------");
            System.out.println("1 - Calcular Novamente\t\t0 - Voltar");
            System.out.println("-----------------------------------------");
            System.out.print("Opção: ");
            option = scanner.nextInt();
        }while(option != 0);
    }
}

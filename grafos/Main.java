//Arthur de Castro Dias - 16855302
//GUilherme Cavalcanti de Santana - 15456556

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrafoListaAdjacencia gLista = new GrafoListaAdjacencia();
        GrafoMatrizAdjacencia gMatriz = new GrafoMatrizAdjacencia();
        GrafoMatrizAdjacenciaPonderado gPonderado = new GrafoMatrizAdjacenciaPonderado();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            String[] partes = linha.split(" ");

            switch (partes[0]) {
                case "i":
                    int peso = Integer.parseInt(partes[3]);

                    gLista.adicionarVertice(partes[1]);
                    gLista.adicionarVertice(partes[2]);
                    gLista.adicionarAresta(partes[1], partes[2]);

                    gMatriz.adicionarVertice(partes[1]);
                    gMatriz.adicionarVertice(partes[2]);
                    gMatriz.adicionarAresta(partes[1], partes[2]);

                    gPonderado.adicionarVertice(partes[1]);
                    gPonderado.adicionarVertice(partes[2]);
                    gPonderado.adicionarAresta(partes[1], partes[2], peso);
                    break;

                case "d":
                    if (partes.length == 3) {
                        gLista.removerAresta(partes[1], partes[2]);
                        gMatriz.removerAresta(partes[1], partes[2]);
                        gPonderado.removerAresta(partes[1], partes[2]);
                    } else if (partes.length == 2) {
                        gLista.removerVertice(partes[1]);
                        gMatriz.removerVertice(partes[1]);
                        gPonderado.removerVertice(partes[1]);
                    }
                    break;

                case "p":
                    System.out.println(gLista);
                    System.out.println(gMatriz);
                    System.out.println(gPonderado);
                    break;

                default:
                    System.out.println("Comando inválido!");
                    break;
            }
        }

        scanner.close();
    }
}
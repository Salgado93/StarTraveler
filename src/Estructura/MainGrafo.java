/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.awt.Color;

/**
 *
 * @author luigy
 */
public class MainGrafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grafo grafo = new Grafo();
        grafo.AddVertice(new Estrella(1, "Estrella1"));
        grafo.AddVertice(new Estrella(2, "Estrella2"));
        grafo.AddVertice(new Estrella(3, "Estrella3"));
        grafo.AddVertice(new Estrella(4, "Estrella4"));
        grafo.AddVertice(new Estrella(5, "Estrella5"));
        grafo.AddVertice(new Estrella(6, "Estrella6"));
        grafo.AddVertice(new Estrella(7, "Estrella7"));
        grafo.AddVertice(new Estrella(8, "Estrella8"));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(1).getValor(), 10));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 5));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 2));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(3).getValor(), 15));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(3).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 2));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(4).getValor(), (Estrella) grafo.getVertices().get(5).getValor(), 100));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(2).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 2));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(2).getValor(), (Estrella) grafo.getVertices().get(6).getValor(), 7));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(6).getValor(), (Estrella) grafo.getVertices().get(7).getValor(), 5));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(5).getValor(), (Estrella) grafo.getVertices().get(7).getValor(), 20));
        Dijkstra((Estrella) grafo.getVertices().get(0).getValor(), grafo);

    }

    static void Dijkstra(Estrella origen, Grafo grafo) {
        Lista visitados = new Lista();
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            visitados.insert(new Nodo(null, false));
        }
        int[][] matriz = new int[grafo.getVertices().size()][grafo.getVertices().size()];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Integer.MAX_VALUE;
            }
        }
        Pila adyacentes = new Pila();
        Pila adyacentes2 = new Pila();
        Cola adyacentes3 = new Cola();
        Estrella actual = origen;
        adyacentes2 = Adyacentes(actual, grafo, adyacentes2);
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            adyacentes = Adyacentes(actual, grafo, adyacentes);
            while (!adyacentes.IsEmpty()) {
                Estrella temporal = (Estrella) adyacentes.Desapilar();
                System.err.println("Estrela" + temporal);
                adyacentes3.queue(temporal);
                int peso = Peso(actual, temporal, grafo, origen);
                if (i > 0) {
                    if (peso < matriz[i - 1][temporal.getId() - 1]) {
                        matriz[i][temporal.getId() - 1] = Peso(actual, temporal, grafo, origen);
                    } else {
                        matriz[i][temporal.getId() - 1] = matriz[i - 1][temporal.getId() - 1];
                    }
                } else {
                    matriz[i][temporal.getId() - 1] = Peso(actual, temporal, grafo, origen);
                }

            }
            if (!adyacentes3.isEmpty()) {
                actual = (Estrella) adyacentes3.Dequeue();
            }

        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i > 0) {
                    if (matriz[i - 1][j] < matriz[i][j]) {
                        matriz[i][j] = matriz[i - 1][j];
                    }
                }
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

    }

    static void Peso2(int peso, Estrella anterior, Grafo grafo, Estrella puntoA) {

    }

    static int Peso(Estrella puntoA, Estrella puntoB, Grafo grafo, Estrella origen) {
        int peso = 0, peso2 = 0;
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA() == puntoA
                    && ((Arista) grafo.getAristas().get(i).getValor()).getPuntoB() == puntoB && ((Arista) grafo.getAristas().get(i).getValor()).getPuntoA() == origen) {
                peso = ((Arista) grafo.getAristas().get(i).getValor()).getPeso();
            } else if ((((Arista) grafo.getAristas().get(i).getValor()).getPuntoA() == puntoA
                    && ((Arista) grafo.getAristas().get(i).getValor()).getPuntoB() == puntoB)) {
                Estrella anterior = origen;
                boolean noEncontrado = true;
                Pila adyacentes = new Pila();
                Cola adyacentes3 = new Cola();
                do {
                    adyacentes = Adyacentes(anterior, grafo, adyacentes);
                    while (!adyacentes.IsEmpty()) {
                        Estrella temporal = (Estrella) adyacentes.Desapilar();
                        adyacentes3.queue(temporal);
                        if (temporal.getId() == puntoA.getId()) {
                            noEncontrado = false;
                            break;
                        }
                    }
                    if (noEncontrado) {
                        if (!adyacentes3.isEmpty()) {
                            anterior = (Estrella) adyacentes3.Dequeue();
                        } else {
                            noEncontrado = false;
                        }
                    }
                } while (noEncontrado);
                for (int j = 0; j < grafo.getAristas().size(); j++) {
                    if (((Arista) grafo.getAristas().get(j).getValor()).getPuntoA() == anterior && ((Arista) grafo.getAristas().get(j).getValor()).getPuntoB() == puntoA) {
                        peso2 += ((Arista) grafo.getAristas().get(j).getValor()).getPeso();
                    }
                }
                Estrella temPuntoA = origen;
                if (anterior.getId() != origen.getId()) {
                    do {
                        noEncontrado = true;
                        adyacentes = new Pila();
                        adyacentes3 = new Cola();

                        do {
                            adyacentes = Adyacentes(temPuntoA, grafo, adyacentes);
                            while (!adyacentes.IsEmpty()) {
                                Estrella temporal = (Estrella) adyacentes.Desapilar();
                                adyacentes3.queue(temporal);
                                if (temporal.getId() == anterior.getId()) {
                                    noEncontrado = false;
                                    break;
                                }
                            }
                            if (noEncontrado) {
                                if (!adyacentes3.isEmpty()) {
                                    temPuntoA = (Estrella) adyacentes3.Dequeue();
                                } else {
                                    noEncontrado = false;
                                }
                            }
                        } while (noEncontrado);
                        for (int j = 0; j < grafo.getAristas().size(); j++) {
                            if (((Arista) grafo.getAristas().get(j).getValor()).getPuntoA() == temPuntoA && ((Arista) grafo.getAristas().get(j).getValor()).getPuntoB() == anterior) {
                                peso2 += ((Arista) grafo.getAristas().get(j).getValor()).getPeso();
                            }
                        }
                        anterior = temPuntoA;
                    } while (temPuntoA.getId() != origen.getId());
                }
                peso = ((Arista) grafo.getAristas().get(i).getValor()).getPeso() + peso2;
            }
        }
        return peso;
    }

    static Pila Adyacentes(Estrella actual, Grafo grafo, Pila adyacentes) {
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA().getId() == actual.getId()) {
                System.out.println((Arista) ((Arista) grafo.getAristas().get(i).getValor()));
                adyacentes.Apilar((Estrella) ((Arista) grafo.getAristas().get(i).getValor()).getPuntoB());
            }
            /* if (i == actual.getNumAristas()) {
                break;
            }*/
        }
        adyacentes.ordenar();
        return adyacentes;
    }
}

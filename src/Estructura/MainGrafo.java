/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import static Estructura.Principal.Adyacentes;
import static Estructura.Principal.Peso;
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
        grafo.AddVertice(new Estrella(9, "Estrella8"));
        
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(1).getValor(), 10));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 6));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 3));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(3).getValor(), 0));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(3).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 2));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(4).getValor(), (Estrella) grafo.getVertices().get(5).getValor(), 100));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(2).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 4));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(2).getValor(), (Estrella) grafo.getVertices().get(6).getValor(), 7));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(6).getValor(), (Estrella) grafo.getVertices().get(7).getValor(), 5));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(5).getValor(), (Estrella) grafo.getVertices().get(7).getValor(), 20));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(7).getValor(), (Estrella) grafo.getVertices().get(8).getValor(), 36));
        grafo.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(8).getValor(), (Estrella) grafo.getVertices().get(0).getValor(), 37));

        Pila camino;
        camino = Dijkstra((Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(8).getValor(), grafo);
        while (!camino.IsEmpty()) {
            System.out.println("[" + camino.Desapilar() + "]");
        }
        Grafo grafo1 = new Grafo();
        grafo1.AddVertice(new Estrella(1, "Estrella8"));
        grafo1.AddVertice(new Estrella(2, "Estrella8"));
        grafo1.AddVertice(new Estrella(3, "Estrella8"));
        grafo1.AddVertice(new Estrella(4, "Estrella8"));
        grafo1.AddVertice(new Estrella(5, "Estrella8"));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(1).getValor(), 10));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(0).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 15));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(2).getValor(), 43));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(1).getValor(), (Estrella) grafo.getVertices().get(3).getValor(), 7));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(2).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 20));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(3).getValor(), (Estrella) grafo.getVertices().get(0).getValor(), 31));
        grafo1.AddArista(new Arista(Color.BLACK, (Estrella) grafo.getVertices().get(3).getValor(), (Estrella) grafo.getVertices().get(4).getValor(), 60));

        System.out.println("......................................");
        MatrizPrim((Estrella) grafo1.getVertices().get(0).getValor(), grafo1);
    }

    static Pila Dijkstra(Estrella origen, Estrella destino, Grafo grafo) {
        Pila camino = new Pila();

        int[][] matriz = new int[grafo.getAristas().size()][grafo.getVertices().size()];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Integer.MAX_VALUE;
            }
        }
        Pila adyacentes = new Pila();
        Cola adyacentes3 = new Cola();
        Estrella actual = origen;
        int i = 0;
        do {
            System.out.println(actual);
            adyacentes = Adyacentes(actual, grafo, adyacentes);
            while (!adyacentes.IsEmpty()) {
                Estrella temporal = (Estrella) adyacentes.Desapilar();
                adyacentes3.queue(temporal);
                int peso = Peso(actual, temporal, grafo, origen);
                if (i > 0) {
                    if (peso < matriz[i - 1][temporal.getId() - 1]) {
                        matriz[i][temporal.getId() - 1] = Peso(actual, temporal, grafo, origen);
                        if (temporal.getId() == destino.getId()) {//----------------->aqui
                            camino = Camino(actual, temporal, grafo, origen);
                        }
                    } else {
                        matriz[i][temporal.getId() - 1] = matriz[i - 1][temporal.getId() - 1];
                    }
                } else {
                    matriz[i][temporal.getId() - 1] = Peso(actual, temporal, grafo, origen);
                    if (temporal.getId() == destino.getId()) {//----------------->aqui
                        camino = Camino(actual, temporal, grafo, origen);
                    }
                }

            }
            if (!adyacentes3.isEmpty()) {
                actual = (Estrella) adyacentes3.Dequeue();
            }
            i++;
            if (i == grafo.getAristas().size()) {
                break;
            }
        } while (!adyacentes3.isEmpty());

        for (int j = 0; j < matriz.length; j++) {
            for (int k = 0; k < matriz[0].length; k++) {
                if (k > 0) {
                    if (matriz[k - 1][k] < matriz[k][k]) {
                        matriz[k][k] = matriz[k - 1][k];
                    }
                }
                System.out.print("[" + matriz[k][k] + "]");
            }
            System.out.println("");
        }

        return camino;
    }

    static int Peso(Estrella puntoA, Estrella puntoB, Grafo grafo, Estrella origen) {
        int peso = 0, peso2 = 0;
        Pila verificar = new Pila();
        verificar = Adyacentes(puntoA, grafo, verificar);
        if (!verificar.IsEmpty()) {
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
        }
        return peso;
    }

    static Pila Camino(Estrella puntoA, Estrella puntoB, Grafo grafo, Estrella origen) {
        Pila aristas = new Pila();
        Pila verificar = new Pila();
        verificar = Adyacentes(puntoA, grafo, verificar);
        if (!verificar.IsEmpty()) {
            for (int i = 0; i < grafo.getAristas().size(); i++) {
                if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA() == puntoA
                        && ((Arista) grafo.getAristas().get(i).getValor()).getPuntoB() == puntoB && ((Arista) grafo.getAristas().get(i).getValor()).getPuntoA() == origen) {
                    aristas.Apilar((Arista) grafo.getAristas().get(i).getValor());
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
                            aristas.Apilar((Arista) grafo.getAristas().get(j).getValor());
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
                                    aristas.Apilar((Arista) grafo.getAristas().get(j).getValor());
                                }
                            }
                            anterior = temPuntoA;
                        } while (temPuntoA.getId() != origen.getId());
                    }
                    aristas.Apilar((Arista) grafo.getAristas().get(i).getValor());
                }
            }
        }
        return aristas;
    }

    static Pila Adyacentes(Estrella actual, Grafo grafo, Pila adyacentes) {
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA().getId() == actual.getId()) {
                adyacentes.Apilar((Estrella) ((Arista) grafo.getAristas().get(i).getValor()).getPuntoB());
                System.out.println(((Arista) grafo.getAristas().get(i).getValor()));
            }
        }
       
        adyacentes.ordenar();
        return adyacentes;

    }

    static int[][] MatrizPrim(Estrella origen, Grafo grafo) {
        int[][] matriz = new int[grafo.getVertices().size()][grafo.getVertices().size()];
        Pila estrellas = new Pila();
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            estrellas.Apilar(((Estrella) grafo.getVertices().get(i).getValor()));
        }
        estrellas.ordenar();
        Estrella actual;
        for (int i = 0; i < matriz.length; i++) {
            actual = (Estrella) estrellas.Desapilar();
            for (int j = 0; j < grafo.getAristas().size(); j++) {
                if (((Arista) grafo.getAristas().get(j).getValor()).getPuntoA().getId() == actual.getId()) {
                    matriz[i][((Arista) grafo.getAristas().get(j).getValor()).getPuntoB().getId() - 1] = ((Arista) grafo.getAristas().get(j).getValor()).getPeso();
                }
                if (((Arista) grafo.getAristas().get(j).getValor()).getPuntoB().getId() == actual.getId()) {
                    matriz[i][((Arista) grafo.getAristas().get(j).getValor()).getPuntoA().getId() - 1] = ((Arista) grafo.getAristas().get(j).getValor()).getPeso();
                }
            }

        }
        return matriz;
    }

}

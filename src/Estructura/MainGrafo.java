/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

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
        grafo.AddVertice(new Estrella(5,"Estrella1"));
        grafo.AddVertice(new Estrella(2,"Estrella2"));
        grafo.AddVertice(new Estrella(2,"Estrella3"));
        System.out.println(grafo.getVertices().size());
        
    }

    static void Dijkstra(Estrella origen, Grafo grafo) {
        Lista visitados = new Lista();
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            visitados.insert(new Nodo(null, false));
        }
        int[][] matriz=new int[grafo.getVertices().size()][grafo.getVertices().size()-1];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]=Integer.MAX_VALUE;
            }
        }
        Pila adyacentes=new Pila();
        Pila adyacentes2=new Pila();
        Estrella actual=origen;
        adyacentes2=Adyacentes(actual,grafo,adyacentes2);
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            adyacentes=Adyacentes(actual,grafo,adyacentes);
            for (int j = 0; j < actual.getNumAristas(); j++) {
                Estrella temporal=(Estrella)adyacentes.Desapilar();
                matriz[i][temporal.getId()-1]=Peso(actual,temporal,grafo,origen);
            }
            actual=(Estrella)adyacentes2.Desapilar();
        }
            
    }
    static int Peso(Estrella puntoA,Estrella puntoB,Grafo grafo,Estrella origen){
        int peso=0,peso2=0;
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista)grafo.getAristas().get(i).getValor()).getPuntoA()==puntoA&&
                    ((Arista)grafo.getAristas().get(i).getValor()).getPuntoB()==puntoB&&((Arista)grafo.getAristas().get(i).getValor()).getPuntoA()==origen) {
                peso=((Arista)grafo.getAristas().get(i).getValor()).getPeso();
            }else if((((Arista)grafo.getAristas().get(i).getValor()).getPuntoA()==puntoA&&
                    ((Arista)grafo.getAristas().get(i).getValor()).getPuntoB()==puntoB)){
                Estrella anterior=origen;
                boolean noEncontrado=true;
                Pila adyacentes=null;
                    adyacentes=Adyacentes(anterior,grafo,adyacentes);
                    Pila adyacentes2=adyacentes;
                do {
                    while(!adyacentes.IsEmpty()){
                        Estrella temporal=(Estrella)adyacentes.Desapilar();
                        if (temporal==puntoA) {
                            noEncontrado=false;
                            break;
                        }
                    }
                    if (!noEncontrado) {
                        anterior=(Estrella)adyacentes2.Desapilar();
                    }
                } while (noEncontrado);
                
                for (int j = 0; j < grafo.getAristas().size(); j++) {
                    if (((Arista)grafo.getAristas().get(j).getValor()).getPuntoA()==anterior&&((Arista)grafo.getAristas().get(j).getValor()).getPuntoB()==puntoA) {
                        peso2=((Arista)grafo.getAristas().get(j).getValor()).getPeso();
                    }
                }
                peso=((Arista)grafo.getAristas().get(i).getValor()).getPeso()+peso2;
            }
        }
        return peso;
    }
    static Pila Adyacentes(Estrella actual, Grafo grafo, Pila adyacentes) {
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA().getId() == actual.getId()) {
               adyacentes.Apilar(new Nodo(null, (Arista) grafo.getAristas().get(i).getValor()));
            }
            if (i==actual.getNumAristas()) {
                break;
            }
        }
        adyacentes.ordenar();
        return adyacentes;
    }
}

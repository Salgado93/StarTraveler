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
        int[] adyaVisitados=new int[origen.getNumAristas()];//cambiar por pila
        for (int i = 0; i < adyaVisitados.length; i++) {
            adyaVisitados[i]=-1;
        }
        Estrella adyacente=Adyacente(origen,grafo,adyaVisitados);
        while(true){
            
            break;
        }
        
        for (int i = 0; i < origen.getNumAristas(); i++) {

        }
    }

    static Estrella Adyacente(Estrella actual, Grafo grafo, int[] adyaVisitados) {
        Estrella adyacente = new Estrella(Integer.MAX_VALUE,0,"");//cambiar por pila
        Lista adyacentes = new Lista();//cambiar por pila
        for (int i = 0; i < grafo.getAristas().size(); i++) {
            if (((Arista) grafo.getAristas().get(i).getValor()).getPuntoA().getId() == actual.getId()) {
                adyacentes.insert(new Nodo(null, (Arista) grafo.getAristas().get(i).getValor()));
            }
            if (i==actual.getNumAristas()) {
                break;
            }
        }
        //cambiar por pila todo esto eliminado
        for (int i = 0; i < actual.getNumAristas(); i++) {
            for (int j = 0; j < adyaVisitados.length; j++) {
                if (((Arista) adyacentes.get(i).getValor()).getPuntoB().getId() != adyaVisitados[j]&&
                        ((Arista) adyacentes.get(i).getValor()).getPuntoB().getId()<adyacente.getId()) {
                    adyacente = (Estrella) adyacentes.get(i).getValor();
                    adyaVisitados[i] = ((Estrella) adyacentes.get(i).getValor()).getId();
                    
                }
            }
        }
        return adyacente;
    }
}

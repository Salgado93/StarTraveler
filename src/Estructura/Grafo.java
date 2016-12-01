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
public class Grafo {
    private Lista vertices;
    private Lista aristas;

    public Grafo() {
        vertices=new Lista();
        aristas=new Lista();
    }

    public Grafo(Lista vertices, Lista aristas) {
        this.vertices = vertices;
        this.aristas = aristas;
    }

    public Lista getVertices() {
        return vertices;
    }

    public void setVertices(Lista vertices) {
        this.vertices = vertices;
    }

    public Lista getAristas() {
        return aristas;
    }

    public void setAristas(Lista aristas) {
        this.aristas = aristas;
    }
    
    public void AddVertice(Estrella entrada){
        vertices.insert(new Nodo(null,entrada));
    }
    public void AddArista(Arista entrada){
        aristas.insert(new Nodo(null,entrada));
    }
}

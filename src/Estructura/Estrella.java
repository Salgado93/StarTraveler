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
public class Estrella {
    private int id;
    private int numAristas;
    private String nombre;
   
    public Estrella() {
    }

    public Estrella(int id, int numAristas, String nombre) {
        this.id = id;
        this.numAristas = numAristas;
        this.nombre = nombre;
    }
    public Estrella(int id, String nombre) {
        this.id = id;
        this.numAristas=0;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumAristas() {
        return numAristas;
    }

    public void setNumAristas(int numAristas) {
        this.numAristas = numAristas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String s = String.valueOf(id);
        s = Integer.toString(id);
        return s;
    }

    
    
}

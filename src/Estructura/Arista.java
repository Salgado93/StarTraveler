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
public class Arista {
    private Color color;
    private Estrella puntoA;
    private Estrella puntoB;
    private int peso;

    public Arista() {
    
    }

    public Arista(Color color, Estrella puntoA, Estrella puntoB, int peso) {
        this.color = color;
        this.puntoA = puntoA;
        this.puntoB = puntoB;
        this.peso = peso;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Estrella getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Estrella puntoA) {
        this.puntoA = puntoA;
    }

    public Estrella getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Estrella puntoB) {
        this.puntoB = puntoB;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return puntoA+"-->"+puntoB;
    }
    
    
}

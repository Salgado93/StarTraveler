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
public class Pila {
    private Nodo head;

    public Pila(Nodo head) {
        this.head = head;
    }

    public Pila() {
        head=null;
    }
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    void Apilar(Object nuevo) {
        if (head == null) {
            head = new Nodo(null, nuevo);
        } else {
            head = new Nodo(head, null);
        }
    }

    Object Desapilar() {
       Nodo salida=head;
       head=head.getNext();
       return salida.getValor();
    }
    int getSize(){
        int salida=1;
        Nodo tem=head;
        while(tem!=null){
            salida++;
        }
        return salida;
    }
    boolean IsEmpty(){
        if (head==null) {
            return true;
        }else{
            return false;
        }
    }
    void listar() {
        Nodo tem = head;
        while (tem != null) {
            System.out.print("[" + tem.getValor() + "]");
            tem = tem.getNext();
        }
        System.out.println();
    }
    void ordenar(){
        
        Estrella[] orden = new Estrella[this.getSize()];
        for (int i = 0; i < orden.length; i++) {
            orden[i]=(Estrella)this.Desapilar();
        }
        Estrella temp;
        for (int i = 1; i < orden.length; i++) {
            for (int j = 0; j < orden.length-1; j++) {
                if (orden[j].getId()<orden[j+1].getId()) {
                    temp=orden[j];
                    orden[j]=orden[j+1];
                    orden[j]=temp;
                }
            }
        }
        for (int i = 0; i < orden.length; i++) {
            this.Apilar(new Nodo(null,orden[i]));
        }
    }
}

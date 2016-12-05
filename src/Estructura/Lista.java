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

public class Lista {
    private Nodo head;

    public Lista() {
    head=null;
    }

    public Lista(Nodo head) {
        this.head = head;
    }
    public void insert(Nodo entrada){
        if (head==null) {
            head=entrada;
        }else{
            Nodo tem=head;
            while(tem.getNext()!=null){
                tem=tem.getNext();
            }
            tem.setNext(entrada);
        }
    }
    public Nodo get(int posicion){
        Nodo tem=head;
        while(posicion>0){
            tem=tem.getNext();
            posicion--;
        }
        return tem;
    }
    public boolean isEmpty(){
        if (head==null) {
            return true;
        }else{
            return false;
        }
    }
    public void Eliminar(int posicion){
        if (!this.isEmpty()) {
            if (posicion==0) {
                head=head.getNext();
            }else{
                int iter=0;
                Nodo temp=head;
                while(iter<posicion-1){
                    temp=temp.getNext();
                    iter++;
                }
                Nodo tem=temp.getNext();
                temp.setNext(tem.getNext());
            }
        }
       
    }
    public int size(){
        Nodo tem=head;
        int salida=0;
        while(tem!=null){
            tem=tem.getNext();
            salida++;
        }
        return salida;
    }
    
}

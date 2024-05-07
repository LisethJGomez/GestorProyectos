package Modelo;

public class Nodo {
    private Tareas dato;
    private Nodo siguiente;
    private Nodo anterior;

    // Constructor, getters, and setters
    public Nodo (Tareas el){
        this(el,null,null); 
    }

    //Constructor para cuando ya hay nodos
    public Nodo(Tareas el, Nodo s, Nodo a) {
        dato=el;
        siguiente=s;
        anterior=a;		
    }
    
    //Getters y Setters
    public Tareas getDato() {
        return dato;
    }

    public void setDato(Tareas dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}
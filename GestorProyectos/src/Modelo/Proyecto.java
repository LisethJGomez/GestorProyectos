package Modelo;

import Controlador.ListaDobleEnlazada;

public class Proyecto {
    private String nombre;
    private ListaDobleEnlazada listaTareas;
    
    //Constructor
    public Proyecto(String nombre, ListaDobleEnlazada listaTareas) {
        this.nombre = nombre;
        this.listaTareas = listaTareas;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaDobleEnlazada getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ListaDobleEnlazada listaTareas) {
        this.listaTareas = listaTareas;
    }

    
}
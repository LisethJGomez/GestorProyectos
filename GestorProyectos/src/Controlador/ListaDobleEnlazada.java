package Controlador;

import Modelo.Nodo;
import Modelo.Tareas;
import javax.swing.JOptionPane;

public class ListaDobleEnlazada {
    //Variables
    private Nodo inicio;
    private Nodo fin;
    private int tamaño;
    
    //Constructor
    public ListaDobleEnlazada() {
        inicio=fin=null;
    }

    //Metodos
    public boolean estaVacia() {
        return inicio==null;
    }
    
    public void mostrarInicioFin() {
        if(!estaVacia()) {
            String datos= "Null <=> ";
            Nodo auxiliar=inicio;
            while(auxiliar!=null) {
                    datos= datos +"["+auxiliar.getDato().getNombre()+"] <=> ";
                    auxiliar= auxiliar.getSiguiente();
            }
            datos+="Null";
            JOptionPane.showMessageDialog(null, datos, 
            "Mostrando Lista de Inicio a Fin", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY DATOS", 
            "Mostrando Lista de Inicio a Fin", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void añadir(Tareas t) {
        if(!estaVacia()) {
            inicio= new Nodo(t,inicio,null);
            inicio.getSiguiente().setAnterior(inicio);//El apuntador del nodo siguiente apunte al nodo anterior
            //[ant] <> [act] <> [sig] ===> [ant == null] < [sig]
            tamaño++;
        }else {//Null <> [nodo] <> Null
            inicio=fin=new Nodo(t);
            tamaño++;
        }
    }

    public void actualizar(int id) {
        Tareas t = buscar(id);
        String datoTemp;
        borrar(id);
        //Modificar datos
        int opcion=0;
        do{
            opcion =Integer.parseInt(JOptionPane.showInputDialog("Que deseas modificar?\n"
            + "1. Nombre\n"
            + "2. Descripción\n"
            + "3. Estado\n"
            + "4. Prioridad\n"
            + "5. Proyecto\n"
            + "6. SALIR"));
            switch (opcion){
                case 1:
                    datoTemp=JOptionPane.showInputDialog("Nombre:");
                    t.setNombre(datoTemp);
                    break;
                case 2:
                    datoTemp=JOptionPane.showInputDialog("Descripción:");
                    t.setNombre(datoTemp);
                    break;
                case 3:
                    datoTemp=JOptionPane.showInputDialog("Estado:");
                    t.setNombre(datoTemp);
                    break;
                case 4:
                    datoTemp=JOptionPane.showInputDialog("Prioridad:");
                    t.setNombre(datoTemp);
                    break;
                case 5:
                    datoTemp=JOptionPane.showInputDialog("Proyecto:");
                    t.setNombre(datoTemp);
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Número no valido", "ERROR",JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion!=6);
        añadir(t);
    }

    public Tareas buscar(int id) {
        Nodo actual = inicio;
        //Se desplaza elemento a elemento hasta encontrar el que tenga ese ID
        while (actual != null) {
            if (actual.getDato().getId() == id) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();//Cambio de elemento
        }
        return null;
    }

    public void borrar(int id) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getDato().getId() == id) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());//El apuntador del nodo anterior apunte al nodo siguiente
                    //[ant] <> [act] <> [sig] ===> [ant] > [sig]
                } else {
                    inicio = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());//El apuntador del nodo siguiente apunte al nodo anterior
                    //[ant] <> [act] <> [sig] ===> [ant] <> [sig]
                } else {
                    fin = actual.getAnterior();
                }
                tamaño--;
                break;
            }
            actual = actual.getSiguiente();
        }
    }
}
package Vista;

import Modelo.*;
import Controlador.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorProyectos {
    private static ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
    private static ListaDobleEnlazada listaTareas = new ListaDobleEnlazada();
    private static Tareas t;

    public static void main(String[] args) {
        int opcion=0;
        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Proyectos\n"
                + "1. Crear Proyecto\n"
                + "2. Eliminar Proyecto\n"
                + "3. Editar Proyecto\n"
                +"4. Mostrar Proyectos\n"
                + "5. SALIR"));
            switch (opcion){
                case 1:
                    crearProyecto();
                    break;
                case 2:
                    eliminarProyecto();
                    break;
                case 3:
                    editarProyecto();
                    break;
                case 4:
                    mostrarProyectos();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no Valida","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }while (opcion!=5);
       
//        listaTareas.añadir(formulario());
    }
    
//Metodos
    //Formulario para crear una nueva tarea
    public static Tareas formularioTareas(int n) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
        String nom = JOptionPane.showInputDialog("Nombre: ");
        String des = JOptionPane.showInputDialog("Descripción: ");
        String est = JOptionPane.showInputDialog("Estado: ");
        String pri = JOptionPane.showInputDialog("Prioridad: ");
       return new Tareas(id, nom, des, est, pri,proyectos.get(n-1).getNombre()); 
    }
    
    public static void mostrarProyectos() {
        String s="";
        for (int i = 0; i < proyectos.size(); i++){
            s+=(i+1)+") "+proyectos.get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null,"PROYECTOS\n"+s);
    }
    public static void crearProyecto() {
        String nom=JOptionPane.showInputDialog("Nombre del proyecto: ");
        proyectos.add(new Proyecto(nom, new ListaDobleEnlazada()));
    }
    public static void eliminarProyecto() {
        String s="";
        for (int i = 0; i < proyectos.size(); i++){
            s+=(i+1)+") "+proyectos.get(i).getNombre()+"\n";
        }
        int n=Integer.parseInt(JOptionPane.showInputDialog("Cual desea Eliminar?\n"+s));
        proyectos.remove(n-1);
    }
    public static void editarProyecto() {
        //Elección de proyecto a editar
        int id;
        String nombre, descripcion, estado, prioridad,proyecto;
        String s="";
        for (int i = 0; i < proyectos.size(); i++){
            s+=(i+1)+") "+proyectos.get(i).getNombre()+"\n";
        }
        int n=Integer.parseInt(JOptionPane.showInputDialog("Cual desea Editar?\n"+s));
        
        JOptionPane.showMessageDialog(null,"Entrando al proyecto "+proyectos.get(n-1).getNombre());
        
        //Elección de acción
        int des=0;
        do{
            des =Integer.parseInt(JOptionPane.showInputDialog("Que desea Realizar?\n"
                + "1. Añadir Tarea\n"
                + "2. Eliminar Tarea\n"
                + "3. Mostrar Tareas\n"
                + "4. Buscar Tarea\n"
                + "5. Actualizar Tarea\n"
                + "6. SALIR"));
            switch (des){
                //Añadir
                case 1:                    
                    t=formularioTareas(n);
                    proyectos.get(n-1).getListaTareas().añadir(t);
                    break;
                //Eliminar
                case 2:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Id: "));
                    proyectos.get(n-1).getListaTareas().borrar(id);
                    break;
                //Mostrar
                case 3:
                    proyectos.get(n-1).getListaTareas().mostrarInicioFin();
                    break;
                //Buscar
                case 4:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Id: "));
                    t=proyectos.get(n-1).getListaTareas().buscar(id);
                    JOptionPane.showMessageDialog(null,"Id: "+t.getId()+"\n"
                            + "Nombre: "+t.getNombre()+"\n"
                            + "Descripción: "+t.getDescripcion()+"\n"
                            + "Estado: "+t.getEstado()+"\n"
                            + "Prioridad: "+t.getPrioridad()+"\n"
                            + "Proyecto: "+t.getProyecto());
                    break;
                //Actualizar
                case 5:
                    id=Integer.parseInt(JOptionPane.showInputDialog("Id: "));
                    proyectos.get(n-1).getListaTareas().actualizar(id);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opción no Valida","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } while (des!=6);
    }
}

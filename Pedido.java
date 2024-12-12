
package restaurapp_v2;

import java.util.*;
import java.io.*;

public class Pedido implements Serializable{ //Me permite serializar los objetos para poderlos almacenar y preservar sus datos
    private static final long serialVersionUID = 2L; //Me permite modificar la clase/objetos en el futuro sin que se generen errores al desserializar
    
    private int NumeroPedido;
    private Menu NumMenus;  //Pongo como atributo a un objeto de la clase Menu, asi asocio al menu con su respectivo pedido
    protected boolean Estado; //Con el booleano puedo controlar si el pedido está completo o pendiente
    private String Fecha;
    protected ArrayList<String> historialPedidos; //Me permite generar una lista modificable con todos los pedidos completados
    
    public Pedido(int numeroPedido, Menu menu, String fecha) { //inicializo los atributos
        this.NumeroPedido = numeroPedido;
        this.NumMenus = menu;
        this.Estado = false;
        this.Fecha = fecha;
        this.historialPedidos = new ArrayList<>(); 
    }
    //Getters para los datos del menu
    public int getNumeroPedido() {
        return NumeroPedido;
    }
    public int getMenu() {
        return NumMenus.getNumeroMenu();
    }
    public String getEstado() {
        String estadoPedido = "";
        if(Estado == false){
            estadoPedido = "Pedido pendiente";
        }else if (Estado == true){
            estadoPedido = "Pedido completo";
        };
        return estadoPedido ;
    }
    public String getFecha() {
        return Fecha;
    }
    public ArrayList<String> getHistorialPedidos(int numeroPedido) {
        return historialPedidos;
    }

    
    

}

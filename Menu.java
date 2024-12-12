
package restaurapp_v2;

import java.io.*;  //Java.io es una biblioteca de java que sirve para manejar entrada y salida de datos (In & Out), serializacion, etc


public class Menu implements Serializable{ //Me permite serializar los objetos para poderlos almacenar y preservar sus datos
    private static final long serialVersionUID = 1L; //Me permite modificar la clase/objetos en el futuro sin que se generen errores al desserializar
    //Atributos
    private int NumeroMenu;
    private String Entrada;
    private String PlatoPrincipal;
    private String Bebida;
    private String Postre;
    private double Precio;    
    //Constructor atributos
     public Menu(int numeroMenu, String entrada, String platoPrincipal, String bebida, String postre, double precio) { //inicializo los atributos
        this.NumeroMenu = numeroMenu;
        this.Entrada = entrada;
        this.PlatoPrincipal = platoPrincipal;
        this.Bebida = bebida;
        this.Postre = postre;
        this.Precio = precio; 
    }
    //Getters para los datos del menu
    public int getNumeroMenu() {
        return NumeroMenu;
    }
    public String getEntrada() {
        return Entrada;
    }
    public String getPlatoPrincipal() {
        return PlatoPrincipal;
    }
    public String getBebida() {
        return Bebida;
    }
    public String getPostre() {
        return Postre;
    }
    public double getPrecio() {
        return Precio;
    }
    
}

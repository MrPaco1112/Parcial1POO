
package restaurapp;
import java.util.*;

public class Menu {
    Scanner s2 = new Scanner(System.in);
    private int NumeroDeMenu;
    private String Entrada;
    private String PlatoPrincipal;
    private String Bebida;
    private String Postre;
    private double Precio;
    private int Cantidad;
    
    public Menu(int NumeroDeMenu, String Entrada, String PlatoPrincipal, String Bebida, String Postre, double Precio, int Cantidad){
        this.NumeroDeMenu = numeroMenu;
        this.Entrada = entrada;
        this.PlatoPrincipal = platoPrincipal;
        this.Bebida = bebida;
        this.Postre = postre;
        this.Precio = precio;
        this.Cantidad = cantidad;
    }
    public int getNumeroMenu(){
        return NumeroDeMenu;
    }
    public String getEntrada(){
        return Entrada;
    }
    public String getPlatoP(){
        return PlatoPrincipal;
    }
    public String getBebida(){
        return Bebida;
    }
    public String getPostre(){
        return Postre;
    }
    public double getPrecio(){
        return Precio;
    }
    public int getCantidad(){
        return Cantidad;
    }
   
    public void mostrarInfo(){
     
     }
        
        
}

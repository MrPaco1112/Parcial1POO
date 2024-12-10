
package restaurapp;
import java.util.*;

/**
 *
 * @author Juan Esteban Sarmiento Benitez
 */
public class Restaurapp {
 Menu menu1 = new Menu(1,"Papas", "Filete de res","Gaseosa","Helado",30000.00,10);
 Menu menu2 = new Menu(2,"Pan", "Pechuga de pollo","Jugo natural","Fresas con crema",20000.00,10);
 Menu menu3 = new Menu(3,"Pan brioche", "Filete de salmon","Te","Mouse de fresa",60000.00,10);
 
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int opcion = -1;
       
        do{
            try{
              System.out.println("=== Menu Principal ===");
              System.out.println("1. Consultar menus disponibles");
              System.out.println("2. Consultar pedidos activos");
              System.out.println("3. Consultar pedidos completados");
              System.out.println("4. Salir");
              System.out.print("Elige una opcion: ");
              opcion = s.nextInt();
             } catch(InputMismatchException e){
              System.out.println("ERROR el valor ingresado no es valido, por favor reintentar");
              break;
            }  
             switch(opcion){
                    case 1: 
                        try{
                            System.out.println("Menus disponibles");
                            System.out.println("Menu" + numeroMenu);
                            System.out.println();
                            System.out.println();
                     
                        }catch(InputMismatchException e){
                            System.out.println("Error el valor ingresado no es valido, reintentar");
                            break;
                        }
                        break;
                    case 2: 
                         try{
                            System.out.println("Pedidos activos:");
                            System.out.println("");
                        
                        }catch(InputMismatchException e){
                            System.out.println("Error el valor ingresado no es valido, reintentar");
                            break;
                        }
                        break;
                    case 3: 
                        try{
                            System.out.println("Pedidos completados: ");
                      
                        }catch(InputMismatchException e){
                            System.out.println("Error el valor ingresado no es valido, reintentar");
                        }   
                        break;
                    case 4: 
                    System.out.println("Saliendo del menu");
                    break;     
            }  
        } while(opcion != 4);
  }
}


package restaurapp_v2;
import java.io.*;
import java.util.*;

/*
 * @author Juan Esteban Sarmiento Benitez
 */
public class Restaurapp_V2 {

 
    public static void main(String[] args) {

        verificarOCrearArchivoMenus();
        verificarOCrearArchivoPedidos();

        
        System.out.println("Bienvenido");
        Scanner s = new Scanner(System.in);
        int opcion = -1;
        int  subOpcion = -1;
        do {
            try{
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Consultar Menus");
                System.out.println("2. Consultar pedidos");
                System.out.println("3. Salir");
                System.out.print("Elige una opcion: ");
                opcion = s.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Error el valor ingresado no es valido, reintentar");
                System.out.println();
                break;
            }
            switch(opcion){
                case 1: // Opcion de consultar info Menus
                    consultarMenus();
                    break;
                case 2: //Opciones de pedidos
                    try{
                        System.out.println("Que deseas hacer?: ");
                        System.out.println("1. Consultar pedidos activos");
                        System.out.println("2. Marcar pedidos como completados");
                        System.out.println("3. Marcar pedidos como pendientes");
                        System.out.println("Elige una opcion: ");
                        subOpcion = s.nextInt();

                    }catch(InputMismatchException e){
                        System.out.println("Error el valor ingresado no es valido, reintentar");
                        break;
                    }
                    if (subOpcion == 1){
                        consultarPedidos();
                    }else if (subOpcion == 2){
                        int pedidoACompletar;
                        System.out.println("Que pedido desea marcar como completo? ");
                        System.out.println("Ingresa el numero del pedido: ");
                        try{
                            pedidoACompletar = s.nextInt();
                            marcarCompletado(pedidoACompletar);
                        }catch(InputMismatchException e){
                            System.out.println("Error el valor ingresado no es valido, reintentar");
                            break;
                        }
                    }else if (subOpcion ==3){
                        int pedidoADesCompletar;
                        System.out.println("Que pedido desea marcar como pendiente? ");
                        System.out.println("Ingresa el numero del pedido: ");
                        try{
                            pedidoADesCompletar = s.nextInt();
                            marcarNoCompletado(pedidoADesCompletar);
                        }catch(InputMismatchException e){
                            System.out.println("Error el valor ingresado no es valido, reintentar");
                            break;
                        }
                    }
                    else{
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 3: //Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion != 3);
    }
    public static void verificarOCrearArchivoMenus() {
        File archivo = new File("menus.ser");
        if (!archivo.exists()) {
            System.out.println("El archivo de menus no existe. Creandolo...");
            crearArchivoMenus();
        } else {
            System.out.println("Archivo de menus encontrado.");
        }
    }
    public static void verificarOCrearArchivoPedidos() {
        File archivo = new File("pedidos.ser");
        if (!archivo.exists()) {
            System.out.println("El archivo de pedidos no existe. Creandolo...");
            crearArchivoPedidos();
        } else {
            System.out.println("Archivo de pedidos encontrado.");
        }
    }
        // Método para cargar los menús desde el archivo
    public static List<Menu> cargarMenus() {
        List<Menu> menus = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menus.ser"))) {
            menus = (List<Menu>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los menus: " + e.getMessage());
        }
        return menus;
    }
    // Cargar los pedidos desde el archivo
    public static List<Pedido> cargarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedidos.ser"))) {
            pedidos = (List<Pedido>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los pedidos: " + e.getMessage());
        }
        return pedidos;
    }

   
    public static void crearArchivoMenus() {
        List<Menu> menus = new ArrayList<>(); //Al ser Array list se le pueden añadir más objetos despues de creada
        menus.add(new Menu(1, "Papas a la francesa", "Punta de Anca 300g", "Jugo de fresa en agua", "Flan de arequipe", 60000));
        menus.add(new Menu(2, "Pan", "Crepe con carne molida y queso", "Limonada cerezada", "Trozo de torta de chocolate", 70000));
        menus.add(new Menu(3, "Papas criollas en casquito", "Pechuga de pollo a la plancha 350g", "Limonada de panela", "Fresas con crema", 50000));
        menus.add(new Menu(4, "Salchiapapa", "Hamburguesa con doble carne", "Gaseosa", "Copa de helado", 70000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("menus.ser"))) {
            oos.writeObject(menus);
            System.out.println("Archivo de menus creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage()); //Acá el querido try me permite capturar un error si se llega a generar
        }
    }
    public static void crearArchivoPedidos() {
        // Cargar los menus desde el archivo
        List<Menu> menus = cargarMenus(); 

        // Verifica si los menus fueron cargados correctamente
        if (menus.isEmpty()) {
        System.out.println("No se pudieron cargar los menús. No se pueden crear los pedidos.");
        return;}
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, menus.get(0), "10/12/2024"));  // Asocia el primer menú con el primer pedido
        pedidos.add(new Pedido(2, menus.get(1), "06/12/2024"));  // Asocia el segundo menú con el segundo pedido
        pedidos.add(new Pedido(3, menus.get(2), "01/12/2024"));  // Asocia el tercer menú con el tercer pedido
        pedidos.add(new Pedido(4, menus.get(3), "28/11/2024"));  // Asocia el cuarto menú con el cuarto pedido

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pedidos.ser"))) {
            oos.writeObject(pedidos);
            System.out.println("Archivo de pedidos creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage()); //Acá el querido try me permite capturar un error si se llega a generar
        }
    }
    public static void consultarMenus(){
        System.out.println("=== Consultar Menus ===");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menus.ser"))) {
            @SuppressWarnings("unchecked")
            List<Menu> menus = (List<Menu>) ois.readObject();
            for (Menu menu : menus) {
                System.out.println("=== Menu " + menu.getNumeroMenu() + " ===");
                System.out.println("Entrada: " + menu.getEntrada());
                System.out.println("Plato principal: " + menu.getPlatoPrincipal());
                System.out.println("Bebida: " + menu.getBebida());
                System.out.println("Postre: " + menu.getPostre());
                System.out.println("Precio: " + menu.getPrecio());
                System.out.println();
                        }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los menus: " + e.getMessage());
        }
    }
    public static void consultarPedidos(){
        System.out.println("=== Pedidos Activos ===");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedidos.ser"))) {
            @SuppressWarnings("unchecked")
            List<Pedido> pedidos = (List<Pedido>) ois.readObject();
            for (Pedido pedido : pedidos) {
                System.out.println("=== Pedido " + pedido.getNumeroPedido() + " ===");
                System.out.println("Menu pedido: " + pedido.getMenu());
                System.out.println("Estado del pedido: " + pedido.getEstado());
                System.out.println("Fecha de solicitud: " + pedido.getFecha());
                System.out.println();
                        }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los pedidos: " + e.getMessage());
        }
    }
    public static void marcarCompletado(int numeroPedido){
        List<Pedido> pedidos = cargarPedidos(); // Cargar los pedidos desde el archivo
        boolean pedidoEncontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                // Marcar el pedido como completo
                pedido.Estado = true; 
                // Agregar al historial la fecha de completado
                pedido.historialPedidos.add("Pedido completado el: " + new Date());
                pedidoEncontrado = true;
                System.out.println("Pedido " + numeroPedido + " marcado como completado.");
                break;
            }
        }
    
        if (!pedidoEncontrado) {
            System.out.println("Pedido no encontrado.");
        }

        // Guardar los cambios nuevamente en el archivo
        guardarPedidos(pedidos);
    }
    public static void marcarNoCompletado(int numeroPedido){
        List<Pedido> pedidos = cargarPedidos(); // Cargar los pedidos desde el archivo
        boolean pedidoEncontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                // Marcar el pedido como completo
                pedido.Estado = false; 
                // Agregar al historial la fecha de completado
                pedido.historialPedidos.add("Pedido marcado como no completo el: " + new Date());
                pedidoEncontrado = true;
                System.out.println("Pedido " + numeroPedido + " marcado como pendiente.");
                break;
            }
        }
    
        if (!pedidoEncontrado) {
            System.out.println("Pedido no encontrado.");
        }

        // Guardar los cambios nuevamente en el archivo
        guardarPedidos(pedidos);
    }
    // Guardar la lista de pedidos modificada
    public static void guardarPedidos(List<Pedido> pedidos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pedidos.ser"))) {
            oos.writeObject(pedidos);
            System.out.println("Pedidos actualizados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los pedidos: " + e.getMessage());
        }
    }
    
}

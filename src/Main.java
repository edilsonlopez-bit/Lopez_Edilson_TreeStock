import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        // Mantiene el menu activo hasta elegir salir
        do {
            System.out.println("\n=== TREE STOCK ===");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("0. Salir");

            opcion = leerEntero(lector, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarProducto(lector, inventario);
                    break;
                case 2:
                    mostrarInventario(inventario);
                    break;
                case 3:
                    buscarProducto(lector, inventario);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        lector.close();
    }

    // Solicita los datos y guarda un producto nuevo
    public static void registrarProducto(Scanner lector, ArbolInventario inventario) {
        int id = leerEntero(lector, "Ingrese el ID del producto: ");

        if (inventario.buscar(id) != null) {
            System.out.println("Ya existe un producto con ese ID");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = lector.nextLine();

        inventario.insertar(id, nombre);
        System.out.println("Producto registrado correctamente");
    }

    // Muestra los productos ordenados por ID
    public static void mostrarInventario(ArbolInventario inventario) {
        System.out.println("\nInventario ordenado");
        inventario.mostrarInorden();
    }

    // Busca un producto por su ID
    public static void buscarProducto(Scanner lector, ArbolInventario inventario) {
        int id = leerEntero(lector, "Ingrese el ID que desea buscar: ");
        Producto productoEncontrado = inventario.buscar(id);

        if (productoEncontrado == null) {
            System.out.println("El producto no existe en el inventario");
        } else {
            System.out.println("Producto encontrado");
            System.out.println("ID: " + productoEncontrado.getId());
            System.out.println("Nombre: " + productoEncontrado.getNombre());
        }
    }

    // Lee un numero entero y evita entradas incorrectas
    public static int leerEntero(Scanner lector, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = lector.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException error) {
                System.out.println("Debe ingresar un numero entero");
            }
        }
    }
}

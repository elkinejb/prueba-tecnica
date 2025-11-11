package backend;

import backend.Controlador.*;
import backend.Modelo.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductoControlador productoCtrl = new ProductoControlador();
        VendedorControlador vendedorCtrl = new VendedorControlador();
        VentaControlador ventaCtrl = new VentaControlador();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Ver productos");
            System.out.println("5. Ver vendedores");
            System.out.println("6. Ver ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registrar Producto ---");
                    System.out.print("ID: ");
                    int idP = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombreP = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    productoCtrl.agregarProducto(new Producto(idP, nombreP, precio, stock));
                    System.out.println("Producto registrado con éxito.");
                    break;

                case 2:
                    System.out.println("\n--- Registrar Vendedor ---");
                    System.out.print("ID: ");
                    int idV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombreV = scanner.nextLine();
                    System.out.print("Identificación: ");
                    String identificacion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    vendedorCtrl.agregarVendedor(new Vendedor(idV, nombreV, identificacion, telefono));
                    System.out.println("Vendedor registrado con éxito.");
                    break;

                case 3:
                    if (productoCtrl.listarProductos().isEmpty() || vendedorCtrl.listarVendedores().isEmpty()) {
                        System.out.println("Debe haber al menos un producto y un vendedor registrados antes de crear una venta.");
                        break;
                    }

                    System.out.println("\n--- Registrar Venta ---");
                    System.out.print("ID Venta: ");
                    int idVenta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nSeleccione un producto (ID):");
                    productoCtrl.listarProductos().forEach(System.out::println);
                    int idProductoSel = scanner.nextInt();
                    Producto productoSel = productoCtrl.listarProductos()
                        .stream().filter(p -> p.getId() == idProductoSel).findFirst().orElse(null);
                    if (productoSel == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.println("\nSeleccione un vendedor (ID):");
                    vendedorCtrl.listarVendedores().forEach(System.out::println);
                    int idVendedorSel = scanner.nextInt();
                    Vendedor vendedorSel = vendedorCtrl.listarVendedores()
                        .stream().filter(v -> v.getId() == idVendedorSel).findFirst().orElse(null);
                    if (vendedorSel == null) {
                        System.out.println("Vendedor no encontrado.");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    if (cantidad > productoSel.getStock()) {
                        System.out.println("Error: no hay suficiente stock disponible.");
                        break;
                    }

                    double total = productoSel.getPrecio() * cantidad;
                    productoSel.setStock(productoSel.getStock() - cantidad);

                    Venta nuevaVenta = new Venta(idVenta, productoSel, vendedorSel, cantidad, total, LocalDate.now());
                    ventaCtrl.registrarVenta(nuevaVenta);

                    System.out.println("Venta registrada con éxito. Total: $" + total);
                    break;

                case 4:
                    System.out.println("\n--- Lista de Productos ---");
                    productoCtrl.listarProductos().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("\n--- Lista de Vendedores ---");
                    vendedorCtrl.listarVendedores().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("\n--- Lista de Ventas ---");
                    ventaCtrl.listarVentas().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}

package main;

import bodega.*;
import ventas.*;

public class ClienteJavaConsola {
    public static void main(String[] args) {
        System.out.println("=== CLIENTE 1 ===");

        BodegaService bodegaService = new BodegaService();
        VentasService ventasService = new VentasService(bodegaService);

        Producto prod = new Producto("P010", "Monitor", 4);
        bodegaService.registrarProducto(prod);

        Cliente cliente = new Cliente("C100", "Sofía Ríos", "Cra 22 #45");
        Vendedor vendedor = new Vendedor("V100", "Carlos Méndez", true);
        ventasService.registrarCliente(cliente);
        ventasService.registrarVendedor(vendedor);
        ventasService.crearOrden("O100", "C100", "V100", "P010", 1);

        System.out.println("\n>> Productos disponibles:");
        for (Producto p : bodegaService.listarProductos()) {
            System.out.println(p);
        }

        System.out.println("\n>> Órdenes registradas:");
        for (OrdenVenta o : ventasService.listarOrdenes()) {
            System.out.println(o);
        }
    }
}

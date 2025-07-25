package main;

import auth.*;
import bodega.BodegaService;
import bodega.Producto;
import bodega.SolicitudProveedor;
import entregas.Entrega;
import entregas.EntregaService;
import java.util.*;
import proveedores.Empresa;
import proveedores.Proveedor;
import proveedores.ProveedorService;
import rrhh.Empleado;
import rrhh.RRHHService;
import ventas.Cliente;
import ventas.OrdenVenta;
import ventas.Vendedor;
import ventas.VentasService;

public class PoliMarketApp {
    public static void main(String[] args) {
        System.out.println("==== POLIMARKET SISTEMA ====");

        // Servicios base
        BodegaService bodegaService = new BodegaService();
        VentasService ventasService = new VentasService(bodegaService);
        RRHHService rrhhService = new RRHHService();
        EntregaService entregaService = new EntregaService(bodegaService);
        ProveedorService proveedorService = new ProveedorService();

        // ============================ AUTENTICACIÓN
        AuthService authService = new AuthService();

        Privilegio pVenta = new Privilegio(1, "Realizar Venta", "registrarOrden", true);
        Privilegio pAutorizar = new Privilegio(2, "Autorizar Vendedor", "autorizarVendedor", true);
        authService.registrarPrivilegio(pVenta);
        authService.registrarPrivilegio(pAutorizar);

        Rol rolVendedor = new Rol(1, "Vendedor");
        rolVendedor.agregarPrivilegio(pVenta);
        authService.registrarRol(rolVendedor);

        Rol rolRRHH = new Rol(2, "RRHH");
        rolRRHH.agregarPrivilegio(pAutorizar);
        authService.registrarRol(rolRRHH);

        Usuario userVendedor = new Usuario(1, "Laura Gómez", "laura@pm.com", "1234", true);
        userVendedor.agregarRol(rolVendedor);
        authService.registrarUsuario(userVendedor);

        Usuario userRRHH = new Usuario(2, "Sofía Ruiz", "sofia@pm.com", "5678", true);
        userRRHH.agregarRol(rolRRHH);
        authService.registrarUsuario(userRRHH);

        // ============================ Datos iniciales
        Producto teclado = new Producto("P001", "Teclado", 10);
        Producto mouse = new Producto("P002", "Mouse", 3);
        bodegaService.registrarProducto(teclado);
        bodegaService.registrarProducto(mouse);

        Cliente cliente = new Cliente("C001", "Juan Pérez", "Calle 123");
        ventasService.registrarCliente(cliente);

        Vendedor vendedor = new Vendedor("V001", "Laura Gómez", false);
        ventasService.registrarVendedor(vendedor);

        Empleado empleado = new Empleado("V001", "Laura Gómez", "Vendedora");
        rrhhService.registrarEmpleado(empleado);

        // ============================ Autorización desde RRHH
        Usuario loginRRHH = authService.autenticar("sofia@pm.com", "5678");
        if (loginRRHH != null && authService.tienePrivilegio(loginRRHH, "autorizarVendedor")) {
            rrhhService.autorizarVendedor("V001", vendedor);
        } else {
            System.out.println("❌ Usuario no autorizado para aprobar vendedores.");
        }

        // ============================ Vendedor realiza una orden
        Usuario loginVendedor = authService.autenticar("laura@pm.com", "1234");
        if (loginVendedor != null && authService.tienePrivilegio(loginVendedor, "registrarOrden")) {
            ventasService.crearOrden("O001", "C001", "V001", "P001", 2);
        } else {
            System.out.println("❌ Usuario no autorizado para registrar orden.");
        }

        // ============================ Entregas
        for (OrdenVenta orden : ventasService.listarOrdenes()) {
            entregaService.registrarEntrega(orden);
        }

        // ============================ Mostrar resultados
        System.out.println("\n=== INVENTARIO FINAL ===");
        for (Producto p : bodegaService.listarProductos()) {
            System.out.println(p);
        }

        System.out.println("\n=== ÓRDENES DE VENTA ===");
        for (OrdenVenta o : ventasService.listarOrdenes()) {
            System.out.println(o);
        }

        System.out.println("\n=== ENTREGAS REALIZADAS ===");
        for (Entrega e : entregaService.listarEntregas()) {
            System.out.println(e);
        }

        System.out.println("\n=== SOLICITUDES A PROVEEDOR ===");
        List<SolicitudProveedor> solicitudes = bodegaService.generarSolicitudReabastecimiento();
        for (SolicitudProveedor s : solicitudes) {
            System.out.println(s);
        }

        Empresa empresa = new Empresa("E001", "ProveedorGeneral");
        for (SolicitudProveedor s : solicitudes) {
            proveedorService.registrarProveedor(empresa, new Producto(s.getIdProducto(), "Producto solicitado", 0), s.getCantidadSolicitada());
        }

        System.out.println("\n=== PROVEEDORES REGISTRADOS ===");
        for (Proveedor p : proveedorService.listarProveedores()) {
            System.out.println(p);
        }

        System.out.println("\n=== USUARIOS Y ROLES ===");
        authService.imprimirUsuarios();
        authService.imprimirRoles();
    }
}

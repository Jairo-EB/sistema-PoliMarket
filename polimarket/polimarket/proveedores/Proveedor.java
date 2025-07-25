package proveedores;

import bodega.Producto;

public class Proveedor {
    private Empresa empresa;
    private Producto producto;
    private int cantidad;

    public Proveedor(Empresa empresa, Producto producto, int cantidad) {
        this.empresa = empresa;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Empresa getEmpresa() { return empresa; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return "Proveedor: " + empresa.getNombre() + " - Producto: " + producto.getNombre() + " - Cantidad: " + cantidad;
    }
}

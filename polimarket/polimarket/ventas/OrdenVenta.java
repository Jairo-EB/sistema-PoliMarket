package ventas;

import bodega.Producto;

public class OrdenVenta {
    private String id;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private String estado;

    public OrdenVenta(String id, Cliente cliente, Producto producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = "Pendiente";
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Orden " + id + ": " + cantidad + " x " + producto.getNombre() + " para " + cliente.getNombre() + " [" + estado + "]";
    }
}

package entregas;

import ventas.Cliente;
import bodega.Producto;

public class Entrega {
    private String id;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Entrega(String id, Cliente cliente, Producto producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return "Entrega " + id + ": " + cantidad + " x " + producto.getNombre() + " para " + cliente.getNombre();
    }
}

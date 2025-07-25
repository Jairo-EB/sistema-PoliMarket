package bodega;

public class SolicitudProveedor {
    private String idProducto;
    private int cantidadSolicitada;
    private String empresaDestino;

    public SolicitudProveedor(String idProducto, int cantidad, String empresaDestino) {
        this.idProducto = idProducto;
        this.cantidadSolicitada = cantidad;
        this.empresaDestino = empresaDestino;
    }

    // Getters
    public String getIdProducto() { return idProducto; }
    public int getCantidadSolicitada() { return cantidadSolicitada; }
    public String getEmpresaDestino() { return empresaDestino; }

    @Override
    public String toString() {
        return "Solicitud de " + cantidadSolicitada + " unidades del producto " + idProducto + " a " + empresaDestino;
    }
}

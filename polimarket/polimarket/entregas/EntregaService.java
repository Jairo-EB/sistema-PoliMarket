package entregas;

import ventas.OrdenVenta;
import bodega.BodegaService;
import java.util.*;

public class EntregaService {
    private List<Entrega> entregas = new ArrayList<>();
    private BodegaService bodegaService;

    public EntregaService(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    public void registrarEntrega(OrdenVenta orden) {
        Entrega entrega = new Entrega(
            orden.getId(),
            orden.getCliente(),
            orden.getProducto(),
            orden.getCantidad()
        );
        entregas.add(entrega);
        bodegaService.reducirStock(orden.getProducto().getId(), orden.getCantidad());
        orden.setEstado("Entregado");
    }

    public List<Entrega> listarEntregas() {
        return entregas;
    }
}

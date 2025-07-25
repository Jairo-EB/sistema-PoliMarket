print("=== CLIENTE 2 ===")

productos = [
    {"id": "P001", "nombre": "Impresora", "cantidad": 4},
    {"id": "P002", "nombre": "Tóner", "cantidad": 2}
]

print("\n>> Productos en inventario:")
for p in productos:
    print(f"{p['nombre']} (ID: {p['id']}) - Stock: {p['cantidad']}")

print("\n>> Solicitudes de reabastecimiento:")
for p in productos:
    if p["cantidad"] < 5:
        print(f"Solicitar 20 unidades del producto {p['id']} a ProveedorGeneral")

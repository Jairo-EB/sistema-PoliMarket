# PoliMarket - Sistema de Gestión de Áreas de Negocio

### Proyecto académico en Java | Gestión de bodega, ventas, RRHH, proveedores y entregas

---

## 📌 Descripción general

**PoliMarket** es un sistema empresarial que simula la interacción entre múltiples áreas de una empresa, incluyendo:

- 📦 Bodega
- 🛒 Ventas
- 👥 Recursos Humanos
- 🚚 Entregas
- 🧾 Proveedores

El sistema permite registrar productos, autorizar vendedores, procesar ventas, controlar inventario, realizar entregas y solicitar reabastecimiento a proveedores. Está construido en Java usando programación orientada a objetos, cumpliendo con un modelo de clases definido previamente.

---

## 🧩 Módulos y funcionalidades principales

| Módulo         | Funcionalidades clave |
|----------------|------------------------|
| **Bodega**     | Registrar productos, consultar inventario, generar solicitudes de reabastecimiento |
| **Ventas**     | Registrar clientes, vendedores, crear órdenes de venta |
| **RRHH**       | Registrar empleados y autorizar vendedores |
| **Entregas**   | Registrar entrega de productos vendidos |
| **Proveedores**| Registrar proveedores según las solicitudes generadas |


---
### ✅ Requisitos del ejercicio cumplidos

✔️ Implementación completa de los módulos requeridos

✔️ Flujo funcional entre áreas (RRHH → Ventas → Bodega → Entregas → Proveedores)

✔️ 2 clientes externos:

Cliente Java (consulta productos y órdenes)

Cliente Python (consulta inventario y genera solicitudes a proveedor)

✔️ Código modular y orientado a objetos

✔️ Simulación de datos y resultados esperados

---
#### 💻 Estructura del proyecto

```bash

polimarket/
│
├── auth/                           # 🔐 Autenticación y Autorización
│   ├── AuthService.java            # Lógica de login, privilegios, roles y usuarios
│   ├── Privilegio.java             # Representa una acción permitida (como registrarOrden)
│   ├── Rol.java                    # Grupo de privilegios (ej. Vendedor, RRHH)
│   └── Usuario.java                # Usuario con correo, clave, estado y roles
│
├── bodega/                         # 📦 Inventario de productos
│   ├── Producto.java               # Producto con id, nombre, cantidad
│   ├── BodegaService.java          # Registro, listado, stock y solicitudes de producto
│   └── SolicitudProveedor.java     # Solicitud generada cuando hay bajo stock
│
├── ventas/                         # 💰 Ventas a clientes
│   ├── Cliente.java                # Cliente con datos básicos
│   ├── Vendedor.java               # Vendedor (autorizado o no)
│   ├── OrdenVenta.java             # Orden con cliente, vendedor, producto, cantidad y estado
│   └── VentasService.java          # Registro de ventas, clientes y control de órdenes
│
├── rrhh/                           # 🧑‍💼 Recursos Humanos
│   ├── Empleado.java               # Empleado que puede autorizar vendedores
│   ├── AutorizacionVendedor.java   # Registro de una autorización (fecha, vendedor, empleado)
│   └── RRHHService.java            # Lógica de autorización de vendedores
│
├── entregas/                       # 🚚 Entregas de productos
│   ├── Entrega.java                # Representa una entrega física
│   └── EntregaService.java         # Registra entregas a partir de órdenes
│
├── proveedores/                    # 🏭 Proveedores externos
│   ├── Empresa.java                # Empresa proveedora
│   ├── Proveedor.java              # Relación empresa-producto-cantidad
│   └── ProveedorService.java       # Registra productos solicitados a empresas
│
├── main/
│   └── PoliMarketApp.java          # 🧠 Clase principal que ejecuta todo el sistema


---

 🚀 Cómo ejecutar el sistema

📦 Requisitos

- Tener Java 17+ instalado
- Tener Python 3+ (para cliente externo)
- Estar dentro de la carpeta raíz del proyecto: `polimarket/`

---

▶ Ejecutar el sistema principal

javac main/PoliMarketApp.java
java main.PoliMarketApp
Este flujo simula todo el proceso de venta, entrega y reabastecimiento.

▶ Ejecutar cliente Java (Cliente 1)

javac main/ClienteJavaConsola.java
java main.ClienteJavaConsola
Simula una aplicación que consulta productos y órdenes creadas.

▶ Ejecutar cliente Python (Cliente 2)

python cliente_api.py
Cliente externo que consume datos simulados del sistema (productos y reabastecimiento).


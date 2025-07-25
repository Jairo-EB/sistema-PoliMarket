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
├── bodega/                # Módulo de productos e inventario
├── ventas/                # Clientes, vendedores, órdenes
├── rrhh/                  # Empleados y autorización
├── proveedores/           # Proveedores y empresas
├── entregas/              # Registro de entregas
├── utils/                 # (opcional) clases de apoyo
│
├── main/
│   ├── PoliMarketApp.java        # Programa principal
│   └── ClienteJavaConsola.java   # Cliente consola en Java
│
├── cliente_api.py         # Cliente externo en Python
└── README.md              # Documentación del proyecto

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


# To-Do List

## 📌 Modelos
- [x] Producto
- [x] Proveedor
- [x] Orden de Compra
- [x] Detalle orden de compra
- [x] Venta
- [x] Detalle venta
- [x] Inventario
- [x] Usuario
- [x] Cajero
- [x] Empleado
- [x] Gerente
- [x] Devolución
- [x] CategoríaProducto
- [x] ReciboPago
- [x] Alerta
- [x] FacturaProveedor
- [x] DetalleFactura
- [x] Oferta
- [x] Reporte
- [x] SKU
- [x] Stock

## ⚙️ Funcionalidades

### 🔑 Registro y Autenticación
- [ ] Usuario y contraseña
- [ ] Google
- [ ] Ingreso
- [ ] Restablecer la contraseña
- [ ] Confirmación de cuenta vía e-mail

### 🌐 RESTful API
- [ ] Diseño
- [ ] Documentación
- [ ] Testing

### 🔍 Consulta de Datos
- [ ] Tablas
- [ ] Filtros
- [ ] Tags

### 🔒 Seguridad
- [ ] OAuth2
- [ ] OpenID Auth

### 📄 Generación de Formatos en PDF
- [ ] Reportes de ventas
- [ ] Facturación Electrónica (CFDI) para proveedores
- [ ] Órdenes de compra
- [ ] Ticket de venta (Recibo pago para clientes)

### 👤 Usuarios
- [ ] Operaciones CRUD
- [ ] Gestión y asignación de roles y permisos
- [ ] Auditoría de acciones dentro del sistema
- [ ] Autorización de vistas y acciones por rol

### 🏷️ Productos
- [ ] Operaciones CRUD
- [ ] Categorías y subcategorías (lácteos, carnes, bebidas, etc.)
- [ ] Fechas de caducidad y control de lotes (FIFO/FEFO)
- [ ] Unidades de medida (kg, litros, unidades)
- [ ] Generación de códigos de barra
- [ ] Generación de SKU por producto

### 📦 Stock
- [ ] Operaciones CRUD
- [ ] Registro de existencias en tiempo real
- [ ] Alertas automáticas para stock bajo o caducidad próxima
- [ ] Diferenciación entre productos perecederos y no perecederos
- [ ] Gestión de múltiples secciones dentro del supermercado

### 🚛 Proveedores
- [ ] Operaciones CRUD
- [ ] Control de tiempos de entrega y devoluciones
- [ ] Validación de facturas y pagos
- [ ] Historial de compras a cada proveedor

### 🛒 Compras y Reabastecimiento
- [ ] Operaciones CRUD
- [ ] Registrar órdenes de compra a proveedores
- [ ] Recepción de mercancía y actualización de stock
- [ ] Gestión de costos y precios de compra
- [ ] Seguimiento de entregas y tiempos de reposición

### 🏪 Punto de Venta
- [ ] Venta y facturación en tiempo real
- [ ] Integracion de métodos de pago (efectivo, tarjeta, digital)
- [ ] Conexión con escáneres de código de barras
- [ ] Escaneo de productos y generación de tickets
- [ ] Cálculo de impuestos y descuentos
- [ ] Registro de ventas diarias

### 🎯 Ofertas
- [ ] Operaciones CRUD para descuentos y promociones
- [ ] Descuentos por cantidad o tiempo limitado
- [ ] Promociones de "compra uno y lleva otro"
- [ ] Cupones y fidelización de clientes

### 📊 Inventario
- [ ] Operaciones CRUD

### 📈 Reportes y Análisis
- [ ] Operaciones CRUD
- [ ] Productos más vendidos y menos vendidos
- [ ] Predicción de demanda para evitar sobrestock o desabasto
- [ ] Control de mermas y pérdidas
- [ ] Generación de reportes diarios, semanales y mensuales

### 🔄 Devoluciones y Control de Caducidad
- [ ] Operaciones CRUD
- [ ] Registro de devoluciones con motivo (producto en mal estado, error en la compra)
- [ ] Eliminación de productos caducados del inventario
- [ ] Ajustes en el stock y en el balance de ingresos

## 🎨 UI

### Vistas
- [ ] Registro
- [ ] Ingreso
- [ ] Ingreso con Google
- [ ] Reestablecer contraseña
- [ ] Form nueva contraseña
- [ ] Panel principal dashboard
- [ ] Usuarios
- [ ] Detalles/Edit Usuario
- [ ] Stocks
- [ ] Registrar stock
- [ ] Productos
- [ ] Registrar producto
- [ ] Reportes
- [ ] Mi cuenta
- [ ] Ventas
- [ ] Registro de venta
- [ ] Orden
- [ ] Crear una orden
- [ ] Devoluciones
- [ ] Escaneo codigo de barras
- [ ] Gestion de Roles y Permisos
- [ ] Auditoria de acciones de usuario en el sistema
- [ ] Historial de compras a proveedores
- [ ] Ofertas


### Componentes
- [ ]

## ⭐ Cualidades del Sistema
- [ ] Escalabilidad
- [ ] Seguridad
- [ ] Eficiencia
- [ ] Mantenibilidad
- [ ] Experiencia de usuario óptima  

2. Implementar los Servicios (Capa de Negocio)
3. Crear los Controladores (Capa de Exposición de API)
4. Configurar Seguridad y Autenticación
5. Documentar la API con Swagger
6. Pruebas y Validaciones
7. Implementar un Manejador Global de Errores
8. Configurar la Base de Datos

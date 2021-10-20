<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="proveedores.css">
</head>
<body>
    <div class="barra-titulo">
      <h3>Tienda Gen�rica</h3>
    </div>
    <div class="menu">
      <ul>
        <li><a href="usuarios.jsp">Usuarios</a></li>
        <li><a href="clientes.jsp">Clientes</a></li>
        <li><a href="proveedores.jsp">Proveedores</a></li>
        <li><a href="productos.jsp">Productos</a></li>
        <li><a href="ventas.jsp">Ventas</a></li>
        <li><a href="reportes.jsp">Reportes</a></li>
      </ul>
    </div>
    <form action="usoProveedores">
    <div class="proveedores">
    <h3>NIT:</h3> <input type = "text" name = "cedula">
         <br />
         <h3>Nombre Proveedor:</h3> <input type = "text" name = "direccion">
         <br />
         <h3>Direccion:</h3> <input type = "text" name = "email">
         <br />
         <h3>Telefono:</h3> <input type = "text" name = "nombre">
         <br />
         <h3>Ciudad:</h3> <input type = "text" name = "telefono" />
    </div>
         
         <div class="botones-proveedores">
         <input type = "submit" value = "Consultar" />
         <input type = "submit" value = "Crear" />
         <input type = "submit" value = "Actualizar" />
         <input type = "submit" value = "Borrar" />
         </div>
      </form>
</body>
</html>
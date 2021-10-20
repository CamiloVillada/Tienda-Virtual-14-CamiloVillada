<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLientes</title>
<link rel="stylesheet" href="cliente.css">
</head>
<body>
    <div class="barra-titulo">
      <h3>Tienda Genérica</h3>
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
    <form action="CreaCliente.jsp">
    <div class="clientes">
    <h3>Cedula:</h3><input type = "text" name = "cedula_cliente">
         <br />
         <h3>Direccion:</h3> <input type = "text" name = "direccion_cliente">
         <br />
         <h3>Correo Electronico:</h3> <input type = "text" name = "email_cliente">
         <br />
         <h3>Nombre Completo:</h3> <input type = "text" name = "nombre_cliente">
         <br />
         <h3>Telefono:</h3> <input type = "text" name = "telefono_cliente" />
         </div>
         
         
         
         <div class="botones-clientes">
         <input type = "submit" value = "Consultar" />
         <input type = "submit" value = "Crear" />
         <input type = "submit" value = "Actualizar" />
         <input type = "submit" value = "Borrar" />
         
         </div>
         </form>
</body>
</html>
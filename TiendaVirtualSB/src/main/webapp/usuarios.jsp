<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="usuarios.css">
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
    
    <form action="usoUsuarios">
    <div class="usuarios">
    <h3>Cedula:</h3> <input type = "text" name = "Cedula">
         <br />
         <h3>Email:</h3> <input type = "text" name = "Correo">
         <br />
         <h3>Nombre Completo:</h3> <input type = "text" name = "Nombre">
         <br />
         <h3>Usuario:</h3> <input type = "text" name = "Usuario">
         <br />
         <h3>Contraseña:</h3> <input type = "text" name = "Contraseña" />
     </div>
        
         <div class="botones-usuarios">
         <input type = "submit" name="boton" value = "Consultar" />
         <input type = "submit" name="boton" value = "Crear" />
         <input type = "submit" name="boton" value = "Actualizar" />
         <input type = "submit" name="boton" value = "Borrar" />
         </div>
    </form>
</body>
</html>
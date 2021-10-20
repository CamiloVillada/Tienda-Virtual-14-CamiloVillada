<%@ page contentType="text/html; charset=UTF-8" 
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaVirtualSB.*,
        com.DTO.TiendaVirtualSB.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
<link href="proveedores.css" rel="stylesheet" type = "text/css" />
</head>
<body>
<%

ClienteController cc=new ClienteController();
DatosVO prod=new DatosVO();
File archivo = new File( request.getParameter("Examinar"));
prod.setArchivo(archivo.getAbsolutePath());
/*cc.EnlistarProductos(prod);*/
request.getRequestDispatcher("productos.jsp").forward(request, response);
%>
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
    <form action="usoProductos">
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



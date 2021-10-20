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
<title>Proveedores</title>
<link href="proveedores.css" rel="stylesheet" type = "text/css" />
</head>
<body>
<%
long nitproveedor=0;
String ciudad_proveedor="";
String direccion_proveedor="";
String nombre_proveedor="";
String telefono_proveedor="";
ClienteController cc=new ClienteController();
DatosVO prov=new DatosVO();
String opcion=request.getParameter("boton");
try{
if(opcion.equals("Consultar")){
	nitproveedor=Long.parseLong(request.getParameter("NIT"));
	prov.setNitproveedor(nitproveedor);
	prov=cc.consultarproveedor(nitproveedor);
	ciudad_proveedor=prov.getCiudad_proveedor();
	direccion_proveedor=prov.getDireccion_proveedor();
	nombre_proveedor=prov.getNombre_proveedor();
	telefono_proveedor=prov.getTelefono_proveedor();
}
else if(opcion.equals("Crear")){
	long NIT=Long.parseLong(request.getParameter("NIT"));
	prov.setNitproveedor(NIT);
	prov.setCiudad_proveedor(request.getParameter("Ciudad"));
	prov.setDireccion_proveedor(request.getParameter("Direccion"));
	prov.setNombre_proveedor(request.getParameter("Nombre"));
	prov.setTelefono_proveedor(request.getParameter("Telefono"));
    cc.registrarproveedor(prov);
    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
}
else if(opcion.equals("Actualizar")){
	nitproveedor=Long.parseLong(request.getParameter("NIT"));
	prov.setNitproveedor(nitproveedor); 
	prov.setCiudad_proveedor(request.getParameter("Ciudad"));
	prov.setDireccion_proveedor(request.getParameter("Direccion"));
	prov.setNombre_proveedor(request.getParameter("Nombre"));
	prov.setTelefono_proveedor(request.getParameter("Telefono"));
    cc.modificarproveedor(prov);
    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
}
else if(opcion.equals("Borrar")){
	nitproveedor=Long.parseLong(request.getParameter("NIT"));
	prov.setNitproveedor(nitproveedor);
	cc.eliminarproveedor(prov);
	request.getRequestDispatcher("proveedores.jsp").forward(request, response);
}
}
catch(Exception e){
	request.getRequestDispatcher("proveedores.jsp").forward(request, response);
}

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
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
<title>Clientes</title>
<link href="clientes.css" rel="stylesheet" type = "text/css" />
</head>
<body>
<%
int cedula_cliente=0;
String nombre_cliente="";
String email_cliente="";
String direccion_cliente="";
String telefono="";
ClienteController cc=new ClienteController();
ClienteVO cli=new ClienteVO();
String opcion=request.getParameter("boton");
try{
if(opcion.equals("Consultar")){
	cedula_cliente=Integer.parseInt(request.getParameter("Cedula"));
	cli.setCedula_cliente(cedula_cliente);
	cli=cc.consultarcliente(cedula_cliente);
	nombre_cliente=cli.getNombre_cliente();
	email_cliente=cli.getEmail_cliente();
	direccion_cliente=cli.getDireccion_cliente();
	telefono=cli.getTelefono_cliente();
}
else if(opcion.equals("Crear")){
	int cedula=Integer.parseInt(request.getParameter("Cedula"));
	cli.setCedula_cliente(cedula); 
    cli.setEmail_cliente(request.getParameter("Correo"));
    cli.setNombre_cliente(request.getParameter("Nombre"));
    cli.setDireccion_cliente(request.getParameter("Direccion"));
    cli.setTelefono_cliente(request.getParameter("Telefono"));
    cc.registrarcliente(cli);
    request.getRequestDispatcher("clientes.jsp").forward(request, response);
}
else if(opcion.equals("Actualizar")){
	cedula_cliente=Integer.parseInt(request.getParameter("Cedula"));
	cli.setCedula_cliente(cedula_cliente); 
	cli.setEmail_cliente(request.getParameter("Correo"));
    cli.setNombre_cliente(request.getParameter("Nombre"));
    cli.setDireccion_cliente(request.getParameter("Direccion"));
    cli.setTelefono_cliente(request.getParameter("Telefono"));
    cc.modificarcliente(cli);
    request.getRequestDispatcher("clientes.jsp").forward(request, response);
}
else if(opcion.equals("Borrar")){
	cedula_cliente=Integer.parseInt(request.getParameter("Cedula"));
	cli.setCedula_cliente(cedula_cliente); 
	cc.eliminarcliente(cli);
	request.getRequestDispatcher("clientes.jsp").forward(request, response);
}
}
catch(Exception e){
	request.getRequestDispatcher("clientes.jsp").forward(request, response);
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
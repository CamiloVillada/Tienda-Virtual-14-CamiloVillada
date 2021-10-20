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
<title>Usuarios</title>
<link href="usuarios.css" rel="stylesheet" type = "text/css" />
</head>
<body>
<%
int cedula_usuario=0;
String nombre_usuario="";
String email_usuario="";
String usuario="";
String password="";
ClienteController cc=new ClienteController();
DatosVO usu=new DatosVO();
String opcion=request.getParameter("boton");
try{
if(opcion.equals("Consultar")){
	cedula_usuario=Integer.parseInt(request.getParameter("Cedula"));
	usu.setCedula_usuario(cedula_usuario);
	usu=cc.consultarUsuario(cedula_usuario);
	nombre_usuario=usu.getNombre_usuario();
	email_usuario=usu.getEmail_usuario();
	usuario=usu.getUsuario();
	password=usu.getContraseña();
}
else if(opcion.equals("Crear")){
	int cedula=Integer.parseInt(request.getParameter("Cedula"));
	usu.setCedula_usuario(cedula); 
	usu.setEmail_usuario(request.getParameter("Correo"));
	usu.setNombre_usuario(request.getParameter("Nombre"));
	usu.setUsuario(request.getParameter("Usuario"));
	usu.setContraseña(request.getParameter("Contrasena"));
    cc.registrarUsuario(usu);
}
else if(opcion.equals("Actualizar")){
	cedula_usuario=Integer.parseInt(request.getParameter("Cedula"));
	usu.setCedula_usuario(cedula_usuario); 
	usu.setEmail_usuario(request.getParameter("Correo"));
	usu.setNombre_usuario(request.getParameter("Nombre"));
	usu.setUsuario(request.getParameter("Usuario"));
	usu.setContraseña(request.getParameter("Contrasena"));
    cc.modificarUsuario(usu);
    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
}
else if(opcion.equals("Borrar")){
	cedula_usuario=Integer.parseInt(request.getParameter("Cedula"));
	usu.setCedula_usuario(cedula_usuario); 
	cc.eliminarUsuario(usu);
	request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}
}
catch(Exception e){
	request.getRequestDispatcher("usuarios.jsp").forward(request, response);
}
%>
    <div class="barra-titulo">
      <h3>Tienda Genérica</h3>
    </div>
    <div class="menu">
      <ul>
        <li><a href="usuarios.html">Usuarios</a></li>
        <li><a href="crearCliente.html">Clientes</a></li>
        <li><a href="proveedores.html">Proveedores</a></li>
        <li><a href="productos.html">Productos</a></li>
        <li><a href="ventas.html">Ventas</a></li>
        <li><a href="reportes.html">Reportes</a></li>
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
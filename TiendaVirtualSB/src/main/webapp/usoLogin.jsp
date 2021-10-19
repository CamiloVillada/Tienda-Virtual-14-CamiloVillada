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
<title>Login</title>
</head>
<body>
<%
	boolean validacion=true;
	ClienteController cc=new ClienteController();
	UsuarioVO usu=new UsuarioVO();
	usu.setUsuario(request.getParameter("usuario"));  
	usu.setContraseña(request.getParameter("contrasena"));
	validacion=cc.validate(usu);
	if(validacion==true){
		request.getRequestDispatcher("menu.html").forward(request, response);
	}
	else{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
 %>	
</body>
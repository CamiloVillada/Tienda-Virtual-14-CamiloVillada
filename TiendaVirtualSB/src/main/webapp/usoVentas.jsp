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
<title>Ventas</title>
<link rel="stylesheet" href="ventas.css">
</head>
<body>
<%
int codigo1=0;
int codigo2=0;
int codigo3=0;
ClienteController cc=new ClienteController();
DatosVO ven=new DatosVO();
String opcion=request.getParameter("button");
int cedula_cliente=0;
String nombre_cliente="";
int consecutivo=0;
int codigo_producto1=0;
String nombre_producto1="";
double precio_unitario1 = 0;
int codigo_producto2=0;
String nombre_producto2="";
double precio_unitario2 = 0;
int codigo_producto3=0;
String nombre_producto3="";
double precio_unitario3= 0;
int cantidad1=0;
int cantidad2=0;
int cantidad3=0;
double IVAS=0;
double total1=0;
double total2=0;
double total3=0;
double Totales=0;
double TotalesIVA=0;
try{
 cedula_cliente=Integer.parseInt(request.getParameter("cedula"));
 nombre_cliente=request.getParameter("cliente");
 consecutivo=Integer.parseInt(request.getParameter("consec"));
}
catch(Exception e){}
try{
codigo1=Integer.parseInt(request.getParameter("codigoP1"));
nombre_producto1=request.getParameter("nombreP1");
precio_unitario1=Double.parseDouble(request.getParameter("vlr1"));
}
catch(Exception e){}
try{
	 codigo2=Integer.parseInt(request.getParameter("codigoP2"));
	 nombre_producto2=request.getParameter("nombreP2");
	 precio_unitario2=Double.parseDouble(request.getParameter("vlr2"));
}
catch(Exception e){}
try{
	 codigo3=Integer.parseInt(request.getParameter("codigoP3"));
	 nombre_producto3=request.getParameter("nombreP3");
	 precio_unitario3=Double.parseDouble(request.getParameter("vlr3"));
}
catch(Exception e){}
try{
	 cantidad1=Integer.parseInt(request.getParameter("cant1"));
	 cantidad2=Integer.parseInt(request.getParameter("cant2"));
	 cantidad3=Integer.parseInt(request.getParameter("cant3"));
}
catch(Exception e){}
try{
	total1=Double.parseDouble(request.getParameter("vlrTotal1"));
	total2=Double.parseDouble(request.getParameter("vlrTotal"));
	total3=Double.parseDouble(request.getParameter("vlrTotal3"));
}
catch(Exception e){}
try{
	Totales=Double.parseDouble(request.getParameter("totalVenta"));
	IVAS=Double.parseDouble(request.getParameter("totalIVA"));
	TotalesIVA=Double.parseDouble(request.getParameter("totalconIVA"));
}
catch(Exception e){}

try{
if(opcion.equals("Consultar")){
	try{
	cedula_cliente=Integer.parseInt(request.getParameter("Cedula"));
	ven.setCedula_cliente(cedula_cliente);
	ven=cc.consultarcliente(cedula_cliente);
 	nombre_cliente=ven.getNombre_cliente();
 	ven=cc.ConsultarClienteVenta(cedula_cliente);
 	consecutivo=ven.getCodigo_venta();
	}
	catch(Exception e){
		request.getRequestDispatcher("ventas.jsp").forward(request, response);
	}
}
else if(opcion.equals("consultar1")){
	codigo_producto1=Integer.parseInt(request.getParameter("codigoP1"));
	codigo1=codigo_producto1;
	ven.setCodigo_producto(codigo_producto1);
	ven=cc.consultarproducto(codigo_producto1);
	codigo_producto1=ven.getCodigo_producto();
	nombre_producto1=ven.getNombre_producto();
	precio_unitario1=ven.getPrecio_venta();
}
else if(opcion.equals("consultar2")){
	codigo_producto2=Integer.parseInt(request.getParameter("codigoP2"));
	codigo2=codigo_producto2;
	ven.setCodigo_producto(codigo_producto2);
	ven=cc.consultarproducto(codigo_producto2);
	codigo_producto2=ven.getCodigo_producto();
	nombre_producto2=ven.getNombre_producto();
	precio_unitario2=ven.getPrecio_venta();
	}
else if(opcion.equals("consultar3")){
	codigo_producto3=Integer.parseInt(request.getParameter("codigoP3"));
	codigo3=codigo_producto3;
	ven.setCodigo_producto(codigo_producto3);
	ven=cc.consultarproducto(codigo_producto3);
	codigo_producto3=ven.getCodigo_producto();
	nombre_producto3=ven.getNombre_producto();
	precio_unitario3=ven.getPrecio_venta();
}
else if(opcion.equals("Calcular")){
	if(Integer.parseInt(request.getParameter("codigoP1"))!=0){
		cantidad1=Integer.parseInt(request.getParameter("cant1"));
		precio_unitario1=Double.parseDouble(request.getParameter("vlr1"));
		total1=(cantidad1*precio_unitario1);
	}
	else{
		cantidad1=0;
		precio_unitario1=0;
		total1=0;
	}
	if(Integer.parseInt(request.getParameter("codigoP2"))!=0){
		cantidad2=Integer.parseInt(request.getParameter("cant2"));
		precio_unitario2=Double.parseDouble(request.getParameter("vlr2"));
		total2=(cantidad2*precio_unitario2);
	}
	else{
		cantidad2=0;
		precio_unitario2=0;
		total2=0;
	}
	if(Integer.parseInt(request.getParameter("codigoP3"))!=0){
		cantidad3=Integer.parseInt(request.getParameter("cant3"));
		precio_unitario3=Double.parseDouble(request.getParameter("vrl3"));
		total3=(cantidad3*precio_unitario3);
    }
	else{
		cantidad3=0;
		precio_unitario3=0;
		total3=0;
	}
	Totales=total1+total2+total3;
	IVAS=Totales*0.19;
	TotalesIVA=Totales+IVAS;
}
else if(opcion.equals("Confirmar")){
	cedula_cliente=Integer.parseInt(request.getParameter("Cedula"));
	ven.setCedula_cliente(cedula_cliente);
	ven.setTotal_venta(Double.parseDouble(request.getParameter("Totales")));	
	ven.setValor_venta(Double.parseDouble(request.getParameter("totalVenta")));
	ven.setCodigo_venta(Integer.parseInt(request.getParameter("consec")));
	cc.confirmarventa(ven);
	if(Integer.parseInt(request.getParameter("codigoP1"))!=0){
		ven.setCantidad_producto(Integer.parseInt(request.getParameter("cant1")));
		ven.setCodigo_producto(Integer.parseInt(request.getParameter("codigoP1")));
		ven.setCodigo_venta(Integer.parseInt(request.getParameter("consec")));
		ven.setValor_total_prod(Double.parseDouble(request.getParameter("total1")));
		ven.setValor_venta_prod(Double.parseDouble(request.getParameter("total1"))+(Double.parseDouble(request.getParameter("total1"))*0.19));
		ven.setValoriva_prod(Double.parseDouble(request.getParameter("total1"))*0.19);
		cc.Creardetalle(ven);
	}
	else{
	}
	if(Integer.parseInt(request.getParameter("codigoP2"))!=0){
		ven.setCantidad_producto(Integer.parseInt(request.getParameter("cant2")));
		ven.setCodigo_producto(Integer.parseInt(request.getParameter("codigoP2")));
		ven.setCodigo_venta(Integer.parseInt(request.getParameter("consec")));
		ven.setValor_total_prod(Double.parseDouble(request.getParameter("total2")));
		ven.setValor_venta_prod(Double.parseDouble(request.getParameter("total2"))+(Double.parseDouble(request.getParameter("total2"))*0.19));
		ven.setValoriva_prod(Double.parseDouble(request.getParameter("total2"))*0.19);
		cc.Creardetalle(ven);
	}
	else{
	}
	if(Integer.parseInt(request.getParameter("codigoP3"))!=0){
		ven.setCantidad_producto(Integer.parseInt(request.getParameter("cant3")));
		ven.setCodigo_producto(Integer.parseInt(request.getParameter("codigoP3")));
		ven.setCodigo_venta(Integer.parseInt(request.getParameter("consec")));
		ven.setValor_total_prod(Double.parseDouble(request.getParameter("total3")));
		ven.setValor_venta_prod(Double.parseDouble(request.getParameter("total3"))+(Double.parseDouble(request.getParameter("total3"))*0.19));
		ven.setValoriva_prod(Double.parseDouble(request.getParameter("total3"))*0.19);
		cc.Creardetalle(ven);
	}
	else{
	}
	request.getRequestDispatcher("ventas.jsp").forward(request, response);

}

}
catch(Exception e){
	
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
    <div class="ventas">
    <h3>Cedula</h3> <input type = "text" name = "cedula"> <input type = "submit" value = "Consultar" />
    <h3>Cliente</h3> <input type = "text" name = "cliente">
    <h3>Consec.</h3> <input type = "text" name = "consec">
     
     <div class="titulos">
     <h3 id="cod" >Cod. Producto</h3> <h3 id="nomb">Nombre Producto</h3> <h3 id="unidad">Valor</h3> <h3 id="titulo2">Cant.</h3> <h3 id="vlr">Vlr. Total</h3>
     </div>
     
     <div class="ventas1">
     <input id="codigo" type = "text" name = "codigoP1"> <input type = "submit" value = "consultar1" />
     <input id="nombre" type = "text" name = "nombreP1">
     <input id="valor" type = "text" name = "vlr1">
     <input id="cant" type = "text" name = "cant1">
     <input id="vlrTotal" type = "text" name = "vlrTotal1">
     </div>
     
     <div class="ventas2">
     <input id="codigo" type = "text" name = "codigoP2"> <input type = "submit" value = "consultar2" />
     <input id="nombre" type = "text" name = "nombreP2">
     <input id="valor" type = "text" name = "vlr2">
     <input id="cant" type = "text" name = "cant2">
     <input id="vlrTotal" type = "text" name = "vlrTotal2">
     </div>
     
     <div class="ventas3">
     <input id="codigo" type = "text" name = "codigoP3"> <input type = "submit" value = "consultar3" />
     <input id="nombre" type = "text" name = "nombreP3">
     <input id="valor" type = "text" name = "vlr2">
     <input id="cant" type = "text" name = "cant3">
     <input id="vlrTotal" type = "text" name = "vlrTotal3">
     </div>
     </div>
     <div class="totales">
     <h3>Total Venta</h3> <input type = "text" name = "totalVenta">
     <br />
    <h3>Total IVA</h3> <input type = "text" name = "totalIVA">
    <br />
    <h3>Total con IVA.</h3> <input type = "text" name = "totalconIVA">
     </div>
         
         <div class="botones-ventas">
         <input type = "submit" value = "Confirmar" />
         </div>
    
</body>
</html>
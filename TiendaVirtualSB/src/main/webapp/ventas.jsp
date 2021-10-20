<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link rel="stylesheet" href="ventas.css">
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
    <h3>Total IVA</h3> <input type = "text" name = "totaIVA">
    <br />
    <h3>Total con IVA.</h3> <input type = "text" name = "totalconIVA">
     </div>
         
         <div class="botones-ventas">
         <input type = "submit" value = "Confirmar" />
         </div>
    
</body>
</html>
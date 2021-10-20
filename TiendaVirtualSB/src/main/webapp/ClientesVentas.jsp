<%@ page contentType="text/html; charset=UTF-8" 
    import="
        java.io.*,
        java.util.*,
        com.BO.TiendaVirtualSB.*,
        com.DAO.TiendaVirtualSB.*,
        com.DTO.TiendaVirtualSB.*"
%>

<%
          ClienteController cc=new ClienteController();
          DatosVO cli=new DatosVO();
          cc.listaDeVentas();
         double total = cli.getTotal_todo();
         %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLientes</title>
<link rel="stylesheet" href="cliente.css">
</head>
<body>
    <script>
        
    var saveme =  $.ajax({
        type: "POST",
        url: "http://localhost:8080/ListarVentas", //nombre del archivo php que consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
          lista = document.getElementById("myTable");
          var tr = document.createElement("tr");
          var columna1 = document.createElement("td")
          columna1.innerHTML = item.cedula_cliente;
          var columna2 = document.createElement("td")
          columna2.innerHTML = item.nombre_cliente;
          var columna3 = document.createElement("td")
          columna3.innerHTML = item.total_por_cliente;
			
        	
          lista.appendChild(tr);
          tr.appendChild(columna1);
          tr.appendChild(columna2);
          tr.appendChild(columna3);
          
          var total = document.createElement("p")
       
         });
        }
      });
    
    </script>
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
	<div class = "contenedor">
		<div class="" >
		 <h3>Total de Ventas por Cliente</h3>
        <table id="ventasClientes">
            <tr>
              <th>Cédula</th>
              <th>Nombre</th>
              <th>Valor Total Ventas</th>
            </tr>

<tbody id="myTable">
</tbody>
			
</table>
<p id="TotalVentas">Total Ventas $: <%= total %></p>

 
        

    		</div> 
		</div>
	</body>
</html>
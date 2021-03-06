<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Clientes</title>
<link rel="stylesheet" href="cliente.css">
</head>
<body>
    <script>
        
    var saveme =  $.ajax({
        type: "POST",
        url: "http://localhost:8080/ListarClientes", //nombre del archivo php que consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
          lista = document.getElementById("myTable");
          var tr = document.createElement("tr");
          var columna1 = document.createElement("td")
          columna1.innerHTML = item.cedula_cliente;
          var columna2 = document.createElement("td")
          columna2.innerHTML = item.nombre_cliente;
          var columna3 = document.createElement("td")
          columna3.innerHTML = item.email_cliente;
          var columna4 = document.createElement("td")
          columna4.innerHTML = item.direccion_cliente;
          var columna5 = document.createElement("td")
          columna5.innerHTML = item.telefono_cliente;
      	
          
          lista.appendChild(tr);
          tr.appendChild(columna1);
          tr.appendChild(columna2);
          tr.appendChild(columna3);
          tr.appendChild(columna4);
          tr.appendChild(columna5);
       
         });
        }
      });
    
    </script>
    <div class="barra-titulo">
      <h3>Tienda Gen?rica</h3>
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
	<div class = "tabla">
		<div class="tablamenor" >
		<h3>Listado de Clientes</h3>
        <table id="Clientes">
        
            <tr>
              <th>C?dula</th>
              <th>Nombre</th>
              <th>Correo Electr?nico</th>
              <th>Direcci?n</th>
              <th>Tel?fono</th>
            </tr>
          </table>
          </div>
          </div>
    </body>
</html>
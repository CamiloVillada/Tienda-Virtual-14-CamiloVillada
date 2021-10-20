<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link rel="stylesheet" href="productos.css">
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
    <div class="productos">
    <h3> Nombre del Archivo:</h3> <input type = "text" name = "cedula">
    <input id="archivo" type = "file" accept=".csv" value = "Cargar" />
    </div>
         
         
         <div class="botones-productos">
         <button type="button" onclick= "subirArchivo()">Subir Archivo</button>
         </div>
         
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script>includeHTML();</script>
    
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script>
        function subirArchivo() {
            try {
                var csvFile = document.getElementById("archivo");
                var input = csvFile.files[0];
                var reader = new FileReader();
                
                reader.onload = function(e) {
                	
                    var text = e.target.result;
                    var arrayLineas = text.split("\n");
                    var xhr = new XMLHttpRequest();
                    
                    xhr.open("DELETE",
                            "http://localhost:8080/eliminartodoproducto", true);
                    xhr.send();
                    
                    for (var i = 0; i < arrayLineas.length; i += 1) {
                        var arraydatos = arrayLineas[i].split(";");
                        
                        if (arrayLineas[i] == "") {
                            continue;
                        }
                        
                        for (var j = 0; j < arraydatos.length; j += 1) {
                            console.log(i + " " + j + "->" + arraydatos[j]);
                        }
                        
                        var formData = new FormData();
                        formData.append("codigo_producto", arraydatos[0]);
                        formData.append("nombre_producto", arraydatos[1]);
                        formData.append("nitproveedor", arraydatos[2]);
                        formData.append("precio_compra", arraydatos[3]);   
                        formData.append("ivacompra", arraydatos[4]);
                        formData.append("precio_venta", arraydatos[5]);
                        var xhr = new XMLHttpRequest();
                        xhr.open("POST",
                                "http://localhost:8080/registrarproducto");
                        xhr.send(formData);
                       
                    }


                   var element = document.getElementById("error");
                    element.classList.add("visually-hidden");
                    var element2 = document.getElementById("correcto");
                    element2.classList.remove("visually-hidden");
                    document.getElementById("archivo").value = "";
                };
                reader.readAsText(input);
            } catch (error) {
                var element = document.getElementById("error");
                element.classList.remove("visually-hidden");
                var element2 = document.getElementById("correcto");
                element2.classList.add("visually-hidden");
                document.getElementById("archivo").value = "";
            }
            
        }
    </script>
 
 
</html>

package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import com.BO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.DatosVO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class VentasDAO 
{		
	
 
 public DatosVO ConsultarClienteVenta(int cedula_cliente) {
	    Conexion conex = new Conexion();
	    DatosVO persona = new DatosVO();
	    try {
	        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes where cedula_cliente=? ");
	        consulta.setInt(1, cedula_cliente);
	        ResultSet res = consulta.executeQuery();
	        if (!res.next() ) {
	            System.out.println("no data");
	            persona.setCodigo_venta(-2);
	        	return persona;
	        }
	        else{
	        	PreparedStatement consecutivo = conex.getConnection().prepareStatement("SELECT * FROM ventas ORDER BY codigo_venta DESC LIMIT 1");
	        	ResultSet rs = consecutivo.executeQuery();
	        	if(!rs.next()) {
	        		System.out.println("toy vacio");
	        		persona.setCodigo_venta(1);
			        Statement estatuto = conex.getConnection().createStatement();
			        estatuto.executeUpdate("INSERT INTO ventas VALUES ('"+persona.getCodigo_venta()+"', '"+cedula_cliente+"','"+Usuarios.CedulaGlobal+"','19','0','0')");
			        estatuto.close();
			        System.out.println("pase en no hay");
			        conex.desconectar();
	        	}
	        	else {
	        		persona.setCodigo_venta(Integer.parseInt(rs.getString("codigo_venta")));
			        int numero=persona.getCodigo_venta()+1;
			        persona.setCodigo_venta(numero);
			        Statement estatuto = conex.getConnection().createStatement();
			        estatuto.executeUpdate("INSERT INTO ventas VALUES ('"+persona.getCodigo_venta()+"', '"+cedula_cliente+"','"+Usuarios.CedulaGlobal+"','19','0','0')");
			        estatuto.close();
			        System.out.println("pase");
			        conex.desconectar();
	        	}
	        	return persona;
	        }

	    } catch (Exception e) {	    	
	    	return persona;
	    }
 	}
 
 public DatosVO ConsultarProducto(int codigo_producto) {
	    Conexion conex = new Conexion();
	    DatosVO persona = new DatosVO();
	    try {
	        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos where codigo_producto=? ");
	        consulta.setInt(1, codigo_producto);
	        ResultSet res = consulta.executeQuery();
	        if (res.next()) {
	            persona.setNombre_producto(res.getString("nombre_producto"));
	            persona.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));
		        conex.desconectar();
		        return persona;
	        }
	        else {
	        	return null;
	        }

	    } catch (Exception e) {
	    	return null;
	    }
	    
	}

 public void Confirmarventa(DatosVO persona) {
     Conexion conex = new Conexion();
     try {
    	 PreparedStatement sentencia= conex.getConnection().prepareStatement("UPDATE ventas SET cedula_cliente = ?, cedula_usuario = ?, ivaventa=?, total_venta = ?, valor_venta = ?  WHERE codigo_venta=?");
         sentencia.setInt(1, persona.getCedula_cliente());
         sentencia.setInt(2, Usuarios.CedulaGlobal);
         sentencia.setDouble(3, (persona.getTotal_venta()*0.19));
         sentencia.setDouble(4, persona.getTotal_venta());
         sentencia.setDouble(5, persona.getValor_venta());
         sentencia.setInt(6, persona.getCodigo_venta());
         sentencia.executeUpdate();
         sentencia.close();
         conex.desconectar();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
 
 public void Creardetalle(DatosVO persona) 
 {
  Conexion conex= new Conexion();
  try {
	  PreparedStatement consecutivo = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas ORDER BY codigo_detalle_venta DESC LIMIT 1");
	  ResultSet rs = consecutivo.executeQuery();
	  	if(!rs.next()) {
	  		System.out.println("toy vacio detalle");
	  		persona.setCodigo_detalle_venta(1);
		    Statement estatuto = conex.getConnection().createStatement();
	        estatuto.executeUpdate("INSERT INTO detalle_ventas VALUES ('"+persona.getCodigo_detalle_venta()+"', '"+persona.getCantidad_producto()+"','"+persona.getCodigo_producto()+"','"+persona.getCodigo_venta()+"','"+persona.getValor_total_prod()+"','"+persona.getValor_venta_prod()+"','"+persona.getValoriva_prod()+"')");
	        estatuto.close();
	        System.out.println("pase en no hay detalle");
	        conex.desconectar();
	  	}
	  	else {
	  		persona.setCodigo_detalle_venta(Integer.parseInt(rs.getString("codigo_detalle_venta")));
	        int numero=persona.getCodigo_detalle_venta()+1;
	        persona.setCodigo_detalle_venta(numero);
	        Statement estatuto = conex.getConnection().createStatement();
	        estatuto.executeUpdate("INSERT INTO detalle_ventas VALUES ('"+persona.getCodigo_detalle_venta()+"', '"+persona.getCantidad_producto()+"','"+persona.getCodigo_producto()+"','"+persona.getCodigo_venta()+"','"+persona.getValor_total_prod()+"','"+persona.getValor_venta_prod()+"','"+persona.getValoriva_prod()+"')");
	        estatuto.close();
	        System.out.println("pase detalle");
	        conex.desconectar();
	  	}
  } catch (SQLException e) {
	  System.out.println(e.getMessage());
  }
 }

 public void Eliminartodoproducto(DatosVO persona) {
	 Conexion conex = new Conexion();
	 try {
		 PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from productos");
		 sentencia.executeUpdate();
		 sentencia.close();
		 conex.desconectar();
 	} catch (Exception e) {
     System.out.println(e.getMessage());
 	}
 }

 public void registrarProductos(DatosVO persona) 
 {
  Conexion conex= new Conexion();
  try {
   Statement estatuto = conex.getConnection().createStatement();
   estatuto.close();
   conex.desconectar();
  } catch (SQLException e) {
	  System.out.println(e.getMessage());
  }
 }
}
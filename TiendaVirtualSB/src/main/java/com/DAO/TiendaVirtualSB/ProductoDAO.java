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


import com.DTO.TiendaVirtualSB.DatosVO;


public class ProductoDAO 
{	

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
	  PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores where nitproveedor=? ");
        consulta.setLong(1, persona.getNitproveedor());
        ResultSet rs = consulta.executeQuery();
        if (!rs.isBeforeFirst()) {    
	        	System.out.println("No hay nit ");
	        } 
	        else {
   Statement estatuto = conex.getConnection().createStatement();
   estatuto.executeUpdate("INSERT INTO productos VALUES ("+persona.getCodigo_producto()+", '"+persona.getIvacompra()+"', '"+persona.getNitproveedor()+"','"+persona.getNombre_producto()+"','"+persona.getPrecio_compra()+"','"+persona.getPrecio_venta()+"')");
 	estatuto.close();
   conex.desconectar();
	        }
  } catch (SQLException e) {
	  System.out.println(e.getMessage());
  }
 }
 /*public void ListarProductos(DatosVO persona) 
 {
	 
	    FileReader archCSV = null;
	    CSVReader csvReader = null;
	    try {
	    	archCSV = new FileReader(persona.getArchivo());
	    	CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
	    	csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
	    	String[] fila = null;
	    	ArrayList<String> lista=new ArrayList<String>();
	    	while((fila = csvReader.readNext()) != null) {
		          lista.add(fila[0]);
		          lista.add(fila[1]);
		          lista.add(fila[2]);
		          lista.add(fila[3]);
		          lista.add(fila[4]);
		          lista.add(fila[5]);
		          String valor=lista.get(0);
		          valor=valor.replaceAll("[^\\d]", "");
		          int Codigo_producto=Integer.parseInt(valor);
		          int nit = Integer.parseInt(lista.get(2));
		    	  double ivacompra=Double.parseDouble(lista.get(4));
		    	  String nombre_producto=lista.get(1);
		    	  double precio_compra=Double.parseDouble(lista.get(3));
		    	  double precio_venta=Double.parseDouble(lista.get(5));
		          persona.setIvacompra(ivacompra);
		          persona.setNombre_producto(nombre_producto);
		          persona.setPrecio_compra(precio_compra);
		          persona.setPrecio_venta(precio_venta);
		          persona.setCodigo_producto(Codigo_producto);
		          Codigo_producto=persona.getCodigo_producto();
		      		Conexion conex = new Conexion();
		  	        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores where nitproveedor=? ");
		  	        consulta.setInt(1, nit);
		  	        ResultSet rs = consulta.executeQuery();
		  	        if (!rs.isBeforeFirst()) {    
		  	        	System.out.println("No hay nit "+lista.get(2));
		  	        } 
		  	        else {
		  	        	Statement estatuto = conex.getConnection().createStatement();
		  	        	estatuto.executeUpdate("INSERT INTO productos VALUES ("+persona.getCodigo_producto()+", '"+persona.getIvacompra()+"', '"+nit+"','"+persona.getNombre_producto()+"','"+persona.getPrecio_compra()+"','"+persona.getPrecio_venta()+"')");
		  	        	estatuto.close();
		  	        	conex.desconectar();
		  	        }
		  	      lista.clear();
		          }
		  		     

	    }
	    catch(IOException e) {
	      System.out.println(e);
	    }
	    catch(Exception e) {
	      System.out.println(e);
	    }
	    finally {
	      try { 
	        archCSV.close();
	        csvReader.close();
	      }
	      catch(IOException e) {
	        System.out.println(e);
	      }
	    }
	  }*/
}

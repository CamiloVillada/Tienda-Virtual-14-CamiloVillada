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

public class ProveedorDAO 
{		
 public void registrarProveedor(DatosVO persona) 
 {
  Conexion conex= new Conexion();
  try {
   Statement estatuto = conex.getConnection().createStatement();
   estatuto.executeUpdate("INSERT INTO proveedores VALUES ('"+persona.getNitproveedor()+"', '" +persona.getCiudad_proveedor()+"', '"+persona.getDireccion_proveedor()+"','"+persona.getNombre_proveedor()+"','"+persona.getTelefono_proveedor()+"')");
   estatuto.close();
   conex.desconectar();
  } catch (SQLException e) {
	  System.out.println(e.getMessage());
  }
 }
   
 public void modificarProveedor(DatosVO persona) {
     Conexion conex = new Conexion();
     try {
    	 PreparedStatement sentencia= conex.getConnection().prepareStatement("UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ? WHERE nitproveedor=?");
         sentencia.setString(1, persona.getCiudad_proveedor());
         sentencia.setString(2, persona.getDireccion_proveedor());
         sentencia.setString(3, persona.getNombre_proveedor());
         sentencia.setString(4, persona.getTelefono_proveedor());
         sentencia.setLong(5, persona.getNitproveedor());
         sentencia.executeUpdate();
         sentencia.close();
         conex.desconectar();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
 
 public void eliminarProveedor(DatosVO persona) {
	 Conexion conex = new Conexion();
	 try {
		 PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from proveedores WHERE nitproveedor=?");
		 sentencia.setLong(1, persona.getNitproveedor());
		 sentencia.executeUpdate();
		 sentencia.close();
		 conex.desconectar();
 	} catch (Exception e) {
     System.out.println(e.getMessage());
 	}
 }
 
 public DatosVO ConsultarProveedor(long nitproveedor) {
	 	Conexion conex = new Conexion();
	 	DatosVO persona = new DatosVO();
	    try {
	        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores where nitproveedor=? ");
	        consulta.setLong(1, nitproveedor);
	        ResultSet res = consulta.executeQuery();
	        if (res.next()) {
	            persona.setCiudad_proveedor(res.getString("ciudad_proveedor"));
	            persona.setDireccion_proveedor(res.getString("direccion_proveedor"));
	            persona.setNombre_proveedor(res.getString("nombre_proveedor"));
	            persona.setTelefono_proveedor(res.getString("telefono_proveedor"));
		        conex.desconectar();
		        return persona;
	        }
	        else {
	        	return null;
	        }

	    } catch (Exception e) {
	    	persona.setNitproveedor((long) 0);
	    	return null;
	    }
 }
 
}

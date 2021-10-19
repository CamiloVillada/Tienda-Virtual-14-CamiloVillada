package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.BO.TiendaVirtualSB.*;
import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.UsuarioVO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class UsuariosDAO 
{
	
	
	public void registrarUsuario(UsuarioVO persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO usuarios VALUES ('"+persona.getCedula_usuario()+"', '"+persona.getEmail_usuario()+"', '"+persona.getNombre_usuario()+"','"+persona.getContraseña()+"','"+persona.getUsuario()+"')");
	   estatuto.close();
	   conex.desconectar();
	  } catch (SQLException e) {
		  System.out.println(e.getMessage());
	  }
	 }
	   
	 public void modificarUsuario(UsuarioVO persona) {
	     Conexion conex = new Conexion();
	     try {
	    	 PreparedStatement sentencia= conex.getConnection().prepareStatement("UPDATE usuarios SET email_usuario = ?, nombre_usuario = ?, password = ?, usuario = ? WHERE cedula_usuario=?");
	         sentencia.setString(1, persona.getEmail_usuario());
	         sentencia.setString(2, persona.getNombre_usuario());
	         sentencia.setString(3, persona.getContraseña());
	         sentencia.setString(4, persona.getUsuario());
	         sentencia.setInt(5, persona.getCedula_usuario());
	         sentencia.executeUpdate();
	         sentencia.close();
	         conex.desconectar();
	     } catch (SQLException e) {
	         System.out.println(e.getMessage());
	     }
	 }
	 
	 public void eliminarUsuario(UsuarioVO persona) {
		 Conexion conex = new Conexion();
		 try {
			 PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from usuarios WHERE cedula_usuario=?");
			 sentencia.setInt(1, persona.getCedula_usuario());
			 sentencia.executeUpdate();
			 sentencia.close();
			 conex.desconectar();
	 	} catch (Exception e) {
	     System.out.println(e.getMessage());
	 	}
	 }
	 
	 public UsuarioVO Consultarusuario(int cedula_usuario) {
		    Conexion conex = new Conexion();
		    UsuarioVO persona = new UsuarioVO();
		    try {
		        PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where cedula_usuario = ? ");
		        consulta.setInt(1, cedula_usuario);
		        ResultSet res = consulta.executeQuery();
		        if (res.next()) {
		            persona.setNombre_usuario(res.getString("nombre_usuario"));
		            persona.setEmail_usuario(res.getString("email_usuario"));
		            persona.setContraseña(res.getString("password"));
		            persona.setUsuario(res.getString("usuario"));
			        conex.desconectar();
			        return persona;
		        }
		        else {
		        	return null;
		        }

		    } catch (Exception e) {
		    	persona.setCedula_usuario(0);
		    	return null;
		    }
		    
		}

	 
	 public boolean validate(UsuarioVO persona){
			boolean validacion=true;
	    try {
	    	Conexion conex= new Conexion();
	    	PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where usuario = ? and password = ? ");
	        consulta.setString(1, persona.getUsuario());
	        consulta.setString(2, persona.getContraseña());
	        ResultSet rs = consulta.executeQuery();
	        if (!rs.isBeforeFirst()) {    
	    	    System.out.println("No data"); 
	    	    validacion=false;
	    	} 
	        else{
	        	validacion=true;
	        	if(rs.next()) {
	        		
	        		Usuarios.CedulaGlobal=(Integer.parseInt(rs.getString("cedula_usuario")));
	        		
	        	}
	        }
	    } catch (SQLException e) {
	    	
	    }
	    return validacion;
		}
	  
}

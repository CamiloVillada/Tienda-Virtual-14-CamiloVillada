package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.DTO.TiendaVirtualSB.ClienteVO;


class Usuarios{
    static int CedulaGlobal;
}

public class ClienteDAO 
{

 /**
  * Permite registrar un Cliente nuevo
  * @param persona
  */
	
	
 public void registrarPersona(ClienteVO persona) 
 {
  Conexion conex= new Conexion();
  try {
   Statement estatuto = conex.getConnection().createStatement();
   estatuto.executeUpdate("INSERT INTO clientes VALUES ('"+persona.getCedulaCliente()+"', '"
     +persona.getDireccionCliente()+"', '"+persona.getEmailCliente()+"','"+persona.getNombreCliente()+"','"+persona.getTelefonoCliente()+"')");

   estatuto.close();
   conex.desconectar();
   
  } catch (SQLException e) {
            System.out.println(e.getMessage());
   /*JOptionPane.showMessageDialog(null, "No se Registro la persona");*/
  }
 }
   
 
 
/**
 * permite consultar el Cliente asociado al documento enviado
 * como parametro 
 * @param documento 
 * @return
 */
public ArrayList<ClienteVO> consultarPersona(int documento) {
  ArrayList< ClienteVO> miCliente = new ArrayList< ClienteVO>();
  Conexion conex= new Conexion();
    
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes where cedula_cliente = ? ");
   consulta.setInt(1, documento);
   ResultSet res = consulta.executeQuery();
   
  if(res.next()){
    ClienteVO persona= new ClienteVO();
    persona.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
    persona.setDireccionCliente(res.getString("direccion_cliente"));
    persona.setEmailCliente(res.getString("email_cliente"));
    persona.setNombreCliente(res.getString("nombre_cliente"));
    persona.setTelefonoCliente(res.getString("telefono_cliente"));
 
    miCliente.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
   
  } catch (Exception e) {
   //JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miCliente;
 }


public void modificarPersona(ClienteVO persona) {
    Conexion conex = new Conexion();
    try {
        Statement estatuto = conex.getConnection().createStatement();
        estatuto.executeUpdate(
                "UPDATE clientes " + 
                " SET direccion_cliente ='"+persona.getDireccionCliente()+"', "+
                " email_cliente ='" + persona.getEmailCliente()+"' "+
                " nombre_cliente ='" + persona.getNombreCliente()+"' "+
                " telefono_cliente ='" + persona.getTelefonoCliente()+"' "+
                "WHERE cedula_cliente=" + persona.getCedulaCliente()
                );
        /*JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);*/
        estatuto.close();
        conex.desconectar();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        //JOptionPane.showMessageDialog(null, "No se Registro la persona");
    }
}

/**
 * permite consultar la lista de Clientes
 * @return
 */
public ArrayList< ClienteVO> listaDePersonas() {
  ArrayList< ClienteVO> miCliente = new ArrayList< ClienteVO>();
  Conexion conex= new Conexion();
    
  try {
   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
   ResultSet res = consulta.executeQuery();
   while(res.next()){
    ClienteVO persona= new ClienteVO();
    persona.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
    persona.setDireccionCliente(res.getString("direccion_cliente"));
    persona.setEmailCliente(res.getString("email_cliente"));
    persona.setNombreCliente(res.getString("nombre_cliente"));
    persona.setTelefonoCliente(res.getString("telefono_cliente"));
  
    miCliente.add(persona);
          }
          res.close();
          consulta.close();
          conex.desconectar();
   
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
  }
  return miCliente;
 }





}
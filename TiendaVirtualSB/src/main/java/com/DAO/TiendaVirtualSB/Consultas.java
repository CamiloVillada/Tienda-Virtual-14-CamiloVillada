package com.DAO.TiendaVirtualSB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas extends Conexion{
		
		public boolean autenticacion(String usuario, String contraseña) {
			PreparedStatement pst=null;
			ResultSet rs=null;
			
			try {
				String consulta = "select * from clientes where nombre_cliente = ? and telefono_cliente = ?";
				pst = getConnection().prepareStatement(consulta);
				pst.setString(1, usuario);
				pst.setString(2, contraseña);
				rs = pst.executeQuery();
				
				if(rs.absolute(1)) {
					return true;
				}
			} catch (Exception e) {
				System.err.println("Error" + e);
			} finally {
				try {
					if(getConnection() !=null) getConnection().close();
					if(pst != null) pst.close();
					if(rs != null) rs.close();
				} catch (Exception e) {
					System.err.println("Error" + e);
				}
			}
			return false;
			
		}
	
}

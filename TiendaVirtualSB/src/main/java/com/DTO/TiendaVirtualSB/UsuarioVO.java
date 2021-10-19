package com.DTO.TiendaVirtualSB;

import java.io.File;

public class UsuarioVO {
	
	 private Integer cedula_usuario;
	 private String nombre_usuario;
	 private String email_usuario;
	 private String usuario;
	 private String contraseña;
	 
	 
	public Integer getCedula_usuario() {
		return cedula_usuario;
	}
	
	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public String getEmail_usuario() {
		return email_usuario;
	}
	
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
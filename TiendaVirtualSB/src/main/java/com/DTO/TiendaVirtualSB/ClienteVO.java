package com.DTO.TiendaVirtualSB;

public class ClienteVO {
	
	 private Integer cedulaCliente;
	 private String nombreCliente;
	 private String telefonoCliente;
	 private String emailCliente;
	 private String direccionCliente;
	 
	 /**
	  * @return the idCliente
	  */
	 public Integer getCedulaCliente() {
	  return cedulaCliente;
	 }
	 
	 /**
	  * @param idCliente the idCliente to set
	  */
	 public void setCedulaCliente(Integer cedulaCliente) {
	  this.cedulaCliente = cedulaCliente;
	 }
	 
	 
	 /**
	  * @return the nombreCliente
	  */
	 public String getNombreCliente() {
	  return nombreCliente;
	 }
	 /**
	  * @param nombreCliente the nombreCliente to set
	  */
	 public void setNombreCliente(String nombreCliente) {
	  this.nombreCliente = nombreCliente;
	 }
	 
	 
	 /**
	  * @return the nombreCliente
	  */
	 public String getTelefonoCliente() {
	  return telefonoCliente;
	 }
	 /**
	  * @param nombreCliente the nombreCliente to set
	  */
	 public void setTelefonoCliente(String telefonoCliente) {
	  this.telefonoCliente = telefonoCliente;
	 }
	 
	 
	 
	 public String getEmailCliente() {	
	  return emailCliente;
	 }
	 /**
	 * @param nombreCliente the nombreCliente to set
	 */
	 public void setEmailCliente(String emailCliente) {
	  this.emailCliente = emailCliente;
	 }
	 
	 
	 public String getDireccionCliente() {	
	  return direccionCliente;
	 }
	 /**
	 * @param nombreCliente the nombreCliente to set
	 */
	 public void setDireccionCliente(String direccionCliente) {
	  this.direccionCliente = direccionCliente;
	 }
	 
	 

}

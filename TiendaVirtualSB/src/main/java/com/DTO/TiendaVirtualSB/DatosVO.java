package com.DTO.TiendaVirtualSB;

import java.io.File;

public class DatosVO {
	
	 private Integer cedula_usuario;
	 private String email_usuario;
	 private String nombre_usuario;
	 private String usuario;
	 private String contraseña;
	 
	 private Integer cedula_cliente;
	 private String direccion_cliente;
	 private String email_cliente;
	 private String nombre_cliente;
	 private String telefono_cliente;
	 
	 private Long nitproveedor;
	 private String ciudad_proveedor;
	 private String direccion_proveedor;
	 private String nombre_proveedor;
	 private String telefono_proveedor;
	 
	 private String Archivo;
	 private int codigo_producto;
	 private double ivacompra;
	 private String nombre_producto;
	 private double precio_compra;
	 private double precio_venta;
	 
	 private int codigo_venta;
	 private double total_venta;
	 private double valor_venta;
	 private int codigo_detalle_venta;
	 private int cantidad_producto;
	 private double valor_total_prod;
	 private double valor_venta_prod;
	 private double valoriva_prod;
	 private double iva_venta;
	 private double total_por_cliente;
	 private double total_todo;
	 
	 
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

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	
	public Integer getCedula_cliente() {
		return cedula_cliente;
	}

	
	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public Long getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getArchivo() {
		return Archivo;
	}

	public void setArchivo(String archivo) {
		this.Archivo = archivo;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public int getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(int codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public double getValor_total_prod() {
		return valor_total_prod;
	}

	public void setValor_total_prod(double valor_total_prod) {
		this.valor_total_prod = valor_total_prod;
	}

	public double getValor_venta_prod() {
		return valor_venta_prod;
	}

	public void setValor_venta_prod(double valor_venta_prod) {
		this.valor_venta_prod = valor_venta_prod;
	}

	public double getValoriva_prod() {
		return valoriva_prod;
	}

	public void setValoriva_prod(double valoriva_prod) {
		this.valoriva_prod = valoriva_prod;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_por_cliente() {
		return total_por_cliente;
	}

	public void setTotal_por_cliente(double total_por_cliente) {
		this.total_por_cliente = total_por_cliente;
	}

	public double getTotal_todo() {
		return total_todo;
	}

	public void setTotal_todo(double total_todo) {
		this.total_todo = total_todo;
	}
	
	
	
}

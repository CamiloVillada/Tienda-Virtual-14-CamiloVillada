package com.BO.TiendaVirtualSB;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DAO.TiendaVirtualSB.ListadosDAO;
import com.DAO.TiendaVirtualSB.ProductoDAO;
import com.DAO.TiendaVirtualSB.ProveedorDAO;
import com.DAO.TiendaVirtualSB.UsuariosDAO;
import com.DAO.TiendaVirtualSB.VentasDAO;
import com.DTO.TiendaVirtualSB.DatosVO;


@RestController
public class ClienteController {
	
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(DatosVO persona) 
	 {
		UsuariosDAO Dao=new UsuariosDAO(); 
	    Dao.registrarUsuario(persona);
	 }
	
	@RequestMapping("/consultarUsuario")   
	public DatosVO consultarUsuario(int cedula_usuario)
	{
		UsuariosDAO Dao=new UsuariosDAO(); 
	    return Dao.Consultarusuario(cedula_usuario);
	}
	
	@RequestMapping("/modificarUsuario")   
	public void modificarUsuario(DatosVO persona)
	{
		UsuariosDAO Dao=new UsuariosDAO();  
	    Dao.modificarUsuario(persona);
	}
	
	@RequestMapping("/eliminarUsuario")   
	public void eliminarUsuario(DatosVO persona)
	{
		UsuariosDAO Dao=new UsuariosDAO(); 
	    Dao.eliminarUsuario(persona);
	}
	@RequestMapping("/validar")
    public boolean validate(DatosVO persona) {
		UsuariosDAO Dao=new UsuariosDAO(); 
        boolean validar=false;
        try {
			validar=Dao.validate(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return validar;
        
    }
	
	
	
	@RequestMapping("/registrarCliente")
	public void registrarcliente(DatosVO persona) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.registrarCliente(persona);
	    
	 }
	
	@RequestMapping("/consultarCliente")   
	public DatosVO consultarcliente(int cedula_cliente)
	{
		ClienteDAO Dao=new ClienteDAO(); 
	    return Dao.ConsultarCliente(cedula_cliente);
	}
	
	@RequestMapping("/modificarCliente")   
	public void modificarcliente(DatosVO persona)
	{
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.modificarCliente(persona);
	}
	
	@RequestMapping("/eliminarCliente")   
	public void eliminarcliente(DatosVO persona)
	{
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.eliminarCliente(persona);
	}
	
	
	
	@RequestMapping("/registrarProveedor")
	public void registrarproveedor(DatosVO persona) 
	 {
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.registrarProveedor(persona);
	    
	 }
	
	@RequestMapping("/consultarProveedor")   
	public DatosVO consultarproveedor(long nitproveedor)
	{
		ProveedorDAO Dao=new ProveedorDAO(); 
	    return Dao.ConsultarProveedor(nitproveedor);
	}
	
	@RequestMapping("/modificarProveedor")   
	public void modificarproveedor(DatosVO persona)
	{
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.modificarProveedor(persona);
	}
	
	@RequestMapping("/eliminarProveedor")   
	public void eliminarproveedor(DatosVO persona)
	{
		ProveedorDAO Dao=new ProveedorDAO(); 
	    Dao.eliminarProveedor(persona);
	}
	
	/*@RequestMapping("/listarproductos")   
	public void EnlistarProductos(DatosVO persona)
	{
		ProductoDAO Dao=new ProductoDAO();
		Dao.ListarProductos(persona);
	}*/
	
	@RequestMapping("/Consultarclienteventa") 
	public DatosVO ConsultarClienteVenta(int cedula_cliente)
	{
		VentasDAO Dao=new VentasDAO(); 
	    return Dao.ConsultarClienteVenta(cedula_cliente);
	}
	
	@RequestMapping("/consultarProducto")   
	public DatosVO consultarproducto(int codigo_producto)
	{
		VentasDAO Dao=new VentasDAO(); 
		return Dao.ConsultarProducto(codigo_producto);
	}
	
	@RequestMapping("/ConfirmarVenta")   
	public void confirmarventa(DatosVO persona)
	{
		VentasDAO Dao=new VentasDAO(); 
	    Dao.Confirmarventa(persona);
	}
	
	@RequestMapping("/Creardetalle") 
	public void Creardetalle(DatosVO persona) {
		VentasDAO Dao=new VentasDAO(); 
	    Dao.Creardetalle(persona);
	}
	
	@RequestMapping("/eliminartodoproducto")   
	public void eliminartodoproducto(DatosVO persona)
	{
		ProductoDAO Dao=new ProductoDAO();
	    Dao.Eliminartodoproducto(persona);
	}
	@RequestMapping("/ListarUsuarios")
	public ArrayList< DatosVO> listaDePersonas() {
		ListadosDAO Dao=new ListadosDAO(); 
		return Dao.listarUsuarios();	   
	}
	
	@RequestMapping("/ListarClientes")
	public ArrayList< DatosVO> listaDeClientes() {
		ListadosDAO Dao=new ListadosDAO();
		return Dao.listarClientes();	   
	}
	
	@RequestMapping("/ListarVentas")
	public ArrayList< DatosVO> listaDeVentas() {
		ListadosDAO Dao=new ListadosDAO();
		return Dao.listarVentas();	   
	}

}
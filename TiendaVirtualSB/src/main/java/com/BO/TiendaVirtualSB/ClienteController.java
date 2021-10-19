package com.BO.TiendaVirtualSB;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaVirtualSB.ClienteDAO;
import com.DAO.TiendaVirtualSB.UsuariosDAO;
import com.DTO.TiendaVirtualSB.ClienteVO;
import com.DTO.TiendaVirtualSB.UsuarioVO;



@RestController
public class ClienteController {
	
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona) 
	 {
		UsuariosDAO Dao=new UsuariosDAO(); 
	    Dao.registrarUsuario(persona);
	 }
	
	@RequestMapping("/consultarUsuario")   
	public UsuarioVO consultarUsuario(int cedula_usuario)
	{
		UsuariosDAO Dao=new UsuariosDAO(); 
	    return Dao.Consultarusuario(cedula_usuario);
	}
	
	@RequestMapping("/modificarUsuario")   
	public void modificarUsuario(UsuarioVO persona)
	{
		UsuariosDAO Dao=new UsuariosDAO();  
	    Dao.modificarUsuario(persona);
	}
	
	@RequestMapping("/eliminarUsuario")   
	public void eliminarUsuario(UsuarioVO persona)
	{
		UsuariosDAO Dao=new UsuariosDAO(); 
	    Dao.eliminarUsuario(persona);
	}
	@RequestMapping("/validar")
    public boolean validate(UsuarioVO persona) {
		UsuariosDAO Dao=new UsuariosDAO(); 
        boolean validar=false;
        try {
			validar=Dao.validate(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return validar;
        
    }
	
	@RequestMapping("/registrarPersona")
	public void registrarPersona(ClienteVO persona) 
	 {
		ClienteDAO Dao=new ClienteDAO(); 
	    Dao.registrarPersona(persona);
	    
	 }
	   
	 
	 
	/**
	 * permite consultar el Cliente asociado al documento enviado
	 * como parametro 
	 * @param documento 
	 * @return
	 */
	
	@RequestMapping("/consultarPersona")
	public ArrayList<ClienteVO> consultarPersona(int documento) {
		ClienteDAO Dao=new ClienteDAO(); 
	return 	Dao.consultarPersona(documento);
		
	}



	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarPersonas")
	public ArrayList< ClienteVO> listaDePersonas() {
		ClienteDAO Dao=new ClienteDAO(); 
			
		return Dao.listaDePersonas();
		
	}

}
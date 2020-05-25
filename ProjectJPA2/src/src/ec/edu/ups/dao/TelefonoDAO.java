package src.ec.edu.ups.dao;

import java.util.List;

import src.ec.edu.ups.entidades.Contacto;
import src.ec.edu.ups.entidades.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer >  {

	
	List<Contacto> buscarCorreo(String correo);
	List<Telefono> buscarCedula(String cedula);
	List<Contacto> obtenerContacto();
	List<Contacto> buscarCedInv(String cedula);

}

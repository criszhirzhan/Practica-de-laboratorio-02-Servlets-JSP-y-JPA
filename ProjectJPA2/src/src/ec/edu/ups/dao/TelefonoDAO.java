package src.ec.edu.ups.dao;

import java.util.List;

import src.ec.edu.ups.entidades.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer >  {


	List<Telefono> buscarCedula(String cedula);
	public List<Telefono> buscarCedInv(String cedula);


}

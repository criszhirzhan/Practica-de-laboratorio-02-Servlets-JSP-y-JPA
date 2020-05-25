package src.ec.edu.ups.jpa;


import java.util.List;

import javax.persistence.Persistence;


import src.ec.edu.ups.dao.TelefonoDAO;
import src.ec.edu.ups.entidades.Contacto;
import src.ec.edu.ups.entidades.Telefono;



public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {
	
	

	public JPATelefonoDAO() {
		super(Telefono.class);
		this.em = Persistence.createEntityManagerFactory("ProjectJPA2").createEntityManager();
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Contacto> obtenerContacto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contacto> buscarCedInv(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

}

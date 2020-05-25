package src.ec.edu.ups.jpa;


import java.util.List;

import javax.persistence.Persistence;


import src.ec.edu.ups.dao.TelefonoDAO;
import src.ec.edu.ups.entidades.Telefono;



public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {
	
	

	public JPATelefonoDAO() {
		super(Telefono.class);
		this.em = Persistence.createEntityManagerFactory("ProjectJPA2").createEntityManager();
		// TODO Auto-generated constructor stub
	}




}

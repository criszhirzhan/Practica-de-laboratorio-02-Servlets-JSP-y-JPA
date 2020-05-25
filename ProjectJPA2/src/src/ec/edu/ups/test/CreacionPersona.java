package src.ec.edu.ups.test;

import src.ec.edu.ups.dao.DAOFactory;
import src.ec.edu.ups.dao.UsuarioDAO;
import src.ec.edu.ups.entidades.Usuario;

public class CreacionPersona {

	public CreacionPersona() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		//Usuario usuario = null;
		
		//usuario=user.buscar("cris@gmail.com", "123");
		
		System.out.println(user.buscar("cris@gmail.com", "123").getApellido());

	}

}

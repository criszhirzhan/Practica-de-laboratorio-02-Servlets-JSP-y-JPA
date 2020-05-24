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
		Usuario usuario = new Usuario("0151027299", "Cris", "Cabrera", "cris@gmail.com", "123");
		Usuario usuario2 = new Usuario("0161027299", "Juan","Perez","cjuan@gmail.com", "123");

		user.create(usuario);
		user.create(usuario2);
		user.create(usuario);
		System.out.println("Usuario Creado");

	}

}

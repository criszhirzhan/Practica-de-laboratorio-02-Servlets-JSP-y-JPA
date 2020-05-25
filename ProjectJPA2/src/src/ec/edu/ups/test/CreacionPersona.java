package src.ec.edu.ups.test;

import java.util.ArrayList;
import java.util.List;

import src.ec.edu.ups.dao.DAOFactory;
import src.ec.edu.ups.dao.TelefonoDAO;
import src.ec.edu.ups.dao.UsuarioDAO;
import src.ec.edu.ups.entidades.Telefono;
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
		TelefonoDAO telf = DAOFactory.getFactory().getTelefonoDAO();
		List<Telefono> listT = new ArrayList<Telefono>();
		
		Telefono telefono= new Telefono();
		listT=telf.buscarCorreo("cris@gmail.com");
		
		for (Telefono telfonoo : listT) {
			 
			 System.out.println(telfonoo.getUsuario().getNombre());
		}
		//System.out.println("Imprimiendo apellido: "+listT.get(0).getUsuario().getApellido());
	}
}

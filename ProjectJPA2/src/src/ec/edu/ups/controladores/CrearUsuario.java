package src.ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.ec.edu.ups.dao.DAOFactory;
import src.ec.edu.ups.dao.UsuarioDAO;
import src.ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class crearUsuario
 */
@WebServlet("/crearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula="";
		String apellidos="";
		String nombres = "";
		String correo="";
		String passwd ="";
		
		Usuario user = new Usuario();
		
		String accion = request.getParameter("registrarUsr");
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		if (accion.equals("RegistrarUsr")) {
			
			cedula = request.getParameter("cedula");
			apellidos = request.getParameter("apellidos");
			nombres = request.getParameter("nombres");
			correo = request.getParameter("email");
			passwd = request.getParameter("psw");
			
			user = new Usuario(cedula, nombres, apellidos, correo, passwd);
			
			usuarioDao.create(user);
			
		}
		
		getServletContext().getRequestDispatcher("/Public/login.jsp").forward(request, response);	
	}

}

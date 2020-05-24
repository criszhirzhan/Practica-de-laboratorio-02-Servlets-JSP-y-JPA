package src.ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.ec.edu.ups.dao.DAOFactory;
import src.ec.edu.ups.dao.TelefonoDAO;
import src.ec.edu.ups.dao.UsuarioDAO;
import src.ec.edu.ups.entidades.Usuario;
import src.ec.edu.ups.entidades.Telefono;

/**
 * Servlet implementation class EditarContacto
 */

@WebServlet(name = "EditarContacto", urlPatterns = { "/EditarContacto" })
public class EditarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Telefono telf =null;
	String idCed = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarContacto() {
		super();
		telf = new Telefono();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		

		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		Usuario usuario = new Usuario();
		
		String id =request.getParameter("idUser");
		
		telf = telefonoDao.read(Integer.parseInt(request.getParameter("id")));
		idCed = telf.getUsuario().getId();
		System.out.print(telf.getUsuario().getId()+" "+telf.getOperadora()+" "+telf.getNumero());
		
		usuario=usuarioDao.read(id);
		
		
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("telefono", telf);
		getServletContext().getRequestDispatcher("/Privada/modificar.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String user="";
		String numero="";
		String tipo = "";
		String operadora="";
		

		String accion = request.getParameter("modificartelf");
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		Usuario usuario = new Usuario();

		if (accion.equals("modificarTelf")) {
			numero = request.getParameter("numerotxt");
			tipo = request.getParameter("tip");
			operadora = request.getParameter("operadoratxt");
			
			usuario=usuarioDao.read(idCed);
			
			telf.setUsuario(usuario);
			telf.setNumero(numero);
			telf.setOperadora(operadora);
			telf.setTipo(tipo);
			
			telefonoDao.update(telf);


		}
		
		try {
			request.setAttribute("telefono", telefonoDao.buscarCedula(idCed));
			request.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/Privada/indexU.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

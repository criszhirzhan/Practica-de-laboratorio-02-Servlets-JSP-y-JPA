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

/**
 * Servlet implementation class IndesController
 */

@WebServlet(name = "IndexController", urlPatterns = { "/IndexController" })
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
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

		
		
		System.out.print("Id sesion IndexController: "+sesion.getAttribute("accesos"));
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();


			if (Integer.parseInt(request.getParameter("id")) == 1) {
				usuario=usuarioDao.read(request.getParameter("c"));
	             System.out.println("Cedula usar: "+request.getParameter("c"));
	             System.out.println("Apellido user: "+usuario.getApellido());
				request.setAttribute("idc", request.getParameter("c"));
				request.setAttribute("usuario", usuario);
				getServletContext().getRequestDispatcher("/Privada/registrar.jsp").forward(request, response);

			} else if (Integer.parseInt(request.getParameter("id")) == 2) {

				// System.out.println(telefonoDao.find().telf_id +','+ str.id_user
				// +','+str.numero+','+str.tipo+','+str.operadora);
				usuario=usuarioDao.read(request.getParameter("idU"));
				
				request.setAttribute("telefono", telefonoDao.buscarCedula(usuario.getId()));
				request.setAttribute("usuario", usuario);
				getServletContext().getRequestDispatcher("/Privada/indexU.jsp").forward(request, response);

			}

		

		if (Integer.parseInt(request.getParameter("id")) == 3) {
			System.out.print("Esta ingresando....");

			request.setAttribute("telefono", telefonoDao.obtenerContacto());
			getServletContext().getRequestDispatcher("/Privada/indexI.jsp").forward(request, response);

		}
		
		if (Integer.parseInt(request.getParameter("id")) == 4) {
			System.out.print("Esta ingresando....");
			usuario=usuarioDao.read(request.getParameter("idU"));
			request.setAttribute("usuario", usuario);
			request.setAttribute("telefono", telefonoDao.obtenerContacto());
			getServletContext().getRequestDispatcher("/Privada/listTelf.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

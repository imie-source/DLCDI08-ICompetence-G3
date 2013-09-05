package fr.imie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/ListUserView")
public class ListUserView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (request.getParameter("numligne") == null && request.getParameter("create") == null) {

			IUtilisateurService utilisateurService = DAOFactory1.getInstance()
					.createUtilisateurService(null);
			List<UtilisateurDTO> listeUtilisateur = new ArrayList<UtilisateurDTO>();

			try {
				listeUtilisateur = utilisateurService.readAllUtilisateur();
				session.setAttribute("listeUtilisateur", listeUtilisateur);
				
				request.getRequestDispatcher("ListUser.jsp")//remplace ancien redirect
				.forward(request, response);

			} catch (TransactionalConnectionException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		} 


		response.setContentType("text/html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

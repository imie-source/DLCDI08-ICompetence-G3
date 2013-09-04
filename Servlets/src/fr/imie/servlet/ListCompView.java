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

import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/ListCompView")
public class ListCompView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCompView() {
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

		if (request.getParameter("ligne") == null) {

			ICompetenceNiveauService compNivService = DAOFactory1.getInstance()
					.createCompetenceNiveauService(null);
			List<CompetenceDTO> listeCompetence = new ArrayList<CompetenceDTO>();

			try {
				listeCompetence = compNivService.readAllCompetence();
				session.setAttribute("listeCompetence", compNivService);
				response.sendRedirect("ListUser.jsp");
				

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

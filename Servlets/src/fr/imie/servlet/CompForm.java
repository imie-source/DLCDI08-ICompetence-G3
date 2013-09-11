package fr.imie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/CompForm")
public class CompForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompForm() {
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

		if (request.getParameter("numLigneComp") != null) {

			int ligne = Integer.valueOf(request.getParameter("numligneComp"));
			Object listObj = session.getAttribute("listeCompetence");
			@SuppressWarnings("unchecked")
			List<CompetenceDTO> listComp = (List<CompetenceDTO>) listObj;
			CompetenceDTO competence = listComp.get(ligne);

			session.removeAttribute("listeCompetence");

			try {
				CompetenceDTO competenceDTO = DAOFactory1.getInstance()
						.createCompetenceNiveauService(null)
						.readCompetence(competence);
				request.setAttribute("competence", competenceDTO);
				List<NiveauDTO> listNivUtil =
				DAOFactory1.getInstance().createCompetenceNiveauService(null).readNiveauUtilisateurCompetence(competence);
				request.setAttribute("ListeNivUtil", listNivUtil);

			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("./CompRead.jsp").forward(request,
					response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

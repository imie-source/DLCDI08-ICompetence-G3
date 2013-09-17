package fr.imie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.PromotionDTO;
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

			int ligne = Integer.valueOf(request.getParameter("numLigneComp"));
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
				List<NiveauDTO> listUtilNiv = DAOFactory1.getInstance()
						.createCompetenceNiveauService(null)
				session.setAttribute("ListeNivUtil", listNivUtil);

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

		// Modifier une competence
		if (request.getParameter("updateAction") != null
				&& request.getParameter("updateAction").equals("Confirmer")) {

			CompetenceDTO competenceUpdate = getCompetence(request
					.getParameter("numCompetence"));

			competenceUpdate.setNom(request.getParameter("nom"));
			
			competenceUpdate.setCompetenceDomaine(getCompetence(request.getParameter("competenceDomaine")));

			try {
				DAOFactory1.getInstance().createCompetenceNiveauService(null)
						.updateCompetence(competenceUpdate);
				request.setAttribute("action", "updateAction");
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("competence",
					getCompetence(request.getParameter("numCompetence")));
			request.getRequestDispatcher("./CompRead.jsp").forward(request,
					response);
		}

		// Ajouter une compétence
		else if (request.getParameter("createAction") != null
				&& request.getParameter("createAction").equals("ajouter")) {

			CompetenceDTO competenceCreate = new CompetenceDTO();

			competenceCreate.setNom(request.getParameter("nom"));
			competenceCreate.setCompetenceDomaine(getCompetence(request.getParameter("competenceDomaine")));

			try {
				DAOFactory1.getInstance().createCompetenceNiveauService(null)
						.createCompetence(competenceCreate);
				request.setAttribute("action", "createAction");
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("competence", competenceCreate);
			request.getRequestDispatcher("./CompRead.jsp").forward(request,
					response);
		}
		// Supprimer une compétence
		else if (request.getParameter("deleteAction") != null
				&& request.getParameter("deleteAction").equals("supprimer")) {

			CompetenceDTO competenceDelete = getCompetence(request
					.getParameter("numCompetence"));

			try {
				DAOFactory1.getInstance().createCompetenceNiveauService(null)
						.deleteCompetence(competenceDelete);
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./ListCompView");
		}
	}

	private CompetenceDTO getCompetence(String requestNumCompetence) {

		CompetenceDTO competenceDTO = new CompetenceDTO();
		int numCompetence = Integer.valueOf(requestNumCompetence);

		CompetenceDTO competenceTemp = new CompetenceDTO();
		competenceTemp.setNum(numCompetence);

		try {
			competenceDTO = DAOFactory1.getInstance()
					.createCompetenceNiveauService(null)
					.readCompetence(competenceTemp);
		} catch (TransactionalConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return competenceDTO;

	}

}

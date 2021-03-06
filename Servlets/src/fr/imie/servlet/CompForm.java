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
		
		//affichage d'une compétence
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
				List<NiveauDTO> listNivUtil = DAOFactory1.getInstance()
						.createCompetenceNiveauService(null).readNiveauUtilisateurCompetence(competenceDTO);
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
		//modification d'une compétence
		else if (request.getParameter("update") != null
				&& request.getParameter("update").equals("modifier")) {
			request.setAttribute("competence", getCompetence(request.getParameter("numComp")));
			
			List<CompetenceDTO> listComp = null;
			
			try {
				listComp = DAOFactory1.getInstance().createCompetenceNiveauService(null).readAllCompetence();
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("ListComp", listComp);
			request.getRequestDispatcher("./CompUpdate.jsp").forward(request, response);
			
		}
		//création d'une compétence
		else if (request.getParameter("create") != null
				&& request.getParameter("create").equals("creer")){
			List<CompetenceDTO> listComp = null;
			
			try {
				listComp = DAOFactory1.getInstance().createCompetenceNiveauService(null).readAllCompetence();
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("ListComp", listComp);
			request.getRequestDispatcher("./CompCreate.jsp").forward(request,
					response);
			
		}
		//suppression d'un compétence
		else if (request.getParameter("delete") != null
				& request.getParameter("delete").equals("supprimer")) {
			request.setAttribute("competence",
					getCompetence(request.getParameter("numComp")));
			request.getRequestDispatcher("./CompDelete.jsp").forward(request,
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
					.getParameter("numComp"));

			competenceUpdate.setNom(request.getParameter("nom"));
			
			if (request.getParameter("competenceDomaine") != ""){
			competenceUpdate.setCompetenceDomaine(getCompetence(request.getParameter("competenceDomaine")));
			} else {
				competenceUpdate.setCompetenceDomaine(null);
			}
			
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
					getCompetence(request.getParameter("numComp")));
			request.getRequestDispatcher("./CompRead.jsp").forward(request,
					response);
		}

		// Ajouter une compétence
		else if (request.getParameter("createAction") != null
				&& request.getParameter("createAction").equals("ajouter")) {

			CompetenceDTO competenceCreate = new CompetenceDTO();

			competenceCreate.setNom(request.getParameter("nom"));
			if (request.getParameter("competenceDomaine") != ""){
			competenceCreate.setCompetenceDomaine(getCompetence(request.getParameter("competenceDomaine")));
			} else {
				competenceCreate.setCompetenceDomaine(null);
			}
			

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
			//request.getRequestDispatcher("./CompRead.jsp").forward(request,
				//	response);
			response.sendRedirect("./ListCompView");
		}
		// Supprimer une compétence
		else if (request.getParameter("deleteAction") != null
				&& request.getParameter("deleteAction").equals("supprimer")) {

			CompetenceDTO competenceDelete = getCompetence(request
					.getParameter("numComp"));

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

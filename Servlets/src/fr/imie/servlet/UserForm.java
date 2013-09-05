package fr.imie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserForm() {
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

		// Afficher un utilisateur
		if ((request.getParameter("read") != null && request.getParameter(
				"read").equals("afficher"))
				|| (request.getParameter("delete") != null && request
						.getParameter("delete").equals("supprimer"))) {
			if (request.getParameter("ligne") != null) {

				int ligne = Integer.valueOf(request.getParameter("ligne"));
				Object listObj = session.getAttribute("listeUtilisateur");
				@SuppressWarnings("unchecked")
				List<UtilisateurDTO> listUtil = (List<UtilisateurDTO>) listObj;
				UtilisateurDTO utilisateur = listUtil.get(ligne);

				session.removeAttribute("listeUtilisateur");

				try {
					UtilisateurDTO utilisateurDTO = DAOFactory1.getInstance()
							.createUtilisateurService(null)
							.readUtilisateur(utilisateur);
					request.setAttribute("utilisateur", utilisateurDTO);
					List<NiveauDTO> listCompNiv = DAOFactory1.getInstance().createCompetenceNiveauService(null).readCompetenceNiveauUtilisateur(utilisateurDTO);
					request.setAttribute("ListeCompNiv", listCompNiv);
					
					// Dans le cas de la suppression
					if ((request.getParameter("delete") != null) 
							&& (request.getParameter("delete").equals("supprimer"))) {
						request.setAttribute("action", "delete");
					} else {
						request.setAttribute("action", "read");
					}

				} catch (TransactionalConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// Passage vers l'écran de modification
		if (request.getParameter("update") != null
				&& request.getParameter("update").equals("modifier")) {

			request.setAttribute("action", "update");
			request.setAttribute("utilisateur",
					getUser(request.getParameter("numUtilisateur")));

		}

		// Passage vers l'écran de modification pour créer un utilisateur
		if (request.getParameter("create") != null
				&& request.getParameter("create").equals("creer")) {

			request.setAttribute("action", "add");
		}
			
		//supprimer un utilisateur
				if (request.getParameter("deleteAction") != null
						&& request.getParameter("deleteAction").equals("supprimer")) {

					UtilisateurDTO utilisateurDelete = getUser(request
							.getParameter("numUtilisateur"));

					try {
						DAOFactory1.getInstance().createUtilisateurService(null)
								.deleteUtilisateur(utilisateurDelete);
						// request.setAttribute("utilisateur", utilisateurUpdate);
						request.setAttribute("action", "deleteAction");
					} catch (TransactionalConnectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DAOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		request.getRequestDispatcher("/UserForm.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Modifier un utilisateur
		if (request.getParameter("updateAction") != null
				&& request.getParameter("updateAction").equals("modifier")) {

			UtilisateurDTO utilisateurUpdate = getUser(request
					.getParameter("numUtilisateur"));

			utilisateurUpdate.setNom(request.getParameter("nom"));
			utilisateurUpdate.setPrenom(request.getParameter("prenom"));

			try {
				DAOFactory1.getInstance().createUtilisateurService(null)
						.updateUtilisateur(utilisateurUpdate);
				// request.setAttribute("utilisateur", utilisateurUpdate);
				request.setAttribute("action", "updateAction");
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Ajouter un utilisateur
		if (request.getParameter("createAction") != null
				&& request.getParameter("createAction").equals("ajouter")) {

			UtilisateurDTO utilisateurCreate = new UtilisateurDTO();

			utilisateurCreate.setNom(request.getParameter("nom"));
			utilisateurCreate.setPrenom(request.getParameter("prenom"));
			PromotionDTO promo = new PromotionDTO();
			promo.setNum(1);
			utilisateurCreate.setPromotion(promo);

			try {
				DAOFactory1.getInstance().createUtilisateurService(null)
						.createUtilisateur(utilisateurCreate);
				request.setAttribute("action", "createAction");
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		request.getRequestDispatcher("/UserForm.jsp")
				.forward(request, response);
	}

	private UtilisateurDTO getUser(String requestNumUtilisateur) {

		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		int numUtilisateur = Integer.valueOf(requestNumUtilisateur);

		UtilisateurDTO utilisateurTemp = new UtilisateurDTO();
		utilisateurTemp.setNum(numUtilisateur);

		try {
			utilisateurDTO = DAOFactory1.getInstance()
					.createUtilisateurService(null)
					.readUtilisateur(utilisateurTemp);
		} catch (TransactionalConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateurDTO;
	}
}

package fr.imie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//Affichage utilisateur
		if (request.getParameter("numligne") != null
				&& request.getParameter("update") == null
				&& request.getParameter("delete") == null) {

			int ligne = Integer.valueOf(request.getParameter("numligne"));
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
				List<NiveauDTO> listCompNiv = DAOFactory1.getInstance()
						.createCompetenceNiveauService(null)
						.readCompetenceNiveauUtilisateur(utilisateurDTO);
				request.setAttribute("ListeCompNiv", listCompNiv);
				 List<ProjetDTO> listUtilProjet = DAOFactory1.getInstance().createProjetService(null).readProjetByUtilisateur(utilisateurDTO);
				request.setAttribute("ListeUtilProjet", listUtilProjet);
				List<PromotionDTO> listPromo = DAOFactory1.getInstance().createPromotionService(null).readAllPromotion();
				request.setAttribute("ListProjet", listPromo);
				

			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("./UserRead.jsp").forward(request,
					response);
		}

		//création utilisateur
		else if (request.getParameter("numligne") == null
				&& request.getParameter("create") != null
				&& request.getParameter("create").equals("creer")) {

			request.getRequestDispatcher("./UserCreate.jsp").forward(request,
					response);
		} //modification utilisateur
		else if (request.getParameter("update") != null
				&& request.getParameter("update").equals("modifier")) {
			request.setAttribute("utilisateur",
					getUser(request.getParameter("numUtilisateur")));
			request.getRequestDispatcher("./UserUpdate.jsp").forward(request,
					response);
		} // suppression utilisateur
		else if (request.getParameter("delete") != null
				& request.getParameter("delete").equals("supprimer")) {
			request.setAttribute("utilisateur",
					getUser(request.getParameter("numUtilisateur")));
			request.getRequestDispatcher("./UserDelete.jsp").forward(request,
					response);

		}

		/*
		 * //supprimer un utilisateur if (request.getParameter("deleteAction")
		 * != null && request.getParameter("deleteAction").equals("supprimer"))
		 * {
		 * 
		 * UtilisateurDTO utilisateurDelete = getUser(request
		 * .getParameter("numUtilisateur"));
		 * 
		 * try { DAOFactory1.getInstance().createUtilisateurService(null)
		 * .deleteUtilisateur(utilisateurDelete); //
		 * request.setAttribute("utilisateur", utilisateurUpdate);
		 * request.setAttribute("action", "deleteAction"); } catch
		 * (TransactionalConnectionException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (DAOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */

<<<<<<< HEAD
=======
			//request.setAttribute("action", "add");
			request.getRequestDispatcher("./UserCreate.jsp").forward(request, response);
		}
			
		/*//supprimer un utilisateur
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
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/

		
>>>>>>> dec4091be33e55b28f1fa6bbb6e7e6386a832498
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Modifier un utilisateur
		if (request.getParameter("updateAction") != null
				&& request.getParameter("updateAction").equals("updateAction")) {

			UtilisateurDTO utilisateurUpdate = getUser(request
					.getParameter("numUtilisateur"));

			utilisateurUpdate.setNom(request.getParameter("nom"));
			utilisateurUpdate.setPrenom(request.getParameter("prenom"));
			
			String userDateNaisParam = request.getParameter("dateNaissance");
			Date userDateNais = new Date();
			try {
				userDateNais = new SimpleDateFormat("dd/MM/yyyy").parse(userDateNaisParam);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			utilisateurUpdate.setDateNaissance(userDateNais);
			
			utilisateurUpdate.setAdresse(request.getParameter("adresse"));
			
			String telParam = request.getParameter("tel");
			Integer userTel = Integer.valueOf(telParam);
			utilisateurUpdate.setTel(userTel);
			
			utilisateurUpdate.setMail(request.getParameter("mail"));
			
			
			//utilisateurUpdate.setPromotion(promotion);

			try {
				DAOFactory1.getInstance().createUtilisateurService(null)
						.updateUtilisateur(utilisateurUpdate);
				// request.setAttribute("utilisateur", utilisateurUpdate);
				request.setAttribute("action", "updateAction");
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
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
			} catch (ServiceException e) {
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
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateurDTO;
	}
}

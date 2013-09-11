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
			List<PromotionDTO> listPromo =null;
			try {
				listPromo = DAOFactory1.getInstance().createPromotionService(null).readAllPromotion();
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ListePromo", listPromo);
			request.getRequestDispatcher("./UserCreate.jsp").forward(request,
					response);
		} //modification utilisateur
		else if (request.getParameter("update") != null
				&& request.getParameter("update").equals("modifier")) {
			request.setAttribute("utilisateur", getUser(request.getParameter("numUtilisateur")));
			
			List<PromotionDTO> listPromo =null;
			try {
				listPromo = DAOFactory1.getInstance().createPromotionService(null).readAllPromotion();
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ListePromo", listPromo);
			
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



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Modifier un utilisateur
		if (request.getParameter("updateAction") != null
				&& request.getParameter("updateAction").equals("Confirmer")) {

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
			
			String promoParam = request.getParameter("promotion");
			PromotionDTO promo = new PromotionDTO();
			Integer promoNum = null;
			if (promoParam != null){
				promoNum = Integer.valueOf(promoParam);
			}
			if (promoNum != null){
				PromotionDTO promoUpdate = new PromotionDTO();
				promoUpdate.setNum(promoNum);
				try {
					promo = DAOFactory1.getInstance().createPromotionService(null).readPromotion(promoUpdate);
				} catch (TransactionalConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			utilisateurUpdate.setPromotion(promo);
			
			utilisateurUpdate.setLogin(request.getParameter("login"));
			utilisateurUpdate.setPassword(request.getParameter("password"));

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
			
			String userDateNaisParam = request.getParameter("dateNaissance");
			Date userDateNais = new Date();
			try {
				userDateNais = new SimpleDateFormat("dd/MM/yyyy").parse(userDateNaisParam);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			utilisateurCreate.setDateNaissance(userDateNais);
			
			utilisateurCreate.setAdresse(request.getParameter("adresse"));
			
			String telParam = request.getParameter("tel");
			Integer userTel = Integer.valueOf(telParam);
			utilisateurCreate.setTel(userTel);
			
			utilisateurCreate.setMail(request.getParameter("mail"));
			
			String promoParam = request.getParameter("promotion");
			PromotionDTO promo = new PromotionDTO();
			Integer promoNum = null;
			if (promoParam != null){
				promoNum = Integer.valueOf(promoParam);
			}
			if (promoNum != null){
				PromotionDTO promoUpdate = new PromotionDTO();
				promoUpdate.setNum(promoNum);
				try {
					promo = DAOFactory1.getInstance().createPromotionService(null).readPromotion(promoUpdate);
				} catch (TransactionalConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			utilisateurCreate.setPromotion(promo);
			
			utilisateurCreate.setLogin(request.getParameter("login"));
			utilisateurCreate.setPassword(request.getParameter("password"));
			

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
		request.setAttribute("utilisateur", getUser(request.getParameter("numUtilisateur")));
		request.getRequestDispatcher("./UserRead.jsp").forward(request,
				response);
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

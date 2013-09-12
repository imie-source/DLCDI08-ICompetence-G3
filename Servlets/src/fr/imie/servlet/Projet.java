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
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

/**
 * Servlet implementation class Projet
 */
@WebServlet("/Projet")
public class Projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Projet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Afficher un projet marche bien
		if (request.getParameter("numligne") != null
				&& request.getParameter("update") == null
				&& request.getParameter("delete") == null) {
		
					int ligne = Integer.valueOf(request.getParameter("numligne"));
					Object listObj = session.getAttribute("listeProjet");
					@SuppressWarnings("unchecked")
					List<ProjetDTO> listeProjet = (List<ProjetDTO>) listObj;
					ProjetDTO projet = listeProjet.get(ligne);
	
					session.removeAttribute("listeProjet");
					
				try {
					ProjetDTO projetDTO = DAOFactory1.getInstance().createProjetService(null).readProjet(projet);
					request.setAttribute("projetDTO", projetDTO);
					List<UtilisateurDTO> listeUtil = DAOFactory1.getInstance().createUtilisateurService(null).readUtilisateurProjet(projetDTO);
					request.setAttribute("listeUtil", listeUtil);
					
					

					// Dans le cas de la suppression
					/*if ((request.getParameter("delete") != null) 
							&& (request.getParameter("delete").equals("supprimer"))) {
						request.setAttribute("action", "delete");
					} else {
						request.setAttribute("action", "read");
					}
					*/

				} catch (TransactionalConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
		
		request.getRequestDispatcher("/ProjetConsult.jsp")
		.forward(request, response);
		}
		
		//La suppression, la modification et la création ne sont pas faites
		//création projet
		else if (request.getParameter("numligne") == null
				&& request.getParameter("create") != null
				&& request.getParameter("create").equals("creer")) {

			request.getRequestDispatcher("./ProjetCreate.jsp").forward(request,
					response);
		}
		
		
		//modification projet
		else if (request.getParameter("update") != null
				&& request.getParameter("update").equals("modifier")) {
			request.setAttribute("projetDTO",getProjet(request.getParameter("numProjet")));
			
			List<UtilisateurDTO> listeForChef =null;
			List<StatutProjetDTO>listeStatut = null;
			List<UtilisateurDTO> listeUtil = null;
			try {
				listeForChef= DAOFactory1.getInstance().createUtilisateurService(null).readAllUtilisateur();
				listeStatut=DAOFactory1.getInstance().createProjetService(null).readAllStatutProjet();
				listeUtil = DAOFactory1.getInstance().createUtilisateurService(null).readUtilisateurProjet(getProjet(request.getParameter("numProjet")));
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listeForChef", listeForChef);
			request.setAttribute("listeStatut", listeStatut);
			request.setAttribute("listeUtil", listeUtil);
			
			request.getRequestDispatcher("./ProjetUpdate.jsp").forward(request,response);
		
		} 
		
		
		// suppression projet
		else if (request.getParameter("delete") != null
				& request.getParameter("delete").equals("supprimer")) {
			request.setAttribute("projet",getProjet(request.getParameter("numligne")));
			request.getRequestDispatcher("./ProjetDelete.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Modifier un projet
			/*	if (request.getParameter("updateAction") != null
						&& request.getParameter("updateAction").equals("Confirmer")) {
					
					ProjetDTO projetUpdate = getProjet(request.getParameter("numProjet"));
					projetUpdate.setIntitule(request.getParameter("intituleProjet"));
					projetUpdate.setDescription(request.getParameter("descriptionProjet"));
					
					String chefParam = request.getParameter("chefProjet");
					UtilisateurDTO chef = new UtilisateurDTO();
					
					
					
				}
		*/
		
		
	}
	
	
	
	
	private ProjetDTO getProjet(String requestNumProjet) {

		ProjetDTO projetDTO = new ProjetDTO();
		int numProjet = Integer.valueOf(requestNumProjet);
		
		ProjetDTO projetTemp = new ProjetDTO();
		projetTemp.setNum(numProjet);

	
		try {
			projetDTO = DAOFactory1.getInstance().createProjetService(null).readProjet(projetTemp);
					
		} catch (TransactionalConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projetDTO;
	}

}

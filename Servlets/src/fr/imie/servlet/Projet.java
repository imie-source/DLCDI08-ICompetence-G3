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

		// Afficher un projet
		if ((request.getParameter("read") != null && request.getParameter(
				"read").equals("afficher"))
				|| (request.getParameter("delete") != null && request
						.getParameter("delete").equals("supprimer"))) {
			if (request.getParameter("ligneProjet") != null) {

				int ligne = Integer.valueOf(request.getParameter("ligneProjet"));
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
					if ((request.getParameter("delete") != null) 
							&& (request.getParameter("delete").equals("supprimer"))) {
						request.setAttribute("action", "delete");
					} else {
						request.setAttribute("action", "read");
					}

				} catch (TransactionalConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
		
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		
		}
		request.getRequestDispatcher("/ProjetConsult.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

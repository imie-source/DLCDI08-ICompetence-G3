package fr.imie.formation.DAO;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IInvitationDAO;
import fr.imie.formation.DTO.InvitationDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;


public class InvitationDAO extends ATransactional implements IInvitationDAO{

	
	
	public int createInvitation (InvitationDTO newInvitation)
			throws TransactionalConnectionException, DAOException {
		// initialisation de la liste qui servira au retour
		int createNum = 0;

		// obtention des DTO avec une nouvelle connection
		createNum = createInvitation(newInvitation, getConnection());
		return createNum;
	}

	
	public List<InvitationDTO> readListInvitationByProjet (ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		List<InvitationDTO> listInvitByProjet = new ArrayList<InvitationDTO>();

		listInvitByProjet=readListInvitationByProjet(projet, getConnection());
		return listInvitByProjet;
	}

	
	public List<InvitationDTO> readAllInvitation (ProjetDTO projet)
			throws TransactionalConnectionException, DAOException {
		
		List<InvitationDTO> listAllInvitation = new ArrayList<InvitationDTO>();

		listAllInvitation=readAllInvitation(projet, getConnection());
		return listAllInvitation;
	}
	
	private int createInvitation(InvitationDTO newInvitation, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		int creatNum = 0;

		try {

			String query = "INSERT INTO invitation (num_projet, num_util, date, message, reponse) VALUES (?, ?, ?, ?, ?)";
			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, newInvitation.getNum_projet());
			pstmt.setInt(2, newInvitation.getNum_util());
			pstmt.setDate(3, (java.sql.Date)  newInvitation.getDate());
			pstmt.setString(3, newInvitation.getMessage());
			pstmt.setBoolean(4, false);
			creatNum = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!= null) {
					pstmt.close();
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return creatNum;				
	}


	private List<InvitationDTO> readListInvitationByProjet (ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException {
		PreparedStatement pstmt = null;
		ResultSet rst = null;

		List<InvitationDTO> listInvitByProjet = new ArrayList<InvitationDTO>();
		InvitationDTO invit = new InvitationDTO();
		UtilisateurDTO util = new UtilisateurDTO();

		String query = "SELECT invitation.date, invitation.num, utilisateur.nom, utilisateur.prenom, invitation.message, invitation.reponse FROM invitation INNER JOIN utilisateur ON invitation.num_util=utilisateur.num WHERE invitation.num_projet=?;";
		try {
			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1,projet.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				invit.setDate(rst.getDate(1));
				invit.setNum(rst.getInt(2));
				util.setNom(rst.getString(3));
				util.setPrenom(rst.getString(4));
				invit.setMessage(rst.getString(5));
				invit.setReponse(rst.getBoolean(6));
				invit.setUtilisateur(util);
				listInvitByProjet.add(invit);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return listInvitByProjet;		
	}


	//méthode pour afficher toutes les invitations
	private List<InvitationDTO> readAllInvitation (ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		
		List<InvitationDTO> listAllInvitation = new ArrayList<InvitationDTO>();

		Statement stmt = null;
		ResultSet rst = null;
		
		String query = "SELECT invitation.num, invitation.date, utilisateur.nom, utilisateur.prenom, invitation.message, invitation.reponse FROM invitation INNER JOIN utilisateur ON invitation.num_util=utilisateur.num ORDER BY invitation.date";

			try {
				stmt = cn.createStatement();
			
			rst = stmt.executeQuery(query);

			while(rst.next()){
				InvitationDTO invitation= new InvitationDTO();
				invitation.setNum(rst.getInt(1));
				invitation.setDate(rst.getDate(2));
				invitation.setMessage(rst.getString(5));
				invitation.setReponse(rst.getBoolean(6));

				UtilisateurDTO utilisateur= new UtilisateurDTO();
				utilisateur.setNom(rst.getString(3));
				utilisateur.setPrenom(rst.getString(4));

				listAllInvitation.add(invitation);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listAllInvitation;
		
		

	}

	//méthode pous afficher toutes les invitations par Utilisateur
}

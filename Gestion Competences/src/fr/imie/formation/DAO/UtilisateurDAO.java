package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IUtilisateurDAO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;
import fr.imie.formation.utils.AgeUtil;

public class UtilisateurDAO extends ATransactional implements IUtilisateurDAO {

	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, DAOException {

		// initial;isation de la liste qui servira au retour
		List<UtilisateurDTO> listUtil = null;

		// obtention des DTO avec une nouvelle connection
		listUtil = readAllUtilisateur(getConnection());
		return listUtil;

	}

	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		UtilisateurDTO util = new UtilisateurDTO();

		// obtention des DTO avec une nouvelle connection
		util = readUtilisateur(utilisateur, getConnection());
		return util;

	}

	public int createUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		int createNum = 0;

		// obtention des DTO avec une nouvelle connection
		createNum = createUtilisateur(utilisateur, getConnection());
		return createNum;

	}

	public int updateUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		int updateNum = 0;

		// obtention des DTO avec une nouvelle connection
		updateNum = updateUtilisateur(utilisateur, getConnection());
		return updateNum;

	}

	public int deleteUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		int deleteNum = 0;

		// obtention des DTO avec une nouvelle connection
		deleteNum = deleteUtilisateur(utilisateur, getConnection());
		return deleteNum;

	}

	public boolean logUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		boolean logExist = false;

		// obtention des DTO avec une nouvelle connection
		logExist = logUtilisateur(utilisateur, getConnection());
		return logExist;

	}

	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{

		List<UtilisateurDTO> listUtilProjet = null;
		listUtilProjet = readUtilisateurProjet(projet, getConnection());
		return listUtilProjet;

	}

	// Liste de tous les utilisateurs avec leurs promotions
	private List<UtilisateurDTO> readAllUtilisateur(Connection cn)
			throws TransactionalConnectionException, DAOException {

		Statement stmt = null;
		ResultSet rst = null;

		List<UtilisateurDTO> listUtil = new ArrayList<UtilisateurDTO>();

		try {
			String query = "select utilisateur.num, utilisateur.nom, prenom, adresse, date_naissance, promotion.intitule, promotion.annee, login , mail,tel from utilisateur left join promotion on promotion.num=utilisateur.num_promotion";

			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				UtilisateurDTO util = new UtilisateurDTO();
				util.setNum(rst.getInt(1));
				util.setNom(rst.getString(2));
				util.setPrenom(rst.getString(3));
				util.setAdresse(rst.getString(4));
				util.setAge(AgeUtil.getInstance().getAge(rst.getDate(5)));
				util.setMail(rst.getString(9));
				util.setTel(rst.getInt(10));

				PromotionDTO promotion = new PromotionDTO();
				promotion.setIntitule(rst.getString(6));
				promotion.setAnnee(rst.getInt(7));
				util.setPromotion(promotion);
				util.setLogin(rst.getString(8));

				listUtil.add(util);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listUtil;
	}

	// Affiche un utilisateur avec ses compétences et sa promotion
	private UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateur,
			Connection cn) throws TransactionalConnectionException,
			DAOException{

		PreparedStatement pstmt = null;
		ResultSet rst = null;

		UtilisateurDTO util = new UtilisateurDTO();
		PromotionDTO promotion = new PromotionDTO();

		try {
			String query = "select utilisateur.num, utilisateur.nom, prenom, adresse, date_naissance, promotion.num, promotion.intitule, promotion.annee,login from utilisateur left join promotion on utilisateur.num_promotion=promotion.num where utilisateur.num=?";

			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, utilisateur.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				util.setNum(rst.getInt(1));
				util.setNom(rst.getString(2));
				util.setPrenom(rst.getString(3));
				util.setAdresse(rst.getString(4));
				util.setAge(AgeUtil.getInstance().getAge(rst.getDate(5)));
				util.setListNiveau(DAOFactory1.getInstance()
						.createCompetenceNiveauService(this)
						.readCompetenceNiveauUtilisateur(utilisateur));

				promotion.setNum(rst.getInt(6));
				promotion.setIntitule(rst.getString(7));
				promotion.setAnnee(rst.getInt(8));
				util.setLogin(rst.getString(9));
				util.setPromotion(promotion);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
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

		return util;
	}

	private int createUtilisateur(UtilisateurDTO utilisateur, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		int createNum = 0;

		try {
			String query = "insert into utilisateur (nom, prenom, date_naissance, num_promotion)  values (?,?,?,?);";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setDate(3, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
			pstmt.setInt(4, utilisateur.getPromotion().getNum());
			createNum = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return createNum;
	}

	private int updateUtilisateur(UtilisateurDTO utilisateur, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		int updateNum = 0;

		try {
			String query = "UPDATE utilisateur SET nom=?, prenom=?, date_naissance=?, adresse=?, num_promotion=?, mail=?, tel=?, login=? where num=?;";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setDate(3, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
			pstmt.setString(4, utilisateur.getAdresse());
			pstmt.setInt(5, utilisateur.getPromotion().getNum());
			pstmt.setString(6, utilisateur.getMail());
			pstmt.setInt(7, utilisateur.getTel());
			pstmt.setString(8, utilisateur.getLogin());
			//pstmt.setString(9, utilisateur.getPassword());
			pstmt.setInt(9, utilisateur.getNum());
			updateNum = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateNum;
	}

	private int deleteUtilisateur(UtilisateurDTO utilisateur, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		int deleteNum = 0;

		try {
			String query = "delete from utilisateur where num=?;";

			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, utilisateur.getNum());
			deleteNum = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteNum;
	}

	private boolean logUtilisateur(UtilisateurDTO utilisateurDTO, Connection cn)
			throws TransactionalConnectionException, DAOException {

		boolean logExist = false;

		PreparedStatement pstmt = null;
		ResultSet rst = null;

		try {
			String query = "select utilisateur.nom from utilisateur where utilisateur.login=?";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, utilisateurDTO.getLogin());
			rst = pstmt.executeQuery();

			if (rst.next()) {
				logExist = true;
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
		return logExist;
	}

	// Liste des utilisateurs pour un projet
	private List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		ResultSet rst = null;

		List<UtilisateurDTO> listUtilProjet = new ArrayList<UtilisateurDTO>();

		try {
			String query = "SELECT utilisateur.num, utilisateur.nom, utilisateur.prenom FROM utilisateur RIGHT JOIN projet_util ON projet_util.num_util=utilisateur.num RIGHT JOIN projet ON projet_util.num_projet=projet.num where projet.num=?";

			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, projet.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				UtilisateurDTO utilisateur = new UtilisateurDTO();
				utilisateur.setNum(rst.getInt(1));
				utilisateur.setNom(rst.getString(2));
				utilisateur.setPrenom(rst.getString(3));

				listUtilProjet.add(utilisateur);

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
		return listUtilProjet;
	}
}

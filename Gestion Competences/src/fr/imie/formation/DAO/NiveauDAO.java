package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.INiveauDAO;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class NiveauDAO extends ATransactional implements INiveauDAO {

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		List<NiveauDTO> listcompNiv = null;

		// obtention des DTO avec une nouvelle connection
		listcompNiv = readCompetenceNiveauUtilisateur(utilisateur,
				getConnection());
		return listcompNiv;

	}

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			DAOException {

		// initialisation de la liste qui servira au retour
		List<NiveauDTO> listNivUtilisateur = null;

		// obtention des DTO avec une nouvelle connection
		listNivUtilisateur = readNiveauUtilisateurCompetence(competence,
				getConnection());
		return listNivUtilisateur;

	}

	// Liste des Niveaux et compétences pour un utilisateur
	private List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstm = null;
		ResultSet rst = null;

		List<NiveauDTO> listcompNiv = new ArrayList<NiveauDTO>();

		try {
			String query = "SELECT niveau.valeur as niveau, competence.nom FROM niveau INNER JOIN competence_util ON niveau.num=competence_util.num_niveau INNER JOIN utilisateur ON utilisateur.num=competence_util.num_util INNER JOIN competence ON competence.num=competence_util.num_competence where utilisateur.num=?;";

			pstm = cn.prepareStatement(query);
			pstm.setInt(1, utilisateur.getNum());
			rst = pstm.executeQuery();

			while (rst.next()) {
				NiveauDTO niveau = new NiveauDTO();
				niveau.setNom(rst.getString(1));
				niveau.setCompetence(rst.getString(2));

				listcompNiv.add(niveau);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listcompNiv;
	}

	// Liste des Niveaux et utilisateurs pour une compétence
	private List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstm = null;
		ResultSet rst = null;

		List<NiveauDTO> listNiveau = new ArrayList<NiveauDTO>();

		try {

			String query = "SELECT utilisateur.nom, niveau.valeur as niveau, competence.nom FROM niveau INNER JOIN competence_util ON niveau.num=competence_util.num_niveau INNER JOIN utilisateur ON utilisateur.num=competence_util.num_util INNER JOIN competence ON competence.num=competence_util.num_competence where competence.num=?;";

			pstm = cn.prepareStatement(query);
			pstm.setInt(1, competence.getNum());
			rst = pstm.executeQuery();

			while (rst.next()) {
				NiveauDTO niveau = new NiveauDTO();

				niveau.setUtilisateur(rst.getString(1));
				niveau.setNom(rst.getString(2));
				niveau.setCompetence(rst.getString(3));

				listNiveau.add(niveau);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listNiveau;
	}

}

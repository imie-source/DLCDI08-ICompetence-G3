package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.ICompetenceDAO;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class CompetenceDAO extends ATransactional implements ICompetenceDAO {

	public CompetenceDTO readCompetence(CompetenceDTO competence)
			throws TransactionalConnectionException, DAOException {

		CompetenceDTO comp = new CompetenceDTO();

		// obtention des DTO avec une nouvelle connection
		comp = readCompetence(competence, getConnection());
		return comp;

	}
	
	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		List<CompetenceDTO> listCompetence = null;

		// obtention des DTO avec une nouvelle connection
		listCompetence = readAllCompetence(getConnection());
		return listCompetence;

	}

	private CompetenceDTO readCompetence(CompetenceDTO competenceDTO, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		ResultSet rst = null;

		CompetenceDTO comp = new CompetenceDTO();
		
		String query = "select num, nom, competence_domaine from competence where num=?";
		try {
			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, competenceDTO.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {			
				comp.setNum(rst.getInt(1));
				comp.setNom(rst.getString(2));
				CompetenceDTO compMere = new CompetenceDTO();
				compMere.setNum(rst.getInt(3));
				if (compMere.getNum() != 0) {
					comp.setCompetenceDomaine(readCompetence(compMere));
				}			
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
		
		return comp;
	}
	
	// Liste de toutes les compétences
	private List<CompetenceDTO> readAllCompetence(Connection cn)
			throws TransactionalConnectionException, DAOException {

		Statement stmt = null;
		ResultSet rst = null;

		List<CompetenceDTO> listCompetence = new ArrayList<CompetenceDTO>();

		String query = "select competence.num, competence.nom, competence.competence_domaine from competence competence left join competence pere on pere.num = competence.competence_domaine order by competence_domaine desc";
		try {
			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				CompetenceDTO comp = new CompetenceDTO();
				comp.setNum(rst.getInt(1));
				comp.setNom(rst.getString(2));
				CompetenceDTO compMere = new CompetenceDTO();
				compMere.setNum(rst.getInt(3));
				if (compMere.getNum() != 0) {
					comp.setCompetenceDomaine(readCompetence(compMere));
				}	
				comp.setListCompetence(readAllCompetenceFille(comp, cn));
				listCompetence.add(comp);
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

		return listCompetence;
	}
	
	private List<CompetenceDTO> readAllCompetenceFille(CompetenceDTO compMere, Connection cn)
			throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		List<CompetenceDTO> listCompetenceFille = new ArrayList<CompetenceDTO>();

		String query = "select num, nom from competence where competence_domaine=?";
		try {
			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, compMere.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				CompetenceDTO comp = new CompetenceDTO();
				comp.setNum(rst.getInt(1));
				comp.setNom(rst.getString(2));
				listCompetenceFille.add(comp);
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

		return listCompetenceFille;
	}

}

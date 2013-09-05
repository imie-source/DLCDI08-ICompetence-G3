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

	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		List<CompetenceDTO> listCompetence = null;

		// obtention des DTO avec une nouvelle connection
		listCompetence = readAllCompetence(getConnection());
		return listCompetence;

	}

	// Liste de toutes les compétences
	private List<CompetenceDTO> readAllCompetence(Connection cn)
			throws TransactionalConnectionException, DAOException {

		Statement stmt = null;
		ResultSet rst = null;

		List<CompetenceDTO> listCompetence = new ArrayList<CompetenceDTO>();

		String query = "select num, nom from competence fille left join competence pere on pere.num = fille.competence_domaine";
		try {
			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				CompetenceDTO comp = new CompetenceDTO();
				comp.setNum(rst.getInt(1));
				comp.setNom(rst.getString(2));
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
	private int createCompetence(CompetenceDTO competence,Connection cn){
		int createNum=0;
		PreparedStatement pstmt=null;

		try {
			String query="insert into competence(nom,competence_domaine)values ('?','?')";
			pstmt= cn.prepareStatement(query);
			pstmt.setString(1, competence.getNom());
			pstmt.setInt(2, competence.getCompetence_domaine);
			createNum=pstmt.executeUpdate();

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
	private int updateCompetence(CompetenceDTO competence,Connection cn){
		int updateNum=0;
		PreparedStatement pstmt=null;
		try {
		String query="update competence set nom='?',competence_domaine='?' where num='?'";
			pstmt.setString(1, competence.getNom());
			pstmt.setInt(2, competence.getCompetence_domaine());
			updateNum=pstmt.executeUpdate();
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
		return updateNum;
	}
	}
	@SuppressWarnings({ "finally", "unused", "null" })
	private int deletecompetence(CompetenceDTO competence,Connection cn){
		int deleteNum=0;
		PreparedStatement pstmt=null;
		try {
		 String query1="delete from competence_util where num_competence=?";
			pstmt.setInt(1, competence.getNum());
			pstmt=cn.prepareStatement(query1);
			
			String query2="DELETE FROM competence WHERE num=?";
			pstmt.setInt(1, competence.getNum());
			pstmt=cn.prepareStatement(query2);
			deleteNum=pstmt.executeUpdate();
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
		return deleteNum;
		
	}
}
}

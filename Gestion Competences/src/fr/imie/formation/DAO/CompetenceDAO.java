package fr.imie.formation.DAO;

import java.sql.Connection;
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

		String query = "select num, nom from competence";
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

}

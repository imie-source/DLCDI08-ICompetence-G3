package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IProfilDAO;
import fr.imie.formation.DTO.ProfilDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProfilDAO extends ATransactional implements IProfilDAO{

	
	public List<ProfilDTO> readAllProfil()
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		List<ProfilDTO> listProfil = null;

		// obtention des DTO avec une nouvelle connection
		listProfil = readAllProfil(getConnection());
		return listProfil;

	}
	
	private List<ProfilDTO> readAllProfil(Connection cn)
	
			throws TransactionalConnectionException, DAOException {

		Statement stmt = null;
		ResultSet rst = null;

		List<ProfilDTO> listProfil = new ArrayList<ProfilDTO>();

		try {
			String query = "select num, nom, num1 from profil";

			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				ProfilDTO profil = new ProfilDTO();
				profil.setNum(rst.getInt(1));
				profil.setNom(rst.getString(2));
				profil.setNumSuper(rst.getInt(3));
				listProfil.add(profil);
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

		return listProfil;
	}
}

package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IPromotionDAO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class PromotionDAO extends ATransactional implements IPromotionDAO {

	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, DAOException {

		// initialisation de la liste qui servira au retour
		List<PromotionDTO> listPromo = null;

		// obtention des DTO avec une nouvelle connection
		listPromo = readAllPromotion(getConnection());
		return listPromo;

	}
                    
	// Liste de toutes les promotions
	private List<PromotionDTO> readAllPromotion(Connection cn)
			throws TransactionalConnectionException, DAOException {

		Statement stmt = null;
		ResultSet rst = null;

		List<PromotionDTO> listPromo = new ArrayList<PromotionDTO>();

		try {
			String query = "select num, intitule, annee from promotion";

			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				PromotionDTO promo = new PromotionDTO();
				promo.setNum(rst.getInt(1));
				promo.setIntitule(rst.getString(2));
				promo.setAnnee(rst.getInt(3));
				listPromo.add(promo);
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

		return listPromo;
	}

}

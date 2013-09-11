package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public List<PromotionDTO> readPromotion(PromotionDTO promo)
		throws TransactionalConnectionException, DAOException {
		
		List<PromotionDTO> listePromotion =null;
		listePromotion=readPromotion(promo,getConnection());
		return listePromotion;

	}
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {

		int createNum = 0;
		createNum = createPromotion(promo, getConnection());
		return createNum;

	}
	
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {

		int updateNum = 0;
		updateNum = updatePromotion(promo, getConnection());
		return updateNum;

	}
	
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {

		int deleteNum = 0;
		deleteNum = deletePromotion(promo, getConnection());
		return deleteNum;

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
	
	private List<PromotionDTO> readPromotion(PromotionDTO promo,Connection cn)
			throws TransactionalConnectionException, DAOException {

	 PreparedStatement pstmt = null;
		ResultSet rst = null;

		List<PromotionDTO> listePromotion = new ArrayList<PromotionDTO>();

		try {
			String query = "SELECT promotion.num, promotion.intitule, promotion.annee FROM promotion WHERE promotion.num=?";


			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, promo.getNum());
			rst = pstmt.executeQuery(query);

			while (rst.next()) {
				PromotionDTO promotion = new PromotionDTO();
				promotion.setIntitule(rst.getString(2));
				promo.setAnnee(rst.getInt(3));
				listePromotion.add(promotion);
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

		return listePromotion;
	}

	private int createPromotion(PromotionDTO promo,Connection cn)throws TransactionalConnectionException, DAOException {
		int createNum=0;
		PreparedStatement pstm=null;

		try {
			String query="insert into promotion (intitule, annee) values (?,?);";
			pstm=cn.prepareStatement(query);
			pstm.setString(1, promo.getIntitule());
			pstm.setInt(2, promo.getAnnee());

			createNum=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return createNum;
	}
	 private int updatePromotion(PromotionDTO promo,Connection cn) throws TransactionalConnectionException, DAOException{
		 int updateNum=0;
		 PreparedStatement pstm=null;
		 try {
		 String query="UPDATE promotion SET  intitule=?, annee=? where num=?;";
		    pstm=cn.prepareStatement(query);
			pstm.setString(1, promo.getIntitule());
			pstm.setInt(2, promo.getAnnee());
			updateNum=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 }
		 return updateNum;
}
	 private int deletePromotion(PromotionDTO promo,Connection cn) throws TransactionalConnectionException, DAOException{
		 int deleteNum=0;
		  PreparedStatement pstm=null;
		  try {
		  String query= "delete from promotion where num=?;";
			pstm=cn.prepareStatement(query);
			pstm.setInt(1, promo.getNum());
			
			deleteNum=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 }
		  return deleteNum;
		  
}
}
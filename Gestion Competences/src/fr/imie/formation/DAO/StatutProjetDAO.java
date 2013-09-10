package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IStatutProjetDAO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;


public class StatutProjetDAO extends ATransactional implements IStatutProjetDAO {

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IStatutProjetDAO#readAllStatutProjet()
	 */
	public List<StatutProjetDTO> readAllStatutProjet()
			throws TransactionalConnectionException, DAOException{
		List<StatutProjetDTO> listStatutProjet = null;
		listStatutProjet = readAllStatutProjet(getConnection());
		return listStatutProjet;
	}

	public int createStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException{
		int createNum = 0;
		createNum=createStatutProjet(statut,getConnection());
		return createNum;
	}

	public int updateStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException {
		int updateNum = 0;
		updateNum = updateStatutProjet(statut, getConnection());
		return updateNum;
	}


	public int deleteStatutProjet(StatutProjetDTO statut)
			throws TransactionalConnectionException, DAOException{
		int deleteNum = 0;
		deleteNum=deleteStatutProjet(statut,getConnection());
		return deleteNum;
	}

	private List<StatutProjetDTO> readAllStatutProjet(Connection cn)
			throws TransactionalConnectionException, DAOException{

		Statement stmt = null;
		ResultSet rst = null;
		List<StatutProjetDTO> listStatutProjet = new ArrayList<StatutProjetDTO>();

		try {
			String query = "SELECT num, valeur FROM statut";
			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				StatutProjetDTO statutProjet = new StatutProjetDTO();

				statutProjet.setNum(rst.getInt(1));
				statutProjet.setValeurStatut(rst.getString(2));

				listStatutProjet.add(statutProjet);
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
		return listStatutProjet;
	}


	private int createStatutProjet(StatutProjetDTO statut,Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		int createNum = 0;

		try {
			String query = "INSERT INTO statut (valeur) VALUES(?)";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, statut.getValeurStatut());
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

	private int updateStatutProjet(StatutProjetDTO statut,Connection cn)throws TransactionalConnectionException, DAOException {
		int updateNum=0;
		PreparedStatement pstm=null;
		try {
			String query= "UPDATE statut SET  valeur=? where num=?;";
			pstm=cn.prepareStatement(query);
			pstm.setString(1, statut.getValeurStatut());
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
	private int deleteStatutProjet(StatutProjetDTO statut,Connection cn)throws TransactionalConnectionException, DAOException {
		int deleteNum=0;
		PreparedStatement pstm=null;
		try {
			String query= "DELETE FROM statut WHERE num=?;";
			pstm=cn.prepareStatement(query);
			pstm.setString(1, statut.getValeurStatut());
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
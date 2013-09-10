package fr.imie.formation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IProjetDAO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ATransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class ProjetDAO extends ATransactional implements IProjetDAO{

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#readAllProjets()
	 */
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, DAOException{

		List<ProjetDTO> listProjet = null;
		listProjet = readAllProjets(getConnection());
		return listProjet;
	}

	public List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException{

		List<ProjetDTO> listeProjetUtilisateur= null;
		
		listeProjetUtilisateur= readProjetByUtilisateur(utilisateur,getConnection());
		return listeProjetUtilisateur;

	}


	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#readProjet(fr.imie.formation.DTO.ProjetDTO)
	 */
	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		ProjetDTO proj = new ProjetDTO();
		proj = readProjet(projet, getConnection());
		return proj;
	}

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#ajoutChefDeProjet(fr.imie.formation.DTO.ProjetDTO)
	 */
	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		int updateCDPnum = 0;
		updateCDPnum = ajoutChefDeProjet(projet, getConnection());
		return updateCDPnum;
	}

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#createProjet(fr.imie.formation.DTO.ProjetDTO)
	 */
	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		int createNum = 0;
		createNum = createProjet(projet, getConnection());
		return createNum;
	}

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#updateProjet(fr.imie.formation.DTO.ProjetDTO)
	 */
	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		int updateNum = 0;
		updateNum = updateProjet(projet, getConnection());
		return updateNum;
	}

	/* (non-Javadoc)
	 * @see fr.imie.formation.DAO.IProjetDAO#deleteProjet(fr.imie.formation.DTO.ProjetDTO)
	 */
	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException{
		int deleteNum =0;
		deleteNum = deleteProjet(projet, getConnection());
		return deleteNum;
	}


	// Liste des projets et de leur statut
	private List<ProjetDTO> readAllProjets(Connection cn)
			throws TransactionalConnectionException, DAOException{

		Statement stmt = null;
		ResultSet rst = null;

		List<ProjetDTO> listProjet = new ArrayList<ProjetDTO>();

		try {
			String query = "SELECT projet.num, projet.intitule, projet.description, statut.valeur as statut, utilisateur.nom, utilisateur.prenom FROM projet Inner join statut on statut.num=projet.num_statut Inner Join utilisateur ON utilisateur.num=projet.num_util";

			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				ProjetDTO projet = new ProjetDTO();
				UtilisateurDTO chefProjet = new UtilisateurDTO();
				projet.setNum(rst.getInt(1));
				projet.setIntitule(rst.getString(2));
				projet.setDescription(rst.getString(3));

				StatutProjetDTO statutProjet = new StatutProjetDTO();
				statutProjet.setValeurStatut(rst.getString(4));
				projet.setStatutProjet(statutProjet);

				chefProjet.setNom(rst.getString(5));
				chefProjet.setPrenom(rst.getString(6));
				projet.setChefDeProjet(chefProjet);


				listProjet.add(projet);
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

		return listProjet;
	}
	// liste des projets pour un utilisateur
	private List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur,Connection cn) 
			throws TransactionalConnectionException, DAOException{

		List<ProjetDTO>listeProjetUtilisateur=new ArrayList<ProjetDTO>();

		PreparedStatement pstmt= null;
		ResultSet rst= null;

		try {
			String query="select projet.num as projet,projet.intitule ,utilisateur.num from projet  inner join projet_util on projet_util.num_projet=projet.num inner join utilisateur on utilisateur.num=projet_util.num_util where utilisateur.num=?";

			pstmt=cn.prepareStatement(query);
			rst=pstmt.executeQuery();

			while(rst.next()){
				ProjetDTO project = new ProjetDTO();
				project.setNum(rst.getInt(1));
				project.setNum(rst.getInt(2));

				UtilisateurDTO user= new UtilisateurDTO();
				user.setNom(rst.getString(3));
				user.setPrenom(rst.getString(4));
				listeProjetUtilisateur.add(project);


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
		return listeProjetUtilisateur;


	}



	// Affiche la fiche d'un projet avec la liste de ses volontaires
	private ProjetDTO readProjet(ProjetDTO projet, Connection cn) throws TransactionalConnectionException, DAOException {

		PreparedStatement pstmt = null;
		ResultSet rst = null;

		ProjetDTO proj = new ProjetDTO();
		StatutProjetDTO statutProjet = new StatutProjetDTO();
		UtilisateurDTO chefDeProjet = new UtilisateurDTO();

		try {
			String query = "SELECT projet.num, projet.intitule as projet, projet.description, statut.valeur as statut, utilisateur.nom, utilisateur.prenom FROM projet Inner join statut on statut.num=projet.num_statut inner join utilisateur on projet.num_util=utilisateur.num where projet.num =?";

			pstmt = cn.prepareStatement(query);

			pstmt.setInt(1, projet.getNum());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				proj.setNum(rst.getInt(1));
				proj.setIntitule(rst.getString(2));
				proj.setDescription(rst.getString(3));
				statutProjet.setValeurStatut(rst.getString(4));
				proj.setStatutProjet(statutProjet);
				chefDeProjet.setNom(rst.getString(5));
				chefDeProjet.setPrenom(rst.getString(6));
				proj.setChefDeProjet(chefDeProjet);
				try {
					proj.setListUtilProjet(DAOFactory1.getInstance().
							createUtilisateurService(this).
							readUtilisateurProjet(projet));
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
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

			return proj;
	}



	// Ajout d'un chef de projet à un projet
	private int ajoutChefDeProjet(ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		int ajoutCDPNum = 0;

		try {
			String query = "UPDATE projet SET num_util=? WHERE num=?";

			pstmt = cn.prepareStatement(query);
			pstmt.setInt(1, projet.getChefDeProjet().getNum());
			pstmt.setInt(2, projet.getNum());
			ajoutCDPNum = pstmt.executeUpdate();

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

		return ajoutCDPNum;
	}

	// Création d'un projet
	private int createProjet(ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		int createNum = 0;

		try {
			String query = "INSERT INTO projet (intitule, description, num_statut) VALUES(?,?,?)";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, projet.getIntitule());
			pstmt.setString(2, projet.getDescription());
			pstmt.setInt(3, projet.getStatutProjet().getNum());
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

	// Modification d'un projet (nom, statut et description)
	private int updateProjet(ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		int updateNum = 0;

		try {
			String query = "UPDATE projet SET intitule=?, description=?, num_statut=? WHERE num=?";

			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, projet.getIntitule());
			pstmt.setString(2, projet.getDescription());
			pstmt.setInt(3, projet.getStatutProjet().getNum());
			pstmt.setInt(4, projet.getNum());
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

	// Suppression d'un projet
	// TODO faire une méthode de suppression dans InvitationDAO pr supp les
	// invitations avec ce num de projet
	private int deleteProjet(ProjetDTO projet, Connection cn)
			throws TransactionalConnectionException, DAOException{

		PreparedStatement pstmt = null;
		int deleteNum = 0;

		try {
			// Suppression de la foreign key dans la table technique projet_util
			String query1 = "Delete from projet_util where num_projet = ? ";
			pstmt = cn.prepareStatement(query1);
			pstmt.setInt(1, projet.getNum());

			String query2 = "DELETE FROM projet WHERE num=?";
			pstmt = cn.prepareStatement(query2);
			pstmt.setInt(1, projet.getNum());
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


	

	
	

}

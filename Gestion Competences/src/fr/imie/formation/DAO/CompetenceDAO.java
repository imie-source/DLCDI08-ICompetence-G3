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
import fr.imie.formation.DTO.UtilisateurDTO;
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

	public List<CompetenceDTO> readListeUtilComp(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, DAOException {
		List<CompetenceDTO> listeUtilComp = null;

		listeUtilComp = readListeUtilComp(competenceDto, getConnection());
		return listeUtilComp;

	}

	public int createCompetence(CompetenceDTO competence)
			throws TransactionalConnectionException, DAOException {
		int createNum = 0;
		createNum = createCompetence(competence, getConnection());
		return createNum;
	}

	public int updateCompetence(CompetenceDTO competence)
			throws TransactionalConnectionException, DAOException {
		int updateNum = 0;
		updateNum = updateCompetence(competence, getConnection());
		return updateNum;
	}

	public int deleteCompetence(CompetenceDTO competence)
			throws TransactionalConnectionException, DAOException {
		int deleteNum = 0;
		deleteNum = deleteCompetence(competence, getConnection());
		return deleteNum;
	}

	private CompetenceDTO readCompetence(CompetenceDTO competenceDTO,
			Connection cn) throws TransactionalConnectionException,
			DAOException {

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

		String query = "WITH RECURSIVE parcourt_arbo(id_competence, libelle, niveau, chemin) AS (SELECT competence.num, competence.nom, 0, ARRAY[competence.num] AS \"array\" FROM competence WHERE competence.competence_domaine IS NULL UNION ALL SELECT precedent.num, precedent.nom, debut.niveau + 1, debut.chemin || precedent.num FROM competence precedent JOIN parcourt_arbo debut ON debut.id_competence = precedent.competence_domaine) SELECT parcourt_arbo.id_competence, parcourt_arbo.libelle, parcourt_arbo.niveau, parcourt_arbo.chemin FROM parcourt_arbo ORDER BY parcourt_arbo.chemin, array_dims(parcourt_arbo.chemin), parcourt_arbo.niveau";
		try {
			stmt = cn.createStatement();
			rst = stmt.executeQuery(query);

			while (rst.next()) {
				CompetenceDTO comp = new CompetenceDTO();
				comp.setNum(rst.getInt(1));
				comp.setNom(rst.getString(2));
				comp.setNiveauArbo(rst.getInt(3));
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

	// Liste de toutes les compétences
	// private List<CompetenceDTO> readAllCompetence(Connection cn)
	// throws TransactionalConnectionException, DAOException {
	//
	// Statement stmt = null;
	// ResultSet rst = null;
	//
	// List<CompetenceDTO> listCompetence = new ArrayList<CompetenceDTO>();
	//
	// String query =
	// "select competence.num, competence.nom, competence.competence_domaine from competence competence left join competence pere on pere.num = competence.competence_domaine order by competence_domaine desc";
	// try {
	// stmt = cn.createStatement();
	// rst = stmt.executeQuery(query);
	//
	// while (rst.next()) {
	// CompetenceDTO comp = new CompetenceDTO();
	// comp.setNum(rst.getInt(1));
	// comp.setNom(rst.getString(2));
	// CompetenceDTO compMere = new CompetenceDTO();
	// compMere.setNum(rst.getInt(3));
	// if (compMere.getNum() != 0) {
	// comp.setCompetenceDomaine(readCompetence(compMere));
	// }
	// comp.setListCompetence(readAllCompetenceFille(comp, cn));
	// listCompetence.add(comp);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// if (rst != null) {
	// rst.close();
	// }
	// if (stmt != null) {
	// stmt.close();
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return listCompetence;
	// }

	private List<CompetenceDTO> readAllCompetenceFille(CompetenceDTO compMere,
			Connection cn) throws TransactionalConnectionException,
			DAOException {

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

	private int createCompetence(CompetenceDTO competence, Connection cn)
			throws TransactionalConnectionException, DAOException {
		int createNum = 0;
		PreparedStatement pstmt = null;

		try {

			String query = "insert into competence(nom,competence_domaine)values (?,?)";
			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, competence.getNom());
			if (competence.getCompetenceDomaine().getNum() == null) {
				pstmt.setInt(2, (Integer) null);
			} else {
				pstmt.setInt(2, competence.getCompetenceDomaine().getNum());
			};
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

	private int updateCompetence(CompetenceDTO competence, Connection cn)
			throws TransactionalConnectionException, DAOException {

		int updateNum = 0;
		PreparedStatement pstmt = null;

		try {
			String query = "update competence set nom=?, competence_domaine=?  where num=?";
			pstmt = cn.prepareStatement(query);
			pstmt.setString(1, competence.getNom());
			if (competence.getCompetenceDomaine().getNum() == null) {
				pstmt.setInt(2, (Integer) null);
			} else {
				pstmt.setInt(2, competence.getCompetenceDomaine().getNum());
			}
			;
			pstmt.setInt(3, competence.getNum());
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

				e.printStackTrace();
			}
		}
		return updateNum;
	}

	private int deleteCompetence(CompetenceDTO competence, Connection cn)
			throws TransactionalConnectionException, DAOException {
		int deleteNum = 0;
		PreparedStatement pstmt = null;
		try {
			String query1 = "delete from competence_util where num_competence=?";
			pstmt = cn.prepareStatement(query1);
			pstmt.setInt(1, competence.getNum());

			String query2 = "DELETE FROM competence WHERE num=?";
			pstmt = cn.prepareStatement(query2);
			pstmt.setInt(1, competence.getNum());
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

				e.printStackTrace();
			}

		}
		return deleteNum;
	}

	// liste d'utilisateur par competence

	private List<CompetenceDTO> readListeUtilComp(CompetenceDTO competenceDto,
			Connection cn) throws TransactionalConnectionException,
			DAOException {

		List<CompetenceDTO> listeUtilComp = new ArrayList<CompetenceDTO>();
		PreparedStatement psmt = null;
		ResultSet rst = null;

		UtilisateurDTO utilisateur = new UtilisateurDTO();
		CompetenceDTO competence = new CompetenceDTO();

		try {

			String query = "SELECT utilisateur.num,utilisateur.nom, utilisateur.prenom, competence.nom as competence FROM competence inner JOIN competence_util ON competence.num=competence_util.num_competence INNER JOIN utilisateur ON utilisateur.num=competence_util.num_util where competence.num=?";
			psmt = cn.prepareStatement(query);
			rst = psmt.executeQuery();

			while (rst.next()) {

				utilisateur.setNum(rst.getInt(1));
				utilisateur.setNom(rst.getString(2));
				utilisateur.setPrenom(rst.getString(3));
				competence.setNom(rst.getString(4));

				listeUtilComp.add(competence);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (psmt != null) {
					psmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listeUtilComp;

	}
}
package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface INiveauDAO extends ITransactional{

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			DAOException;
	
	public int addCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException, DAOException;
	
	public int updateCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException, DAOException;
	
	public int deleteCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException, DAOException;
	
	public List<NiveauDTO> readAllNomNiveau()
			throws TransactionalConnectionException, DAOException ;
	
	public NiveauDTO readNiveau(NiveauDTO niveauDTO)
			throws TransactionalConnectionException, DAOException ;
	
}

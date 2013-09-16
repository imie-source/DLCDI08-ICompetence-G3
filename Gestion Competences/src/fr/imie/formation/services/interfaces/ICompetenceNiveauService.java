package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface ICompetenceNiveauService extends ITransactional {

	// COMPETENCE

	public CompetenceDTO readCompetence(CompetenceDTO competenceDTO)
			throws TransactionalConnectionException, ServiceException;
	
	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, ServiceException;
	
	public List<CompetenceDTO> readListeUtilComp(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, DAOException, ServiceException;

	// NIVEAU

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException;

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			ServiceException;

	public int addCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException,  ServiceException;
	
	public int deleteCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException,  ServiceException;

	public int updateCompUtil(UtilisateurDTO utilisateur,CompetenceDTO comp,NiveauDTO niveau)
			throws TransactionalConnectionException,  ServiceException;
	
	public int createCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException;
	
	public int updateCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException;
	
	public int deleteCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException;
	
	public List<NiveauDTO> readAllNomNiveau()
			throws TransactionalConnectionException, ServiceException;
	
	public NiveauDTO readNiveau(NiveauDTO niveauDTO)
			throws TransactionalConnectionException, ServiceException;
	
}

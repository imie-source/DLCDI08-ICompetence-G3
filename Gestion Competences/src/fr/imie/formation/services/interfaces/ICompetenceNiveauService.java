package fr.imie.formation.services.interfaces;

import java.util.List;

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

	// NIVEAU

	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException;

	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			ServiceException;

}

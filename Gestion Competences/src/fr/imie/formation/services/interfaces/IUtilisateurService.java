package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IUtilisateurService extends ITransactional {

	// UTILISATEUR

	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, ServiceException;

	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException;

	public int createUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException;

	public int updateUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException;

	public int deleteUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException;
	
	public boolean logUtilisateur(UtilisateurDTO utilisateurDTO)
			throws TransactionalConnectionException, ServiceException;
	
	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;
}

package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IUtilisateurDAO extends ITransactional {

	public List<UtilisateurDTO> readAllUtilisateur()
			throws TransactionalConnectionException, DAOException;

	public UtilisateurDTO readUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;

	public int createUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;

	public int updateUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;

	public int deleteUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;
	
	public boolean logUtilisateur(UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, DAOException;
	
	public List<UtilisateurDTO> readUtilisateurProjet(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

}

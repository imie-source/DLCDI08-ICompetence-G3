package fr.imie.formation.services.interfaces;

import java.util.List;

import fr.imie.formation.DTO.InvitationDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.DTO.StatutProjetDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IProjetService extends ITransactional{
	
	//PROJET
	public List<ProjetDTO> readAllProjets()
			throws TransactionalConnectionException, ServiceException;

	public ProjetDTO readProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;
	
	public List<ProjetDTO> readProjetByUtilisateur(UtilisateurDTO utilisateur)
	throws TransactionalConnectionException, ServiceException;

	public int ajoutChefDeProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int createProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int updateProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;

	public int deleteProjet(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;
	
	public int addProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
			throws TransactionalConnectionException,  ServiceException;
	
	public int updateProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
			throws TransactionalConnectionException,  ServiceException;
	
	public int deleteProjetUtil(UtilisateurDTO utilisateur,ProjetDTO projet)
			throws TransactionalConnectionException,  ServiceException;
	
	//STATUT PROJET
	public List<StatutProjetDTO> readAllStatutProjet()
		throws TransactionalConnectionException, ServiceException;
	
	// invitattion
	
	public  List<InvitationDTO> readAllInvitation(ProjetDTO projet)
			throws TransactionalConnectionException, ServiceException;
}

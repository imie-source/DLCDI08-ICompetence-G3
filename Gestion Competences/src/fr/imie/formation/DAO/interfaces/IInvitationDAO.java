package fr.imie.formation.DAO.interfaces;

import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.InvitationDTO;
import fr.imie.formation.DTO.ProjetDTO;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public interface IInvitationDAO {

	public  int createInvitation(InvitationDTO newInvitation)
			throws TransactionalConnectionException, DAOException;

	public List<InvitationDTO> readListInvitationByProjet(
			ProjetDTO projet) throws TransactionalConnectionException,
			DAOException;

	public  List<InvitationDTO> readAllInvitation(ProjetDTO projet)
			throws TransactionalConnectionException, DAOException;

}
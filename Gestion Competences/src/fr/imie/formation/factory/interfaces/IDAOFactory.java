package fr.imie.formation.factory.interfaces;

import fr.imie.formation.DAO.interfaces.ICompetenceDAO;
import fr.imie.formation.DAO.interfaces.IInvitationDAO;
import fr.imie.formation.DAO.interfaces.INiveauDAO;
import fr.imie.formation.DAO.interfaces.IProjetDAO;
import fr.imie.formation.DAO.interfaces.IPromotionDAO;
import fr.imie.formation.DAO.interfaces.IStatutProjetDAO;
import fr.imie.formation.DAO.interfaces.IUtilisateurDAO;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.services.interfaces.IProfilService;
import fr.imie.formation.services.interfaces.IProjetService;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.ITransactional;

public interface IDAOFactory {

	// SERVICES
	public IUtilisateurService createUtilisateurService(ITransactional caller);

	public ICompetenceNiveauService createCompetenceNiveauService(
			ITransactional caller);

	public IPromotionService createPromotionService(ITransactional caller);
	
	public IProjetService createProjetService(ITransactional caller);
	
	public IProfilService createProfilService(ITransactional caller);

	// DAO
	public IUtilisateurDAO createIUtilisateurDAO(ITransactional caller);

	public ICompetenceDAO createICompetenceDAO(ITransactional caller);

	public IPromotionDAO createIPromotionDAO(ITransactional caller);

	public INiveauDAO createINiveauDAO(ITransactional caller);
	
	public IProjetDAO createIProjetDAO(ITransactional caller);
	
	public IStatutProjetDAO createIStatutProjetDAO(ITransactional caller);

	public IInvitationDAO createIInvitationDAO(ITransactional caller);

}

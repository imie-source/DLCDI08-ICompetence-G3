package fr.imie.formation.factory;

import fr.imie.formation.DAO.CompetenceDAO;
import fr.imie.formation.DAO.NiveauDAO;
import fr.imie.formation.DAO.ProjetDAO;
import fr.imie.formation.DAO.PromotionDAO;
import fr.imie.formation.DAO.StatutProjetDAO;
import fr.imie.formation.DAO.UtilisateurDAO;
import fr.imie.formation.DAO.interfaces.ICompetenceDAO;
import fr.imie.formation.DAO.interfaces.IInvitationDAO;
import fr.imie.formation.DAO.interfaces.INiveauDAO;
import fr.imie.formation.DAO.interfaces.IProjetDAO;
import fr.imie.formation.DAO.interfaces.IPromotionDAO;
import fr.imie.formation.DAO.interfaces.IStatutProjetDAO;
import fr.imie.formation.DAO.interfaces.IUtilisateurDAO;
import fr.imie.formation.DAO.proxies.CompetenceProxy;
import fr.imie.formation.DAO.proxies.NiveauProxy;
import fr.imie.formation.DAO.proxies.ProjetProxy;
import fr.imie.formation.DAO.proxies.PromotionProxy;
import fr.imie.formation.DAO.proxies.StatutProjetProxy;
import fr.imie.formation.DAO.proxies.UtilisateurProxy;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.CompetenceNiveauService;
import fr.imie.formation.services.ProjetService;
import fr.imie.formation.services.PromotionService1;
import fr.imie.formation.services.UtilisateurService;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.services.interfaces.IProfilService;
import fr.imie.formation.services.interfaces.IProjetService;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.services.proxies.CompetenceNiveauServiceProxy;
import fr.imie.formation.services.proxies.ProjetServiceProxy;
import fr.imie.formation.services.proxies.PromotionService1Proxy;
import fr.imie.formation.services.proxies.UtilisateurServiceProxy;
import fr.imie.formation.transactionalFramework.ITransactional;

public class DAOFactory1 implements IDAOFactory {

	// Singleton
	// Constructeur privé
	private DAOFactory1() {
	}

	// Instance unique pré-initialisée
	private static DAOFactory1 INSTANCE = new DAOFactory1();

	// Point d'accès pour l'instance unique du singleton
	public static synchronized DAOFactory1 getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DAOFactory1();
		return INSTANCE;
	}

	@Override
	public IUtilisateurService createUtilisateurService(ITransactional caller) {
		// TODO Auto-generated method stub
		return new UtilisateurServiceProxy(new UtilisateurService(), caller);
	}

	@Override
	public ICompetenceNiveauService createCompetenceNiveauService(
			ITransactional caller) {
		// TODO Auto-generated method stub
		return new CompetenceNiveauServiceProxy(new CompetenceNiveauService(),
				caller);
	}

	@Override
	public IPromotionService createPromotionService(ITransactional caller) {
		// TODO Auto-generated method stub
		return new PromotionService1Proxy(new PromotionService1(), caller);
	}

	@Override
	public IUtilisateurDAO createIUtilisateurDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new UtilisateurProxy(new UtilisateurDAO(), caller);
	}

	@Override
	public ICompetenceDAO createICompetenceDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new CompetenceProxy(new CompetenceDAO(), caller);
	}

	@Override
	public INiveauDAO createINiveauDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new NiveauProxy(new NiveauDAO(), caller);
	}

	@Override
	public IPromotionDAO createIPromotionDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new PromotionProxy(new PromotionDAO(), caller);
	}

	@Override
	public IProjetService createProjetService(ITransactional caller) {
		// TODO Auto-generated method stub
		return new ProjetServiceProxy(new ProjetService(), caller);
	}

	@Override
	public IProjetDAO createIProjetDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new ProjetProxy(new ProjetDAO(), caller);
	}

	@Override
	public IStatutProjetDAO createIStatutProjetDAO(ITransactional caller) {
		// TODO Auto-generated method stub
		return new StatutProjetProxy(new StatutProjetDAO(), caller);
	}

	@Override
	public IProfilService createProfilService(ITransactional caller) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IInvitationDAO createIInvitationDAO(ITransactional caller){
		return null;
		
		
	}

}

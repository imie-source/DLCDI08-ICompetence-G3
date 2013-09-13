package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.services.CompetenceNiveauService;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class CompetenceNiveauServiceProxy implements ICompetenceNiveauService {

	private CompetenceNiveauService competenceNiveauService;

	ITransactional caller = null;

	public CompetenceNiveauServiceProxy(
			CompetenceNiveauService competenceNiveauService,
			ITransactional caller) {
		super();
		this.competenceNiveauService = competenceNiveauService;
		this.caller = caller;
	}

	@Override
	public Connection getConnection() {

		return competenceNiveauService.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {

		competenceNiveauService.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {

		competenceNiveauService.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {

		competenceNiveauService.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {

		competenceNiveauService.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {

		competenceNiveauService.beginTransactionalConnexion();

	}

	@Override
	public List<CompetenceDTO> readAllCompetence()
			throws TransactionalConnectionException, ServiceException {

		List<CompetenceDTO> listeCompetence = new ArrayList<CompetenceDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeCompetence = competenceNiveauService.readAllCompetence();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeCompetence;
	}

	@Override
	public List<NiveauDTO> readCompetenceNiveauUtilisateur(
			UtilisateurDTO utilisateur)
			throws TransactionalConnectionException, ServiceException {

		List<NiveauDTO> listeNiveau = new ArrayList<NiveauDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNiveau = competenceNiveauService
				.readCompetenceNiveauUtilisateur(utilisateur);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNiveau;
	}

	@Override
	public List<NiveauDTO> readNiveauUtilisateurCompetence(
			CompetenceDTO competence) throws TransactionalConnectionException,
			ServiceException {

		List<NiveauDTO> listeNiveau = new ArrayList<NiveauDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNiveau = competenceNiveauService
				.readNiveauUtilisateurCompetence(competence);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNiveau;
	}

	@Override
	public CompetenceDTO readCompetence(CompetenceDTO competenceDTO)
			throws TransactionalConnectionException, ServiceException {
		
		CompetenceDTO competence = new CompetenceDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		competence = competenceNiveauService
				.readCompetence(competenceDTO);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return competence;
	}

	@Override
	public int addCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			ServiceException {
		int addNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		addNum = competenceNiveauService.addCompUtil(utilisateur, comp, niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return addNum;
	}

	@Override
	public int deleteCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			ServiceException {
		int deleteNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = competenceNiveauService.deleteCompUtil(utilisateur, comp, niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return deleteNum;
	}

	@Override
	public int updateCompUtil(UtilisateurDTO utilisateur, CompetenceDTO comp,
			NiveauDTO niveau) throws TransactionalConnectionException,
			ServiceException {
		int updateNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = competenceNiveauService.updateCompUtil(utilisateur, comp, niveau);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;
	}

	@Override
	public List<CompetenceDTO> readListeUtilComp(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, DAOException,
			ServiceException {
		
		List<CompetenceDTO>listeUtilComp=new ArrayList<CompetenceDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeUtilComp= competenceNiveauService
				.readListeUtilComp(competenceDto);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeUtilComp;
	}

	@Override
	public int createCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {
		
		int createNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = competenceNiveauService.createCompetence(competenceDto);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;
	

	}

	@Override
	public int updateCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {
		
       int updateNum = 0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = competenceNiveauService.updateCompetence(competenceDto);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;
	
	}

	@Override
	public int deleteCompetence(CompetenceDTO competenceDto)
			throws TransactionalConnectionException, ServiceException {
		   
		int deleteNum = 0;
			if (caller == null) {
				beginTransactionalConnexion();
			} else {
				putInTransaction(caller);
			}
			deleteNum = competenceNiveauService.deleteCompetence(competenceDto);
			if (caller == null) {
				endTransactionalConnexion();
			} else {
				putOffTransaction();
			}
			return deleteNum;
		
		
	}

	@Override
	public List<NiveauDTO> readAllNomNiveau()
			throws TransactionalConnectionException, ServiceException {
		
		List<NiveauDTO> listeNiveau = new ArrayList<NiveauDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listeNiveau = competenceNiveauService
				.readAllNomNiveau();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listeNiveau;
	}

	}



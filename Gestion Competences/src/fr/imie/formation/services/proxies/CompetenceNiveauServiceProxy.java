package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

}

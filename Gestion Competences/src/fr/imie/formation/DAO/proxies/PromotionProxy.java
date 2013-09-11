package fr.imie.formation.DAO.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DAO.PromotionDAO;
import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DAO.interfaces.IPromotionDAO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class PromotionProxy implements IPromotionDAO {

	PromotionDAO promotionDAO;
	ITransactional caller = null;

	public PromotionProxy(PromotionDAO promotionDAO, ITransactional caller) {
		super();
		this.caller = caller;
		this.promotionDAO = promotionDAO;
	}

	public PromotionProxy(PromotionDAO promotionDAO) {

		this.promotionDAO = promotionDAO;
	}

	@Override
	public Connection getConnection() {

		return promotionDAO.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {
		promotionDAO.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		promotionDAO.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {
		promotionDAO.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {
		promotionDAO.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		promotionDAO.beginTransactionalConnexion();

	}

	@Override
	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, DAOException {

		List<PromotionDTO> listePromo= new ArrayList<PromotionDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listePromo = promotionDAO.readAllPromotion();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listePromo;

	}

	@Override
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {
		
		int createNum = 0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = promotionDAO.createPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;
	
		
	}

	@Override
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {
		int updateNum=0;
		
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		updateNum = promotionDAO.createPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return updateNum;
	}

	@Override
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {
		int deleteNum=0;
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		deleteNum = promotionDAO.createPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return deleteNum;
	}

	@Override
	public PromotionDTO readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, DAOException {
		
		PromotionDTO promotion = new PromotionDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		promotion = promotionDAO.readPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		
		return promotion;
	}

}

package fr.imie.formation.services.proxies;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.services.PromotionService1;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.transactionalFramework.ITransactional;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

public class PromotionService1Proxy implements IPromotionService {

	private PromotionService1 promotionService1;

	ITransactional caller = null;

	public PromotionService1Proxy(PromotionService1 promotionService1,
			ITransactional caller) {
		super();
		this.promotionService1 = promotionService1;
		this.caller = caller;
	}

	@Override
	public Connection getConnection() {

		return promotionService1.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {

		promotionService1.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {

		promotionService1.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {

		promotionService1.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {

		promotionService1.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {

		promotionService1.beginTransactionalConnexion();

	}

	@Override
	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, ServiceException {

		List<PromotionDTO> listePromo = new ArrayList<PromotionDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listePromo = promotionService1.readAllPromotion();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listePromo;
	}

	@Override
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		int createNum = 0;

		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = promotionService1.createPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;

	}

	@Override
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		int createNum = 0;

		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = promotionService1.deletePromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;

	}

	@Override
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {

		int createNum = 0;

		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		createNum = promotionService1.updatePromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return createNum;

		
		
	}

	@Override
	public PromotionDTO readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		
		PromotionDTO promotion = new PromotionDTO();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		promotion = promotionService1.readPromotion(promo);
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return promotion;
	
		
	}

}

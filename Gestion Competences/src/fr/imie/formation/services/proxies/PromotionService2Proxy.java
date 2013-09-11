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

public class PromotionService2Proxy implements IPromotionService {

	private PromotionService1 promotionService2;

	ITransactional caller = null;

	public PromotionService2Proxy(PromotionService1 promotionService2,
			ITransactional caller) {
		super();
		this.promotionService2 = promotionService2;
		this.caller = caller;
	}

	@Override
	public Connection getConnection() {

		return promotionService2.getConnection();
	}

	@Override
	public void setConnection(Connection connection) {

		promotionService2.setConnection(connection);

	}

	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {

		promotionService2.putInTransaction(transactional);

	}

	@Override
	public void putOffTransaction() {

		promotionService2.putOffTransaction();

	}

	@Override
	public void endTransactionalConnexion() {

		promotionService2.endTransactionalConnexion();

	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {

		promotionService2.beginTransactionalConnexion();

	}

	@Override
	public List<PromotionDTO> readAllPromotion()
			throws TransactionalConnectionException, ServiceException {

		List<PromotionDTO> listePromotion = new ArrayList<PromotionDTO>();
		if (caller == null) {
			beginTransactionalConnexion();
		} else {
			putInTransaction(caller);
		}
		listePromotion = promotionService2.readAllPromotion();
		if (caller == null) {
			endTransactionalConnexion();
		} else {
			putOffTransaction();
		}
		return listePromotion;
	}

	@Override
	public int createPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PromotionDTO readPromotion(PromotionDTO promo)
			throws TransactionalConnectionException, ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}

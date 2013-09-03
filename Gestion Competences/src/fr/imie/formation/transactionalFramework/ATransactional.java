package fr.imie.formation.transactionalFramework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;

//Classe abstraite qui met en commun une ouverture et fermeture de connection pour toutes ses sous-classes
public abstract class ATransactional implements ITransactional {

	private Connection connection;
	private Boolean transactionalInitiator = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.connectionFramework.IService#getConnection()
	 */
	@Override
	public Connection getConnection() {
		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.imie.connectionFramework.IService#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private Connection openConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			if (connection == null) {
				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/imie", "postgres",
						"postgres");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IAbstractDAO#putInTransaction(org.imie.DAO.AbstractDAO)
	 */
	@Override
	public void putInTransaction(ITransactional transactional)
			throws TransactionalConnectionException {
		if (transactionalInitiator != null) {
			throw new TransactionalConnectionException("");
		}
		this.connection = transactional.getConnection();
		this.transactionalInitiator = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.DAO.IAbstractDAO#putOffTransaction()
	 */
	@Override
	public void putOffTransaction() {
		this.connection = null;
		this.transactionalInitiator = null;
	}

	@Override
	public void beginTransactionalConnexion()
			throws TransactionalConnectionException {
		System.out.println("$$$$$$$$$$$$ debut transaction "
				+ this.getClass().getName());
		if (transactionalInitiator != null) {
			if (transactionalInitiator == true) {
				throw new TransactionalConnectionException(
						"en cours de connexion");
			} else if (transactionalInitiator == false) {
				System.out.println("$$$$$$$$$$$$ transaction exclave "
						+ this.getClass().getName());
				// rien à faire
			}
		} else {
			System.out.println("$$$$$$$$$$$$ creation transaction");
			transactionalInitiator = true;
			openConnection();
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void endTransactionalConnexion() {
		System.out.println("$$$$$$$$$$$$ fin transaction "
				+ this.getClass().getName());
		if (transactionalInitiator == true) {
			// libération des ressources
			try {
				if (connection != null) {
					System.out.println("$$$$$$$$$$$$ commit "
							+ this.getClass().getName());
					connection.commit();
				}
			} catch (SQLException e) {
				if (connection != null) {
					try {
						System.out.println("$$$$$$$$$$$$ rollback "
								+ this.getClass().getName());
						connection.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				transactionalInitiator = null;
			}

		}
	}

}

package fr.imie.formation.transactionalFramework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class TransactionInvocationHandler implements InvocationHandler {

	private ITransactional iService;
	private Connection connection;
	private ITransactional caller;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setCaller(ITransactional caller) {
		this.caller = caller;
	}

	public TransactionInvocationHandler(ITransactional iService) {
		super();
		this.iService = iService;
	}

	// @Override
	// public Object invoke(Object proxy, Method method, Object[] args) throws
	// Throwable {
	// Object retour=null;
	// System.out.println("debut methode service");
	// Boolean connectionToClose= false;
	// if (connection==null){
	// connectionToClose = true;
	// System.out.println("NEW connection");
	// // chargement du driver postgres dans la JVM
	// Class.forName("org.postgresql.Driver");
	// connection =
	// DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie",
	// "postgres", "postgres");
	// }
	// iService.setConnection(connection);
	//
	// try {
	//
	// retour = method.invoke(iService, args);
	// } finally {
	// // libération des ressources
	// try {
	// if (connectionToClose && connection != null) {
	// connection.close();
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// System.out.println("fin methode service");
	// return retour;
	// };

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object retour = null;
		System.out.println("debut methode service");
		// Boolean connectionToClose= false;
		// if (connection==null){
		// connectionToClose = true;
		// System.out.println("NEW connection");
		// // chargement du driver postgres dans la JVM
		// Class.forName("org.postgresql.Driver");
		// connection =
		// DriverManager.getConnection("jdbc:postgresql://localhost:5432/imie",
		// "postgres", "postgres");
		// }
		// iService.setConnection(connection);

		try {
			if (caller != null && caller.getConnection() != null) {
				iService.putInTransaction(caller);
			} else {
				iService.beginTransactionalConnexion();
			}
			retour = method.invoke(iService, args);
			if (caller != null) {
				iService.putOffTransaction();
			} else {
				iService.endTransactionalConnexion();
			}

		} finally {
			// // libération des ressources
			// try {
			// if (connectionToClose && connection != null) {
			// connection.close();
			// }
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

		}

		System.out.println("fin methode service");
		return retour;
	};

}

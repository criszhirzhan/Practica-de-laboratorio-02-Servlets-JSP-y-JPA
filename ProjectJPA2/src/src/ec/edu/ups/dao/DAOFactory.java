package src.ec.edu.ups.dao;

import src.ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
	return factory;
    }

    public abstract TelefonoDAO getTelefonoDAO();
    public abstract UsuarioDAO getUsuarioDAO();

}

package fr.univubs.inf1603.mahjong.dao;

/**
 * La classe <code>DAOException</code> régroupe les exceptions de la couche DAO.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.1.1
 */
public class DAOException extends Exception {

    /**
     * Constructeur avec le message d'erreur.
     *
     * @param message Message d'erreur.
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructeur avec la cause de l'erreur.
     *
     * @param throwable Cause de l'erreur.
     */
    public DAOException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Constructeur avec le message et la cause de l'erreur.
     *
     * @param message Message de l'erreur.
     * @param throwable Cause de l'erreur.
     */
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

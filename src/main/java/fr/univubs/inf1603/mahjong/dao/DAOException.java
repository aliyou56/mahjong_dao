
package fr.univubs.inf1603.mahjong.dao;


/**
 * La classe {@code DAOException} régroupe les exceptions de la couche DAO.
 * 
 * @author aliyou
 * @version 1.0.0
 */
public class DAOException extends Exception {
    
    /**
     * Constructeur avec le message
     * @param message Message
     */
    public DAOException(String message) {
        super(message);
    }
    
    /**
     * Constructeur avec la cause
     * @param throwable Cause
     */
    public DAOException(Throwable throwable) {
        super(throwable);
    }
    
    /**
     * Constructeur avec le message et la cause
     * @param message Message
     * @param throwable Cause
     */
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
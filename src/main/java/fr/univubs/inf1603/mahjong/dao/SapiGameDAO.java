package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.sapi.impl.SapiGame;
import java.util.List;

/**
 * L'interface {@code SapiGame} rajoute deux méthodes à l'interface {@code DAO}.
 * 
 * @author aliyou
 * @version 1.1.1
 */
public interface SapiGameDAO extends DAO<SapiGame> {

    /**
     * Rémonte les noms de tous les objets {@code SimpleGame} persistés depuis
     * la solution persistante.
     *
     * @return Noms de tous les objets {@code SimpleGame} persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<String> loadPersistedNames() throws DAOException;

    /**
     * Rémonte une partie de Mahjong à l'aide de son nom
     * 
     * @param gameName Nom d'une partie de Mahjong.
     * @return SapiGame.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public SapiGame find(String gameName) throws DAOException;
    
    /**
     * Persiste une vision simplifiée d'une partie de Mahjong {@code SimpleGame}.
     *
     * @param simpleGame Une vision simplifiée d'une partie de Mahjong {@code SimpleGame}
     * @param game Une partie de Mahjong
     * @throws DAOException s'il y'a une erreur lors de la persistance.
     */
//    public void save(SimpleGame simpleGame, Game game) throws DAOException;
    
    /**
     * Permet de passer la réference du SapiManager au DAO.
     * 
     * @param sapiManager Gestionnaire des Parties de Mahjong.
     */
//    public void setSapiManager(SapiManager sapiManager);
}
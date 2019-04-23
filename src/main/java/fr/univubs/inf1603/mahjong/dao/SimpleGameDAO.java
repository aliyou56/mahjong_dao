package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.game.Game;
import fr.univubs.inf1603.mahjong.sapi.SapiManager;
import fr.univubs.inf1603.mahjong.sapi.SimpleGame;
import java.util.List;

/**
 * Cette interface rajoute la méthode {@code loadPersistedNames} à l'interface
 * {@code DAO}.
 *
 * @author aliyou
 * @version 1.0.3
 */
public interface SimpleGameDAO extends DAO<SimpleGame> {

    /**
     * Rémonte les noms de tous les objets {@code SimpleGame} persistés depuis
     * la solution persistante.
     *
     * @return Noms de tous les objets {@code SimpleGame} persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<String> loadPersistedNames() throws DAOException;

    /**
     * Persiste un simple game.
     *
     * @param simpleGame Le simple Game
     * @param game La partie de mahjong
     * @throws DAOException s'il y'a une erreur lors de la persistance.
     */
    public void save(SimpleGame simpleGame, Game game) throws DAOException;
    
    /**
     * Permet de passer la réference du SapiManager au DAO.
     * 
     * @param sp SapiManager
     */
    public void setSapiManager(SapiManager sp);
}
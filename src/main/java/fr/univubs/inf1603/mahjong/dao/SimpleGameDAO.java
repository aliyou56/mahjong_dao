package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.game.Game;
import fr.univubs.inf1603.mahjong.sapi.SapiManager;
import fr.univubs.inf1603.mahjong.sapi.SimpleGame;
import java.util.List;

/**
 * Cette interface spécifie des méthodes pour la persistaence d'une vision simplifiée
 * d'une partie de Mahjong {@code SimpleGame}.
 *
 * @author aliyou
 * @version 1.1.0
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
     * Persiste une vision simplifiée d'une partie de Mahjong {@code SimpleGame}.
     *
     * @param simpleGame Une vision simplifiée d'une partie de Mahjong {@code SimpleGame}
     * @param game Une partie de Mahjong
     * @throws DAOException s'il y'a une erreur lors de la persistance.
     */
    public void save(SimpleGame simpleGame, Game game) throws DAOException;
    
    /**
     * Permet de passer la réference du SapiManager au DAO.
     * 
     * @param sapiManager Gestionnaire des Parties de Mahjong.
     */
    public void setSapiManager(SapiManager sapiManager);
}
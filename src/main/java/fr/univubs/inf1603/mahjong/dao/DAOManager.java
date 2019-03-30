package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.dao.fake_engine.Game;
import fr.univubs.inf1603.mahjong.dao.fake_engine.GameTile;
import fr.univubs.inf1603.mahjong.dao.fake_engine.Player;
import fr.univubs.inf1603.mahjong.dao.fake_engine.Zone;

/**
 * L'interface <code>DAOManager</code> gère l'ensemble des DAO. Elle spécifie
 * les méthodes qui permettent d'acceder aux DAO.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.0.0
 */
public interface DAOManager {

    /**
     * Rétourne l'instance du DAO qui gère les parties <code>Game</code>.
     *
     * @return L'instance du DAO qui gère les parties <code>Game</code>.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>GameDAO</code>.
     */
    public DAO<Game> getGameDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les zones <code>Zone</code>.
     *
     * @return L'instance du DAO qui gère les zonees <code>Zone</code>
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>ZoneDAO</code>.
     */
    public DAO<Zone> getZoneDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les tuiles <code>GameTile</code>.
     *
     * @return L'instance du DAO qui gère les tuiles <code>GameTile</code>.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>GameDAO</code>.
     */
    public DAO<GameTile> getTileDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les joueurs <code>Player</code>.
     *
     * @return L'instance du DAO qui gère les joueurs <code>Player</code>.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>PlayerDAO</code>.
     */
    public DAO<Player> getPlayerDao() throws DAOException;
}

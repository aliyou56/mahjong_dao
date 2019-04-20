package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.game.Game;
import fr.univubs.inf1603.mahjong.engine.game.GameTile;
import fr.univubs.inf1603.mahjong.engine.game.TileZone;
import fr.univubs.inf1603.mahjong.sapi.Player;

/**
 * L'interface <code>DAOManager</code> gère l'ensemble des DAO. Elle spécifie
 * les méthodes qui permettent d'acceder aux DAO.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.0.2
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
     * Rétourne l'instance du DAO qui gère les zones <code>TileZone</code>.
     *
     * @return L'instance du DAO qui gère les zones <code>TileZone</code>
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>ZoneDAO</code>.
     */
    public DAO<TileZone> getZoneDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les tuiles <code>GameTile</code>.
     *
     * @return L'instance du DAO qui gère les tuiles <code>GameTile</code>.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>GameDAO</code>.
     */
    public DAO<GameTile> getTileDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les simple games {@code SimpleGame}.
     *
     * @return L'instance du DAO qui gère les simple games {@code SimpleGame}.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation.
     */
    public SimpleGameDAO getSimpleGameDao() throws DAOException;
    
    /**
     * Rétourne l'instance du DAO qui gère les joueurs <code>Player</code>.
     *
     * @return L'instance du DAO qui gère les joueurs <code>Player</code>.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de
     * <code>PlayerDAO</code>.
     */
    public DAO<Player> getPlayerDao() throws DAOException;
}
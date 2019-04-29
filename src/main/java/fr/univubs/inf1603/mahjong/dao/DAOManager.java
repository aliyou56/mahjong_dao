package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.game.Game;
import fr.univubs.inf1603.mahjong.engine.game.GameTileInterface;
import fr.univubs.inf1603.mahjong.engine.game.TileZone;

/**
 * L'interface }@code DAOManager} gère l'ensemble des DAO. Elle spécifie
 * les méthodes qui permettent d'acceder aux DAO.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.1.2
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
    public DAO<GameTileInterface> getTileDao() throws DAOException;

    /**
     * Rétourne l'instance du DAO qui gère les objets {@code SapiGame}.
     *
     * @return L'instance du DAO qui gère les objets {@code SapiGame}.
     * @throws DAOException s'il y'a une erreur lors de l'instanciation.
     */
    public SapiGameDAO getSapiGameDao() throws DAOException;
    
}

package fr.univubs.inf1603.mahjong.dao;

//import fr.univubs.inf1603.mahjong.engine.AbstractTile;
import fr.univubs.inf1603.mahjong.engine.Zone;
import fr.univubs.inf1603.mahjong.sapi.Player;

/**
 * L'interface {@code DAOManager} gère l'ensemble des DAO. Elle spécifie les 
 * méthodes pour acceder aux DAO.
 * @author aliyou
 * @version 1.0.0
 */
public interface DAOManager {
    
    /**
     * Rétourne l'instance du DAO qui gère les parties {@code Game}.
     * @return  l'instance du DAO qui gère les parties {@code Game}
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de {@code GameDAO}
     */
    public DAO getGameDao() throws DAOException;
    
    /**
     * Rétourne l'instance du DAO qui gère les zones {@code Zone}.
     * @return  l'instance du DAO qui gère les zonees {@code Zone}
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de {@code ZoneDAO}
     */
    public DAO<Zone> getZoneDao() throws DAOException;
    
    /**
     * Rétourne l'instance du DAO qui gère les tuiles {@code AbstractTile}.
     * @return  l'instance du DAO qui gère les tuiles {@code AbstractTile}
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de {@code TileDAO}
     */
    public DAO<AbstractTile> getTileDao() throws DAOException;
    
    /**
     * Rétourne l'instance du DAO qui gère les joueurs {@code Player}.
     * @return  l'instance du DAO qui gère les  joueurs {@code Player}
     * @throws DAOException s'il y'a une erreur lors de l'instanciation de {@code PlayerDAO}
     */
    public DAO<Player> getPlayerDao() throws DAOException;
}

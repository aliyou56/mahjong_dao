
package fr.univubs.inf1603.mahjong.dao.fake_engine;

import fr.univubs.inf1603.mahjong.dao.Persistable;
import java.util.ArrayList;

/**
 *
 * @author aliyou
 */
public interface Zone extends Persistable {

    public String getName();
    
    /**
     * Returns the collection that contains the tiles
     *
     * @return tiles Tiles
     */
    public ArrayList<GameTile> getTilesCollection() ;
    
    /**
     * Returns the collection that contains the zones
     *
     * @return zones Zones
     */
    public ArrayList<Zone> getZonesCollection();

    /**
     * Allows to add a tile in the collection
     *
     * @param tile The tile we want to add
     * @return if the tile has been correctly added
     */
    public boolean addTile(GameTile tile);

    /**
     * Allows to remove a tile from the collection
     *
     * @param tile The tile we want to remove
     * @return if the tile has been correctly removed
     */
    public boolean removeTile(GameTile tile);

    /**
     * Allows to add a zone in the collection
     *
     * @param zone The zone we want to add
     * @return if the zone has been correctly added
     */
    public boolean addZone(Zone zone);

    /**
     * Allows to remove a zone in the collection
     *
     * @param zone The zone we want to remove
     * @return if the zone has been correctly removed
     */
    public boolean removeZone(Zone zone);
}

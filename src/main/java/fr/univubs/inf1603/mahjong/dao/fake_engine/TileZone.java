
package fr.univubs.inf1603.mahjong.dao.fake_engine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author aliyou
 */
public class TileZone implements Zone {

    private final PropertyChangeSupport pcs;
    
    private final UUID id;
    private final String name;
    private ArrayList<GameTile> tiles;
//    private ArrayList<Zone> zones;
    private ArrayList<Zone> zones;

    /**
     * The constructor of TileZone, the id is generate in the constructor
     *
     * @param name The name of the zone
     * @param tiles The collection of tiles contains in this zone (cannot be
     * null)
     * @param zones The collection of zones contains in this zone (can be null)
     */
    public TileZone(String name, ArrayList<GameTile> tiles, ArrayList<Zone> zones) {
        this(UUID.randomUUID(), name, tiles, zones); 
    }

    public TileZone(UUID uuid, String name, ArrayList<GameTile> tiles, ArrayList<Zone> zones) {
        this.id = uuid;
        this.name = name;

        if (tiles == null) {
            throw new IllegalArgumentException("The collection of tiles cannot be null.");
        }
        this.tiles = tiles;

//        this.zones = zones;
        this.pcs = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the collection that contains the tiles
     *
     * @return tiles Tiles
     */
    public ArrayList<GameTile> getTilesCollection() {
        return this.tiles;
    }

    /**
     * Returns the collection that contains the zones
     *
     * @return zones Zones
     */
    public ArrayList<Zone> getZonesCollection() {
        return this.zones;
    }

    /**
     * Returns the id of the TileZone
     *
     * @return id ID
     */
    @Override
    public UUID getUUID() {
        return this.id;
    }

    /**
     * Allows to add a tile in the collection
     *
     * @param tile The tile we want to add
     * @return if the tile has been correctly added
     */
    public boolean addTile(GameTile tile) {
        return this.tiles.add(tile);
    }

    /**
     * Allows to remove a tile from the collection
     *
     * @param tile The tile we want to remove
     * @return if the tile has been correctly removed
     */
    public boolean removeTile(GameTile tile) {
        return this.tiles.remove(tile);
    }

    /**
     * Allows to add a zone in the collection
     *
     * @param zone The zone we want to add
     * @return if the zone has been correctly added
     */
    public boolean addZone(Zone zone) {
        return this.zones.add(zone);
    }

    /**
     * Allows to remove a zone in the collection
     *
     * @param zone The zone we want to remove
     * @return if the zone has been correctly removed
     */
    public boolean removeZone(Zone zone) {
        return this.zones.remove(zone);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "TileZone{" + "id=" + id + ", name=" + name + ", tiles=" + tiles +", zones=" + zones + '}'; 
    }
    
}
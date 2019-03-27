
package fr.univubs.inf1603.mahjong.dao.myengine;

import fr.univubs.inf1603.mahjong.dao.MahJongObservable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;

/**
 *
 * @author aliyou
 */
public class GameTile implements MahJongObservable {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private final UUID uuid;
    private String category;
    private String family;
    
    public GameTile(UUID uuid, String category, String family) {
        this.uuid = uuid;
        this.category = category;
        this.family = family;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldValue = this.category;
        this.category = category;
        this.pcs.firePropertyChange("categorie", oldValue, category);
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        String oldValue = this.family;
        this.family = family;
        this.pcs.firePropertyChange("family", oldValue, family);
    }
 
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Tile{" + "uuid=" + uuid + ", category=" + category + ", family=" + family + '}';
    }
    
}

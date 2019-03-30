
package fr.univubs.inf1603.mahjong.dao.fake_engine;

import fr.univubs.inf1603.mahjong.dao.Persistable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author aliyou
 */
public class GameTile implements Persistable {

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.uuid);
        hash = 97 * hash + Objects.hashCode(this.category);
        hash = 97 * hash + Objects.hashCode(this.family);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameTile other = (GameTile) obj;
        if (!this.category.equals(other.category)) {
            return false;
        }
        if (!this.family.equals(other.family)) {
            return false;
        }
        if (this.uuid.compareTo(other.uuid) != 0) {
            return false;
        }
        return true;
    }
    
}

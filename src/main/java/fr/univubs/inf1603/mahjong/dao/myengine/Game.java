
package fr.univubs.inf1603.mahjong.dao.myengine;

import fr.univubs.inf1603.mahjong.dao.MahJongObservable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;

/**
 *
 * @author aliyou
 */
public class Game implements MahJongObservable {

    private final PropertyChangeSupport pcs;
    
    UUID uuid;
    Board board;
//    Move lastMove;
    
    Game(Board board) {
        this.uuid = UUID.randomUUID();
        this.board = board;
        this.pcs = new PropertyChangeSupport(this);
    }

    public UUID getUUID() {
        return uuid;
    }
    
    public Board getBoard() {
        return board;
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

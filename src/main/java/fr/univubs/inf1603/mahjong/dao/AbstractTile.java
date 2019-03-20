
package fr.univubs.inf1603.mahjong.dao;

import java.util.UUID;

/**
 * Juste pour tester.
 * PAS INCLUS DANS LE MODULE.
 * @author aliyou
 */
public interface AbstractTile {
    public UUID getUUID() ;

    public String getCategory() ;

    public String getFamily();
    
    public void setCategory(String category);

    public void setFamily(String family);
}

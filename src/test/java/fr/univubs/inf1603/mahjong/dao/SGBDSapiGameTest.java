
package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.daosgbd.SGBDDAOManager;

/**
 *
 * @author aliyou
 */
public class SGBDSapiGameTest extends AbstractSapiGameDAOTest {
    
    public SGBDSapiGameTest() throws DAOException {
        super(SGBDDAOManager.getInstance(0, rootDir.toString(), "testDB").getSapiGameDao());
    }
}

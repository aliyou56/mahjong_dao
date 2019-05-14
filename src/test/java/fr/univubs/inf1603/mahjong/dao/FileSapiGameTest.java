
package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.daofile.FileDAOManager;

/**
 *
 * @author aliyou
 */
public class FileSapiGameTest extends AbstractSapiGameDAOTest {
    
    public FileSapiGameTest() throws DAOException {
        super(FileDAOManager.getInstance(rootDir).getSapiGameDao());
    }
}

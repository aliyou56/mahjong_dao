package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.Wind;
import fr.univubs.inf1603.mahjong.engine.game.Game;
import fr.univubs.inf1603.mahjong.engine.game.GameException;
import fr.univubs.inf1603.mahjong.engine.game.MahjongBoard;
import fr.univubs.inf1603.mahjong.engine.game.MahjongGame;
import fr.univubs.inf1603.mahjong.engine.game.Move;
import fr.univubs.inf1603.mahjong.engine.game.TileZoneIdentifier;
import fr.univubs.inf1603.mahjong.engine.rule.GameRule;
import fr.univubs.inf1603.mahjong.engine.rule.GameRuleFactory;
import fr.univubs.inf1603.mahjong.engine.rule.RulesException;
import fr.univubs.inf1603.mahjong.sapi.Difficulty;
import fr.univubs.inf1603.mahjong.sapi.impl.SapiGame;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author aliyou
 */
public abstract class AbstractSapiGameDAOTest {

    /**
     * Logging
     */
    private static final Logger LOGGER = Logger.getLogger(AbstractSapiGameDAOTest.class.getName());

    SapiGameDAO dao;
    protected static Path rootDir;

    protected AbstractSapiGameDAOTest(SapiGameDAO dao) {
        System.out.println("AbstractSapiGameDAOTest");
        this.dao = dao;
    }

    /**
     * Préparation de l'envireonnement de test.
     */
    @BeforeClass
    public static void setUpClass() {
        rootDir = Paths.get("/tmp", "mahjong", "dao");
        if (!rootDir.toFile().exists()) {
            rootDir.toFile().mkdirs();
        }
        System.out.println(" \n **** rootDir : " + rootDir + " *****\n");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n *** deleting test files *** \n ");
        clean(rootDir.getParent());
    }

    /**
     * Supprime récurssivement les fichiers d'un repertoire.
     *
     * @param path Chemin du parent.
     */
    protected static void clean(Path path) {
        File pathFile = path.toFile();
        if (pathFile.isDirectory()) {
            for (File file : pathFile.listFiles()) {
                clean(file.toPath());
            }
        }
        System.out.print(pathFile.delete() ? "[OK] " : "[NOK] ");
        System.out.println(pathFile.getAbsolutePath());
    }

    /**
     * Test of save method, of class SapiGameDAO.
     */
    @Test
    public void testSave() {
        try {
            System.out.println("save");
            SapiGame sapiGame = new SapiGame("testSaveGame", Difficulty.SILLY, createGame(new UUID(0, 10)));
            dao.save(sapiGame);
            assertTest(sapiGame, dao.find(sapiGame.getName()));
            dao.delete(sapiGame);
        } catch (DAOException | RulesException | GameException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of loadPersistedNames method, of class SapiGameDAO.
     */
    @Test
    public void testLoadPersistedNames() {
        try {
            System.out.println("loadPersistedNames");

            assertEquals(new ArrayList<>(), dao.loadPersistedNames());

            String name1 = "loadPersistedNamesSapiGame1";
            String name2 = "loadPersistedNamesSapiGame2";
            String name3 = "loadPersistedNamesSapiGame3";
            SapiGame sapiGame1 = new SapiGame(name1, Difficulty.SILLY, createGame(new UUID(0, 20)));
            SapiGame sapiGame2 = new SapiGame(name2, Difficulty.HARD, createGame(new UUID(0, 21)));
            SapiGame sapiGame3 = new SapiGame(name3, Difficulty.HARD, createGame(new UUID(0, 19)));
            dao.save(sapiGame1);
            dao.save(sapiGame2);
            dao.save(sapiGame3);

            List<String> expResult = new ArrayList<>();
            expResult.add(name1);
            expResult.add(name2);
            expResult.add(name3);
            Collections.sort(expResult);
            List<String> result = dao.loadPersistedNames();
            Collections.sort(result);

            System.out.println("\nexpect : " + expResult);
            System.out.println("result : " + result + "\n");

            Assert.assertArrayEquals(expResult.toArray(), result.toArray());

            dao.delete(sapiGame1);
            dao.delete(sapiGame2);
            dao.delete(sapiGame3);
        } catch (DAOException | RulesException | GameException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of loadPersistedUUIDs method, of class SapiGameDAO.
     */
    @Test
    public void testLoadPersistedUUIDs() {
        try {
            System.out.println("loadPersistedUUIDs");

            assertEquals(new ArrayList<>(), dao.loadPersistedUUIDs());

            UUID id1 = new UUID(0, 31);
            UUID id2 = new UUID(0, 32);
            UUID id3 = new UUID(0, 29);
            SapiGame sapiGame1 = new SapiGame("testLoadPersistedUUIDsGame1", Difficulty.MEDIUM, createGame(id1));
            SapiGame sapiGame2 = new SapiGame("testLoadPersistedUUIDsGame2", Difficulty.HARD, createGame(id2));
            SapiGame sapiGame3 = new SapiGame("testLoadPersistedUUIDsGame3", Difficulty.SILLY, createGame(id3));
            dao.save(sapiGame1);
            dao.save(sapiGame2);
            dao.save(sapiGame3);

            List<UUID> expResult = new ArrayList<>();
            expResult.add(id1);
            expResult.add(id2);
            expResult.add(id3);
            Collections.sort(expResult);
            List<UUID> result = dao.loadPersistedUUIDs();
            Collections.sort(result);

            System.out.println("\nexpect : " + expResult);
            System.out.println("result : " + result + "\n");

            Assert.assertArrayEquals(expResult.toArray(), result.toArray());

            dao.delete(sapiGame1);
            dao.delete(sapiGame2);
            dao.delete(sapiGame3);
        } catch (DAOException | RulesException | GameException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
    protected void assertTest(SapiGame sp1, SapiGame sp2) throws GameException {
        assertEquals(sp1.getUUID(), sp2.getUUID());
        assertEquals(sp1.getName(), sp2.getName());
        assertEquals(sp1.getSurrenderDifficulty(), sp2.getSurrenderDifficulty());
        Game game1 = sp1.getGame();
        Game game2 = sp2.getGame();
        Assert.assertEquals(game1.getUUID(), game1.getUUID());
        Assert.assertEquals(game1.getCurrentwind(), game2.getCurrentwind());
        Assert.assertEquals(game1.getPlayingTime(), game2.getPlayingTime());
        Assert.assertEquals(game1.getStealingTime(), game2.getStealingTime());
        Assert.assertEquals(game1.getRule().getName(), game2.getRule().getName());
        StringBuilder sb = new StringBuilder();
        Wind[] w1 = game1.getPlayerWinds();
        Wind[] w2 = game2.getPlayerWinds();
        Assert.assertArrayEquals(game1.getPlayerWinds(), game2.getPlayerWinds());
        Assert.assertArrayEquals(game1.getAllPlayerPoints(), game2.getAllPlayerPoints());
        Assert.assertTrue(game1.getLastPlayedMove().isEqual(game2.getLastPlayedMove()));
        sb.append("\n game1 \t\t game2");
        for (int i = 0; i < w1.length; i++) {
            sb.append("\n ").append(w1[i]).append(" \t\t ").append(w2[i]);
        }
        sb.append("\n");
    }

    private MahjongGame createGame(UUID gameID) throws RulesException, GameException {
        GameRuleFactory ruleFactory = new GameRuleFactory();
        GameRule rule = ruleFactory.create("INTERNATIONAL");
        MahjongBoard board = rule.getBoardRule().distributeTiles(rule.getBoardRule().buildWall());
        HashMap<Integer, TileZoneIdentifier> path = new HashMap<>();
        path.put(2, TileZoneIdentifier.Wall);
        HashMap<Integer, Boolean> publicalyVisible = new HashMap<>();
        publicalyVisible.put(2, true);
        Move lastPlayedMove = new Move(Wind.WEST, 0, path, publicalyVisible);
        int[] playerPoints = {4, 8, 16, 32};
        Wind[] playerWind = Wind.values();

        MahjongGame game = new MahjongGame(rule, board, lastPlayedMove, Duration.ofMillis(4000), Duration.ofMillis(4000),
                playerPoints, gameID, playerWind);
        return game;
    }

}

package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.sapi.impl.SapiGame;
import java.util.List;
import java.util.UUID;

/**
 * L'interface {@code SapiGameDAO} spécifie les méthodes du {@code DAO} gérant
 * la persistance des objets {@code SapiGame}.
 *
 * @author aliyou
 * @version 1.2.0
 */
public interface SapiGameDAO extends DAO<SapiGame> {

    /**
     * Rémonte les noms de l'ensemble des parties de Mahjong persistés depuis la
     * solution persistante.
     *
     * @return Liste des noms des parties de Mahjong persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<String> loadPersistedNames() throws DAOException;

    /**
     * Renvoie la liste des identifiants des parties persistées.
     * @return Liste des identifiants des parties persistées.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<UUID> loadPersistedUUIDs() throws DAOException;
    
    /**
     * Rémonte une partie de Mahjong, depuis la solution de persistance,
     * rétrouvée à l'aide de son nom.
     *
     * @param gameName Nom d'une partie de Mahjong à remonter. NE DOIT PAS ETRE
     * NULL.
     * @return l'objet {@code SapiGame} contenant la partie de Mahjong.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public SapiGame find(String gameName) throws DAOException;

    /**
     * Supprime une partie de Mahjong de la solution de persistance rétrouvée à
     * l'aide de son nom.
     *
     * @param gameName Nom de la partie de Mahjong à supprimer. NE DOIT PAS ETRE
     * NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    default public void delete(String gameName) throws DAOException {
        if (gameName == null) {
            throw new DAOException("gameName == null");
        }
        SapiGame game = find(gameName);
        if (game != null) {
            delete(game);
        }
    }

}

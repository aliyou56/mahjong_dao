package fr.univubs.inf1603.mahjong.dao;

import java.util.List;
import java.util.UUID;

/**
 * L'Interface <code>DAO</code> specifie les méthodes d'accès aux données.
 *
 * @author aliyou
 * @version 1.0.0
 * @param <T> Objet à persister
 */
public interface DAO<T extends MahJongObservable> {

    /**
     * Persiste un object T dans la solution de persistance.
     *
     * @param object Objet à persister. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la persistance.
     */
    public void save(T object) throws DAOException;

    /**
     * Rétourne un objet T persisté à l'aide de son identifiant
     * <code>UUID</code>.
     *
     * @param objectID Identifiant de l'objet à retrouver. NE DOIT PAS ETRE
     * NULL.
     * @return L'objet persisté s'il est rétrouvé sinon <code>null</code>.
     * @throws DAOException s'il y'a une erreur lors de la recherche.
     */
    public MahJongObservable find(UUID objectID) throws DAOException;

    /**
     * Retire un objet T persisté de la solution de persistance.
     *
     * @param object Objet persisté à retirer. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    public void delete(T object) throws DAOException;

    /**
     * Retire un objet T persisté de la solution de persistance à l'aide de son
     * identifiant <code>UUID</code>.
     *
     * @param objectID Identifiant de l'objet persisté à retirer. NE DOIT PAS
     * ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    public void delete(UUID objectID) throws DAOException;

    /**
     * Rétourne l'ensemble des objets T persistés dans la solution de
     * persistance.
     *
     * @return Liste de tous les objets T persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<T> findAll() throws DAOException;
}

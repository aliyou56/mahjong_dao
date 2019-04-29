package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.persistence.Persistable;
import java.util.List;
import java.util.UUID;

/**
 * L'Interface {@code DAO} specifie les méthodes d'accès aux données.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.1.2
 * @param <T> Objet {@code T} à persister.
 */
public interface DAO<T extends Persistable> {

    /**
     * Persiste un object {@code T} dans la solution de persistance.
     *
     * @param object Objet {@code T} à persister. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la persistance.
     */
    public void save(T object) throws DAOException;

    /**
     * Rémonte un objet {@code T} persisté retrouvé à l'aide de son
     * identifiant {@code UUID}.
     *
     * @param objectID Identifiant de l'objet à retrouver. NE DOIT PAS ETRE
     * NULL.
     * @return L'objet {@code T} persisté s'il est rétrouvé sinon
     * {@code null}.
     * @throws DAOException s'il y'a une erreur lors de la recherche.
     */
    public T find(UUID objectID) throws DAOException;

    /**
     * Retire un objet {@code T} persisté de la solution de persistance.
     *
     * @param object Objet {@code T} persisté à retirer. NE DOIT PAS ETRE
     * NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    public void delete(T object) throws DAOException;

    /**
     * Retire un objet {@code T} persisté de la solution de persistance à
     * l'aide de son identifiant {@code UUID}.
     *
     * @param objectID Identifiant de l'objet {@code T} persisté à retirer.
     * NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    public void delete(UUID objectID) throws DAOException;

    /**
     * Rémonte l'ensemble des objets {@code T} persistés dans la solution
     * de persistance.
     *
     * @return Liste de tous les objets {@code T} persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<T> findAll() throws DAOException;
}
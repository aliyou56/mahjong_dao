
package fr.univubs.inf1603.mahjong.dao;

import java.util.List;
import java.util.UUID;

/**
 * L'Interface DAO specifie les méthodes d'accès aux données.
 * 
 * @author aliyou
 * @version 1.0.0
 * @param <T> Objet à persister
 */
public interface DAO<T> {
    
    /**
     * Persiste un object T dans la solution de persistance.
     * @param object Objet à persister. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la persistance
     */
    public void save(T object) throws DAOException;
    
    /**
     * Rétourne un objet T persisté à l'aide de son identifiant ({@code uuid}).
     * @param uuid Identifiant de l'objet à retrouver. NE DOIT PAS ETRE NULL.
     * @return L'objet persisté s'il est rétrouvé sinon {@code null}
     * @throws DAOException s'il y'a une erreur lors de la recherche
     */
    public T find(UUID uuid) throws DAOException;
    
    /**
     * Retire un objet T persisté de la solution de persistance.
     * @param object Objet persisté à retirer. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression
     */
    public void delete(T object) throws DAOException;
    
    /**
     * Retire un objet T persisté de la solution de persistance à l'aide de son
     * identifiant.
     * @param uuid Identifiant de l'objet persisté à retirer. NE DOIT PAS ETRE NULL.
     * @throws DAOException s'il y'a une erreur lors de la suppression
     */
    public void delete(UUID uuid) throws DAOException;
    
    /**
     * Rétourne l'ensemble des objets T persistés
     * @return Liste de tous les objets T persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    public List<T> findAll() throws DAOException;
}

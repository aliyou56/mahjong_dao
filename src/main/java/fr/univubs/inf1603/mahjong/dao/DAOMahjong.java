package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.engine.persistence.Persistable;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * Cette classe générique répresente l'interface générale pour la gestion des
 * objets dans la solution de persistance. Elle définit les méthodes d'accès aux
 * données. Les objets montés en mémoire sont rangés dans un tableau associatif
 * ayant comme clé l'identifiant <code>UUID</code>.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.2.0
 * @param <T> Objet <code>T</code> à persister.
 */
public abstract class DAOMahjong<T extends Persistable> implements DAO<T> {

    /**
     * Tableau associatif contenant les objets <code>T</code> en mémoire.
     */
    protected final WeakHashMap<UUID, T> map;

    /**
     * Constructeur vide.
     */
    protected DAOMahjong() {
        map = new WeakHashMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public void save(T object) throws DAOException {
        checkNotNull("object", object);
        UUID objectID = object.getUUID();
        if (find(objectID) == null) {
            map.put(objectID, object);
            writeToPersistence(object);
        } else {
            throw new DAOException("L'identifiant <" + objectID + "> existe déjà dans la solution de persistance.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public T find(UUID objectID) throws DAOException {
        checkNotNull("uuid", objectID);
        T found = map.get(objectID); 
        if (found == null) {
            found = loadFromPersistence(objectID);
            if (found != null) {
                map.put(objectID, found);
            }
        }
        return found;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public void delete(T object) throws DAOException {
        checkNotNull("object", object);
        deleteFromPersistence(object);
        if (map.containsValue(object)) {
            map.remove(object.getUUID());
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public void delete(UUID objectID) throws DAOException {
        checkNotNull("objectID", objectID);
        T object = find(objectID);
        if (object != null) {
            delete(object);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public List<T> findAll() throws DAOException {
        return laodAll();
    }

    /**
     * Vérifie si un objet est null ou pas. Lève une exception de type
     * <code>DAOException</code> si l'ojet est <code>null</code>.
     *
     * @param name Nom de l'objet à tester.
     * @param obj Objet à tester.
     */
    private void checkNotNull(String name, Object obj) throws DAOException {
        if (obj == null) {
            throw new DAOException(name + " == null");
        }
    }

    /**
     * Enregistre un objet <code>T</code> dans la solution de persistance.
     *
     * @param object Objet <code>T</code> à persister.
     * @throws DAOException s'il y'a une erreur lors de la sauvegarde.
     */
    protected abstract void writeToPersistence(T object) throws DAOException;

    /**
     * Charge un objet <code>T</code> retrouvé à l'aide de son identifiant
     * <code>objectID</code> depuis la solution de persistance
     *
     * @param objectID Identifiant de l'objet à retrouver.
     * @return L'objet T s'il est retrouvé sinon <code>null</code>.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    protected abstract T loadFromPersistence(UUID objectID) throws DAOException;

    /**
     * Supprime un objet <code>T</code> de la solution de persistance.
     *
     * @param object Objet <code>T</code> à supprimer.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    protected abstract void deleteFromPersistence(T object) throws DAOException;

    /**
     * Rétourne la liste de tous les objets <code>T</code> persistés dans la
     * solution de persistance.
     *
     * @return Liste de tous les objets <code>T</code> persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    protected abstract List<T> laodAll() throws DAOException;
}
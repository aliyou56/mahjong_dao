
package fr.univubs.inf1603.mahjong.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * La classe générique {@code DAOMahJong} est l'interface générale pour la gestion
 * des objets dans la solution de persistance. 
 * Elle définit les méthodes d'accès aux données.
 * Les objets montés en mémoire sont rangés dans un tableau associatif
 * ayant comme clé l'identifiant {@code UUID}. 
 * L'identifiant des objets gérés est récupéré par la réflexivité.
 * L'ajout et la suppression des écoutes sont également éffectués par la réflexivité.
 * 
 * LES OBJETS A PERSISTER DOIVENT AVOIR : 
 *      - UNE METHODE {@code getUUID()}
 *      - UNE METHODE {@code addPropertyChangeListener(PropertyChangeListener listener)}
 *      - UNE METHODE {@code removePropertyChangeListener(PropertyChangeListener listener)}
 * 
 * @author aliyou
 * @version 1.0.0
 * @param <T> Objet à persister
 */
public abstract class DAOMahJong<T> implements DAO<T> {
    
    /**
     * Tableau associatif contenant les objets T en mémoire.
     */
    protected final WeakHashMap<UUID, T> map;
    
    /**
     * Constructeur vide.
     */
    protected DAOMahJong() {
        map = new WeakHashMap();
    }
    
    /**
     * {@inheritDoc} 
     */
    @Override
    final public void save(T object) throws DAOException {
        object.getClass().getName();
        checkNotNull("save : object", object);
        UUID objectUUID = getObjectUUID(object);
        if (find(objectUUID) == null) {
            map.put(objectUUID, object);
            writeToPersistance(object);
        } else {
            throw new DAOException("Cet objet existe déjà dans la solution de persistance, uuid : " + objectUUID);
        }
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    final public T find(UUID uuid) throws DAOException {
        checkNotNull("find : uuid", uuid);
        T founded = map.get(uuid);
        if(founded == null) {
            founded = loadFromPersistance(uuid);
            if(founded != null) {
                map.put(uuid, founded);
            }
        }
        return founded;
    }
         
    /**
     * {@inheritDoc} 
     */
    @Override
    final public void delete(T object) throws DAOException {
        checkNotNull("delete : object", object);
        deleteFromPersistance(object);
        if (map.containsValue(object)) {
            UUID objectUUID = getObjectUUID(object);
            map.remove(objectUUID);
        }

    }
   
    /**
     * {@inheritDoc} 
     */
    @Override
    final public void delete(UUID uuid) throws DAOException {
        checkNotNull("delete : uuid", uuid);
        T object = find(uuid);
        if(object != null) {
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
     * Rétourne l'identifiant d'un objet T par la reflexivité. Cette méthode part
     * du principe que tous les objets à persister ont une méthode getUUID() qui
     * renvoie l'identifiant de l'objet en question.
     * 
     * @param object Objet
     * @return l'identifiant {@code UUID} de l'objet.
     * @throws ClassNotFoundException si la classe de l'objet n'eest pas trouvé.
     * @throws NoSuchMethodException si la méthode {code getUUID()} n'est pas trouvé
     * @throws IllegalArgumentException si le nombre d'argument est incorrect
     * @throws IllegalAccessException s'il ya un problème d'accès
     * @throws InvocationTargetException s'il ya un problème lors de l'invocation.
     */
    private UUID getObjectUUID(T object) throws DAOException {
        try {
            Class<?> cl = Class.forName(object.getClass().getName());
            Method method = cl.getDeclaredMethod("getUUID");
            return (UUID) method.invoke(object);
        } catch (ClassNotFoundException ex) {
            throw new DAOException("La classe n'a pas été trouvé" + ex.getMessage());
        } catch (NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            throw new DAOException("La méthode getUUID() n'a pas été trouvé" + ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new DAOException("Problème d'accès à la méthode getUUID()" + ex.getMessage());
        }
    }
    
    /**
     * Vérifie si un objet est null ou pas. Lève une exception de type 
     * {@code IllegalArgumentException} si l'ojet est {@code null}
     * @param name nom de l'objet à tester
     * @param obj Objet à tester
     */
    private void checkNotNull(String name, Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException(name + " == null");
        }
    }
    
   
    /**
     * Enregistre un objet T dans la solution de persistance.
     * @param object Objet à persister.
     * @throws DAOException s'il y'a une erreur lors de la sauvegarde.
     */
    protected abstract void writeToPersistance(T object) throws DAOException;
    
    /**
     * Charge un objet T depuis la solution de persistance à l'aide de son identifiant
     * @param uuid Identifiant de l'objet à retrouver.
     * @return L'objet T s'il est retrouvé sinon {@code null}
     * @throws DAOException s'il y'a une erreur lors du chargement
     */
    protected abstract T loadFromPersistance(UUID uuid) throws DAOException;
    
    /**
     * Supprimer un objet T de la solution de persistance.
     * @param object Objet à supprimer.
     * @throws DAOException s'il y'a une erreur lors de la suppression.
     */
    protected abstract void deleteFromPersistance(T object) throws DAOException;
    
    /**
     * Rétourne la liste de tous les objets T persistés.
     * @return Liste de tous les objets T persistés.
     * @throws DAOException s'il y'a une erreur lors du chargement.
     */
    protected abstract List<T> laodAll() throws DAOException;
}

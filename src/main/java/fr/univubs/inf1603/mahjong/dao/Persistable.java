
package fr.univubs.inf1603.mahjong.dao;

/**
 * Cette interface englobe les notions d'unicité et d'observable 
 * qui est basé sur la notion d'écoute des java beans. 
 *
 * TOUTES LES CLASSES QUI SONT A PERSISTER DOIVENT IMPLEMENTER CETTE INTERFACE.
 *
 * @author aliyou, faroud, louis, nesrine
 * @version 1.0.0
 */
public interface Persistable extends UniqueIdentifiable, MahJongObservable {
    
}

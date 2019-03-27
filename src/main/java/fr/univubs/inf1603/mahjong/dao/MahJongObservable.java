package fr.univubs.inf1603.mahjong.dao;

import java.beans.PropertyChangeListener;

/**
 * Cette interface définit la notion d'observable qui est basé sur la notion
 * d'écoute des java beans.
 *
 * TOUTES LES CLASSES QUI SONT A PERSISTER DOIVENT IMPLEMENTER CETTE INTERFACE.
 *
 * @author aliyou
 * @version 1.0.0
 */
public interface MahJongObservable extends UniqueIdentifiable {

    /**
     * Ajoute un nouvel écouteur.
     *
     * @param listener Ecouteur à rajouter.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * Supprime un écouteur.
     *
     * @param listener Ecouteur à supprimer.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener);
}

package fr.univubs.inf1603.mahjong.dao;

import fr.univubs.inf1603.mahjong.sapi.SimpleGame;
import java.util.List;

/**
 * Cette interface rajoute la méthode {@code loadPersistedNames} à l'interface
 * {@code DAO}. Le nom est certainement mal choisi ...
 *
 * @author aliyou
 * @param <T> Objet {@code T} à persister.
 */
public interface PersistedNameDAO<T extends SimpleGame> extends DAO<T> {

    /**
     * Rétourne les noms de tous les objets {@code SimpleGame} persistés depuis
     * la solution persistante.
     *
     * @return Noms tous les objets {@code SimpleGame}.
     */
    public List<String> loadPersistedNames();
}
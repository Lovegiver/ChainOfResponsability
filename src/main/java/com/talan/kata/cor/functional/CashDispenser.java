package com.talan.kata.cor.functional;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Définit une interface (fonctionnelle) générique ainsi qu'une fonction 'par défaut' qui
 * prendra en charge le chaînage des opérations en lieu et place d'un chaînage de constructeurs.<br>
 * @param <T> l'argument reçu et le résultat renvoyé sont de même type
 */
@FunctionalInterface
public interface CashDispenser<T> {

    /**
     * Calcule le nombre de billets d'une certaine valeur.<br>
     * @param t argument en entrée
     * @return la nouvelle base de calcul
     */
    @NotNull
    T dispenseCash(@NotNull T t);

    /**
     * Permet de chaîner plusieurs appels à la méthode {@link #dispenseCash(Object)}.<br>
     * @param after l'opération suivante
     * @return un objet {@link CashDispenser} à chaîner avec le précédent
     */
    @NotNull
    default CashDispenser<T> andThen(@NotNull CashDispenser<T> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.dispenseCash(dispenseCash(t));
    }

}

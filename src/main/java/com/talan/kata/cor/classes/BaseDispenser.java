package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Permet de centraliser le code commun → réduit le taux de duplication.<br>
 * Seule cette classe appelle le {@link DelegatedDispenser}.<br>
 * À l'exception du {@link DelegatedDispenser}, les classes-filles du {@link BaseDispenser} appelle
 * la méthode {@link #dispenseBucks(int)} de la classe-mère.<br>
 * La classe-mère instancie le DelegatedDispenser et appelle sa méthode {@link #dispenseBucks(int)}.<br>
 * Ça devient un peu tordu et moins lisible :)
 */
abstract class BaseDispenser implements MoneyDispenser {
    /** Etape suivante du traitement */
    final MoneyDispenser next;
    /** Valeur faciale du billet */
    final int buckValue;

    BaseDispenser(@NotNull MoneyDispenser next, int buckValue) {
        this.next = next;
        this.buckValue = buckValue;
    }

    /**
     * Traitement par défaut.
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        /* Réduit le code dupliqué en appliquant le traitement par défaut */
        DelegatedDispenser delegate = new DelegatedDispenser(this.next, this.buckValue);
        delegate.dispenseBucks(amount);
    }
}

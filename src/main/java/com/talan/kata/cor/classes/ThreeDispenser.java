package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Hérite de {@link MoneyDispenser}.
 * Accepte un argument NON NULL parce que NULL c'est le mal
 */
public class ThreeDispenser implements MoneyDispenser{

    private final MoneyDispenser next;

    private static final int BUCK_VALUE = 3;

    public ThreeDispenser(@NotNull MoneyDispenser next) {
        this.next = next;
    }

    /**
     * Distribue des billets de 3$ (certainement un faux-monnayeur)
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        /* Réduit le code dupliqué en appliquant le traitement par défaut */
        DelegatedDispenser delegate = new DelegatedDispenser(this.next, BUCK_VALUE);
        delegate.dispenseBucks(amount);
    }
}

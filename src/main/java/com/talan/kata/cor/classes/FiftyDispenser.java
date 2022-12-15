package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Hérite de {@link MoneyDispenser}.
 * Accepte un argument NON NULL parce que NULL c'est le mal
 */
public class FiftyDispenser implements MoneyDispenser{

    private final MoneyDispenser next;

    private final int buckValue = 50;

    public FiftyDispenser(@NotNull MoneyDispenser next) {
        this.next = next;
    }

    /**
     * Distribue des billets de 50$
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        DelegatedDispenser delegate = new DelegatedDispenser(this.next, this.buckValue);
        delegate.dispenseBucks(amount);
    }
}

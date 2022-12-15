package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Hérite de {@link MoneyDispenser}.
 * Accepte un argument NON NULL parce que NULL c'est le mal
 */
public class ThreeDispenser extends BaseDispenser {
    private static final int BUCK_VALUE = 20;

    public ThreeDispenser(@NotNull MoneyDispenser next) {
        super(next, BUCK_VALUE);
    }

    /**
     * Distribue des billets de 50$
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        super.dispenseBucks(amount);
    }
}

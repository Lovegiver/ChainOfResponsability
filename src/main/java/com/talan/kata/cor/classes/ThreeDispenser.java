package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Hérite de {@link MoneyDispenser}.
 * Accepte un argument NON NULL parce que NULL c'est le mal
 */
public class ThreeDispenser implements MoneyDispenser{

    private final MoneyDispenser next;

    private final int buckValue = 3;

    public ThreeDispenser(@NotNull MoneyDispenser next) {
        this.next = next;
    }

    /**
     * Distribue des billets de 3$ (certainement un faux-monnayeur)
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        int numberOfBucks = amount / this.buckValue;
        int remainingAmount = amount % this.buckValue;
        if (numberOfBucks > 0) {
            System.out.printf("Here are %d bucks of %d$\n", numberOfBucks, this.buckValue);
        }
        if (remainingAmount > 0) {
            next.dispenseBucks(remainingAmount);
        }
    }
}

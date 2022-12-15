package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Pour limiter la duplication du code, on centralise le code commun dans une classe unique.<br>
 * Cette implémentation de l'interface {@link MoneyDispenser} accepte un argument supplémentaire dans
 * son constructeur. Son utilisation n'est pas obligatoire, elle ne fait que proposer un traitement par défaut.
 */
class DelegatedDispenser implements MoneyDispenser {
    private final MoneyDispenser dispenser;
    private final int buckValue;

    public DelegatedDispenser(@NotNull MoneyDispenser dispenser, int buckValue) {
        this.dispenser = dispenser;
        this.buckValue = buckValue;
    }

    /**
     * Traitement par défaut.
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        int numberOfBucks = amount / buckValue;
        int remainingAmount = amount % buckValue;
        if (numberOfBucks > 0) {
            System.out.printf("Here are %d bucks of %d$\n", numberOfBucks, buckValue);
        }
        if (remainingAmount > 0) {
            dispenser.dispenseBucks(remainingAmount);
        }
    }
}

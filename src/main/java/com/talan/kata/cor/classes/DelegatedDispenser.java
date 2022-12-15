package com.talan.kata.cor.classes;

import org.jetbrains.annotations.NotNull;

/**
 * Pour limiter la duplication du code, on centralise le code commun dans une classe unique.<br>
 * Cette implémentation de l'interface {@link MoneyDispenser} accepte un argument supplémentaire dans
 * son constructeur. Son utilisation n'est pas obligatoire, elle ne fait que proposer un traitement par défaut.
 */
class DelegatedDispenser extends BaseDispenser {

    public DelegatedDispenser(@NotNull MoneyDispenser dispenser, int buckValue) {
        super(dispenser, buckValue);
    }

    /**
     * Traitement par défaut.
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        int numberOfBucks = amount / super.buckValue;
        int remainingAmount = amount % super.buckValue;
        if (numberOfBucks > 0) {
            System.out.printf("Here are %d bucks of %d$\n", numberOfBucks, super.buckValue);
        }
        if (remainingAmount > 0) {
            super.next.dispenseBucks(remainingAmount);
        }
    }
}

package com.talan.kata.cor.classes;

abstract class BaseDispenser implements MoneyDispenser {
    private final MoneyDispenser next;
    private final int buckValue;

    BaseDispenser(MoneyDispenser next, int buckValue) {
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

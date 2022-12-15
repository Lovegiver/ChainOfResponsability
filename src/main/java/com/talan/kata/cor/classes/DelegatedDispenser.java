package com.talan.kata.cor.classes;

class DelegatedDispenser implements MoneyDispenser {
    private final MoneyDispenser dispenser;
    private final int buckValue;

    public DelegatedDispenser(MoneyDispenser dispenser, int buckValue) {
        this.dispenser = dispenser;
        this.buckValue = buckValue;
    }

    /**
     * @param amount
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

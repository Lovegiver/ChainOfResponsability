package com.talan.kata.cor.classes;

/**
 * Cette classe peut sembler inutile, mais elle permet de boucler la boucle proprement
 * en évitant d'instancier une nouvelle classe (héritant de MoneyDispenser) à laquelle
 * on passerait un argument de type MoneyDispenser null.
 */
public class NullDispenser implements MoneyDispenser{

    // Aucune propriété

    /**
     * Ce constructeur est vide parce qu'il n'a vraiment rien à faire ;)
     */
    public NullDispenser() {
        // Pas d'injection de dépendance
    }

    /**
     * Passe ce qu'il reste par pertes et profits
     * @param amount Montant restant à servir
     */
    @Override
    public void dispenseBucks(int amount) {
        if (amount > 0) {
            System.out.printf("You've just lost %d$\n", amount);
        }
        System.out.println("That's all for now");
    }
}

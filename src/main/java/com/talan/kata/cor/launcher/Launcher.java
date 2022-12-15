package com.talan.kata.cor.launcher;

import com.talan.kata.cor.classes.FiftyDispenser;
import com.talan.kata.cor.classes.MoneyDispenser;
import com.talan.kata.cor.classes.NullDispenser;
import com.talan.kata.cor.classes.ThreeDispenser;
import com.talan.kata.cor.classes.TwentyDispenser;
import lombok.extern.java.Log;

@Log
public class Launcher {

    /**
     * Notre ami Yegor Bugayenko ("Elegant Objects") déteste à juste titre les classes et/ou méthodes :
     * <ol>
     *     <li>auxquelles l'on passe des arguments NULL</li>
     *     <li>qui renvoient NULL comme résultat</li>
     * </ol>
     * parce que cela oblige à faire des null checks de partout, rendant le code moins lisible et moins maintenable
     * ("All is about maintainability").<br>
     * Le truc est donc d'avoir recours à un "Null Pattern", c'est à dire un objet instancié, donc non null,
     * dont les éléments sont adaptés : pas de propriétés, constructeur vide, tout en respectant le contrat
     * de l'interface : sa méthode est bien appelée, mais ne calcule rien et n'appelle personne.
     * @param args no args
     */
    public static void main(String[] args) {

        final long start = System.currentTimeMillis();

        /*
         * C'est ici que l'on injecte les dépendances, aucun montant.
         * Noter la dernière dépendance qui implémente l'interface MoneyDispenser, comme les autres,
         * mais n'accepte aucun argument, contrairement aux autres qui valideront à la compilation la
         * non-nullité de l'objet reçu
         */
        MoneyDispenser moneyDispenser = new FiftyDispenser(
                new TwentyDispenser(
                        new ThreeDispenser(
                                new NullDispenser()
                        )
                )
        );
        moneyDispenser.dispenseBucks(2592);

        final long end = System.currentTimeMillis();

        log.info(String.format("Opération réalisée en %d ms%n", end-start));

    }
}

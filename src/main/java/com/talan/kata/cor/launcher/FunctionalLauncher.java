package com.talan.kata.cor.launcher;

import com.talan.kata.cor.functional.CashDispenser;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

@Log
public class FunctionalLauncher {

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();

        /*
         * Par souci de lisibilité, cette classe se voit déléguer les opérations à réaliser puisque seule
         * la valeur du billet diffère d'un appel à l'autre.
         * Elle permet de limiter la duplication du code.
         */
        class DelegatedCasher implements CashDispenser<Integer> {
            final int buxValue;

            DelegatedCasher(int buxValue) {
                if (buxValue <= 0) throw new IllegalArgumentException("Un billet a forcément une valeur positive");
                this.buxValue = buxValue;
            }

            /**
             * Calcul du nombre de billets à distribuer en fonction du montant reçu en argument.<br>
             * @param amount the amount to serve
             * @return the remaining amount
             */
            @Override
            @NotNull
            public Integer dispenseCash(@NotNull Integer amount) {
                final int buxNumber = amount / buxValue;
                final int remainingAmount = amount % buxValue;
                log.info(String.format("Voilà %d billets de %d$%n", buxNumber, buxValue));
                return remainingAmount;
            }
        }

        /* Calcule le nombre de billets de 50$ à distribuer */
        @NotNull
        CashDispenser<Integer> fiftyBux = amount -> {
            final int buxValue = 50;
            return new DelegatedCasher(buxValue).dispenseCash(amount);
        };
        /* Calcule le nombre de billets de 20$ à distribuer */
        @NotNull
        CashDispenser<Integer> twentyBux = amount -> {
            final int buxValue = 20;
            return new DelegatedCasher(buxValue).dispenseCash(amount);
        };
        /* Calcule le nombre de billets de 3$ à distribuer */
        @NotNull
        CashDispenser<Integer> threeBux = amount -> {
            final int buxValue = 3;
            return new DelegatedCasher(buxValue).dispenseCash(amount);
        };
        /* Affiche le montant perdu faute de billet adapté */
        @NotNull
        CashDispenser<Integer> endOperation = amount -> {
            log.info(String.format("Tu as perdu %d$%n", amount));
            return 0;
        };

        int solde = fiftyBux
                .andThen(twentyBux
                        .andThen(threeBux
                                .andThen(endOperation)
                        )
                )
                .dispenseCash(2592);

        log.info(String.format("Reste à distribuer : %d$%n", solde));

        final long end = System.currentTimeMillis();

        log.info(String.format("Opération réalisée en %d ms%n", end-start));

    }
}

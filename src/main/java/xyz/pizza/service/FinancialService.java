package xyz.pizza.service;

import java.math.BigDecimal;
import java.util.Optional;

public class FinancialService {

    /**
     * Calculates the charge amount
     */
    public static Optional<BigDecimal> chargeForPizza(Integer numOfPizza, BigDecimal price) {
        return Optional.ofNullable(numOfPizza)
                .filter(FinancialService::validateNumOfPizza)
                .map(number -> price.multiply(new BigDecimal(number)));
    }

    private static boolean validateNumOfPizza(Integer numOfPizza) {
        return numOfPizza >= 0;
    }
}

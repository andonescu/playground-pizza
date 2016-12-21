package xyz.pizza.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import xyz.pizza.entity.Pizza;

public class FinancialServiceTest {

    BigDecimal pricePerPizza = Pizza.PRICE;

    @Test
    public void chargeProperlyForThreePizza() {

        Integer numOfPizza = 3;

        Optional<BigDecimal> chargeOpt = FinancialService.chargeForPizza(numOfPizza, pricePerPizza);

        testChargeForTheGivenAmountOfPizza(numOfPizza, chargeOpt);
    }

    @Test
    public void chargeProperlyForOnePizza() {
        Integer numOfPizza = 1;

        Optional<BigDecimal> chargeOpt = FinancialService.chargeForPizza(numOfPizza, pricePerPizza);

        testChargeForTheGivenAmountOfPizza(numOfPizza, chargeOpt);
    }

    @Test
    public void chargeProperlyForZeroPizza() {
        Integer numOfPizza = 0;

        Optional<BigDecimal> chargeOpt = FinancialService.chargeForPizza(numOfPizza, pricePerPizza);

        testChargeForTheGivenAmountOfPizza(numOfPizza, chargeOpt);
    }

    @Test
    public void chargeProperlyForMinusOnePizza() {
        Integer numOfPizza = -1;

        Optional<BigDecimal> chargeOpt = FinancialService.chargeForPizza(numOfPizza, pricePerPizza);

        Assert.assertFalse(chargeOpt.isPresent());
    }

    private void testChargeForTheGivenAmountOfPizza(Integer numOfPizza, Optional<BigDecimal> chargeOpt) {
        Assert.assertTrue(chargeOpt.isPresent());
        Assert.assertEquals(pricePerPizza.multiply(new BigDecimal(numOfPizza)), chargeOpt.get());
    }
}
package xyz.pizza.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import xyz.pizza.entity.PizzaType;
import xyz.pizza.payment.CreditCard;
import xyz.pizza.payment.Transaction;

public class PizzaShopServiceChargeMultiplePizzasTest {

    @Test
    public void orderOnePizza() throws Exception {
        Optional<Transaction> transactionOpt = orderMargarita(1);

        Assert.assertTrue(transactionOpt.isPresent());
    }

    @Test
    public void orderZeroPizza() throws Exception {
        Optional<Transaction> transactionOpt = orderMargarita(0);

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    public void orderMinusOnePizza() throws Exception {
        Optional<Transaction> transactionOpt = orderMargarita(-1);

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    public void orderTenThousandsPizza() throws Exception {
        Optional<Transaction> transactionOpt = orderMargarita(10000);

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    public void orderMultipleNullPizza() throws Exception {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizzas(null, 3, new CreditCard());

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    public void orderNullMargaritaPizza() throws Exception {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizzas(PizzaType.Margarita, null,
                new CreditCard());

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    public void orderMargaritaWithNullCardPizza() throws Exception {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizzas(PizzaType.Margarita, 2,
                null);

        Assert.assertFalse(transactionOpt.isPresent());
    }

    @Test
    @Ignore
    public void orderPizzaWithoutSufficientMoneyOnTheAccount() throws Exception {
        Optional<Transaction> transactionOpt = orderMargarita(10);
        // TODO: order pizza without enough money

        Assert.assertFalse(transactionOpt.isPresent());
    }

    private Optional<Transaction> orderMargarita(Integer number) {
        return PizzaShopService.orderPizzas(PizzaType.Margarita, number, new CreditCard());
    }
}
package xyz.pizza.service;

import static xyz.pizza.service.util.PizzaOrderUtilsTest.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import xyz.pizza.entity.Pizza;
import xyz.pizza.entity.PizzaType;
import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;
import xyz.pizza.payment.CreditCard;
import xyz.pizza.payment.Transaction;

public class PizzaShopServiceCookMargaritaTest {

    final String MARGARITA = "Margarita";

    final CreditCard creditCardWithMoney = new CreditCard();

    @Test
    public void createMargarita() throws Exception {

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(PizzaType.Margarita, creditCardWithMoney);

        testTransactionIsOkWithASinglePizza(transactionOpt);
    }

    @Test
    public void createMargaritaWithProperIngredients() throws Exception {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(PizzaType.Margarita, creditCardWithMoney);

        Pizza pizza = testTransactionIsOkWithASinglePizza(transactionOpt);

        Ingredient[] margaritaIngredients = { new Tomatoes(), new Mozzarella() };

        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());
    }

    @Test
    public void tryToCreateUnknownPizza() {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(PizzaType.Custom, creditCardWithMoney);
        Assert.assertFalse(transactionOpt.isPresent());
    }

}
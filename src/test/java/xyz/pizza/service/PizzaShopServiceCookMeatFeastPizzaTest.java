package xyz.pizza.service;

import static xyz.pizza.service.util.PizzaOrderUtilsTest.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import xyz.pizza.entity.Pizza;
import xyz.pizza.entity.PizzaType;
import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.meat.Ham;
import xyz.pizza.entity.ingredients.meat.Salami;
import xyz.pizza.entity.ingredients.meat.Sausage;
import xyz.pizza.entity.ingredients.meat.SpicyBeef;
import xyz.pizza.payment.CreditCard;
import xyz.pizza.payment.Transaction;

public class PizzaShopServiceCookMeatFeastPizzaTest {

    final String MARGARITA = "Meat Feast";

    final CreditCard creditCardWithMoney = new CreditCard();

    @Test
    public void createMeatFeast() throws Exception {

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(PizzaType.MeatFeast, creditCardWithMoney);

        testTransactionIsOkWithASinglePizza(transactionOpt);
    }

    @Test
    public void createMargaritaWithProperIngredients() throws Exception {
        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(PizzaType.MeatFeast, creditCardWithMoney);

        Pizza pizza = testTransactionIsOkWithASinglePizza(transactionOpt);

        Ingredient[] margaritaIngredients = { new Ham(), new Salami(), new Sausage(), new SpicyBeef() };

        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());

    }

}
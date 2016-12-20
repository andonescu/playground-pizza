package xyz.pizza.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.meat.Ham;
import xyz.pizza.entity.ingredients.meat.Salami;
import xyz.pizza.entity.ingredients.meat.Sausage;
import xyz.pizza.entity.ingredients.meat.SpicyBeef;
import xyz.pizza.entity.ingredients.veggie.Mushrooms;
import xyz.pizza.entity.ingredients.veggie.Peppers;
import xyz.pizza.entity.ingredients.veggie.Sweetcorn;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;
import xyz.pizza.payment.CreditCard;
import xyz.pizza.payment.Transaction;

public class PizzaShopServiceTest {

    @Test
    public void orderPizzaWithoutCreditCard() throws Exception {
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );

        Optional<Transaction> transaction = PizzaShopService.orderPizza(ingredients, null);

        Assert.assertTrue(!transaction.isPresent());
    }

    @Test
    @Ignore("nice to have")
    public void orderTheSameIngredientsUsedInMargarita() throws Exception {
        String margaritaName = "Margarita";
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );
        CreditCard creditCardWithMoney = new CreditCard();

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(ingredients, creditCardWithMoney);

        Assert.assertTrue(transactionOpt.isPresent());

        Transaction transaction = transactionOpt.get();

        Assert.assertEquals(1, transaction.getOrder().size());
        Assert.assertEquals(margaritaName, transaction.getOrder().get(0).getName());
    }

    @Test
    @Ignore
    public void orderTheSameIngredientsUsedInMeatFeast() throws Exception {
        String meatFestName = "Meat Feast";
        List<Ingredient> ingredients = Arrays.asList(
                new Ham(), new Salami(), new Sausage(), new SpicyBeef()
        );
        CreditCard creditCardWithMoney = new CreditCard();

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(ingredients, creditCardWithMoney);

        Assert.assertTrue(transactionOpt.isPresent());

        Transaction transaction = transactionOpt.get();

        Assert.assertEquals(1, transaction.getOrder().size());
        Assert.assertEquals(meatFestName, transaction.getOrder().get(0).getName());
    }

    @Test
    @Ignore
    public void orderTheSameIngredientsUsedInVeggieFeast() throws Exception {
        String veggieFestName = "VeggieFeast";
        List<Ingredient> ingredients = Arrays.asList(
                new Mushrooms(),
                new Peppers(),
                new Sweetcorn(),
                new Tomatoes()
        );
        CreditCard creditCardWithMoney = new CreditCard();

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(ingredients, creditCardWithMoney);

        Assert.assertTrue(transactionOpt.isPresent());

        Transaction transaction = transactionOpt.get();

        Assert.assertEquals(1, transaction.getOrder().size());
        Assert.assertEquals(veggieFestName, transaction.getOrder().get(0).getName());
    }

    @Test
    public void ordersCustomPizza() throws Exception {
        String pizzaName = "Custom";
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );
        CreditCard creditCardWithMoney = new CreditCard();

        Optional<Transaction> transactionOpt = PizzaShopService.orderPizza(ingredients, creditCardWithMoney);

        Assert.assertTrue(transactionOpt.isPresent());

        Transaction transaction = transactionOpt.get();

        Assert.assertEquals(1, transaction.getOrder().size());
        Assert.assertEquals(pizzaName, transaction.getOrder().get(0).getName());
    }

}
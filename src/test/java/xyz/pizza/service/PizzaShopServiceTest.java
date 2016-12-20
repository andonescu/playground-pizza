package xyz.pizza.service;

import xyz.pizza.entity.Pizza;
import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.meat.Ham;
import xyz.pizza.entity.ingredients.meat.Salami;
import xyz.pizza.entity.ingredients.meat.Sausage;
import xyz.pizza.entity.ingredients.meat.SpicyBeef;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;
import org.junit.Assert;
import xyz.pizza.service.PizzaShopService;

import java.util.Arrays;
import java.util.List;

public class PizzaShopServiceTest {

    @org.junit.Test
    public void createPizza() throws Exception {
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );

        Pizza pizza = new PizzaShopService().orderPizza(ingredients);

        Assert.assertNotNull(pizza);
    }

    @org.junit.Test
    public void orderTheSameIngredientsUsedInMargarita() throws Exception {
        String margaritaName = "Margarita";
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );

        Pizza pizza = new PizzaShopService().orderPizza(ingredients);

        Assert.assertNotNull(pizza);
        Assert.assertEquals(margaritaName, pizza.getName());
    }

    @org.junit.Test
    public void orderTheSameIngredientsUsedInMeatFeast() throws Exception {
        String meatFestName = "Meat Feast";
        List<Ingredient> ingredients = Arrays.asList(
                new Ham(), new Salami(), new Sausage(), new SpicyBeef()
        );

        Pizza pizza = new PizzaShopService().orderPizza(ingredients);

        Assert.assertNotNull(pizza);
        Assert.assertEquals(meatFestName, pizza.getName());
    }


    @org.junit.Test
    public void orderTheSameIngredientsUsedInVeggieFeast() throws Exception {
        String veggieFestName = "VeggieFeast";
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );

        Pizza pizza = new PizzaShopService().orderPizza(ingredients);

        Assert.assertNotNull(pizza);
        Assert.assertEquals(veggieFestName, pizza.getName());
    }

    @org.junit.Test
    public void ordersCustomPizza() throws Exception {
        String pizzaName = "Custom";
        List<Ingredient> ingredients = Arrays.asList(
                new Tomatoes(),
                new Mozzarella()
        );

        Pizza pizza = new PizzaShopService().orderPizza(ingredients);

        Assert.assertNotNull(pizza);
        Assert.assertEquals(pizzaName, pizza.getName());
    }

}
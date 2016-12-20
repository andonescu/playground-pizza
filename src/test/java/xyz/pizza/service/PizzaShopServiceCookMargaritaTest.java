package xyz.pizza.service;

import xyz.pizza.entity.Pizza;
import xyz.pizza.entity.PizzaType;
import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;
import org.junit.Assert;
import org.junit.Test;
import xyz.pizza.service.PizzaShopService;

import java.util.Optional;

public class PizzaShopServiceCookMargaritaTest {

    final String MARGARITA = "Margarita";

    @Test
    public void createMargarita() throws Exception {

        Optional<Pizza> pizzaOpt = new PizzaShopService().orderPizza(PizzaType.Margarita);

        Assert.assertTrue(pizzaOpt.isPresent());

        Pizza pizza = pizzaOpt.get();

        Assert.assertEquals(2, pizza.getIngredients().size());

        // TODO: add list verification
        // validate that the pizzaOpt has only Tomatoes and Mozzarella
    }

    @Test
    public void createMargaritaWithProperIngredients() throws Exception {
        Optional<Pizza> pizzaOpt = new PizzaShopService().orderPizza(PizzaType.Margarita);
        Assert.assertTrue(pizzaOpt.isPresent());

        Pizza pizza = pizzaOpt.get();
        Assert.assertEquals(2, pizza.getIngredients().size());
        // TODO: add list verification
        // validate that the pizza has only Tomatoes and Mozzarella

        Ingredient[] margaritaIngredients = {new Tomatoes(), new Mozzarella()};

        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());

    }

    @Test
    public void createMargaritaWithProperIngredients_NotInTheSameOrder() throws Exception {
        Optional<Pizza> pizzaOpt = new PizzaShopService().orderPizza(PizzaType.Margarita);
        Assert.assertTrue(pizzaOpt.isPresent());

        Pizza pizza = pizzaOpt.get();
        Assert.assertEquals(2, pizza.getIngredients().size());
        // TODO: add list verification
        // validate that the pizza has only Tomatoes and Mozzarella

        Ingredient[] margaritaIngredients = {new Tomatoes(), new Mozzarella()};

//        ???
//        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());

    }

    @Test
    public void tryToCreateUnknownPizza() {
        Optional<Pizza> pizzaOpt = new PizzaShopService().orderPizza(PizzaType.Custom);
        Assert.assertFalse(pizzaOpt.isPresent());
    }

}
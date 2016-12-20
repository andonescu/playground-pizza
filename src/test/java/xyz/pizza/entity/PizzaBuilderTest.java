package xyz.pizza.entity;

import org.junit.Assert;
import org.junit.Test;

import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.meat.Ham;
import xyz.pizza.entity.ingredients.meat.Salami;
import xyz.pizza.entity.ingredients.meat.Sausage;
import xyz.pizza.entity.ingredients.meat.SpicyBeef;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;

public class PizzaBuilderTest {

    @Test
    public void createPizzaByTypeTest_Margarita() {
        Pizza pizza = PizzaBuilder.createPizzaByType(PizzaType.Margarita);

        testMargaritaPizza(pizza);
    }

    @Test
    public void createPizzaByType_MeatFeast() {
        Pizza pizza = PizzaBuilder.createPizzaByType(PizzaType.MeatFeast);

        testMeatFeastPizza(pizza);
    }

    private void testMargaritaPizza(Pizza pizza) {
        Assert.assertNotNull(pizza);

        Assert.assertEquals(2, pizza.getIngredients().size());

        Ingredient[] margaritaIngredients = { new Tomatoes(), new Mozzarella() };

        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());
    }

    private void testMeatFeastPizza(Pizza pizza) {
        Assert.assertNotNull(pizza);

        Assert.assertEquals(4, pizza.getIngredients().size());

        Ingredient[] margaritaIngredients = { new Ham(), new Salami(), new Sausage(), new SpicyBeef() };

        Assert.assertArrayEquals(margaritaIngredients, pizza.getIngredients().toArray());
    }

}
package xyz.pizza.entity;

import xyz.pizza.entity.ingredients.cheese.Mozzarella;
import xyz.pizza.entity.ingredients.meat.Ham;
import xyz.pizza.entity.ingredients.meat.Salami;
import xyz.pizza.entity.ingredients.meat.Sausage;
import xyz.pizza.entity.ingredients.meat.SpicyBeef;
import xyz.pizza.entity.ingredients.veggie.Tomatoes;

import java.util.Arrays;

public class PizzaBuilder {

    private static Pizza cookMargarita() {
        return new Pizza(
                Arrays.asList(new Tomatoes(), new Mozzarella()),
                "Margarita");
    }

    private static Pizza cookMeatFeast() {
        return new Pizza(
                Arrays.asList(new Ham(), new Salami(), new Sausage(), new SpicyBeef()),
                "Meat Feast");
    }

    public static Pizza createPizzaByType(PizzaType type) {
        switch (type) {
            case Margarita:
                return cookMargarita();
            case MeatFeast:
                return cookMeatFeast();
        }
        throw new RuntimeException();
    }

}

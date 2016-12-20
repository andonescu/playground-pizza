package xyz.pizza.entity;

import xyz.pizza.entity.ingredients.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public class Pizza {

    public static BigDecimal PRICE = BigDecimal.TEN;

    private final List<Ingredient> ingredients;

    private final String name;

    public Pizza(List<Ingredient> ingredients, String name) {
        this.ingredients = ingredients;
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                '}';
    }
}

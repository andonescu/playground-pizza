package xyz.pizza.entity.ingredients.cheese;

import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.IngredientType;


public abstract class AbstractCheese extends Ingredient {

    public AbstractCheese(String name) {
        super(name);
    }

    public IngredientType type() {
        return IngredientType.Cheese;
    }
}

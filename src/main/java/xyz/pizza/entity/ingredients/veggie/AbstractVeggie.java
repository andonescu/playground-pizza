package xyz.pizza.entity.ingredients.veggie;

import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.IngredientType;


public abstract class AbstractVeggie extends Ingredient {

    public AbstractVeggie(String name) {
        super(name);
    }

    public IngredientType type() {
        return IngredientType.Veggie;
    }
}

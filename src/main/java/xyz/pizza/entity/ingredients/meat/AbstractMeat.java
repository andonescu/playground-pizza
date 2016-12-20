package xyz.pizza.entity.ingredients.meat;

import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.entity.ingredients.IngredientType;


public abstract class AbstractMeat extends Ingredient {

    public AbstractMeat(String name) {
        super(name);
    }

    public IngredientType type() {
        return IngredientType.Meat;
    }
}

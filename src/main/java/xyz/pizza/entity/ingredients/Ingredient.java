package xyz.pizza.entity.ingredients;


public abstract class Ingredient {

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract IngredientType type();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return com.google.common.base.Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(name);
    }
}

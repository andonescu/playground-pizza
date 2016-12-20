package xyz.pizza.entity;

public enum PizzaType {
    Margarita("Margarita"), MeatFeast("Meat Feast"), VeggieFeast("Veggie Feast"), CheeseFeast("Cheese Feast"), Custom("Custom");

    private String desc;

    PizzaType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

package xyz.pizza.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import xyz.pizza.entity.Pizza;
import xyz.pizza.entity.PizzaBuilder;
import xyz.pizza.entity.PizzaType;
import xyz.pizza.entity.ingredients.Ingredient;
import xyz.pizza.payment.CreditCard;
import xyz.pizza.payment.Transaction;

public class PizzaShopService {

    /**
     * order {@link xyz.pizza.entity.Pizza} by a {@link java.util.List} of
     * {@link xyz.pizza.entity.ingredients.Ingredient}s
     */
    public static Pizza orderPizza(List<Ingredient> ingredients) {
        return new Pizza(ingredients, PizzaType.Custom.getDesc());
    }

    /**
     * order {@link xyz.pizza.entity.Pizza} by a {@link xyz.pizza.entity.PizzaType}
     * <br/>
     * available options:
     * <ul>
     * <li>{@link xyz.pizza.entity.PizzaType#Margarita}</li>
     * </ul>
     */
    public static Optional<Pizza> orderPizza(PizzaType type) {

        switch (type) {
            case Margarita:
                return Optional.of(PizzaBuilder.cookMargarita());
            default:
                return Optional.empty();
        }
    }

    /**
     * order {@link xyz.pizza.entity.Pizza} by
     *
     * @param type   {@link xyz.pizza.entity.PizzaType}
     * @param number number of pizzas
     * @param card   given the credit card
     * @return an {@link java.util.Optional} of {@link xyz.pizza.payment.Transaction} with what will be bought
     */
    public static Optional<Transaction> orderPizzas(PizzaType type, Integer number, CreditCard card) {

        // primitive validation
        // validation to see if we didn't received null data
        long validInputNum = Arrays.asList(Optional.ofNullable(type), Optional.ofNullable(number),
                Optional.ofNullable(card))
                .stream()
                .filter(o -> o.isPresent())
                .count();

        if (validInputNum == 3) {
            return checkPizzaNumberToCook(number).map(validatedNumber ->
                    new Transaction(
                            card,
                            Pizza.PRICE.multiply(new BigDecimal(validatedNumber)),
                            createPizzaBy(type, validatedNumber)
                    )

            );
        }

        return Optional.empty();
    }

    /**
     * The number of pizza purchased is limited
     */
    private static Optional<Integer> checkPizzaNumberToCook(Integer number) {
        return Optional.ofNullable(number).filter(n -> n > 0 && n < 100);
    }

    /**
     * For a given pizza type and number assemble a list of those items
     */
    private static List<Pizza> createPizzaBy(PizzaType type, Integer number) {
        List<Pizza> pizzas = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            pizzas.add(PizzaBuilder.createPizzaByType(type));
        }

        return pizzas;
    }

}


package xyz.pizza.payment;

import xyz.pizza.entity.Pizza;

import java.math.BigDecimal;
import java.util.List;

public class Transaction {

    private CreditCard creditCard;

    private BigDecimal amount;

    private List<Pizza> order;

    public Transaction(CreditCard creditCard, BigDecimal amount, List<Pizza> order) {
        this.creditCard = creditCard;
        this.amount = amount;
        this.order = order;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Pizza> getOrder() {
        return order;
    }
}

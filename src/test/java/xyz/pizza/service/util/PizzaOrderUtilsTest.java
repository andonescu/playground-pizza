package xyz.pizza.service.util;

import java.util.Optional;

import org.junit.Assert;

import xyz.pizza.entity.Pizza;
import xyz.pizza.payment.Transaction;

public class PizzaOrderUtilsTest {

    public static Pizza testTransactionIsOkWithASinglePizza(Optional<Transaction> transactionOpt) {
        Assert.assertTrue(transactionOpt.isPresent());

        Transaction transaction = transactionOpt.get();
        Assert.assertEquals(1, transaction.getOrder().size());

        return  transaction.getOrder().get(0);
    }
}

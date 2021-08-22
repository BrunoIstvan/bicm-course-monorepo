package br.com.bicmsystems.bicmpayroll.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentModelTest {

    @Test
    public void shouldAssertTrue_WhenPaymentIsCreatedUsingAllArgsConstructor() {

        PaymentModel model = new PaymentModel("user name", 200.00, 15);

        assertNotNull(model);
        assertEquals("user name", model.getName());
        assertEquals(200.00, model.getDailyIncome());
        assertEquals(15, model.getDays());
        assertEquals(3000.00, model.getTotal());

    }

    @Test
    public void shouldAssertTrue_WhenPaymentIsCreatedUsingNoArgsConstructor() {

        PaymentModel model = new PaymentModel();
        assertNotNull(model);
        model.setDays(15);
        model.setName("user name");
        model.setDailyIncome(200.00);
        assertEquals(15, model.getDays());
        assertEquals("user name", model.getName());
        assertEquals(200.00, model.getDailyIncome());
        assertEquals(3000.00, model.getTotal());

    }

}

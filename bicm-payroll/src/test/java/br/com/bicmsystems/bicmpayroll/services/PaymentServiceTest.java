package br.com.bicmsystems.bicmpayroll.services;

import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PaymentServiceTest {

    @TestConfiguration
    static class UserServiceConfiguration {
        @Bean
        public PaymentService getPaymentService() {
            return new PaymentService();
        }
    }

    @Autowired
    private PaymentService service;

    @Test
    public void shouldReturnAPaymentWithTotal_WhenValidWorkerIdAndDaysIsPassedIntoGetPaymentMethod() {

        PaymentModel model = new PaymentModel("user teste", 100.0, 20);

        // when(service.getPayment(any(), any())).thenReturn(model);

        PaymentModel result = service.getPayment(1L, 20);

        assertNotNull(result);
        assertEquals(result.getDailyIncome(), model.getDailyIncome());
        assertEquals(result.getName(), model.getName());
        assertEquals(result.getDays(), model.getDays());
        assertEquals(result.getTotal(), 2000.00);

    }

}

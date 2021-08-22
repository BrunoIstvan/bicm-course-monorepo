package br.com.bicmsystems.bicmpayroll.services;

import br.com.bicmsystems.bicmpayroll.clients.WorkerFeignClient;
import br.com.bicmsystems.bicmpayroll.config.WireMockConfig;
import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import br.com.bicmsystems.bicmpayroll.entities.WorkerModel;
import br.com.bicmsystems.bicmpayroll.exceptions.WorkerNotFoundException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static br.com.bicmsystems.bicmpayroll.client.WorkerMocks.setupMockWorkerResponse;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class PaymentServiceTest {

    @Autowired
    private WireMockServer mockWorkerService;

    @Autowired
    private WorkerFeignClient workerFeignClient;

    @Autowired
    private PaymentService service;

    @TestConfiguration
    static class PaymentServiceConfiguration {
        @Bean
        public PaymentService getPaymentService() {
            return new PaymentService();
        }
    }

    @BeforeEach
    void setUp() throws IOException {

    }

    @Test
    public void shouldReturnAPaymentWithTotal_WhenValidWorkerIdAndDaysIsPassedIntoGetPaymentMethod()
            throws IOException, WorkerNotFoundException {

        setupMockWorkerResponse(mockWorkerService,
                "/workers/1",
                HttpStatus.OK.value(),
                "payload/find-worker-by-id-1-response.json");

        final ResponseEntity<WorkerModel> response = workerFeignClient.findById(1L);
        PaymentModel model =
                new PaymentModel(
                        response.getBody().getName(),
                        response.getBody().getDailyIncome(),
                        20);

        PaymentModel result = service.getPayment(1L, 20);

        assertNotNull(result);
        assertEquals(result.getDailyIncome(), model.getDailyIncome());
        assertEquals(result.getName(), model.getName());
        assertEquals(result.getDays(), model.getDays());
        assertEquals(result.getTotal(), 3000.00);

    }

    @Test
    public void shouldThrowWorkerNotFoundException_WhenInvalidWorkerIdIsPassedIntoGetPaymentMethod()
            throws IOException, WorkerNotFoundException {

        setupMockWorkerResponse(mockWorkerService,
                "/workers/1000",
                HttpStatus.NOT_FOUND.value(),
                "payload/find-worker-by-id-1000-expected-not-found-response.json");

        assertThrows(WorkerNotFoundException.class, () -> {

            PaymentModel result = service.getPayment(1000L, 20);
            assertNull(result);

        });

    }

}

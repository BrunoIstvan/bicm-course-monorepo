package br.com.bicmsystems.bicmpayroll.controllers;

import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import br.com.bicmsystems.bicmpayroll.services.PaymentService;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@WebMvcTest
public class PaymentControllerTest {

    @Autowired
    private PaymentController controller;

    @MockBean
    private PaymentService service;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.controller);
    }

    @Test
    @DisplayName("GET /payments/100/days/10 200")
    public void shouldReturnPayment_WhenGetPaymentIsCalledWithValidWorkerIdAndDays() {

        PaymentModel model = new PaymentModel("usuario 1", 115.0, 10);
        when(service.getPayment(any(), any())).thenReturn(model);

        given()
            .accept(ContentType.JSON)
            .when()
                .get("/payments/100/days/10")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body("name", Matchers.equalTo("usuario 1"))
                .body("dailyIncome", Matchers.equalTo(115.0F))
                .body("days", Matchers.equalTo(10))
                .body("total", Matchers.equalTo(1150.F));

    }

}

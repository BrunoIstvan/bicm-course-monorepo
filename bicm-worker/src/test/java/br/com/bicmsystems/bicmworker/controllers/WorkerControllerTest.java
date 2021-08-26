package br.com.bicmsystems.bicmworker.controllers;

import br.com.bicmsystems.bicmworker.entities.WorkerModel;
import br.com.bicmsystems.bicmworker.repositories.WorkerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

@WebMvcTest
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class WorkerControllerTest {

    @Autowired
    private WorkerController controller;

    @MockBean
    private WorkerRepository repository;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.controller);
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    @DisplayName("GET /workers 200")
    public void shouldFindAllWorkers_WhenFindAllIsCalled() {

        WorkerModel w1 = new WorkerModel(null, "usuario 1", 100.0);
        WorkerModel w2 = new WorkerModel(null, "usuario 2", 200.0);
        WorkerModel w3 = new WorkerModel(null, "usuario 3", 300.0);
        List<WorkerModel> list = List.of(w1, w2, w3);
        when(repository.findAll()).thenReturn(list);

        given()
            .accept(ContentType.JSON)
            .when()
                .get("/workers")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("[0].name", Matchers.equalTo("usuario 1"))
                .body("[0].dailyIncome", Matchers.equalTo(100.0F))
                .body("[1].name", Matchers.equalTo("usuario 2"))
                .body("[1].dailyIncome", Matchers.equalTo(200F))
                .body("[2].name", Matchers.equalTo("usuario 3"))
                .body("[2].dailyIncome", Matchers.equalTo(300F));

    }

    @Test
    @DisplayName("GET /workers/100 200")
    public void shouldFindUser_WhenFindUsersIsCalledForAExistingUser() {

        WorkerModel w1 = new WorkerModel(100L, "usuario 1", 100.0);
        when(repository.findById(100L)).thenReturn(Optional.of(w1));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/workers/100")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("name", Matchers.equalTo("usuario 1"))
                .body("dailyIncome", Matchers.equalTo(100.0F));

    }

    @Test
    @DisplayName("GET /workers/100 - Not Found")
    public void shouldNotFindUser_WhenFindUsersIsCalledForANotExistingUser() {

        when(repository.findById(100L)).thenReturn(Optional.empty());

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/workers/100")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    @DisplayName("GET /workers/-1 - Bad Request")
    public void shouldReturnBadRequest_WhenFindUsersIsCalledWithNegativeId() {

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/workers/-1")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }

}

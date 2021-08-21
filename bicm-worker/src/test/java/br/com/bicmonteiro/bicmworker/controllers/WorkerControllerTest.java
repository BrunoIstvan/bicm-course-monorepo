package br.com.bicmonteiro.bicmworker.controllers;

import br.com.bicmonteiro.bicmworker.entities.WorkerModel;
import br.com.bicmonteiro.bicmworker.repositories.WorkerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

@WebMvcTest
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
    public void shouldFindAllWorkers_WhenFindAllIsCalled() throws Exception {

        WorkerModel w1 = new WorkerModel(null, "usuario 1", 100.3);
        WorkerModel w2 = new WorkerModel(null, "usuario 2", 103.3);
        WorkerModel w3 = new WorkerModel(null, "usuario 3", 130.3);
        List<WorkerModel> list = List.of(w1, w2, w3);
        when(repository.findAll()).thenReturn(list);

        given()
            .accept(ContentType.JSON)
            .when()
                .get("/workers")
                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat(response -> response.getResponse().getContentAsString().contains("usuario 1"));

    }

    @Test
    @DisplayName("GET /workers/100 200")
    public void shouldFindUser_WhenFindUsersIsCalledForAExistingUser() throws Exception {

        WorkerModel w1 = new WorkerModel(100L, "usuario 1", 100.3);
        when(repository.findById(100L)).thenReturn(Optional.of(w1));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/workers/100")
                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat(response -> response.getResponse().getContentAsString().contains("usuario 1"));

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

}

package br.com.bicmonteiro.bicmworker.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerModelTest {

    @Test
    public void shouldAssertTrue_WhenWorkerIsCreatedUsingAllArgsConstructor() {

        WorkerModel model = new WorkerModel(100L, "user name", 2000.00);

        assertNotNull(model);
        assertEquals(100L, model.getId());
        assertEquals("user name", model.getName());
        assertEquals(2000.00, model.getDailyIncome());

    }

}

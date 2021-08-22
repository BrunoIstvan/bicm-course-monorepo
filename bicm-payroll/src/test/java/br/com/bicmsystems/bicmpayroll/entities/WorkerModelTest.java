package br.com.bicmsystems.bicmpayroll.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WorkerModelTest {

    @Test
    public void shouldAssertTrue_WhenWorkerIsCreatedUsingAllArgsConstructor() {

        WorkerModel model = new WorkerModel(100L, "user name", 200.00);

        assertNotNull(model);
        assertEquals(100L, model.getId());
        assertEquals("user name", model.getName());
        assertEquals(200.00, model.getDailyIncome());

    }

    @Test
    public void shouldAssertTrue_WhenWorkerIsCreatedUsingNoArgsConstructor() {

        WorkerModel model = new WorkerModel();
        assertNotNull(model);
        model.setId(100L);
        model.setName("user name");
        model.setDailyIncome(200.00);
        assertEquals(100L, model.getId());
        assertEquals("user name", model.getName());
        assertEquals(200.00, model.getDailyIncome());

    }

}

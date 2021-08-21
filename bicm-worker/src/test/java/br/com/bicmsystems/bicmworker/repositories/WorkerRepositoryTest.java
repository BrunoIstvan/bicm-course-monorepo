package br.com.bicmsystems.bicmworker.repositories;

import br.com.bicmsystems.bicmworker.entities.WorkerModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class WorkerRepositoryTest {

    @Autowired
    private WorkerRepository repository;

    @Test
    public void shouldFindWorker_WhenSearchedById() {

        WorkerModel worker = new WorkerModel(null, "teste", 200.0);
        repository.save(worker);
        Optional<WorkerModel> found = repository.findById(worker.getId());
        assertTrue(found.isPresent());
        assertEquals(found.get().getId(), worker.getId());
        assertEquals(found.get().getName(), worker.getName());
        assertEquals(found.get().getDailyIncome(), worker.getDailyIncome());

    }

}

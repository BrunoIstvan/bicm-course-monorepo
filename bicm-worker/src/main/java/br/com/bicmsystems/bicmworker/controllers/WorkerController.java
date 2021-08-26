package br.com.bicmsystems.bicmworker.controllers;

import br.com.bicmsystems.bicmworker.entities.WorkerModel;
import br.com.bicmsystems.bicmworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Value("${test.config.server}")
    private String testConfigServer;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        if(id < 0)
            return ResponseEntity.badRequest().build();

        Optional<WorkerModel> found = repository.findById(id);
        if(found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
    }


    @GetMapping("/configs")
    public ResponseEntity<?> showConfig() {
        logger.info(testConfigServer);
        return ResponseEntity.ok(testConfigServer);
    }

}

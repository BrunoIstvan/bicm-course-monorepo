package br.com.bicmsystems.bicmpayroll.clients;

import br.com.bicmsystems.bicmpayroll.entities.WorkerModel;
import br.com.bicmsystems.bicmpayroll.exceptions.WorkerNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "bicm-worker", url = "${worker.service.url}", path = "workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<WorkerModel> findById(@PathVariable Long id) throws WorkerNotFoundException;

}



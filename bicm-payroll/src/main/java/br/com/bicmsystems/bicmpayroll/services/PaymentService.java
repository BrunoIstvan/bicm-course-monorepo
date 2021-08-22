package br.com.bicmsystems.bicmpayroll.services;

import br.com.bicmsystems.bicmpayroll.clients.WorkerFeignClient;
import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import br.com.bicmsystems.bicmpayroll.entities.WorkerModel;
import br.com.bicmsystems.bicmpayroll.exceptions.WorkerNotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;

    public PaymentModel getPayment(Long workerId, Integer days) throws WorkerNotFoundException {

        try {
            var response = client.findById(workerId);
            if(!response.getStatusCode().is2xxSuccessful()) {
                throw new WorkerNotFoundException("Worker not found");
            }
            WorkerModel worker = response.getBody();
            return new PaymentModel(worker.getName(), worker.getDailyIncome(), days);
        } catch (FeignException e) {
            throw new WorkerNotFoundException("Worker not found");
        }

    }

}

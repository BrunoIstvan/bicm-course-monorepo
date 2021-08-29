package br.com.bicmsystems.bicmpayroll.controllers;

import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import br.com.bicmsystems.bicmpayroll.exceptions.WorkerNotFoundException;
import br.com.bicmsystems.bicmpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId,
                                        @PathVariable Integer days)
            throws WorkerNotFoundException {
        if(workerId < 0 || days < 0)
            return ResponseEntity.badRequest().build();
        try {
            return ResponseEntity.ok(service.getPayment(workerId, days));
        } catch (WorkerNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> getPaymentAlternative(Long workerId, Integer days) {
        return new ResponseEntity("Infelizmente estamos com algum problema e já estamos atuando nisso",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

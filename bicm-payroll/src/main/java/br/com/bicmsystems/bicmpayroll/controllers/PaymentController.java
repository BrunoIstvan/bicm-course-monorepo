package br.com.bicmsystems.bicmpayroll.controllers;

import br.com.bicmsystems.bicmpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {

        if(workerId < 0 || days < 0)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(service.getPayment(workerId, days));

    }


}

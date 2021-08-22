package br.com.bicmsystems.bicmpayroll.services;

import br.com.bicmsystems.bicmpayroll.entities.PaymentModel;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentModel getPayment(Long workerId, Integer days) {
        return new PaymentModel("usuario 1", 115.0, days);
    }

}

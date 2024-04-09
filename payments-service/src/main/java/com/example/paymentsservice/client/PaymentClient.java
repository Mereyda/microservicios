package com.example.paymentsservice.client;

import com.example.paymentsservice.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {
    public Boolean createPayment(Payment payment) {
        //este scio ejecuta una llamada a un servicio externo para crear el pago
        return true;
    }
}

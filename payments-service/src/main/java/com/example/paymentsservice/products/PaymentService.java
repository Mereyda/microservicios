package com.example.paymentsservice.products;

import com.example.paymentsservice.client.PaymentClient;
import com.example.paymentsservice.model.Payment;
import com.example.paymentsservice.service.PublisNotification;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PublisNotification publisNotification;
    private PaymentClient paymentClient;

    public PaymentService(PublisNotification publisNotification, PaymentClient paymentClient) {
        this.publisNotification = publisNotification;
        this.paymentClient = paymentClient;
    }

    public void createPayment(Payment payment){
        //crear un paymet
        paymentClient.createPayment(payment);
        publisNotification.sendMessageToTopic("enviar notificacion al usuario con con id: " + payment.getClientId());
    }
}


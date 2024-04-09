package com.example.paymentsservice.restController;

import com.example.paymentsservice.model.Payment;
import com.example.paymentsservice.products.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payments")
@RestController
public class PaymentsRestController {
    private PaymentService paymentService;
    Logger log = LoggerFactory.getLogger(PaymentsRestController.class);

    public PaymentsRestController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }
    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.createPayment(payment);
    }
    @GetMapping()
    public Payment getPayment(String id){
        log.info("Intentando obtener payment con id: " + id);
        return new Payment(id, 400.0f,"id 1", "id 2");
    }

}

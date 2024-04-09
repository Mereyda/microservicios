package com.example.checkoutService.controller;

import com.example.checkoutService.model.Checkout;
import com.example.checkoutService.service.IcheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class checkoutRestController {
    private IcheckoutService checkoutService;

    public checkoutRestController(IcheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }
    @GetMapping("/{id}")//sirve para comunicarme internamente como proveedor de recurso
    public Checkout getById(@PathVariable String id){
        return new Checkout(id);
    }
    @GetMapping()// sirve para comunicarme externamente como cliente
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-solicitud") String requestSolicitud, @RequestHeader()Map<String,String> headers) {
        System.out.println("Enviado desde: "+ requestSolicitud);
        if(!requestSolicitud.equals("gateway")) {
            return null;
        }
        return checkoutService.buildCheckout(productIds);
    }
}

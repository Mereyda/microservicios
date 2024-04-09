package com.example.checkoutService.service.Implementacion;

import com.example.checkoutService.model.Checkout;
import com.example.checkoutService.model.dto.Product;
import com.example.checkoutService.service.IcheckoutService;
import com.example.checkoutService.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class checkoutService implements IcheckoutService{
    private IProductService productService;

    public checkoutService(IProductService productService) {

        this.productService = productService;
    }

    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for (String id : productIds) {
            Product product = productService.getProduct(id);
            System.out.println("respuesta desde " + product.getInstance());
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234","www.digitalhause.com/checkout?code=234",total.toString(),List.of("credit_card"));
        return checkout;

    }
}

package com.example.checkoutService.service;

import com.example.checkoutService.model.Checkout;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IcheckoutService {
    public Checkout buildCheckout(List<String> productIds);

}

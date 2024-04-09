package com.example.checkoutService.service;

import com.example.checkoutService.model.dto.Product;
import org.springframework.stereotype.Service;


public interface IProductService {
    public Product getProduct(String id);
}

package com.example.demo.controllers;

import com.example.demo.services.CheckoutService;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
     private CheckoutService checkoutService;

//    @CrossOrigin
//
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchaseData){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchaseData);

        return purchaseResponse;
    }
}

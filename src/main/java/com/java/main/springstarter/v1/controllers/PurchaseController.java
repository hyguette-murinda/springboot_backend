package com.java.main.springstarter.v1.controllers;

import com.java.main.springstarter.v1.dtos.CreatePurchaseDto;
import com.java.main.springstarter.v1.models.Purchase;
import com.java.main.springstarter.v1.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody CreatePurchaseDto purchase){
        Purchase purchase1 = purchaseService.createPurchase(purchase);
        return new ResponseEntity<>(purchase1, HttpStatus.CREATED);
    }
    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> getPurchaseDetails(@PathVariable Long purchaseId){
        Purchase purchase = purchaseService.getPurchaseDetails(purchaseId);
        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        List<Purchase> purchases = purchaseService.getAllPurchases();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }
}


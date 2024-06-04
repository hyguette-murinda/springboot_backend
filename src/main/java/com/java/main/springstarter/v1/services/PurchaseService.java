package com.java.main.springstarter.v1.services;

import com.java.main.springstarter.v1.dtos.CreatePurchaseDto;
import com.java.main.springstarter.v1.models.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase createPurchase(CreatePurchaseDto purchase);
    List<Purchase> getAllPurchases();
    Purchase getPurchaseDetails(Long purchaseId);
}

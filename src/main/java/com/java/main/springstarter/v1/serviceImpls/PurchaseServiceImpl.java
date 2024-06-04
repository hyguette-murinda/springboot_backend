package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.dtos.CreatePurchaseDto;
import com.java.main.springstarter.v1.models.Purchase;
import com.java.main.springstarter.v1.repositories.IPurchaseRepository;
import com.java.main.springstarter.v1.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final IPurchaseRepository purchaseRepository;

    @Override
    public Purchase createPurchase(CreatePurchaseDto purchase) {
        Purchase purchase1 = new Purchase();
        purchase1.setUser(purchase.getUser());
        purchase1.setTotalPrice(purchase.getTotalPrice());
        return (Purchase) purchaseRepository.save(purchase1);
    }
    @Override
    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }
    @Override
    public Purchase getPurchaseDetails(Long purchaseId){
        return (Purchase) purchaseRepository.getById(purchaseId);
    }
}


//package com.java.main.springstarter.v1.serviceImpls;
//
//import com.java.main.springstarter.v1.dtos.CreatePurchaseDto;
//import com.java.main.springstarter.v1.models.Product;
//import com.java.main.springstarter.v1.models.Purchase;
//import com.java.main.springstarter.v1.repositories.IProductRepository;
//import com.java.main.springstarter.v1.repositories.IPurchaseRepository;
//import com.java.main.springstarter.v1.services.ProductService;
//import com.java.main.springstarter.v1.services.PurchaseService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class PurchaseServiceImpl implements PurchaseService {
//
//
//    @Autowired
//    private final IPurchaseRepository purchaseRepository;
//
//    @Override
//    public Purchase createPurchase(CreatePurchaseDto purchase) {
//        Purchase purchase1 = new Purchase();
//        purchase1.setDate(purchase.getDate());
//        purchase1.setQuantity(purchase.getQuantity());
//        purchase1.setProductCode(purchase.getProductCode());
//        purchase1.setTotalPrice(purchase.getTotalPrice());
//        return (Purchase) purchaseRepository.save(purchase1);
//    }
//    @Override
//    public List<Purchase> getAllPurchases(){
//        return purchaseRepository.findAll();
//    }
//    @Override
//    public Purchase getPurchaseDetails(Long purchaseId){
//        return (Purchase) purchaseRepository.getById(purchaseId);
//    }
//}
//

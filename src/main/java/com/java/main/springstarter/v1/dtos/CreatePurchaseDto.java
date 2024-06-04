package com.java.main.springstarter.v1.dtos;

import com.java.main.springstarter.v1.models.User;
import lombok.Data;

@Data
public class CreatePurchaseDto {
    private User user;
//    private List<PurchaseItem> purchaseItems = new ArrayList<>();
    private double totalPrice;

}


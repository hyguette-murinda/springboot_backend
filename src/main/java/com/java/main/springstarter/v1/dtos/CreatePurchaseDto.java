package com.java.main.springstarter.v1.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreatePurchaseDto {
    private  String productCode ;
    private  long quantity;
    private  double totalPrice;
    private Date date;


}


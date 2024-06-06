package com.java.main.springstarter.v1.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProductDto {
    private String product_code;
    private long quantity;
    private Date date;
    private String name;
    private double price;
}

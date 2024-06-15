package com.java.main.springstarter.v1.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CreateProductDto {

    @NotNull
    private String productName;

    @NotNull
    private String productType;

    @NotNull
    @DecimalMin(value = "0.1", message = "Price should be greater that 0.1")
    private double price;

    @NotNull
    @Min(1)
    private int quantity;

    private String image;

}

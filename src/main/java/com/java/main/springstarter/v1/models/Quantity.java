package com.java.main.springstarter.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;


    private  String productCode ;
    private  String quantity;
    private  String operation;
    private Date date;


}

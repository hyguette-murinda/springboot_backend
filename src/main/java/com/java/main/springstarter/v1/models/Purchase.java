package com.java.main.springstarter.v1.models;

import javax.persistence.*;

import com.java.main.springstarter.v1.audits.InitiatorAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase extends InitiatorAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<CartItem> purchasedProducts=new ArrayList<>();

    private double total;

}
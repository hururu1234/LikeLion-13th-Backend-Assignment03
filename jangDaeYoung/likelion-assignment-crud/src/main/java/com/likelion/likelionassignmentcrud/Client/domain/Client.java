package com.likelion.likelionassignmentcrud.Client.domain;


import com.likelion.likelionassignmentcrud.Delivery.domain.Delivery;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long ClientId;

    private String name;      //고객이름

    private int age;           //고객나이

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Payment payment;        //결제 방식

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveryList = new ArrayList<>();

    @Builder
    private Client(String name, int age, Payment payment){
        this.name = name;
        this.age = age;
        this.payment = payment;


    }


}

package com.likelion.likelionassignmentcrud.Delivery.domain;

import com.likelion.likelionassignmentcrud.Client.domain.Client;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long DeliveryId;

    private String itemName;    //고객 이름

    private String deliveryStatus;  //배송 상태

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Builder
    private Delivery(String itemName, String deliveryStatus, Client client){
        this.itemName = itemName;
        this.deliveryStatus = deliveryStatus;
        this.client = client;

    }






}

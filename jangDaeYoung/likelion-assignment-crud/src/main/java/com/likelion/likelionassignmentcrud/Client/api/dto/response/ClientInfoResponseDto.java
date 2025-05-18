package com.likelion.likelionassignmentcrud.Client.api.dto.response;

import com.likelion.likelionassignmentcrud.Client.domain.Client;
import com.likelion.likelionassignmentcrud.Client.domain.Payment;
import com.likelion.likelionassignmentcrud.Delivery.domain.Delivery;
import lombok.Builder;

@Builder
public record ClientInfoResponseDto (
        String name,
        int age,
        Payment payment
){
    public static ClientInfoResponseDto from(Client client){
        return ClientInfoResponseDto.builder()
                .name(client.getName())
                .age(client.getAge())
                .payment(client.getPayment())
                .build();
    }


}

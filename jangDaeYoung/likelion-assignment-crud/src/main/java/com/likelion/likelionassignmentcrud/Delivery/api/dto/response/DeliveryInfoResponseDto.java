package com.likelion.likelionassignmentcrud.Delivery.api.dto.response;

import com.likelion.likelionassignmentcrud.Delivery.domain.Delivery;
import lombok.Builder;

@Builder
public record DeliveryInfoResponseDto(
        String itemName,
        String deliveryStatus,
        String ordererName
) {

    public static DeliveryInfoResponseDto from(Delivery delivery){
        return DeliveryInfoResponseDto.builder()
                .itemName(delivery.getItemName())
                .deliveryStatus(delivery.getDeliveryStatus())
                .ordererName(delivery.getClient().getName())
                .build();
    }

}

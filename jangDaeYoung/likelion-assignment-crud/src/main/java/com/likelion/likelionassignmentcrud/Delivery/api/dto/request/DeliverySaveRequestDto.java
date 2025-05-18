package com.likelion.likelionassignmentcrud.Delivery.api.dto.request;

public record DeliverySaveRequestDto (
        Long clientId,
        String itemName,
        String deliveryStatus
){
}

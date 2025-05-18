package com.likelion.likelionassignmentcrud.Delivery.api.dto.response;

import com.likelion.likelionassignmentcrud.Delivery.api.dto.request.DeliverySaveRequestDto;
import lombok.Builder;

import java.util.List;

@Builder
public record DeliveryListResponseDto(
        List<DeliveryInfoResponseDto> deliverys
) {

    public static DeliveryListResponseDto from(List<DeliveryInfoResponseDto> deliverys){
        return DeliveryListResponseDto.builder()
                .deliverys(deliverys)
                .build();
    }
}

package com.likelion.likelionassignmentcrud.Client.api.dto.request;

import com.likelion.likelionassignmentcrud.Client.domain.Payment;

public record ClientSaveRequestDto (
        String name,
        int age,
        Payment payment
){

}

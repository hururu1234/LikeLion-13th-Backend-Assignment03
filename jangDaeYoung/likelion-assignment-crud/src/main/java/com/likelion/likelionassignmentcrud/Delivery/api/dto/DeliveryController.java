package com.likelion.likelionassignmentcrud.Delivery.api.dto;


import com.likelion.likelionassignmentcrud.Delivery.api.dto.request.DeliverySaveRequestDto;
import com.likelion.likelionassignmentcrud.Delivery.api.dto.response.DeliveryListResponseDto;
import com.likelion.likelionassignmentcrud.Delivery.application.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    //주문 저장
    @PostMapping("/save")
    public ResponseEntity<String> deliverySave(@RequestBody DeliverySaveRequestDto deliverySaveRequestDto){
        deliveryService.deliverySave(deliverySaveRequestDto);
        return new ResponseEntity<>("주문 저장 완료!" , HttpStatus.CREATED);
    }


    //고객id로 배달 내역 검색
    @GetMapping("/{clientId}")
    public ResponseEntity<DeliveryListResponseDto> findMyAllDelivery(@PathVariable("clientId") Long clientId){
        DeliveryListResponseDto deliveryListResponseDto = deliveryService.deliveryFindByClientId(clientId);
        return new ResponseEntity<>(deliveryListResponseDto, HttpStatus.OK);
    }

}

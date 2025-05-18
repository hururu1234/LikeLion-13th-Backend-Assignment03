package com.likelion.likelionassignmentcrud.Delivery.application;

import com.likelion.likelionassignmentcrud.Client.domain.Client;
import com.likelion.likelionassignmentcrud.Client.domain.repository.ClientRepository;
import com.likelion.likelionassignmentcrud.Delivery.api.dto.request.DeliverySaveRequestDto;
import com.likelion.likelionassignmentcrud.Delivery.api.dto.response.DeliveryInfoResponseDto;
import com.likelion.likelionassignmentcrud.Delivery.api.dto.response.DeliveryListResponseDto;
import com.likelion.likelionassignmentcrud.Delivery.domain.Delivery;
import com.likelion.likelionassignmentcrud.Delivery.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryService {

    private final ClientRepository clientRepository;
    private final DeliveryRepository deliveryRepository;

    //주문저장
    @Transactional
    public void deliverySave(DeliverySaveRequestDto deliverySaveRequestDto){
        Client client = clientRepository.findById(deliverySaveRequestDto.clientId())
                .orElseThrow(IllegalArgumentException::new);

        Delivery delivery = Delivery.builder()
                .itemName(deliverySaveRequestDto.itemName())
                .deliveryStatus(deliverySaveRequestDto.deliveryStatus())
                .client(client)
                .build();

        deliveryRepository.save(delivery);

    }

    //고객 번호로 주문 조회
    public DeliveryListResponseDto deliveryFindByClientId(Long clientId){
        Client client = clientRepository.findById(clientId).orElseThrow(IllegalArgumentException::new);

        List<Delivery> deliveries = deliveryRepository.findByClient(client);
        List<DeliveryInfoResponseDto> deliveryListResponseDtos = deliveries.stream()
                .map(DeliveryInfoResponseDto::from)
                .toList();

        return DeliveryListResponseDto.from(deliveryListResponseDtos);

    }

}

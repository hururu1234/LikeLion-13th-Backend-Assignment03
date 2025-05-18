package com.likelion.likelionassignmentcrud.Client.application;


import com.likelion.likelionassignmentcrud.Client.api.dto.request.ClientSaveRequestDto;
import com.likelion.likelionassignmentcrud.Client.api.dto.response.ClientInfoResponseDto;
import com.likelion.likelionassignmentcrud.Client.api.dto.response.ClientListResponseDto;
import com.likelion.likelionassignmentcrud.Client.domain.Client;
import com.likelion.likelionassignmentcrud.Client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;

    //고객 정보 저장
    @Transactional
    public void clientSave(ClientSaveRequestDto clientSaveRequestDto){
        Client client = Client.builder()
                .name(clientSaveRequestDto.name())
                .age(clientSaveRequestDto.age())
                .payment(clientSaveRequestDto.payment())
                .build();

        clientRepository.save(client);
    }

    //전체 고객 조회
    public ClientListResponseDto clientFindAll(){
        List<Client> clients = clientRepository.findAll();
        List<ClientInfoResponseDto> clientInfoResponseDtoList = clients.stream()
                .map(ClientInfoResponseDto::from)
                .toList();
        return ClientListResponseDto.from(clientInfoResponseDtoList);
    }

    //단일 고객 조회
    public ClientInfoResponseDto clientFineById(Long clientId){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(IllegalArgumentException::new);
        return ClientInfoResponseDto.from(client);
    }


}

package com.likelion.likelionassignmentcrud.Client.api;

import com.likelion.likelionassignmentcrud.Client.api.dto.request.ClientSaveRequestDto;
import com.likelion.likelionassignmentcrud.Client.api.dto.response.ClientInfoResponseDto;
import com.likelion.likelionassignmentcrud.Client.api.dto.response.ClientListResponseDto;
import com.likelion.likelionassignmentcrud.Client.application.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    // 고객 저장
    @PostMapping("/save")
    public ResponseEntity<String> clientSave(@RequestBody ClientSaveRequestDto clientSaveRequestDto){
        clientService.clientSave(clientSaveRequestDto);
        return new ResponseEntity<>("고객 정보 저장 완료!", HttpStatus.CREATED);
    }

    // 전체 고객 조회
    @GetMapping("/all")
    public ResponseEntity<ClientListResponseDto> clientFindAll(){
        ClientListResponseDto clientListResponseDto = clientService.clientFindAll();
        return new ResponseEntity<>(clientListResponseDto, HttpStatus.OK);
    }

    // 고객id로 특정 고객 조회
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientInfoResponseDto> clientFindById(@PathVariable("clientId") Long clientId){
        ClientInfoResponseDto clientInfoResponseDto = clientService.clientFineById(clientId);
        return new ResponseEntity<>(clientInfoResponseDto, HttpStatus.OK);
    }



}

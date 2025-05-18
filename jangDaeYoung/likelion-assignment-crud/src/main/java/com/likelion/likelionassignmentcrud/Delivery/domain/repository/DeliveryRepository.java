package com.likelion.likelionassignmentcrud.Delivery.domain.repository;

import com.likelion.likelionassignmentcrud.Client.domain.Client;
import com.likelion.likelionassignmentcrud.Delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByClient(Client client);
}

package com.likelion.likelionassignmentcrud.Client.domain.repository;

import com.likelion.likelionassignmentcrud.Client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

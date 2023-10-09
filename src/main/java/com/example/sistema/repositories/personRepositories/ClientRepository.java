package com.example.sistema.repositories.personRepositories;

import com.example.sistema.models.personModels.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM tb_clients WHERE cpf = :cpf", nativeQuery = true)
    Client findByClientCpf(@Param("cpf") String cpf);
}

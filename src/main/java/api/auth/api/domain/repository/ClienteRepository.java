package api.auth.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.auth.api.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

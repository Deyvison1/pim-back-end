package api.auth.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.auth.api.domain.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}

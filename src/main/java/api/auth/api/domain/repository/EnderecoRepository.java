package api.auth.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.auth.api.domain.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

package api.auth.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.auth.api.domain.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	Product findByNome(String nome);
}

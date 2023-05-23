package api.auth.api.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendas")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "data_venda")
	private LocalDateTime dataVenda;
	private BigDecimal valor;
	@Column(name = "tipo_pagamento")
	private String tipoPagamento;
	@Column(name = "status_venda")
	private String statusVenda;
	private Integer quantidade;
	@Column(name = "status_pagamento")
	private String statusPagamento;
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "updated_at", nullable = true, updatable = true)
	private LocalDateTime updatedAt;
	
	@ManyToMany
	private List<Product> products;
	@ManyToOne
	private Cliente cliente;
}

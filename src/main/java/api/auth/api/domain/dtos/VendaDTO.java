package api.auth.api.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import api.auth.api.domain.entity.Cliente;
import api.auth.api.domain.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private LocalDateTime dataVenda;
	private BigDecimal valor;
	private String tipoPagamento;
	private String statusVenda;
	private String statusPagamento;
	private Integer quantidade;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Product> products;
	private Cliente cliente;
}

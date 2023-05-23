package api.auth.api.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import api.auth.api.domain.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigoBarra;
	private String nome;
	private String fabricante;
	private BigDecimal valor;
	private int quantidade;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Category category;
}

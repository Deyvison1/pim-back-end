package api.auth.api.domain.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String ddd;
}

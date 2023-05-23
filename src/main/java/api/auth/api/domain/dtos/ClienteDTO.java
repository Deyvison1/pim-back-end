package api.auth.api.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String rg;
	private String cpf;
	private String nome;
	private LocalDate dataCadastro;
	private String telefone;
	private String email;
	private EnderecoDTO endereco;

}

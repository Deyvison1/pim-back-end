package api.auth.api.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.auth.api.domain.dtos.ClienteDTO;
import api.auth.api.domain.entity.Cliente;
import api.auth.api.domain.repository.ClienteRepository;
import api.auth.api.service.ClienteService;
import api.auth.api.utils.mappers.IClienteMapper;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository repo;
	private final IClienteMapper mapper;

	public ClienteServiceImpl(ClienteRepository repo, IClienteMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public void add(ClienteDTO cliente) {
		Cliente clienteToEntity = mapper.toEntity(cliente);
		clienteToEntity.setDataCadastro(LocalDate.now());
		repo.save(clienteToEntity);
	}

	@Override
	public List<ClienteDTO> findAll() {
		return mapper.toDto(repo.findAll());
	}

	@Override
	public void delete(Long id) {
		Optional<Cliente> cliente = repo.findById(id);
		if(cliente.isPresent()) {
			repo.delete(cliente.get());
		}
	}

}

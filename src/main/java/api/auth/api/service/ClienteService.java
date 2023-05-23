package api.auth.api.service;

import java.util.List;

import api.auth.api.domain.dtos.ClienteDTO;

public interface ClienteService {

	void add(ClienteDTO cliente);
	void delete(Long id);
	List<ClienteDTO> findAll();
}

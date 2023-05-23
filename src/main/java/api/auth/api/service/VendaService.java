package api.auth.api.service;

import java.util.List;

import api.auth.api.domain.dtos.VendaDTO;

public interface VendaService {

	VendaDTO newVenda(VendaDTO venda);
	
	List<VendaDTO> findAll();
	
	void excluir(Long id);
	
	VendaDTO cancelarVenda(Long id);
	
	void finalizarVenda(Long id);
}

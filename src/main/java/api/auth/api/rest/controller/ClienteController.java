package api.auth.api.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.auth.api.domain.dtos.ClienteDTO;
import api.auth.api.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClienteController {

	private ClienteService clienteService;
	
	@PreAuthorize("hasAnyRole('ESTOQUISTA', 'GERENTE')")
	@PostMapping
	public void add(@RequestBody ClienteDTO clienteDTO) {
		clienteService.add(clienteDTO);
	}
	
	@PreAuthorize("hasAnyRole('ESTOQUISTA', 'GERENTE')")
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
	@PreAuthorize("hasAnyRole('ESTOQUISTA', 'GERENTE')")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}
}

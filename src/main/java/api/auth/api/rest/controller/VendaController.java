package api.auth.api.rest.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import api.auth.api.domain.dtos.VendaDTO;
import api.auth.api.service.VendaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/venda")
@AllArgsConstructor
public class VendaController {

	private VendaService service;
	
	@PostMapping
	public ResponseEntity<VendaDTO> add(@RequestBody VendaDTO vendaDTO) {
		return ResponseEntity.ok(service.newVenda(vendaDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/cancelar/{id}")
	public ResponseEntity<VendaDTO> cancelarVenda(@PathVariable Long id) {
		return ResponseEntity.ok(service.cancelarVenda(id));
	}
	
	@GetMapping("/finalizar/{id}")
	public void finalizarVenda(@PathVariable Long id) {
		service.finalizarVenda(id);
	}
	
}

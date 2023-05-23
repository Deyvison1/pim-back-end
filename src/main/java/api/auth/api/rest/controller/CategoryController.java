package api.auth.api.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.auth.api.domain.dtos.CategoryDTO;
import api.auth.api.domain.entity.Category;
import api.auth.api.service.ICategoryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
	
	private ICategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDTO> add(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.add(category));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryService.remove(id);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
}

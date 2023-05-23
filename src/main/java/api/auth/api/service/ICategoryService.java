package api.auth.api.service;

import java.util.List;

import api.auth.api.domain.dtos.CategoryDTO;
import api.auth.api.domain.entity.Category;


public interface ICategoryService {

	CategoryDTO add(Category category);
	void remove(Long id);
	List<CategoryDTO> findAll();
}

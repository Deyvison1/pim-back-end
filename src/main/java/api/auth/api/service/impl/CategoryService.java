package api.auth.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.auth.api.domain.dtos.CategoryDTO;
import api.auth.api.domain.entity.Category;
import api.auth.api.domain.repository.ICategoryRepository;
import api.auth.api.service.ICategoryService;
import api.auth.api.utils.mappers.ICategoryMapper;

@Service
public class CategoryService implements ICategoryService {
	
	private ICategoryRepository categoryRepo;
	private ICategoryMapper categoryMapper;
	
	public CategoryService(ICategoryRepository categoryRepo, ICategoryMapper categoryMapper) {
		this.categoryRepo = categoryRepo;
		this.categoryMapper = categoryMapper;
	}
	
	@Override
	public CategoryDTO add(Category category) {
		return categoryMapper.toDto(categoryRepo.save(category));
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryMapper.toDto(categoryRepo.findAll());
	}

	@Override
	public void remove(Long id) {
		Optional<Category> produto = categoryRepo.findById(id);
		if(produto.isPresent()) {
			categoryRepo.delete(produto.get());
		}
	}
}

package api.auth.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import api.auth.api.domain.dtos.CategoryDTO;
import api.auth.api.domain.entity.Category;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper extends BaseEntityMapper<Category, CategoryDTO> {
}

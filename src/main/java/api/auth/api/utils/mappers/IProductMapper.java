package api.auth.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import api.auth.api.domain.dtos.ProductDTO;
import api.auth.api.domain.entity.Product;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper extends BaseEntityMapper<Product, ProductDTO> {
	
}

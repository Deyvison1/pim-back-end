package api.auth.api.service.impl;

import java.awt.Font;
import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.auth.api.domain.dtos.ProductDTO;
import api.auth.api.domain.entity.Cliente;
import api.auth.api.domain.entity.Product;
import api.auth.api.domain.repository.IProductRepository;
import api.auth.api.service.IProductService;
import api.auth.api.utils.mappers.IProductMapper;
import io.jsonwebtoken.lang.Objects;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

@Service
public class ProductService implements IProductService {

	private IProductRepository productRepository;
	private IProductMapper productMapper;

	public ProductService(IProductRepository productRepository, IProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public ProductDTO add(Product product) throws BarcodeException, OutputException {
		Boolean isValid = validaCadastro(product);
		Product produto = new Product();
		if(isValid) {
			produto = productRepository.save(product);
		} else {
			produto = productRepository.save(product);
		}
		return productMapper.toDto(produto);
	}
	
	private Boolean validaCadastro(Product produto) {
		Product product = productRepository.findByNome(produto.getNome());
		if(product != null) {
			product.setQuantidade(product.getQuantidade());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ProductDTO> findAll() {
		return productMapper.toDto(productRepository.findAll());
	}

	@Override
	public void remove(Long id) {
		Optional<Product> produto = productRepository.findById(id);
		if (produto.isPresent()) {
			productRepository.delete(produto.get());
		}
	}

}

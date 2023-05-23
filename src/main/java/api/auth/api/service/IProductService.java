package api.auth.api.service;

import java.util.List;


import api.auth.api.domain.dtos.ProductDTO;
import api.auth.api.domain.entity.Product;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

public interface IProductService {

	ProductDTO add(Product product) throws BarcodeException, OutputException;
	void remove(Long id);
	List<ProductDTO> findAll();
}

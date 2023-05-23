package api.auth.api.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import api.auth.api.domain.dtos.VendaDTO;
import api.auth.api.domain.entity.Product;
import api.auth.api.domain.entity.Venda;
import api.auth.api.domain.repository.IProductRepository;
import api.auth.api.domain.repository.VendaRepository;
import api.auth.api.service.VendaService;
import api.auth.api.utils.mappers.IVendaMapper;

@Service
public class VendaServiceImpl implements VendaService {

	private final VendaRepository repo;
	private final IProductRepository repoProduct;
	private final IVendaMapper mapper;

	public VendaServiceImpl(VendaRepository repo, IVendaMapper mapper, IProductRepository repoProduct) {
		this.repo = repo;
		this.mapper = mapper;
		this.repoProduct = repoProduct;
	}

	@Override
	public VendaDTO newVenda(VendaDTO venda) {
		Venda vendaToEntity = mapper.toEntity(venda);
		setQuantidadeVenda(vendaToEntity);
		vendaToEntity.setDataVenda(LocalDateTime.now());
		baixaQuantidade(venda.getProducts());
		valorAtualizadoDaVenda(vendaToEntity);

		return mapper.toDto(repo.save(vendaToEntity));
	}

	public void setQuantidadeVenda(Venda venda) {
		Product produto = venda.getProducts().get(0);
		venda.setQuantidade(produto.getQuantidade());
	}

	public void baixaQuantidade(List<Product> product) {
		Optional<Product> produto = repoProduct.findById(product.get(0).getId());
		if (produto.isPresent()) {
			produto.get().setQuantidade(produto.get().getQuantidade() - product.get(0).getQuantidade());
			repoProduct.save(produto.get());
		}
	}

	public void valorAtualizadoDaVenda(Venda venda) {
		Product product = venda.getProducts().get(0);
		BigDecimal valorAtualizado = product.getValor().multiply(new BigDecimal(product.getQuantidade()));
		venda.setValor(valorAtualizado);
	}

	@Override
	public List<VendaDTO> findAll() {
		return mapper.toDto(repo.findAll());
	}

	@Override
	public void excluir(Long id) {
		Optional<Venda> venda = repo.findById(id);

		if (venda.isPresent()) {
			repo.delete(venda.get());
		}
	}

	@Override
	public VendaDTO cancelarVenda(Long id) {
		Optional<Venda> venda = repo.findById(id);
		ajustarQuantidadeNoProduto(venda.get());
		if (venda.isPresent()) {
			venda.get().setStatusVenda("CANCELADA");
			return mapper.toDto(repo.save(venda.get()));
		}
		return null;
	}

	private void ajustarQuantidadeNoProduto(Venda venda) {
		Integer qtd = venda.getProducts().get(0).getQuantidade() + venda.getQuantidade();
		Optional<Product> produto = repoProduct.findById(venda.getProducts().get(0).getId());
		if(produto.isPresent()) {
			produto.get().setQuantidade(qtd);
		}
	}

	@Override
	public void finalizarVenda(Long id) {
		Optional<Venda> venda = repo.findById(id);
		if (venda.isPresent()) {
			venda.get().setStatusVenda("FINALIZADO");
			repo.save(venda.get());
		}
	}

}

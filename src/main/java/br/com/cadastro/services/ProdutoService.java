package br.com.cadastro.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cadastro.entity.Produto;
import br.com.cadastro.models.ProdutoRequest;
import br.com.cadastro.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	private static final Logger logger = LogManager.getLogger(ProdutoService.class);


	/**
	 * @param prodRequest
	 * @return
	 */
	public ResponseEntity<Produto> inclusao(ProdutoRequest prodRequest) {
		logger.info("Iniciando a chamada da Inclusao de Produto");

		Produto produto = new Produto();
		produto = addPedido(prodRequest, produto);
		try {
			produto = produtoRepository.save(produto);
		} catch (Exception e) {
			logger.error("Ocorreu um erro na persistencia de Dados");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(produto);
		}

		if(produto != null) {
			return ResponseEntity.ok().body(produto);
		}

		return ResponseEntity.notFound().build();

	}

	private Produto addPedido(ProdutoRequest prodRequest, Produto produto) {

		if(prodRequest.getId() != null) {
			produto.setId(Long.valueOf(prodRequest.getId()));;
		}

		produto.setCodigo(prodRequest.getCodigo());
		produto.setProdutoNome(prodRequest.getProdutoNome());;
		produto.setDescricao(prodRequest.getDescricao());;
		produto.setMarca(prodRequest.getMarca());
		produto.setTipo(prodRequest.getTipo());
		produto.setValidade(prodRequest.getValidade());
		produto.setDepositoid(prodRequest.getDepositoid());
		return produto;
	}

	/**
	 * @param codigo
	 * @return
	 */
	public ResponseEntity<List<Produto>> consultarProdutos() {
		logger.info("Iniciando a chamada da Consulta de Produto");

		try {

			List<Produto> findAll = this.produtoRepository.findAll();
			if(findAll.size() > 0 ) {
				return ResponseEntity.ok().body(findAll);
			}

		} catch (Exception e) {
			logger.error("Iniciando a chamada da consulta de Produto");
			return ResponseEntity.notFound().build();
		}

		logger.info("Fim da chamada da consulta de Produto");
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<Produto> atualizar(ProdutoRequest prodRequest) {
		logger.info("Iniciando a chamada da atualizar de Produto");

		List<Produto> findByCodigo = produtoRepository.findByCodigo(prodRequest.getCodigo());

		if(findByCodigo.size() > 0) {

			for (Produto prod : findByCodigo) {

				Produto produto = new Produto();
				produto = atualizaPedido(prodRequest, prod);
				try {
					produto = produtoRepository.saveAndFlush(produto);
				} catch (Exception e) {
					logger.error("Ocorreu um erro na persistencia de Dados");
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(produto);
				}

				if(produto != null) {
					return ResponseEntity.ok().body(produto);
				}

			}

		}

		return ResponseEntity.notFound().build();

	}

	private Produto atualizaPedido(ProdutoRequest prodRequest, Produto produto) {

		if(produto.getId() != null) {
			produto.setId(Long.valueOf(produto.getId()));;
		}

		produto.setCodigo(produto.getCodigo());
		produto.setProdutoNome(prodRequest.getProdutoNome());;
		produto.setDescricao(prodRequest.getDescricao());;
		produto.setMarca(prodRequest.getMarca());
		produto.setTipo(prodRequest.getTipo());
		produto.setValidade(prodRequest.getValidade());
		produto.setDepositoid(prodRequest.getDepositoid());
		return produto;
	}

	public ResponseEntity<List<Produto>> consultaByCodigoProduto(String codigoProduto) {
		logger.info("Iniciando a chamada da atualizar de consultaByCodigoProduto");
		Integer codigo = Integer.valueOf(codigoProduto);

		List<Produto> findByCodigo = produtoRepository.findByCodigo(codigo);

		if(findByCodigo.size() > 0) {
			return ResponseEntity.ok().body(findByCodigo);
		}
		
		return ResponseEntity.notFound().build();
	}




}

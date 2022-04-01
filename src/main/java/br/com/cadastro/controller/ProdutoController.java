package br.com.cadastro.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.cadastro.entity.Produto;
import br.com.cadastro.models.ProdutoRequest;
import br.com.cadastro.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@Api(value = "Produto")
@RequestMapping("/produto/v1")
public class ProdutoController {
	

	@Autowired
	private ProdutoService produtoService;
	
	private static final Logger logger = LogManager.getLogger(ProdutoController.class);

	@ApiOperation(value = "Inclui Produto")
	@PostMapping(path = "/incluir" , produces = {"application/json"})
	public ResponseEntity<Produto> inclusao(@RequestBody ProdutoRequest depositoRequest, @RequestHeader("authorization") String authorization) {
		logger.info("Iniciando a Inclusao do produtoService");
		return produtoService.inclusao(depositoRequest );
	}

	
	@ApiOperation(value = "Lista de Produtos")
	@GetMapping(path = "/listarProdutos" , produces = {"application/json"})
	public ResponseEntity<List<Produto>> consultaOrdens(@RequestHeader("authorization") String authorization) {
		logger.info("Iniciando a consulta do produtoService");
		return produtoService.consultarProdutos();
	}
	
	@ApiOperation(value = "Atualizar Produto")
	@PutMapping(path = "/alterar" , produces = {"application/json"})
	public ResponseEntity<Produto> atualizar(@RequestBody ProdutoRequest depositoRequest, @RequestHeader("authorization") String authorization) {
		logger.info("Iniciando a Inclusao do produtoService");
		return produtoService.atualizar(depositoRequest );
	}
	
	@ApiOperation(value = "Produto")
	@GetMapping(path = "/consultaByCodigoProduto" , produces = {"application/json"})
	public ResponseEntity<List<Produto>> consultaByCodigoProduto(@RequestParam("codigo") String codigo, @RequestHeader("authorization") String authorization ) {
		logger.info("Iniciando a consulta do produtoService");
		return produtoService.consultaByCodigoProduto(codigo);
	}
	

}

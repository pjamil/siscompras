package br.com.pjsistemas.app.siscompras.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.pjsistemas.app.siscompras.dao.ProdutoDao;
import br.com.pjsistemas.app.siscompras.model.CategoriaProduto;
import br.com.pjsistemas.app.siscompras.model.Fornecedor;
import br.com.pjsistemas.app.siscompras.model.Imposto;
import br.com.pjsistemas.app.siscompras.model.ItemMidia;
import br.com.pjsistemas.app.siscompras.model.Produto;
import br.com.pjsistemas.app.siscompras.model.TipoProduto;
import br.com.pjsistemas.app.siscompras.model.UnidadeMedida;

@Stateless
public class ProdutoDaoBean implements ProdutoDao {

	@Inject
	private Logger log;
	
	@Inject
	EntityManager entityManager;
	
	@Inject
	private Event<Produto> produtoEventSrc;

	@Override
	public void inserirProduto(Produto produto) {
		log.info("Inserindo Produto : " + produto.getNome());
		entityManager.persist(produto);
		produtoEventSrc.fire(produto);
	}

	@Override
	public void atualizarProduto(Produto produto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirProduto(Produto produto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produto selecionarProdutoNome(String nomeProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto selecionarProdutosCodigo(String codigoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> selecionarProdutosCategoria(
			CategoriaProduto categoriaProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> selecionarProdutosTipo(TipoProduto tipoProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> selecionarProdutosUnidadeMedida(
			UnidadeMedida unidadeMedida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> selecionarTodosProdutos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> selecionarFornecedoresProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemMidia> selecionarItensMidiaProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imposto> selecionarImpostosProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

}

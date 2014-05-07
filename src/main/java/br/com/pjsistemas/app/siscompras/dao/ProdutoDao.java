package br.com.pjsistemas.app.siscompras.dao;

import java.util.List;

import javax.ejb.Local;
import javax.validation.constraints.Null;

import br.com.pjsistemas.app.siscompras.model.CategoriaProduto;
import br.com.pjsistemas.app.siscompras.model.Fornecedor;
import br.com.pjsistemas.app.siscompras.model.Imposto;
import br.com.pjsistemas.app.siscompras.model.ItemMidia;
import br.com.pjsistemas.app.siscompras.model.Produto;
import br.com.pjsistemas.app.siscompras.model.TipoProduto;
import br.com.pjsistemas.app.siscompras.model.UnidadeMedida;

/**
 * Interface de acesso a dados para {@link Produto}
 */
@Local
public interface ProdutoDao {
	
	/**
	 * Insere um {@link Produto} na base de dados do sistema.
	 * @param produto produto a ser inserido
	 */
	void inserirProduto(Produto produto);

	/**
	 * Atualiza um {@link Produto} na base de dados do sistema.
	 * @param produto produto a ser atualizado
	 */
	void atualizarProduto(Produto produto);
	
	/**
	 * Exclui um {@link Produto} na base de dados do sistema.
	 * @param produto produto a ser excluído
	 */
	void excluirProduto(Produto produto);
	
	/**
	 * Seleciona um produto pelo nome
	 * @param nomeProduto nome do produto
	 * @return {@link Produto} ou {@link Null}
	 */
	Produto selecionarProdutoNome(String nomeProduto);
	
	/**
	 * Seleciona um produto pelo codigo
	 * @param codigoProduto codigo do produto a ser selecionado
	 * @return {@link Produto} ou {@link Null}
	 */
	Produto selecionarProdutosCodigo(String codigoProduto);

	/**
	 * Seleciona produtos de uma categoria do produto
	 * @param categoriaProduto categoria dos produtos a serem selecionados
	 * @return {@link List} de {@link Produto} ou {@link Null} 
	 */
	List<Produto> selecionarProdutosCategoria(CategoriaProduto categoriaProduto);

	/**
	 * Seleciona produtos de um tipo de produto
	 * @param tipoProduto tipo dos produtos a serem selecionados
	 * @return {@link List} de {@link Produto} ou {@link Null} 
	 */
	List<Produto> selecionarProdutosTipo(TipoProduto tipoProduto);

	/**
	 * Seleciona produtos de uma unidade de medida.
	 * @param unidadeMedida unidade de medida dos produtos a serem selecionados
	 * @return {@link List} de {@link Produto} ou {@link Null} 
	 */
	List<Produto> selecionarProdutosUnidadeMedida(UnidadeMedida unidadeMedida);
	
	/**
	 * Seleciona todos os produtos na base de dados.
	 * @return todos os produtos
	 */
	List<Produto> selecionarTodosProdutos();

	/**
	 * Seleciona fornecedores de um produto.
	 * @param produto produto dos fornecedores a serem selecionados
	 * @return {@link List} de {@link Fornecedor} ou {@link Null} 
	 */
	List<Fornecedor> selecionarFornecedoresProduto(Produto produto);

	/**
	 * Seleciona ite de um produto.
	 * @param produto produto dos fornecedores a serem selecionados
	 * @return {@link List} de {@link Fornecedor} ou {@link Null} 
	 */
	List<ItemMidia> selecionarItensMidiaProduto(Produto produto);
	
	List<Imposto> selecionarImpostosProduto(Produto produto);
}

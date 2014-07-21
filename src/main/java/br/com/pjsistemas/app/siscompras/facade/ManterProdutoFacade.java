/**
 *
 */
package br.com.pjsistemas.app.siscompras.facade;

import javax.ejb.Local;

import br.com.pjsistemas.app.siscompras.model.Produto;

/**
 * Facade para o ECU Manter Produtos.
 *
 */
@Local
public interface ManterProdutoFacade {

	/**
	 * Método para salvar um produto.
	 * @param produto a ser salvo
	 */
	void salvarProduto(Produto produto);
}

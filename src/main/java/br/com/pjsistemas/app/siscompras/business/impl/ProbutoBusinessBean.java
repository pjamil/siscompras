/**
 *
 */
package br.com.pjsistemas.app.siscompras.business.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.pjsistemas.app.siscompras.business.ProdutoBusiness;
import br.com.pjsistemas.app.siscompras.dao.ProdutoDao;
import br.com.pjsistemas.app.siscompras.model.Produto;

/**
 * Implementação Business da entidade Pessoa.
 *
 */
@Stateless
public class ProbutoBusinessBean implements ProdutoBusiness {

	@EJB
	private ProdutoDao produtoDao;

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	@Override
	public void salvarProduto(Produto produto) {
		produtoDao.salvarProduto(produto);
	}

}

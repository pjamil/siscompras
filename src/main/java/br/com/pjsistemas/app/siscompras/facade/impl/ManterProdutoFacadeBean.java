/**
 *
 */
package br.com.pjsistemas.app.siscompras.facade.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.pjsistemas.app.siscompras.business.ProdutoBusiness;
import br.com.pjsistemas.app.siscompras.facade.ManterProdutoFacade;
import br.com.pjsistemas.app.siscompras.model.Produto;

/**
 * EJB de facade para as chamadas de view de {@link Produto}
 */
@Stateless
public class ManterProdutoFacadeBean implements ManterProdutoFacade {

	/**
	 * {@link ProdutoBusiness}
	 */
	@EJB
	private ProdutoBusiness produtoBusiness;

	public void setProdutoBusiness(ProdutoBusiness produtoBusiness) {
		this.produtoBusiness = produtoBusiness;
	}

	@Override
	public void salvarProduto(Produto produto) {
		produtoBusiness.salvarProduto(produto);
	}

}

/**
 *
 */
package br.com.pjsistemas.app.siscompras.view;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

import br.com.pjsistemas.app.siscompras.facade.ManterProdutoFacade;
import br.com.pjsistemas.app.siscompras.model.Produto;

/**
 * View para o cadastro de {@link Produto}
 */
@ConversationScoped
public class ManterProdutoBean implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -8482479271582213787L;

	/**
	 * {@link Produto} sendo incluido ou editado.
	 */
	private Produto produto;

	@Inject
	private ManterProdutoFacade manterProdutoFacade;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ManterProdutoFacade getManterProdutoFacade() {
		return manterProdutoFacade;
	}

	public void setManterProdutoFacade(ManterProdutoFacade manterProdutoFacade) {
		this.manterProdutoFacade = manterProdutoFacade;
	}

	public String novo() {
		this.produto = new Produto();
		return "null";
	}

	public void salvar() {
		manterProdutoFacade.salvarProduto(produto);
	}

}

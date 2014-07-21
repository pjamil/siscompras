package br.com.pjsistemas.app.siscompras.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.pjsistemas.app.siscompras.model.BaseEntity;

/**
 * Implementa metodos genericos de persistencia.
 * @param <T> Tipo de entidade a qual a persistencia sera realizada.
 */
public abstract class JpaDaoGenerico<T extends BaseEntity> {
	/**
	 * EntityManager injetado pelo container.
	 */
	@Inject
	@PersistenceContext
	protected EntityManager entityManager;

	@Inject
	private Logger log;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Utilizado pelos metodos de persistencia para a identificacao de qual
	 * classe a persistencia esta sendo feita. Utilizada na implementacao do
	 * padrao Template Method.
	 *
	 * @return a classe da entidade a qual o DAO realiza a persistencia.
	 */
	protected abstract Class<T> getClasseEntidade();

	/**
	 * Insere a entidade na base de dados.
	 *
	 * @param entidade
	 *            Entidade a ser persistida.
	 */
	protected void inserirEntidade(T entidade) {
		entityManager.persist(entidade);
	}

	/**
	 * Exclui a entidade na base de dados.
	 *
	 * @param entidade
	 *            Entidade a ser persistida.
	 */
	protected void excluirEntidade(T entidade) {
		//entityManager.lock(entidade, LockModeType.NONE);
		//entityManager.refresh(entidade);
		final T entity = selecionarEntidade(entidade);
		entityManager.remove(entity);
		//entityManager.flush();
		//entityManager.clear();
	}

	/**
	 * Atualiza a entidade na base de dados.
	 *
	 * @param entidade
	 *            entidade a ser atualizada
	 */
	protected void atualizarEntidade(T entidade) {
		entityManager.merge(entidade);
	}

	/**
	 * Salva a entidade na base de dados.
	 *
	 * @param entidade
	 *            Entidade a ser persistida.
	 */
	protected void salvarEntidade(T entidade) {
		if (entidade.getId() == null) {
			inserirEntidade(entidade);
		} else {
			atualizarEntidade(entidade);
		}
	}

	/**
	 * Seleciona todos os registros aramzenado de um entidade {@link T}
	 * ordenados, ou nao, pelos campos passados.
	 *
	 * @return lista de {@link T}
	 */
	@SuppressWarnings("unchecked")
	protected List<T> selecionarTodos() {
		final Query query = entityManager.createQuery("Select e from "
				+ getClasseEntidade().getName() + " e ");
		return query.getResultList();
	}

	/**
	 * Seleciona uma entidade a apartir de seu ID.
	 *
	 * @param entidade
	 *            Entidade com ID preenchido.
	 * @return as entidades que correspondam aos parametros da consulta.
	 */
	protected T selecionarEntidade(final T entidade) {
		return entityManager.find(getClasseEntidade(), entidade.getId());
	}
}
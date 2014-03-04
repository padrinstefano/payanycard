package com.nxsystems.payanycard.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.common.base.Preconditions;

public abstract class AJpaDao<T extends Serializable> {

	@PersistenceContext
	private EntityManager entityManager;

	protected abstract Class<T> getClazz();
	
	public T getById(final Object id) {
		Preconditions.checkArgument(id != null);
		return (T) this.entityManager.find(getClazz(), id);
	}

	public List<T> getAll() {
		return this.entityManager.createQuery("from " + getClazz().getName(), getClazz()).getResultList();
	}

	public void create(final T entity) {
		Preconditions.checkNotNull(entity);
		this.entityManager.persist(entity);
	}

	public void update(final T entity) {
		Preconditions.checkNotNull(entity);
		this.entityManager.merge(entity);
	}

	public void delete(final T entity) {
		Preconditions.checkNotNull(entity);
		this.entityManager.remove(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = this.getById(entityId);
		Preconditions.checkState(entity != null);
		this.delete(entity);
	}

}

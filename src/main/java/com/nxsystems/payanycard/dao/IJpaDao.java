package com.nxsystems.payanycard.dao;

import java.io.Serializable;
import java.util.List;

public interface IJpaDao<T extends Serializable> {

	public T getById(final Object id);

	public List<T> getAll();

	public void create(final T entity);

	public void update(final T entity);

	public void delete(final T entity);

	public void deleteById(final Long entityId);

}

package com.hcl.slc.stub.poc.base.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

public abstract class AbstractFacade<T>
{
  private Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass)
  {
    this.entityClass = entityClass;
  }

  public int count()
  {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    Root rt = cq.from(this.entityClass);
    cq.multiselect(new Selection[] { getEntityManager().getCriteriaBuilder().count(rt) });
    Query q = getEntityManager().createQuery(cq);
    return ((Long)q.getSingleResult()).intValue();
  }

  public void create(T entity)
  {
    getEntityManager().persist(entity);
  }

  public void edit(T entity)
  {
    getEntityManager().merge(entity);
  }

  public T find(Object id)
  {
    return getEntityManager().find(this.entityClass, id);
  }

  public List<T> findAll()
  {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(this.entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findBy(T e) {
    return null;
  }

  public List<String> findByDistinctNamedQuery(String queryName)
  {
    TypedQuery tq = getEntityManager().createNamedQuery(queryName, String.class);
    return tq.getResultList();
  }

  public List<T> findRange(int[] range)
  {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(this.entityClass));
    Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0]);
    q.setFirstResult(range[0]);
    return q.getResultList();
  }

  protected abstract EntityManager getEntityManager();
  public void remove(T entity)
  {
    getEntityManager().remove(getEntityManager().merge(entity));
  }
}
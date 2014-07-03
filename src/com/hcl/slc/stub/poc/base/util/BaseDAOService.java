package com.hcl.slc.stub.poc.base.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseDAOService<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityManager entityManager;
	
	private Class<T> entity;
	
	public BaseDAOService() {
	}

	public BaseDAOService(Class<T> entity) {
		this.entity = entity;
	}
	
	public void beginTransaction(){
		openEntityManager();
		entityManager.getTransaction().begin();
		//entityManager.joinTransaction();
	}
	
	public void closeEntityManager(){
		entityManager.close();
	}
	public void commit(){
		//entityManager.getTransaction().commit();
		//entityManager.flush();
		entityManager.getTransaction().commit();
	}
	public void commitAndCloseTransaction() {  
		commit();  
		closeEntityManager();  
	}
	public void delete(T entity) {  

		T entityToBeRemoved = entityManager.merge(entity);
		entityManager.remove(entityToBeRemoved);  

	}
	
	public T find(long entityID) {
		
		return entityManager.find(entity, entityID);  

	}  

	public List<T> findAll(){
		
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		
		cq.select(cq.from(entity));
		
		List<T> resultList = entityManager.createQuery(cq).getResultList();
		
		return resultList;
	}  

	public List<T> findAllByNamedQuery(String sql, Map<Integer, Object> inputMap, Class className){
			
			Query query = entityManager.createNamedQuery(sql, className);
			
			populateQueryParam(query, inputMap);
			
			return query.getResultList();
		}  
	public List<T> findAllBySQLQuery(String sql, Map<Integer, Object> inputMap, Class className){
		
		Query query = entityManager.createNativeQuery(sql, className);
		
		populateQueryParam(query, inputMap);
		
		return query.getResultList();
	}  

	@SuppressWarnings("unchecked")
	public List<Object> findAllBySQLQueryObj(String sql, Map<Integer, Object> inputMap){
		
		Query query = entityManager.createNativeQuery(sql);
		
		populateQueryParam(query, inputMap);
				
		return (List<Object>)query.getResultList();
	}  

	@SuppressWarnings("unchecked")
	public T findBySQLQuery (String sql, Map<Integer, Object> inputMap, Class className){
		
		Query query = entityManager.createNativeQuery(sql, className);		
		populateQueryParam(query, inputMap);
				
		return (T)query.getSingleResult();
	}  

	public T findReferenceOnly(int entityID) {  

		return entityManager.getReference(entity, entityID);
	}  

	public void flush() {  
		entityManager.flush();
	} 

	public void joinTransaction() {  
		//entityManager = EntityManagerUtil.getEntityManager();
		openEntityManager();
		entityManager.joinTransaction();  
	}
	
	public void openEntityManager(){
		entityManager = EntityManagerService.getEntityManager();
	}
	
private void populateQueryParam (Query query, Map<Integer, Object> inputMap){
	
	if (null != inputMap){
		for (Entry<Integer, Object> entry : inputMap.entrySet()) {	
			query.setParameter(entry.getKey(), entry.getValue());
			
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	System.out.println("Exit Populate");
}
	
	public void rollback(){
		entityManager.getTransaction().rollback();
	}
		
	
	public void save(T entity) {  

		entityManager.persist(entity);
	}
	
	public T update(T entity) {

		return entityManager.merge(entity);  
	}
	
	public int updateBySQLQuery(String sql, Map<Integer, Object> inputMap){
		
		Query query = entityManager.createNativeQuery(sql);
					
		populateQueryParam(query, inputMap);
	
		System.out.println("SQL : " + query.toString());
		
		return query.executeUpdate();
	}

	
		

}

package com.hcl.slc.stub.poc.service;

import java.util.List;
import java.util.Map;

import com.hcl.slc.stub.poc.daos.StubparamDAO;
import com.hcl.slc.stub.poc.entity.Stubparamconfig;


public class StubparamService {

	
	private StubparamDAO objdao;
	
	public StubparamService(){		
		super();
		objdao = new StubparamDAO();
	}
	
	public void save(Stubparamconfig entity) {	
		objdao.save(entity);
	}
	
	public void delete(Stubparamconfig entity) {
		objdao.delete(entity);
	}

	
	public Stubparamconfig update(Stubparamconfig entity) {
		return objdao.update(entity);
	}

	public Stubparamconfig find(long entityID){		
		return objdao.find(entityID);
	}
	
	public List<Stubparamconfig> findAll(){ 
		return objdao.findAll();
	}
	
	public Stubparamconfig findReferenceOnly(int entityID) {
		return objdao.findReferenceOnly(entityID);
	}

	
	public List<Stubparamconfig> findAllBySQLQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {
		return objdao.findAllBySQLQuery(sql, inputMap, className);
	}

	
	public List<Object> findAllBySQLQueryObj(String sql,
			Map<Integer, Object> inputMap) {
		return objdao.findAllBySQLQueryObj(sql, inputMap);
	}

	
	public Stubparamconfig findBySQLQuery(String sql, Map<Integer, Object> inputMap,
			Class className) {
		return objdao.findBySQLQuery(sql, inputMap, className);
	}

	
	public int updateBySQLQuery(String sql, Map<Integer, Object> inputMap) {
		return objdao.updateBySQLQuery(sql, inputMap);
	}

	
	



}

package com.hcl.slc.stub.poc.service;

import java.util.List;
import java.util.Map;

import com.hcl.slc.stub.poc.daos.AddressDAO;
import com.hcl.slc.stub.poc.entity.Address;


public class AddressService {

	
	private AddressDAO objdao;
	
	public AddressService(){		
		super();
		objdao = new AddressDAO();
	}
	
	public void save(Address entity) {	
		objdao.save(entity);
	}
	
	public void delete(Address entity) {
		objdao.delete(entity);
	}

	
	public Address update(Address entity) {
		return objdao.update(entity);
	}

	public Address find(long entityID){		
		return objdao.find(entityID);
	}
	
	public List<Address> findAll(){ 
		return objdao.findAll();
	}
	
	public Address findReferenceOnly(int entityID) {
		return objdao.findReferenceOnly(entityID);
	}

	
	public List<Address> findAllBySQLQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {
		return objdao.findAllBySQLQuery(sql, inputMap, className);
	}

	
	public List<Object> findAllBySQLQueryObj(String sql,
			Map<Integer, Object> inputMap) {
		return objdao.findAllBySQLQueryObj(sql, inputMap);
	}

	
	public Address findBySQLQuery(String sql, Map<Integer, Object> inputMap,
			Class className) {
		return objdao.findBySQLQuery(sql, inputMap, className);
	}

	
	public int updateBySQLQuery(String sql, Map<Integer, Object> inputMap) {
		return objdao.updateBySQLQuery(sql, inputMap);
	}

	
	



}

package com.hcl.slc.stub.poc.daos;

import java.util.List;
import java.util.Map;

import com.hcl.slc.stub.poc.base.util.BaseDAOService;
import com.hcl.slc.stub.poc.entity.Address;

public class AddressDAO extends BaseDAOService<Address>{
	
	public AddressDAO() {
		super(Address.class);
	}

	@Override
	public void delete(Address entity) {
		// TODO Auto-generated method stub
		super.beginTransaction();
		super.delete(entity);
		super.commit();
	}

	@Override
	public Address find(long entityID) {
		super.openEntityManager();

		Address obj = super.find(entityID);

		super.closeEntityManager();
		return obj;

	}

	@Override
	public List<Address> findAll() {
		super.openEntityManager();
		List<Address> objList = super.findAll();
		super.closeEntityManager();
		return objList;
	}

	@Override
	public List<Address> findAllByNamedQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {
		// TODO Auto-generated method stub
		super.openEntityManager();
		List<Address> objList = super.findAllByNamedQuery(sql, inputMap,
				className);
		super.closeEntityManager();

		return objList;

	}

	@Override
	public List<Address> findAllBySQLQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {

		super.openEntityManager();
		List<Address> objList = super.findAllBySQLQuery(sql, inputMap,
				className);
		super.closeEntityManager();

		return objList;
	}

	@Override
	public List<Object> findAllBySQLQueryObj(String sql,
			Map<Integer, Object> inputMap) {
		super.openEntityManager();
		List<Object> objList = super.findAllBySQLQueryObj(sql, inputMap);
		super.closeEntityManager();

		return objList;

	}

	@Override
	public Address findBySQLQuery(String sql, Map<Integer, Object> inputMap,
			Class className) {
		super.openEntityManager();
		Address obj = super.findBySQLQuery(sql, inputMap, className);
		super.closeEntityManager();

		return obj;

	}

	@Override
	public Address findReferenceOnly(int entityID) {
		super.openEntityManager();
		Address obj = super.findReferenceOnly(entityID);
		super.closeEntityManager();
		return obj;
	}

	@Override
	public void save(Address entity) {
		// TODO Auto-generated method stub
		super.beginTransaction();
		super.save(entity);
		super.commit();
	}

	@Override
	public Address update(Address entity) {
		super.beginTransaction();
		Address obj = super.update(entity);
		super.commitAndCloseTransaction();
		return obj;

	}

	@Override
	public int updateBySQLQuery(String sql, Map<Integer, Object> inputMap) {
		super.beginTransaction();
		int records = super.updateBySQLQuery(sql, inputMap);
		super.commitAndCloseTransaction();

		return records;
	}


	
}

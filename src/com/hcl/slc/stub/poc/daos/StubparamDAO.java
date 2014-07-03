package com.hcl.slc.stub.poc.daos;

import java.util.List;
import java.util.Map;

import com.hcl.slc.stub.poc.base.util.BaseDAOService;
import com.hcl.slc.stub.poc.entity.Stubparamconfig;

public class StubparamDAO extends BaseDAOService<Stubparamconfig>{
	
	public StubparamDAO() {
		super(Stubparamconfig.class);
	}

	@Override
	public void delete(Stubparamconfig entity) {
		// TODO Auto-generated method stub
		super.beginTransaction();
		super.delete(entity);
		super.commit();
	}

	@Override
	public Stubparamconfig find(long entityID) {
		super.openEntityManager();

		Stubparamconfig obj = super.find(entityID);

		super.closeEntityManager();
		return obj;

	}

	@Override
	public List<Stubparamconfig> findAll() {
		super.openEntityManager();
		List<Stubparamconfig> objList = super.findAll();
		super.closeEntityManager();
		return objList;
	}

	@Override
	public List<Stubparamconfig> findAllByNamedQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {
		// TODO Auto-generated method stub
		super.openEntityManager();
		List<Stubparamconfig> objList = super.findAllByNamedQuery(sql, inputMap,
				className);
		super.closeEntityManager();

		return objList;

	}

	@Override
	public List<Stubparamconfig> findAllBySQLQuery(String sql,
			Map<Integer, Object> inputMap, Class className) {

		super.openEntityManager();
		List<Stubparamconfig> objList = super.findAllBySQLQuery(sql, inputMap,
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
	public Stubparamconfig findBySQLQuery(String sql, Map<Integer, Object> inputMap,
			Class className) {
		super.openEntityManager();
		Stubparamconfig obj = super.findBySQLQuery(sql, inputMap, className);
		super.closeEntityManager();

		return obj;

	}

	@Override
	public Stubparamconfig findReferenceOnly(int entityID) {
		super.openEntityManager();
		Stubparamconfig obj = super.findReferenceOnly(entityID);
		super.closeEntityManager();
		return obj;
	}

	@Override
	public void save(Stubparamconfig entity) {
		// TODO Auto-generated method stub
		super.beginTransaction();
		super.save(entity);
		super.commit();
	}

	@Override
	public Stubparamconfig update(Stubparamconfig entity) {
		super.beginTransaction();
		Stubparamconfig obj = super.update(entity);
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

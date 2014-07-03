package com.hcl.slc.stub.poc.dynamic;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.log4j.Logger;

import com.hcl.slc.stub.poc.entity.Stubparamconfig;

public class DynamicBeanCreator {
	static Logger logger = Logger.getLogger(DynamicBeanCreator.class);
	public Object createDymanicBean(DynaProperty[] prop,List<Stubparamconfig> stublist) {
		try {
			DynamicFieldDataGen datagenerator=new DynamicFieldDataGen();
			DynaClass dynaclass = new BasicDynaClass("slcdynamic", null, prop);
			DynaBean dynabean = dynaclass.newInstance();
			int i=0;
			for (Stubparamconfig s : stublist) {
				i++;
				dynabean.set(s.getSourcefieldname(),datagenerator.parseFileds(s));
				logger.info("s.getSourceColumnName()"+BeanUtils.getProperty(dynabean,s.getSourcefieldname()));
				System.out.println(s.getSourcefieldname()+":"+BeanUtils.getProperty(dynabean,s.getSourcefieldname()));
			}
			return dynabean;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}

package com.hcl.slc.stub.poc.dynamic;

import java.util.List;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.log4j.Logger;

import com.hcl.slc.stub.poc.entity.Stubparamconfig;

public class DynamicPropertyCreator {

	static Logger logger = Logger.getLogger(DynamicPropertyCreator.class);

	public DynaProperty[] createDynamicProperty(List<Stubparamconfig> list)
	{
		try{
			DynaProperty prop[] = new DynaProperty[list.size()];
			/*creating the dynamic properties*/
			int propno=0;
			Class classtype;
			for(Stubparamconfig s:list)
			{
				/*if(s.getDatatype()!="Date")
				{
					classtype=Class.forName("java.lang."+s.getDatatype());
					
				}
				else
				{
					classtype=Class.forName("java.util."+s.getDatatype());
				}
				System.out.println(classtype);*/
				classtype=Class.forName(s.getSourcedatatype());
				prop[propno] = new DynaProperty(s.getSourcefieldname(),classtype);
				propno++;
			}
			logger.info("Total Dynamic Properties Created:"+prop.length);
			System.out.println("Total Dynamic Properties Created:"+prop.length);
			return prop;
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

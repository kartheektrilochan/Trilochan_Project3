package stub.research;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.fluttercode.datafactory.impl.DataFactory;

import com.hcl.slc.stub.poc.controller.StubparamController;
import com.hcl.slc.stub.poc.entity.Address;
import com.hcl.slc.stub.poc.entity.Stubparamconfig;

public class ClassFieldsParserTemp {

	
	public void parseFileds(Object obj,List<Stubparamconfig> stublist)
	{
		//Class cls = Address.class;
		try {
			
		Class cls = DataFactory.class;
		DataFactory factory=new DataFactory();
		Address add = new Address();
		Method[] m=cls.getMethods();
		List<Method> slist=Arrays.asList(m);
		List<String> methodnames=new ArrayList<String>(m.length);
		for(int p=0;p<m.length;p++)
		{
			methodnames.add(m[p].getName());
		}
		for(String str:methodnames)
		{
			if(str.contains("Address"))
			{
				System.out.println("str:"+str);
			}
		}
		
		System.out.println("first:"+methodnames.contains("getAddress"));
		Collections.sort(methodnames);
		int pointer=0;
		while(pointer!=methodnames.size())
		{
			int index = Collections.binarySearch(methodnames,"getAddress");
			System.out.println("index:"+index);
            String tempArrayString = methodnames.get(index).toString();

            if( tempArrayString.toLowerCase().contains("Address") ) {

                 System.out.println("Element found at : " + index);
            }

            pointer++;
        }

		Arrays.binarySearch(m, "Address");
		//System.out.println(factory.getNumberBetween(10, 100));
		System.out.println(m.length);
		for(int i=0;i<m.length;i++)
		{
			//System.out.println(m[i].getGenericParameterTypes().length);
			
			if(m[i].getName().startsWith("get")&&(!m[i].getName().endsWith("Number"))&&(m[i].getGenericParameterTypes().length==0))
			{
				System.out.println(m[i].getName());
				
			}
		}
		for(int i=0;i<m.length;i++)
		{
			//System.out.println(!m[i].getName().endsWith("Number"));
			if(m[i].getName().startsWith("get")&&(!m[i].getName().endsWith("Number"))&&(m[i].getGenericParameterTypes().length==0))
			{
					System.out.println(m[i].getName()+":"+m[i].invoke(factory, null));
				
			}
		}

//		/System.out.println("fields.length:" + fields.length);
		/*
		 * Search for the available fields from the database and assign it
		 * to the fields
		 */
		/*for (int k = 0; k < fields.length; k++) {
			System.out.println(fields[k].getName());
			for (Stubparamconfig s : stublist)
			{
				if (s.getDestfield().equals(fields[k].getName())) 
				{
					fields[k].setAccessible(true);
					fields[k].set(add, BeanUtils.getProperty(obj,s.getSourcefield()));
				}
			}
		}*/
		//return add;
	
		}  catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
		System.out.println("executing");
		ClassFieldsParserTemp parser=new ClassFieldsParserTemp();
		StubparamController controller=new StubparamController();
		List<Stubparamconfig> stublist=controller.getFullDetails();
		parser.parseFileds(new Object(), stublist);
		
	}
}

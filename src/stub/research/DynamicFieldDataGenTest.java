package stub.research;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.fluttercode.datafactory.impl.DataFactory;

import com.hcl.slc.stub.poc.controller.StubparamController;
import com.hcl.slc.stub.poc.entity.Stubparamconfig;

public class DynamicFieldDataGenTest {

	public Object parseFileds(Stubparamconfig stubparamconfig) {
		String fieldname=stubparamconfig.getSourcefieldname();
		fieldname = convertToSuitableCase(fieldname);
		System.out.println("Parameter is:" + fieldname);
		int methodsmatched=0;
		try {
			Class cls = DataFactory.class;
			DataFactory factory = new DataFactory();
			Method[] avail_methods = cls.getMethods();
			List<Method> bestmethods=new ArrayList<Method>();
			List<Integer> stringdiff=new ArrayList<Integer>();
			Object obj = null;
			/*below logic is to generate data when 
			 * use test data is enabled in database for the particular column*/
			/*Generating the data using datafactory*/
			if(stubparamconfig.getUsetestdata().equalsIgnoreCase("false"))
			{
				System.out.println("Generating Data using DataFactory");
				for (int index = 0; index < avail_methods.length; index++) {
					
					if (avail_methods[index].getName().contains(fieldname)&& (!avail_methods[index].getName().endsWith("Number"))&& (avail_methods[index].getGenericParameterTypes().length == 0)) {
						obj = avail_methods[index].invoke(factory, null);
						System.out.println("Matched Methods in DataFactory are::"+avail_methods[index].getName());
						bestmethods.add(avail_methods[index]);
					}
					
				}
				if(bestmethods.size()!=0)
				{
					System.out.println("No.of methods matched in datafactory:"+bestmethods.size());
					for(methodsmatched=0;methodsmatched<bestmethods.size();methodsmatched++)
					{
						System.out.println("Selecting the best method from datafactory");
						//System.out.println(bestmethods.get(methodsmatched).getName().length()-fieldname.length());
						stringdiff.add(bestmethods.get(methodsmatched).getName().length()-fieldname.length());
				}
				int test=stringdiff.indexOf(Collections.min(stringdiff));
				obj=bestmethods.get(test).invoke(factory, null);
				}
				if(obj==null)
				{
					System.out.println("No Methods are available in datafactory:Selecting Random Method to Generate data");
					obj=createRandomText(factory,stubparamconfig);
				}
			}
			else
			{
				/*taking data from database*/
				System.out.println("UseTestData column is set to true so selecting the data from TESTDATA Column");
				String db_data=stubparamconfig.getTestdata();
				StringTokenizer stringtokenizer=new StringTokenizer(db_data,",");
				List<Object> value_list=new ArrayList<Object>();
				while(stringtokenizer.hasMoreElements())
				{
					value_list.add(stringtokenizer.nextElement());
				}
				Object[] objarray=value_list.toArray(new String[value_list.size()]);
				obj=objarray[new Random().nextInt(objarray.length)];
				System.out.println(obj);
			}
			return obj;

		} catch (SecurityException e) {
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
		return null;
	}

	private Object createRandomText(DataFactory factory,Stubparamconfig stubparamconfig) 
	{
		int data_length=Integer.valueOf(stubparamconfig.getDatalength());
		System.out.println("data_length:"+data_length);
		String randomword;
		int random_number;
		if(stubparamconfig.getSourcedatatype().equals("java.lang.String"))
		{
			randomword=factory.getRandomText(data_length);
			return randomword;
		}
		else if(stubparamconfig.getSourcedatatype().equals("java.math.BigDecimal"))
		{
			System.out.println("Big Decimal");
			random_number=factory.getNumberUpTo(100000);
			BigDecimal num=new BigDecimal(random_number);
			return num;
		}
		else if(stubparamconfig.getSourcedatatype().equals("java.lang.Integer"))
		{
			System.out.println("Integer");
			random_number=factory.getNumberUpTo(100000);
			return random_number;
		}
		return null;
	}

	private String convertToSuitableCase(String fieldname) {
		
		return fieldname.substring(0,1).toUpperCase() + fieldname.substring(1).toLowerCase();
	}

	public static void main(String[] args) {
		System.out.println("executing");
		DynamicFieldDataGenTest parser = new DynamicFieldDataGenTest();
		StubparamController controller = new StubparamController();
		List<Stubparamconfig> stublist = controller.getFullDetails();
		System.out.println("trilochan:" + parser.parseFileds(stublist.get(0)));
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
/*		System.out.println("trilochan:" + parser.parseFileds(stublist.get(1)));
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
		System.out.println("trilochan:" + parser.parseFileds(stublist.get(2)));
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
		System.out.println("trilochan:" + parser.parseFileds(stublist.get(3)));
*/
	}
}

package stub.framework.client;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.DynaProperty;

import com.hcl.slc.stub.poc.controller.StubparamController;
import com.hcl.slc.stub.poc.dynamic.DynamicBeanCreator;
import com.hcl.slc.stub.poc.dynamic.DynamicPropertyCreator;
import com.hcl.slc.stub.poc.dynamic.FieldSetterGetterBean;
import com.hcl.slc.stub.poc.entity.Address;
import com.hcl.slc.stub.poc.entity.Stubparamconfig;
import com.hcl.slc.stub.poc.service.AddressService;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream propfile = new FileInputStream(
					"config\\config.properties");
			Properties prop = new Properties();
			prop.load(propfile);
			String destination = (String) prop.get("destination");
			System.out.println("Destination:" + destination);
			StubparamController bean = new StubparamController();
			List<Stubparamconfig> stublist = bean.getFullDetails();

			DynamicPropertyCreator propcreator = new DynamicPropertyCreator();
			DynaProperty[] dynaprop = propcreator
					.createDynamicProperty(stublist);

			DynamicBeanCreator beancreator = new DynamicBeanCreator();
			Object obj1 = beancreator.createDymanicBean(dynaprop, stublist);

			FieldSetterGetterBean fieldsetterbean = new FieldSetterGetterBean();
			Address address = (Address) fieldsetterbean.assignValues2Fields(
					obj1, stublist);
			List<Address> addresslist = new ArrayList<Address>();
			addresslist.add(address);
			AddressService service=new AddressService();
			for(Address a:addresslist)
			{
				service.save(a);
			}
			/*CamelClient client=new CamelClient();
			client.sendToMQ(addresslist, destination);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package stub.framework.client;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import test.CamelUtilTest;

import com.hcl.slc.stub.poc.camel.CamelUtil;
import com.hcl.slc.stub.poc.controller.AddressController;
import com.hcl.slc.stub.poc.entity.Address;

public class CamelClient {

	public static void main(String[] args) {
		try {
			CamelClient client = new CamelClient();
			FileInputStream propfile = new FileInputStream("config\\config.properties");
			Properties prop = new Properties();
			prop.load(propfile);
			String destination = (String) prop.get("destination");
			System.out.println("Destination:" + destination);
			AddressController controller = new AddressController();
			List<Address> addresslist = controller.getFullDetails();
			client.sendToMQ(addresslist, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendToMQ(List<Address> addresslist, String destination) {
		try {
			CamelUtil util = new CamelUtil();
			//CamelUtilTest util = new CamelUtilTest();
			util.sendToRoutes(addresslist, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

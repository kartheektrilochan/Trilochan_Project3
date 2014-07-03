package stub.research;

import com.hcl.slc.stub.poc.entity.Address;
import com.hcl.slc.stub.poc.service.AddressService;

public class ManualInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Address address=new Address();
		//address.setAddressid("2");
		address.setDocid("2");
		address.setUbisarchive("N");
		address.setUbpremisesstatus("hi");
		address.setUbisdelete("N");
		AddressService service=new AddressService();
		service.save(address);
	}

}

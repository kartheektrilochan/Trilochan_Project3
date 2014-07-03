package com.hcl.slc.stub.poc.controller;

import java.util.List;

import com.hcl.slc.stub.poc.entity.Address;
import com.hcl.slc.stub.poc.service.AddressService;


public class AddressController {

		private AddressService service;
		
		public AddressController(){
			super();
			service=new AddressService();
		}
		
		public List<Address> getFullDetails()
		{
			List<Address> stublist=service.findAll();
			System.out.println(stublist.size());
			return stublist;
		}
		
		
		public static void main(String[] args) {
			AddressController controller=new AddressController();
			controller.getFullDetails();
		}




}

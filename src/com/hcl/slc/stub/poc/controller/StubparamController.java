package com.hcl.slc.stub.poc.controller;

import java.util.List;

import com.hcl.slc.stub.poc.entity.Stubparamconfig;
import com.hcl.slc.stub.poc.service.StubparamService;


public class StubparamController {

		private StubparamService service;
		
		public StubparamController(){
			super();
			service=new StubparamService();
		}
		
		public List<Stubparamconfig> getFullDetails()
		{
			List<Stubparamconfig> stublist=service.findAll();
			return stublist;
		}
		
		
		public static void main(String[] args) {
			StubparamController controller=new StubparamController();
			controller.getFullDetails();
		}




}

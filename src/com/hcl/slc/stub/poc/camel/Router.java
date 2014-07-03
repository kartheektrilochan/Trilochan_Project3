package com.hcl.slc.stub.poc.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class Router extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("direct:startRq").to("velocity:file:config/AddressTemplate.vm").
			choice().when(header("destination").isEqualTo("FILE")).to("file:data/OUT")
					.when(header("destination").isEqualTo("QUEUE")).to("slc-jms:queue:SLC_Queue_OUT")
					.otherwise().to("slc-jms:queue:temp");
		
		from("slc-jms:queue:SLC_Queue_IN").to("file:data/IN");
		
		from("slc-jms:queue:SLC_Queue_OUT").to("slc-jms:queue:SLC_Queue_IN");
		
		/*from("direct:startRq").
				choice().
				when(header("destination").isEqualTo("BACSFILE")).to("file:data/BACS")
				.when(header("destination").isEqualTo("QUEUE")).to("slc-jms:queue:SLC_Queue_OUT").process(new Processor() {
					
					public void process(Exchange arg0) throws Exception {
						System.out.println("this is callad");
						System.out.println(arg0.getIn().getBody());
					}
				})
				.otherwise().to("slc-jms:queue:temp");
		from("slc-jms:queue:SLC_Queue_OUT").to("file:data/temp");
		from("slc-jms:queue:SLC_Queue_IN").to("file:data/IN");*/
	
		
	}

}

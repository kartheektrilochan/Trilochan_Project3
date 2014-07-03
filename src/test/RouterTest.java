package test;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.hcl.slc.stub.poc.entity.Address;

public class RouterTest extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("direct:startRq").to("velocity:file:config/AddressTemplate.vm").process(new Processor() {
			
			public void process(Exchange arg0) throws Exception {
				String s=arg0.getIn().getBody(String.class);
				System.out.println(">>>>>>>>>"+s);				
			}
		}).
			choice().when(header("destination").isEqualTo("BACSFILE")).to("file:data/BACS")
					.when(header("destination").isEqualTo("QUEUE")).to("slc-jms:queue:SLC_Queue_OUT").to("slc-jms:queue:SLC_Queue_IN").process(new Processor() {
						
						public void process(Exchange arg0) throws Exception {
						System.out.println("its working");
							
						}
					})
					.otherwise().to("slc-jms:queue:temp");
		from("slc-jms:queue:SLC_Queue_OUT").to("slc-jms:queue:SLC_Queue_IN");
		from("slc-jms:queue:SLC_Queue_IN").process(new Processor() {
			
			public void process(Exchange arg0) throws Exception {
				System.out.println("this is calling fine");
			}
		}).to("file:data/IN");
		
		/*from("direct:startRq").
				choice().
				when(header("destination").isEqualTo("BACSFILE")).to("file:data/BACS")
				.when(header("destination").isEqualTo("QUEUE")).to("slc-jms:queue:SLC_Queue_OUTTest").process(new Processor() {
					
					public void process(Exchange arg0) throws Exception {
						System.out.println("this is callad");
						System.out.println(arg0.getIn().getBody(Address.class));
					}
				})
				.otherwise().to("slc-jms:queue:temp");
		from("slc-jms:queue:SLC_Queue_OUT").to("file:data/temp");
		from("slc-jms:queue:SLC_Queue_IN").to("file:data/IN");*/
	
		
	}

}

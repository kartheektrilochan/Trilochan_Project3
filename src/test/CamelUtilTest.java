package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;

import com.hcl.slc.stub.poc.entity.Address;

public class CamelUtilTest {

	public void sendToRoutes(List<Address> cmdlist, String destination) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connection = new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("slc-jms", JmsComponent.jmsComponentAutoAcknowledge(connection));
		context.addRoutes(new RouterTest());
		context.start();
		
		ProducerTemplate temp = context.createProducerTemplate();
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("destination",destination);
		/*temp.asyncSendBody("direct:startRq", cmdlist);*/
		
		temp.asyncRequestBodyAndHeaders("direct:startRq", cmdlist,properties);
		ConsumerTemplate cons = context.createConsumerTemplate();
		cons.start();
		System.out.println("context started");
		Thread.sleep(2000);
		System.out.println("Context stopped");
		//context.stop();
	}

}

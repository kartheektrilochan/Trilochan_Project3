package stub.research;

import org.fluttercode.datafactory.impl.DataFactory;

public class DataTest {

	public static void main(String[] args) {

		DataFactory factory=new DataFactory();
		
		System.out.println(factory.getAddress());
		String s=factory.getRandomText(120);
		System.out.println(s);
		int i=factory.getNumberUpTo(100000);
		System.out.println(i);
	}

}

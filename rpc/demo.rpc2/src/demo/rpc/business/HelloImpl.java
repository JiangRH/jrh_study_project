package demo.rpc.business;

public class HelloImpl implements IHello {

	public String sayHello(String name) {
		return "Hello, " + name + ", This is an RPC test";
	}


}

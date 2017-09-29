package demo.rpc.business;

public class HelloImpl implements IHello {

	public String sayHello(String name) {
		return "Hello, " + name + ", This is an RPC test";
	}

	@Override
	public void dolog(String log) {
		System.out.println("Print log info ----> " + log);
	}

	@Override
	public String sayHello(int age) {
		return "Age is : "+ age;
	}

}

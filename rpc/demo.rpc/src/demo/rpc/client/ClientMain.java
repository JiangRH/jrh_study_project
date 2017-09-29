package demo.rpc.client;

import demo.rpc.business.IHello;

public class ClientMain
{

	public static void main(String[] args)
	{
		String host = "127.0.0.1";
		int port = 8080;
		try
		{
			IHello hello = (IHello) RPCClient.getProxy(IHello.class.getName(), host, port);

			System.out.println(hello.sayHello("Tom"));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

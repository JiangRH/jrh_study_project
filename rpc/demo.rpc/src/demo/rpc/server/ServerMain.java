package demo.rpc.server;

import demo.rpc.business.HelloImpl;
import demo.rpc.business.IHello;

public class ServerMain
{

	public static void main(String[] args) throws InterruptedException
	{
		RPCServer rpcServer = new RPCServer(8080);
		// ע�����
		rpcServer.register(IHello.class.getName(), new HelloImpl());
		// ����������
		rpcServer.start();

		Thread.sleep( 10 * 1000);

		// ͣ��������
		rpcServer.stop();
	}

}

package demo.rpc.server;

import demo.rpc.business.HelloImpl;
import demo.rpc.business.IHello;

public class ServerMain
{

	public static void main(String[] args) throws InterruptedException
	{
		RPCServer rpcServer = new RPCServer(8080);
		// 注册服务
		rpcServer.register(IHello.class.getName(), new HelloImpl());
		// 启动服务器
		rpcServer.start();

		Thread.sleep( 10 * 1000);

		// 停掉服务器
		rpcServer.stop();
	}

}

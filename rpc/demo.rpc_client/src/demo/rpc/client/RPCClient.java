package demo.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import demo.rpc.protocol.InvokerBean;
import demo.rpc.protocol.RPCMethod;

public class RPCClient
{

	public static Object getProxy(String name, String host, int port) throws ClassNotFoundException,
			UnknownHostException
	{
		Class<?> interfaceClass = Class.forName(name);
		InvocationHandler handler = new ClientInvocationHandler(name, InetAddress.getByName(host), port);
		// ���ô�����ķ�����ʵ�����ǵ���handler��invoke����
		return Proxy.newProxyInstance(RPCClient.class.getClassLoader(), new Class<?>[] { interfaceClass }, handler);
	}

}

class ClientInvocationHandler implements InvocationHandler
{

	private InetAddress address;

	private int port;

	private String name;

	public ClientInvocationHandler(String name, InetAddress address, int port)
	{
		super();
		this.address = address;
		this.port = port;
		this.name = name;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		// �ѵ��÷����������Ϣ��װ��bean��
		InvokerBean invokerBean = new InvokerBean(name, new RPCMethod(method.getName(), method.getParameterTypes()), args);

		// ����socket
		Socket client = new Socket(address, port);

		// �����л�����ת��������ʹ��JDK�Դ���ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
		oos.writeObject(invokerBean);
		oos.flush();

		// ��ȡ����˷��صĽ��
		ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
		invokerBean = (InvokerBean) ois.readObject();

		oos.close();
		ois.close();
		client.close();

		return invokerBean.getResult();
	}

}
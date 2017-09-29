package demo.rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import demo.rpc.protocol.InvokerBean;

public class Listener extends Thread
{

	private RPCServer rpcServer;

	public Listener(RPCServer rpcServer)
	{
		this.rpcServer = rpcServer;
	}

	public void run()
	{
		ServerSocket server = null;
		try
		{
			System.out.println("server start...");
			server = new ServerSocket(rpcServer.getPort());

			while (rpcServer.isRun())
			{
				// �����ͻ��˵����󣬸÷�������������ʹ������RPCServer��stop������Ҳ���ڽ��յ�һ������֮���ֹͣ��
				Socket socket = server.accept();

				// �������Կͻ��˵���
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				InvokerBean invokerBean = (InvokerBean) ois.readObject();
				String serviceName = invokerBean.getServiceName();
				String methodName = invokerBean.getMethod().getMethodname();
				Class<?>[] parameterType = invokerBean.getMethod().getParameterType();
				Object[] parameters = invokerBean.getParameters();
				System.out.println("invoking... serviceName = " + serviceName + ". methodName = " + methodName);

				// ��ע��ķ����б��У���ȡ���񣬲����÷�����е���
				Object service = rpcServer.getServiceEngine().get(serviceName);
				if (service == null)
				{
					System.err.println("service not found!");
				} else
				{
					Class<?> InterfaceClass = Class.forName(serviceName);
					Method method = InterfaceClass.getMethod(methodName, parameterType);
					Object result = method.invoke(service, parameters);
					invokerBean.setResult(result);
				}

				// ����result
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(invokerBean);
				oos.flush();

				socket.close();
				System.out.println("invoking over");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				server.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Server stoped.");
	}

}

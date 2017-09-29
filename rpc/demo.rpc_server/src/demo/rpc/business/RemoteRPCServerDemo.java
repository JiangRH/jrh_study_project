package demo.rpc.business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteRPCServerDemo {

	private static boolean isRun = true;

	public static void main(String[] args) {
		run();
	}

	private static void run() {
		ServerSocket server = null;
		try {
			System.out.println("server start...");
			server = new ServerSocket(8080);

			while (isRun) {
				// �����ͻ��˵����󣬸÷�������������ʹ������RPCServer��stop������Ҳ���ڽ��յ�һ������֮���ֹͣ��
				Socket socket = server.accept();

				// �������Կͻ��˵���
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Object invokerBeanName = ois.readObject();
				String methodName = (String) ois.readObject();
				Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
				Object[] methodParams = (Object[]) ois.readObject();
				
				Object realObj = null;
				Object result = null;
				System.out.println("========invokerBeanName============"+invokerBeanName);
				if(IHello.class.getSimpleName().equals(invokerBeanName)) {
					realObj = new HelloImpl();
					Method method = realObj.getClass().getMethod(methodName, parameterTypes);
					result = method.invoke(realObj, methodParams);
				}

				// ����result
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(result);
				oos.flush();

				socket.close();
				System.out.println("invoking over");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Server stoped.");
	}

}

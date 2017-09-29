package demo.rpc.business;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class RemoteRPCClientDemo {
	
	public static void main(String[] args) {
		try {
			IHello hello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class<?>[] { IHello.class }, new IHelloProxyInvocationHandler2());
			String result = hello.sayHello("rhjiang");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class IHelloProxyInvocationHandler2 implements InvocationHandler {
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Socket client = new Socket("127.0.0.1", 8080);

		// �����л�����ת��������ʹ��JDK�Դ���ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
		if(proxy instanceof IHello) {
			oos.writeObject(IHello.class.getSimpleName());
		}
		oos.writeObject(method.getName());
		oos.writeObject(method.getParameterTypes());
		oos.writeObject(args);
		oos.flush();

		// ��ȡ����˷��صĽ��
		ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
		Object result = ois.readObject();

		oos.close();
		ois.close();
		client.close();

		return result;
	}
	
}

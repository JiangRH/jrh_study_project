package demo.rpc.business;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LocalProxyDemo {
	
	public static void main(String[] args) {
		try {
			IHello hello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class<?>[] { IHello.class }, new IHelloProxyInvocationHandler());
			String result = hello.sayHello("===========");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class IHelloProxyInvocationHandler implements InvocationHandler {
	
	IHello hello = new HelloImpl();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass().getCanonicalName());
		System.out.println(proxy instanceof IHello);
		return method.invoke(hello, args);
	}
	
}

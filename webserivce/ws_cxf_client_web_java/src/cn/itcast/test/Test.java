package cn.itcast.test;

import cn.itcast.server.HelloWorld;
import cn.itcast.server.HelloWorldService;

/**
 * @Description 描述：
 *
 * @author  JRH
 * @date    2014年6月22日 下午8:01:50
 * @version v1.0.0
 */
public class Test {

	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldService();
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		System.out.println(helloWorld.sayHi("老蒋"));
	}
	
}

package cn.itcast.test;

import cn.itcast.server.HelloWorld;
import cn.itcast.server.HelloWorldService;

/**
 * @Description 描述：
 *
 * @author  JRH
 * @date    2014年6月22日 下午12:43:12
 * @version v1.0.0
 */
public class TestWs {

	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldService();
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		String rs = helloWorld.sayHi("老蒋");
		System.out.println(rs);
	}
	
}

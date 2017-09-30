package test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.initialjiang.wserice.demo.JdkWS;

public class TestJdkWS2 {

	public static void main(String[] args) throws Exception {

		// 定义webservice的命名空间名称
		String ns = "http://demo.wserice.initialjiang.com/";

		// 定义webservice的使用说明书的地址
		URL url = new URL("http://localhost:8080/jdkwsdemo/demo.JdkWebService?wsdl");

		// 指定本地部分myServiceName
		QName serviceqname = new QName(ns, "JdkWSService");
		Service service = Service.create(url, serviceqname);

		// 指定本地部分myPortName
		QName protqname = new QName(ns, "JdkWSPort");
		JdkWS jdkWS = service.getPort(protqname, JdkWS.class);
		
		String rs = jdkWS.doSomething("===================张三");
		System.out.println(rs);
	}
}

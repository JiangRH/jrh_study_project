package cn.itcast.server;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class HelloWorldImpl implements HelloWorld {

	private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public String sayHi(String name) {
		System.out.println("薪火SOFT 欢迎您，"+name+"先生/女士");
		return "hi!薪火SOFT 欢迎您，"+name+" 先生/女士， 当前时间:"+SDF.format(new Date());
	}
}

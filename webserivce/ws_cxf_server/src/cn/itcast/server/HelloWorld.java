package cn.itcast.server;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public interface HelloWorld {
	public String sayHi(String name);
}

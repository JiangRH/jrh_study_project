package cn.itcast.server;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * @Description 描述：
 * 	
 * 	该web service wsdl 说明书查看路径：
 * 
 * 		http://localhost:8180/ws_cxf_server_web/ws/helloworld?wsdl
 *
 * @author  JRH
 * @date    2014年6月22日 下午6:54:19
 * @version v1.0.0
 */
@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public interface HelloWorld {
	public String sayHi(String name);
}

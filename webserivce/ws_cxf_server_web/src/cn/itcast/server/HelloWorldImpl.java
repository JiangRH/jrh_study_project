package cn.itcast.server;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * @Description 描述：
 * 	
 * 	该web service wsdl 说明书查看路径：
 * 
 * 		http://localhost:8180/ws_cxf_server_web/ws/helloworld?wsdl
 * 
 * 生成客户端的方式： 下载CXF   http://www.apache.org/dyn/closer.lua/cxf/2.7.18/apache-cxf-2.7.18.zip
 * 不要使用 cxf-3.x ， 3.x 需要jdk1.8
 * 运行后，执行 
 * D:\Program Files\apache-cxf-2.7.18\bin\wsdl2java -p com.aa -d d:/ -client http://localhost:8180/ws_cxf_server_web/ws/helloworld?wsdl
 * 参数说明:
	-p 也就是package 对应java中的包
	-d 输入目录,生成.java文件会在该目录,会自动添加-p参数配置的包路径
	-client 生成客户端测试web service的代码.
	-server 生成服务器启动web  service的代码.
	-impl 生成web service的实现代码.
	-ant  生成build.xml文件.
	-all 生成上面-client -server -impl -ant 对应的所有文件.
 * @param args
 *
 * @author  JRH
 * @date    2014年6月22日 下午6:54:19
 * @version v1.0.0
 */
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

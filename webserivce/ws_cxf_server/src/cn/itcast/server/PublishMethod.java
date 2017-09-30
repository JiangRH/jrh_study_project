package cn.itcast.server;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class PublishMethod {

	/**
	 * 生成客户端的方式： 下载CXF   http://www.apache.org/dyn/closer.lua/cxf/2.7.18/apache-cxf-2.7.18.zip
	 * 不要使用 cxf-3.x ， 3.x 需要jdk1.8
	 * 运行后，执行 
	 * D:\Program Files\apache-cxf-2.7.18\bin\wsdl2java -p com.aa -d d:/ -client http://localhost:8180/helloworld?wsdl
	 * 参数说明:
		-p 也就是package 对应java中的包
		-d 输入目录,生成.java文件会在该目录,会自动添加-p参数配置的包路径
		-client 生成客户端测试web service的代码.
		-server 生成服务器启动web  service的代码.
		-impl 生成web service的实现代码.
		-ant  生成build.xml文件.
		-all 生成上面-client -server -impl -ant 对应的所有文件.
	 * @param args
	 */
	public static void main(String[] args) {
		JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
		//创建访问的地址  // http://localhost:8180/helloworld?wsdl
		server.setAddress("http://localhost:8180/helloworld");
		//设置需要发布的接口
		server.setServiceClass(HelloWorld.class);
		//设置需要发布的实现类
		server.setServiceBean(new HelloWorldImpl());
		//添加输入的拦截器
		server.getInInterceptors().add(new LoggingInInterceptor());
		//添加输出的拦截器
		server.getOutInterceptors().add(new LoggingOutInterceptor());
		//发布服务
		server.create();
	}

}

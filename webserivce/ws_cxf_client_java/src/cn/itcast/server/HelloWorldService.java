package cn.itcast.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.0 2014-06-22T12:38:45.492+08:00
 * Generated source version: 3.0.0
 * 
 */
@WebServiceClient(name = "HelloWorldService", wsdlLocation = "http://localhost:8180/helloworld?wsdl", targetNamespace = "http://server.itcast.cn/")
public class HelloWorldService extends Service {

	public final static URL WSDL_LOCATION;

	public final static QName SERVICE = new QName("http://server.itcast.cn/", "HelloWorldService");
	public final static QName HelloWorldPort = new QName("http://server.itcast.cn/", "HelloWorldPort");
	static {
		URL url = null;
		try {
			url = new URL("http://localhost:8180/helloworld?wsdl");
		} catch (MalformedURLException e) {
			java.util.logging.Logger.getLogger(HelloWorldService.class.getName()).log(java.util.logging.Level.INFO, "Can not initialize the default wsdl from {0}", "http://localhost:8180/helloworld?wsdl");
		}
		WSDL_LOCATION = url;
	}

	public HelloWorldService(URL wsdlLocation) {
		super(wsdlLocation, SERVICE);
	}

	public HelloWorldService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public HelloWorldService() {
		super(WSDL_LOCATION, SERVICE);
	}

	// This constructor requires JAX-WS API 2.2. You will need to endorse the
	// 2.2
	// API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
	// 2.1
	// compliant code instead.
	public HelloWorldService(WebServiceFeature... features) {
		super(WSDL_LOCATION, SERVICE, features);
	}

	// This constructor requires JAX-WS API 2.2. You will need to endorse the
	// 2.2
	// API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
	// 2.1
	// compliant code instead.
	public HelloWorldService(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, SERVICE, features);
	}

	// This constructor requires JAX-WS API 2.2. You will need to endorse the
	// 2.2
	// API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS
	// 2.1
	// compliant code instead.
	public HelloWorldService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 *
	 * @return returns HelloWorld
	 */
	@WebEndpoint(name = "HelloWorldPort")
	public HelloWorld getHelloWorldPort() {
		return super.getPort(HelloWorldPort, HelloWorld.class);
	}

	/**
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns HelloWorld
	 */
	@WebEndpoint(name = "HelloWorldPort")
	public HelloWorld getHelloWorldPort(WebServiceFeature... features) {
		return super.getPort(HelloWorldPort, HelloWorld.class, features);
	}

}

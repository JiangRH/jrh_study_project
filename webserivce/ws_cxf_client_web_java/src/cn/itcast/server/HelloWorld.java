package cn.itcast.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.0
 * 2014-06-22T18:53:42.801+08:00
 * Generated source version: 3.0.0
 * 
 */
@WebService(targetNamespace = "http://server.itcast.cn/", name = "HelloWorld")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorld {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://server.itcast.cn/", className = "cn.itcast.server.SayHi")
    @WebMethod
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://server.itcast.cn/", className = "cn.itcast.server.SayHiResponse")
    public java.lang.String sayHi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}

package com.initialjiang.wserice.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class JdkWS {

    public String doSomething(@WebParam(name="value", targetNamespace = "http://demo/", mode = WebParam.Mode.IN)String value) { 
        System.out.println("-------------------aaaaaaaaa");
    	return "Just do it," + value + "!"; 
    } 


	public String uploadFile(String fileName,byte [] b) throws IOException{
		OutputStream out = new FileOutputStream("f:/"+fileName);
		out.write(b);
		out.close();
		System.out.println("您上传的"+fileName+"文件成功！");
		return "您已成功上传"+fileName;
	}
     
    public static void main(String[] args) { 

        Endpoint.publish("http://localhost:8080/jdkwsdemo/demo.JdkWebService", new JdkWS()); 

    } 
    
}

package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestJdkWS3 {

	public static void main(String[] args) throws Exception {

		// 定义webservice的命名空间名称
//		String ns = "http://demo.wserice.initialjiang.com/";
//
//		// 定义webservice的使用说明书的地址
//		URL url = new URL("http://localhost:8080/jdkwsdemo/demo.JdkWebService?wsdl");
//
//		// 指定本地部分myServiceName
//		QName serviceqname = new QName(ns, "JdkWSService");
//		Service service = Service.create(url, serviceqname);
//
//		// 指定本地部分myPortName
//		QName protqname = new QName(ns, "JdkWSPort");
//		JdkWS jdkWS = service.getPort(protqname, JdkWS.class);
//		
//		String rs = jdkWS.doSomething("===================张三");
//		System.out.println(rs);
//		
		
		String params = "zh=aaa&dxlbid=15";

		//建立指定url的Http连接
		URL url = new URL("http://localhost:8080/jdkwsdemo/demo.JdkWebService?wsdl");
		
//		{“securityId”:<provided by CCC>,”securityPwd”:<provided by CCC>,”callerNum”:<caller number>,”calledNum”:<CCC service number>,”extNum”:<extension number>,”incomingTime”:<tel incoming  time, format is yyyy-MM-dd HH:mm:ss>,”connectedTime”:<tel connected time, format is yyyy-MM-dd HH:mm:ss >,”hangupTime”:< tel hangup time, format is yyyy-MM-dd HH:mm:ss >,”staff”:<user name>}
		
		HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Accept","[*]/[*]");
		httpURLConnection.setRequestMethod("GET");
//		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput( true);
		
		//取得输出流并写入请求参数
		OutputStream outputStream=httpURLConnection.getOutputStream();
//		outputStream.write(params.getBytes( "UTF-8"));
		outputStream.flush();
		outputStream.close();
		
//		//读取返回的内容到StringBuffer
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
//		StringBuffer stringBuffer = new StringBuffer();
//		int ch;
//		while ((ch = bufferedReader.read()) > -1) {
//			stringBuffer.append((char) ch);
//		}
//		bufferedReader.close();
//		String pushReturn=stringBuffer.toString();
		
	}
	
}

package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.initialjiang.wserice.demo.JdkWS;
import com.initialjiang.wserice.demo.JdkWSService;

public class TestJdkWS {

	public static void main(String[] args) throws Exception {
		JdkWSService jwsService = new JdkWSService();
		
		JdkWS jdkWS = jwsService.getJdkWSPort();
		String rs = jdkWS.doSomething("===================张三");
		System.out.println(rs);
		
		File file = new File("d:/img.txt");
		
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[in.available()];
		in.read(b);
		in.close();
		
		String rs2 = jdkWS.uploadFile(file.getName(), b);
		System.out.println(rs2);
		
	}
}

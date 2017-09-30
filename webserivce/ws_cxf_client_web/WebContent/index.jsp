<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--<script type="text/javascript" src="./js/jquery-1.5.1.min.js"></script>-->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<html>
  <head>
  </head>
  <body>
    <form action="hello.action" method="post">
    	姓名：<input type="text" name="name" id="name">
    	<br>
    	<s:property value="%{name}"/>
    	<br>
    	<hr>
    	<input type="submit" value="提交">
    	<br>
    	<hr>
    	<input type="button" value="ajax提交" id="butt">
    </form>
  </body>
</html>
<script>
	$(function(){
		$("#butt").click(function(){
			var name = $("#name").val();
			var dt = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
			         '<soap:Body><ns2:sayHi xmlns:ns2="http://server.itcast.cn/">'+
			         '<arg0>'+name+'</arg0></ns2:sayHi></soap:Body></soap:Envelope>';
			       
			$.ajax({
				/* 
					如果客户端应用跟WebService 服务端，发布在两个不同的项目中，用Ajax 请求WebService可能会出现跨域的问题，导致无法请求。
					
					如果这里使用ajax 直接调用的WebService 是另一个Web 服务器地址
					(如：http://localhost:8180/ws_cxf_server_web/ws/helloworld,   [8180端口跟当前项目发布的端口不一样])
					这时候WebService 服务端会出现以下异常：
						警告: Interceptor for {http://server.itcast.cn/}HelloWorldService has thrown exception, unwinding now
							   org.apache.cxf.interceptor.Fault: HTTP verb was not GET or POST
					客户端浏览器，截获的请求信息如下：
						请求地址：http://localhost:8180/ws_cxf_server_web/ws/helloworld
						请求方式：OPTIONS
						请求头部：
								Host: localhost:8180
								User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0
								Accept: text/html,application/xhtml+xml,application/xml;q=0.9,\*\/\*;q=0.8
								Accept-Language: zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3
								Accept-Encoding: gzip, deflate
								Origin: http://localhost:8080
								Access-Control-Request-Method: POST
								Access-Control-Request-Headers: cache-control,pragma
								Connection: keep-alive
								Pragma: no-cache
								Cache-Control: no-cache
				*/
				url:"http://localhost:8080/ws_cxf_server_web/ws/helloworld",
				contentType:"application/xml+soap",
				type: 'POST',
				dataType:"xml",
				data: dt,
				success:function(data){
					alert(data);
					//data是返回的数据，数据格式是xml格式
					//<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
					//<soap:Body><ns2:sayHelloResponse xmlns:ns2="http://server.itcast.cn/">
					//<return>Hello!李四      time:1322642117468</return></ns2:sayHelloResponse>
					//</soap:Body></soap:Envelope>
					var value = $(data).find("return").first().text();
					alert(value);
				},
				error:function(a,b,c){
					alert('errot');
				}
			},"xml");
			
		});
	});
	
</script>

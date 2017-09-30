<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!--<script type="text/javascript" src="./js/jquery-1.5.1.min.js"></script>-->
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<html>
  <head>
  </head>
  <body>
    <form action="hello.action" method="post">
    	姓名：<input type="text" name="name" id="name">
    	<br>
    	<hr>
    	<!-- <input type="submit" value="提交"> -->
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
			var vv = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
			         '<soap:Body><ns2:sayHi xmlns:ns2="http://server.itcast.cn/">'+
			         '<arg0>'+name+'</arg0></ns2:sayHi></soap:Body></soap:Envelope>';
			       
			$.ajax({
				url:"http://localhost:8180/ws_cxf_server_web/ws/helloworld",
				contentType:"application/xml+soap",
				type: 'POST',
				dataType:"xml",
				data:vv,
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
	
	function OnSuccess(){
		alert("kkk")
	}

	function OnError(){
		alert("jjjjj")
	}
</script>
<!-- 
var vv = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'+
			         '<soap:Body><ns2:sayHi xmlns:ns2="http://server.itcast.cn/">'+
			         '<arg0>'+name+'</arg0></ns2:sayHi></soap:Body></soap:Envelope>';
			         
$.ajax({
				url:"http://localhost:8180/ws_cxf_server_web/ws/helloworld",
				//contentType:"application/xml+soap",
				contentType: "application/json", 
				type:"POST",
				dataType:"xml",
				data:vv,
				success:function(data){
					alert(data);
					//data是返回的数据，数据格式是xml格式
					//<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
					//<soap:Body><ns2:sayHelloResponse xmlns:ns2="http://server.itcast.cn/">
					//<return>Hello!李四      time:1322642117468</return></ns2:sayHelloResponse>
					//</soap:Body></soap:Envelope>
					var value = $(data).find("return").first().text();
					alert(value);
				},error:function(a,b,c){
					alert('errot');
				}
			},"xml");

 -->
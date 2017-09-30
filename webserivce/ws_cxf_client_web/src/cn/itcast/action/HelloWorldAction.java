package cn.itcast.action;

import cn.itcast.server.HelloWorld;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
	
	private HelloWorld helloworld;

	private String name;
	
	public HelloWorld getHelloworld() {
		return helloworld;
	}

	public void setHelloworld(HelloWorld helloworld) {
		this.helloworld = helloworld;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String execute() throws Exception {
		name = getHelloworld().sayHi(getName());
		return SUCCESS;
	}
	
}

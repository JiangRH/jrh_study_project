package demo.rpc.protocol;

import java.io.Serializable;

/**
 * 因为java.lang.reflect.Method是非序列化的，不能直接使用
 * @author Tom
 *
 */
public class RPCMethod implements Serializable
{

	private static final long serialVersionUID = -1430761763297676014L;

	/**
	 * 方法名
	 */
	private String methodname;

	/**
	 * 参数类型
	 */
	private Class<?>[] parameterType;

	public String getMethodname()
	{
		return methodname;
	}

	public void setMethodname(String methodname)
	{
		this.methodname = methodname;
	}

	public Class<?>[] getParameterType()
	{
		return parameterType;
	}

	public void setParameterType(Class<?>[] parameterType)
	{
		this.parameterType = parameterType;
	}

	public RPCMethod(String methodname, Class<?>[] parameterType)
	{
		this.methodname = methodname;
		this.parameterType = parameterType;
	}

}

package demo.rpc.protocol;

import java.io.Serializable;

/**
 * ��װ�ͻ��˺ͷ����ͨ���������Ϣ
 * @author Tom
 *
 */
public class InvokerBean implements Serializable
{

	private static final long serialVersionUID = 6563927772423449956L;

	/**
	 * ��������
	 */
	private String serviceName;

	/**
	 * ������
	 */
	private RPCMethod method;

	/**
	 * ����ֵ
	 */
	private Object[] parameters;

	/**
	 * ���
	 */
	private Object result;

	public Object getResult()
	{
		return result;
	}

	public void setResult(Object result)
	{
		this.result = result;
	}

	public Object[] getParameters()
	{
		return parameters;
	}

	public void setParameters(Object[] parameters)
	{
		this.parameters = parameters;
	}

	public String getServiceName()
	{
		return serviceName;
	}

	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}

	public RPCMethod getMethod()
	{
		return method;
	}

	public void setMethod(RPCMethod method)
	{
		this.method = method;
	}

	public InvokerBean(String serviceName, RPCMethod method,
			Object[] parameters)
	{
		super();
		this.serviceName = serviceName;
		this.method = method;
		this.parameters = parameters;
	}

	public InvokerBean()
	{
	}
}

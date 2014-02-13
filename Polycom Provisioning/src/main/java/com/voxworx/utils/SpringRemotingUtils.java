package com.voxworx.utils;

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

public class SpringRemotingUtils {

	private static final int SERVICE_PORT = 8080;
	private static final String SERVLET_CONTEXT = "voxworx";

	/**
	 * Factory method; build the Spring Http Invoker proxy to enable remote commands
	 * @param host The web host (Spring server)
	 * @param url The url suffix to append to the service url
	 * @param proxyClass The proxy class type (i.e. DAO, Service, etc)
	 * @return A proxy to the remote server (i.e. now capable of executing remote commands)
	 */
	public static <E> E getRemotingClient(String host, String url, Class<E> proxyClass) {
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		proxy.setServiceUrl(buildUrl(host, url));
		proxy.setServiceInterface(proxyClass);
		proxy.afterPropertiesSet();
		@SuppressWarnings("unchecked")
		E proxyObject = (E)proxy.getObject();
		return proxyObject;
	}
	
	/**
	 * Build the remote url:<br>
	 * http://host:8080/voxworx/target
	 * @param host The spring host server
	 * @param target The url suffix which defines the remoting service
	 * @return
	 */
	static String buildUrl(String host, String target) {
		StringBuilder s = new StringBuilder();
		s.append("http://");
		s.append(host);
		s.append(":");
		s.append(SERVICE_PORT);
		s.append("/");
		s.append(SERVLET_CONTEXT);
		s.append("/");
		s.append(target);
		return s.toString();
	}
}

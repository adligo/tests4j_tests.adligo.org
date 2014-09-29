package org.adligo.tests4j_tests.system.shared.mocks;

import org.adligo.tests4j.shared.xml.I_XML_Builder;
import org.adligo.tests4j.system.shared.I_Tests4J_RemoteInfo;

/** a mock capable of throwing a
 * throwable from one of it's get* methods.
 * 
 * @author scott
 *
 */
public class Tests4J_RemoteInfoMock implements I_Tests4J_RemoteInfo {
	private RuntimeException toThrow = null;
	private String host;
	private int port;
	private String authCode;
	private boolean throwHost;
	private boolean throwPort;
	private boolean throwAuthCode;
	
	private I_XML_Builder lastBuilder;
	
	public Tests4J_RemoteInfoMock() {
		super();
	}

	@Override
	public void toXml(I_XML_Builder builder) {
		lastBuilder = builder;
	}

	@Override
	public String getHost() {
		if ( !throwHost && toThrow != null) {
			throw toThrow;
		}
		return host;
	}

	@Override
	public int getPort() {
		if ( !throwPort && toThrow != null) {
			throw toThrow;
		}
		return port;
	}

	@Override
	public String getAuthCode() {
		if ( !throwAuthCode && toThrow != null) {
			throw toThrow;
		}
		return authCode;
	}

	public RuntimeException getToThrow() {
		return toThrow;
	}

	public I_XML_Builder getLastBuilder() {
		return lastBuilder;
	}

	public void setToThrow(RuntimeException toThrow) {
		this.toThrow = toThrow;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public boolean isThrowHost() {
		return throwHost;
	}

	public boolean isThrowPort() {
		return throwPort;
	}

	public boolean isThrowAuthCode() {
		return throwAuthCode;
	}

	public void setThrowHost(boolean throwHost) {
		this.throwHost = throwHost;
	}

	public void setThrowPort(boolean throwPort) {
		this.throwPort = throwPort;
	}

	public void setThrowAuthCode(boolean throwAuthCode) {
		this.throwAuthCode = throwAuthCode;
	}

	
}

package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.models.shared.SourceFileScope;
import org.adligo.tests4j.models.shared.SourceFileTrial;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j.models.shared.asserts.I_Thrower;
import org.adligo.tests4j.models.shared.asserts.ThrownAssertionData;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_Commands;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_SocketMessage;

@SourceFileScope (sourceClass=Tests4J_SocketMessage.class)
public class Tests4J_SocketMessageTrial extends SourceFileTrial {
	
	@Test
	public void testConnectionIO() {
		Tests4J_SocketMessage mes = new Tests4J_SocketMessage(
				Tests4J_Commands.CONNECT, "8675309abc");
		assertEquals(Tests4J_Commands.CONNECT, mes.getCommand());
		assertEquals("8675309abc", mes.getAuthCode());
		String xml = mes.toXml();
		assertUniform(
				"<tests4j_socket_message version=\"1.0\" command=\"" + 
				Tests4J_Commands.CONNECT + "\" authCode=\"8675309abc\" />",
				xml);
		
		Tests4J_SocketMessage fromXml = new Tests4J_SocketMessage(xml);
		assertEquals(Tests4J_Commands.CONNECT, fromXml.getCommand());
		assertEquals("8675309abc", fromXml.getAuthCode());
	}
	
	@Test
	public void testXmlErrors() {
		//TODO working on this
		/*
		assertThrown(new ThrownAssertionData(
				IllegalArgumentException.class, Tests4J_SocketMessage.REQUIRES_ERROR), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new Tests4J_SocketMessage(null);
			}
		});
		*/
	}
}

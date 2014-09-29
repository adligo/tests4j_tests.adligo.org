package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.run.remote.socket_api.Tests4J_SocketMessage;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Tests4J_SocketMessage.class, minCoverage=9.0)
public class Tests4J_SocketMessageTrial extends SourceFileCountingTrial {
	
	/*
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
	*/
	@Test
	public void testXmlErrors() {
		assertThrown(new ExpectedThrownData(
				new IllegalArgumentException(Tests4J_SocketMessage.REQUIRES_ERROR)), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new Tests4J_SocketMessage(null);
			}
		});
		
		assertThrown(new ExpectedThrownData(
				new IllegalArgumentException(Tests4J_SocketMessage.REQUIRES_ERROR)), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new Tests4J_SocketMessage("hey");
			}
		});
		
		assertThrown(new ExpectedThrownData(
				new IllegalArgumentException("Unknown Version null expecting 1.0.")), 
			new I_Thrower() {
			
			@Override
			public void run() {
				new Tests4J_SocketMessage(Tests4J_SocketMessage.MESSAGE_START);
			}
		});
	}
	

	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 3;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

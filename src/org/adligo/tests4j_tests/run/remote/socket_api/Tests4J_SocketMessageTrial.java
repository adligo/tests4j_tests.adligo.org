package org.adligo.tests4j_tests.run.remote.socket_api;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_Commands;
import org.adligo.tests4j.run.remote.socket_api.Tests4J_SocketMessage;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Tests4J_SocketMessage.class)
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

	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			//assertGreaterThanOrEquals(40.0, coverage.getPercentageCoveredDouble());
			assertGreaterThanOrEquals(14.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 3;
	}

	@Override
	public int getUniqueAsserts() {
		return 3;
	}
}

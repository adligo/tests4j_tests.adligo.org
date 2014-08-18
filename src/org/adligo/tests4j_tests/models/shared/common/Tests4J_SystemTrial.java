package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.common.Tests4J_System;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.SystemSimpleMock;
import org.adligo.tests4j_tests.models.shared.common.mocks.ThreadLocalSystemMock;

@SourceFileScope (sourceClass=Tests4J_System.class, minCoverage=80.0)
public class Tests4J_SystemTrial extends SourceFileCountingTrial {
	private static final SystemSimpleMock MOCK = new SystemSimpleMock();
	
	@Override
	public void beforeTests() {
		ThreadLocalSystemMock.setConstantToMock();
		ThreadLocalSystemMock.setSystem(MOCK);
	}
	
	@Test
	public void testMethods() {
		Tests4J_System.println("line");
		assertEquals("line", MOCK.getLastPrintln());
		
		Tests4J_System.exitJvm(9);
		assertEquals(9, MOCK.getLastSystemExit());
		
		MOCK.setNextLineSeperator("\t\r\n\t");
		assertEquals("\t\r\n\t", Tests4J_System.getLineSeperator());
		
		MOCK.setNextTime(0);
		assertEquals(0L, Tests4J_System.getTime());
	}
	
	public void afterTests() {
		ThreadLocalSystemMock.markDone();
	}
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 4;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}

}

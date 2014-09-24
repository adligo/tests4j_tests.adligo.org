package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.common.Tests4J_System;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.shared.common.mocks.SystemSimpleMock;
import org.adligo.tests4j_tests.shared.common.mocks.ThreadLocalSystemMock;

@SourceFileScope (sourceClass=Tests4J_System.class, minCoverage=50.0)
@AllowedDependencies (groups=Tests4J_Common_DependencyGroup.class)
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
		assertEquals("\t\r\n\t", Tests4J_System.lineSeperator());
		
		MOCK.setNextTime(0);
		assertEquals(0L, Tests4J_System.getTime());
	}
	
	public void afterTests() {
		ThreadLocalSystemMock.markDone();
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, 7);
		} else {
			return super.getAsserts(type, 4);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 7);
		} else {
			return super.getUniqueAsserts(type, 4);
		}
	}
}

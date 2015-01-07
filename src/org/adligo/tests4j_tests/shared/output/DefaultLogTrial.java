package org.adligo.tests4j_tests.shared.output;

import org.adligo.tests4j.run.common.JseSystem;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.shared.common.DelegateSystem;
import org.adligo.tests4j.shared.common.I_System;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Output_GwtReferenceGroup;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SourceFileScope (sourceClass=DefaultLog.class, minCoverage=47.0)
@AllowedReferences (groups=Tests4J_Output_GwtReferenceGroup.class)
public class DefaultLogTrial extends SourceFileCountingTrial {

	@Test
	public void testDefault() {
		DefaultLogMock d = new DefaultLogMock();
		I_System sys = d.getSystem();
		assertNotNull(sys);
		assertEquals(DefaultSystem.class.getName(), sys.getClass().getName());
		Set<String> defaultLoggers = new HashSet<String>();
		defaultLoggers.add(DefaultSystem.class.getName());
		defaultLoggers.add(JseSystem.class.getName());
		assertFalse(d.isLogEnabled(this.getClass()));
		
		
	}
	
	@Test
	public void testSelfDelegate() {
		Map<Class<?>, Boolean> logStates = new HashMap<Class<?>, Boolean>();
		logStates.put(this.getClass(), true);
		I_System mockSys = mock(I_System.class);
		when(mockSys.getCurrentThreadName()).thenReturn("cThread");
		when(mockSys.getCurrentThreadGroupName()).thenReturn("cThreadGroup");
		DefaultLog d = new DefaultLog(mockSys, logStates);
		
		assertTrue(d.isLogEnabled(this.getClass()));
		assertEquals("Thread; cThread", d.getThreadMessage());
		assertEquals("Thread/Group; cThread~~~cThreadGroup", d.getThreadWithGroupNameMessage());
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 6;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}

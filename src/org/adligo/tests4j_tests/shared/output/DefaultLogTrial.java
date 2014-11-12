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
public class DefaultLogTrial extends SourceFileCountingTrial implements I_System {

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
		DefaultLog d = new DefaultLog(this, logStates);
		
		assertTrue(d.isLogEnabled(this.getClass()));
	}
	
	@Override
	public void println(String p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitJvm(int p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String lineSeperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentThreadName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJseVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintStream getOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 4;
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
		int thisUniqueAsserts = 4;
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

	@Override
	public boolean isMainSystem() {
		// TODO Auto-generated method stub
		return false;
	}

}

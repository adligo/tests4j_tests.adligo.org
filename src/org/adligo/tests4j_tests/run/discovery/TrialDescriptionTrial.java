package org.adligo.tests4j_tests.run.discovery;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageBriefMutant;
import org.adligo.tests4j.run.common.I_Memory;
import org.adligo.tests4j.run.discovery.TrialDescription;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.mock_trials.MockWithNothingTrial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SourceFileScope (sourceClass=TrialDescription.class, minCoverage=33.0)
public class TrialDescriptionTrial extends SourceFileCountingTrial {

	@Test
	public void testGetPackageCoverage() {
	  I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    I_Memory memoryMock = mock(I_Memory.class);
    when(memoryMock.getLog()).thenReturn(logMock); 
    
		TrialDescription td = new TrialDescription(TrialDescriptionTrial.class, memoryMock);
		
		List<I_PackageCoverageBrief> pc = new ArrayList<I_PackageCoverageBrief>();
		addPackage(pc, "org.adligo.tests4j.run.discovery", null);

		I_PackageCoverageBrief pk =  td.findPackageCoverage(pc);
		assertNotNull(pk);
		assertEquals("org.adligo.tests4j.run.discovery", pk.getPackageName());
		
		pc.clear();
		addPackage(pc, "org.adligo.tests4j.run.discovery", Collections.singletonList( "org.adligo.tests4j.run.discovery.foo"));
		pk =  td.findPackageCoverage(pc);
		assertNotNull(pk);
		assertEquals("org.adligo.tests4j.run.discovery", pk.getPackageName());
		
		pc.clear();
		addPackage(pc, "org.adligo.tests4j.run", Collections.singletonList( "org.adligo.tests4j.run.discovery"));
		pk =  td.findPackageCoverage(pc);
		assertNotNull(pk);
		assertEquals("org.adligo.tests4j.run.discovery", pk.getPackageName());
		
	}
	
	public void addPackage(List<I_PackageCoverageBrief> pc, String name, List<String> children) {
		PackageCoverageBriefMutant pcm = new PackageCoverageBriefMutant();
		pcm.setPackageName(name);
		pc .add(pcm);
		if (children != null) {
			for (String child: children) {
				PackageCoverageBriefMutant childCm = new PackageCoverageBriefMutant();
				childCm.setPackageName(child);
				pcm.addChild(childCm);
			}
		}
	}
	
	@Test
	public void testFindBeforeAfterTrials() {
		I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
		I_Memory memoryMock = mock(I_Memory.class);
		when(memoryMock.getLog()).thenReturn(logMock);
		
		TrialDescription td = new TrialDescription(MockWithNothingTrial.class,memoryMock);
		//shouldn't throw a exception
		td.findBeforeAfterTrials(null);
		assertNull(td.getBeforeTrialMethod());
		assertNull(td.getAfterTrialMethod());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 8;
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
		int thisUniqueAsserts = 5;
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

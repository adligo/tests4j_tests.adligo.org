package org.adligo.tests4j_tests.run.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageMutant;
import org.adligo.tests4j.models.shared.trials.I_AbstractTrial;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.TrialDescription;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.jacoco.plugin.data.common.ProbesMutantTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
import org.adligo.tests4j_tests.run.helpers.mocks.Tests4J_MemoryMock;

@SourceFileScope (sourceClass=TrialDescription.class, minCoverage=37.0)
public class TrialDescriptionTrial extends SourceFileCountingTrial {

	@Test
	public void testGetPackageCoverage() {
		Tests4J_MemoryMock memoryMock = new Tests4J_MemoryMock();
		
		TrialDescription td = new TrialDescription(TrialDescriptionTrial.class, memoryMock);
		
		List<I_PackageCoverage> pc = new ArrayList<I_PackageCoverage>();
		addPackage(pc, "org.adligo.tests4j.run.discovery", null);

		I_PackageCoverage pk =  td.findPackageCoverage(pc);
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
	
	public void addPackage(List<I_PackageCoverage> pc, String name, List<String> children) {
		PackageCoverageMutant pcm = new PackageCoverageMutant();
		pcm.setPackageName(name);
		pc .add(pcm);
		if (children != null) {
			for (String child: children) {
				PackageCoverageMutant childCm = new PackageCoverageMutant();
				childCm.setPackageName(child);
				pcm.addChild(childCm);
			}
		}
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 6;
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
		int thisUniqueAsserts = 4;
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

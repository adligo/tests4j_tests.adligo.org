package org.adligo.tests4j_tests.models.shared.metadata;


import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCaseBrief;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.TrialType;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Metadata_GwtReferenceGroup;

@SourceFileScope (sourceClass=TrialMetadata.class, minCoverage=82.0)
@AllowedReferences (groups=Tests4J_Metadata_GwtReferenceGroup.class)
public class TrialMetadataTrial extends SourceFileCountingTrial {

	@Test
	public void testCopyConstructor() throws Exception {
		TrialMetadataMutant tmm = new TrialMetadataMutant();
		tmm.setAfterTrialMethodName("afterTrialMethodName");
		tmm.setBeforeTrialMethodName("beforeTrialMethodName");
		tmm.setTestedPackage("testedPackageName");
		tmm.setTestedSourceFile("testedSourceFile");
		tmm.setTimeout(13L);
		tmm.setTrialName("someTrialName");
		tmm.setType(TrialType.SourceFileTrial);
		tmm.setMinimumCodeCoverage(11.1);
		
		UseCaseBrief ucm = new UseCaseBrief("nown", "verb");
		tmm.setUseCase(ucm);
		tmm.setIgnored(true);
		
		
		TestMetadataMutant testMm = new TestMetadataMutant();
		tmm.addTest(testMm);
		testMm = new TestMetadataMutant();
		testMm.setIgnored(true);
		tmm.addTest(testMm);
		
		TrialMetadata tm = new TrialMetadata(tmm);
		assertEquals("testedPackageName", 
				tm.getTestedPackage());
		assertEquals("testedSourceFile", 
				tm.getTestedSourceFile());
		assertEquals(13L, tm.getTimeout());
		assertEquals("someTrialName", tm.getTrialName());
		assertEquals(TrialType.SourceFileTrial, tm.getType());
		assertSame(ucm, tm.getUseCase());
		assertTrue(tm.isIgnored());
		assertEquals(11.1, tm.getMinimumCodeCoverage());
		
		assertEquals(2, tm.getTestCount());
		List<I_TestMetadata>tests =  tm.getTests();
		assertEquals(2, tests.size());
	
		assertEquals("afterTrialMethodName", 
				tm.getAfterTrialMethodName());
		assertEquals("beforeTrialMethodName", 
				tm.getBeforeTrialMethodName());
		assertEquals(1, tm.getIgnoredTestCount());
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
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
		int thisUniqueAsserts = 12;
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

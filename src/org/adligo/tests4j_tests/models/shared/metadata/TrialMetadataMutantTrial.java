package org.adligo.tests4j_tests.models.shared.metadata;


import java.util.List;

import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
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

@SourceFileScope (sourceClass=TrialMetadataMutant.class, minCoverage=54.0)
@AllowedReferences (groups=Tests4J_Metadata_GwtReferenceGroup.class)
public class TrialMetadataMutantTrial extends SourceFileCountingTrial {

	@SuppressWarnings("boxing")
  @Test
	public void testGetsAndSets() throws Exception {
		TrialMetadataMutant tmm = new TrialMetadataMutant();
		assertNull(tmm.getAfterTrialMethodName());
		assertNull(tmm.getBeforeTrialMethodName());
		assertEquals(0, tmm.getIgnoredTestCount());
		assertEquals(0, tmm.getTestCount());
		assertNull(tmm.getTestedPackage());
		assertNull(tmm.getTestedSourceFile());
		assertNull(tmm.getMinimumCodeCoverage());
		
		List<I_TestMetadata> tests =  tmm.getTests();
		assertEquals(0, tests.size());
		assertNull(tmm.getTimeout());
		assertNull(tmm.getTrialName());
		assertNull(tmm.getType());
		assertNull(tmm.getUseCase());
		assertFalse(tmm.isIgnored());
		
		tmm.setAfterTrialMethodName("afterTrialMethodName");
		assertEquals("afterTrialMethodName", 
				tmm.getAfterTrialMethodName());
		
		tmm.setBeforeTrialMethodName("beforeTrialMethodName");
		assertEquals("beforeTrialMethodName", 
				tmm.getBeforeTrialMethodName());
	
		tmm.setMinimumCodeCoverage(100.0);
		assertEquals(100.0, tmm.getMinimumCodeCoverage());
		
		tmm.setTestedPackage("testedPackageName");
		assertEquals("testedPackageName", 
				tmm.getTestedPackage());
		assertNull(tmm.getTestedSourceFile());
		
		tmm.setTestedSourceFile("testedSourceFile");
		assertEquals("testedSourceFile", 
				tmm.getTestedSourceFile());
		
		tmm.setTimeout(13L);
		assertEquals(13L, tmm.getTimeout());
		tmm.setTrialName("someTrialName");
		assertEquals("someTrialName", tmm.getTrialName());
		
		tmm.setType(TrialType.SourceFileTrial);
		assertEquals(TrialType.SourceFileTrial, tmm.getType());
		
		UseCaseBrief ucm = new UseCaseBrief("nown", "verb");
		tmm.setUseCase(ucm);
		assertSame(ucm, tmm.getUseCase());
		
		tmm.setIgnored(true);
		assertTrue(tmm.isIgnored());
		
		TestMetadataMutant testMm = new TestMetadataMutant();
		tmm.addTest(testMm);
		assertEquals(1, tmm.getTestCount());
		tests =  tmm.getTests();
		assertEquals(1, tests.size());
	
		assertEquals(0, tmm.getIgnoredTestCount());
		
		testMm = new TestMetadataMutant();
		testMm.setIgnored(true);
		tmm.addTest(testMm);
		assertEquals(2, tmm.getTestCount());
		tests =  tmm.getTests();
		assertEquals(2, tests.size());
	
		assertEquals(1, tmm.getIgnoredTestCount());
	}
	
	@SuppressWarnings("boxing")
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
		
		tmm = new TrialMetadataMutant(tmm);
		assertEquals("testedPackageName", 
				tmm.getTestedPackage());
		assertEquals("testedSourceFile", 
				tmm.getTestedSourceFile());
		assertEquals(13L, tmm.getTimeout());
		assertEquals("someTrialName", tmm.getTrialName());
		assertEquals(TrialType.SourceFileTrial, tmm.getType());
		assertSame(ucm, tmm.getUseCase());
		assertTrue(tmm.isIgnored());
		assertEquals(11.1, tmm.getMinimumCodeCoverage());
		
		assertEquals(2, tmm.getTestCount());
		List<I_TestMetadata>tests =  tmm.getTests();
		assertEquals(2, tests.size());
	
		assertEquals("afterTrialMethodName", 
				tmm.getAfterTrialMethodName());
		assertEquals("beforeTrialMethodName", 
				tmm.getBeforeTrialMethodName());
		assertEquals(1, tmm.getIgnoredTestCount());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 43;
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
		int thisUniqueAsserts = 27;
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

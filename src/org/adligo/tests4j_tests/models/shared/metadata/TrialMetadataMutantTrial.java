package org.adligo.tests4j_tests.models.shared.metadata;


import java.util.List;

import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCaseMetadata;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TrialMetadataMutant.class)
public class TrialMetadataMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testGetsAndSets() throws Exception {
		TrialMetadataMutant tmm = new TrialMetadataMutant();
		assertNull(tmm.getAfterTrialMethodName());
		assertNull(tmm.getBeforeTrialMethodName());
		assertEquals(0, tmm.getIgnoredTestCount());
		assertNull(tmm.getSystem());
		assertEquals(0, tmm.getTestCount());
		assertNull(tmm.getTestedPackage());
		assertNull(tmm.getTestedSourceFile());
		
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
		
		UseCaseMetadata ucm = new UseCaseMetadata("nown", "verb");
		tmm.setUseCase(ucm);
		assertSame(ucm, tmm.getUseCase());
		tmm.setSystem("systemName");
		assertEquals("systemName", 
				tmm.getSystem());
		
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
		
		UseCaseMetadata ucm = new UseCaseMetadata("nown", "verb");
		tmm.setUseCase(ucm);
		tmm.setSystem("systemName");
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
		assertEquals("systemName", 
				tmm.getSystem());
		
		assertEquals(2, tmm.getTestCount());
		List<I_TestMetadata>tests =  tmm.getTests();
		assertEquals(2, tests.size());
	
		assertEquals("afterTrialMethodName", 
				tmm.getAfterTrialMethodName());
		assertEquals("beforeTrialMethodName", 
				tmm.getBeforeTrialMethodName());
		assertEquals(1, tmm.getIgnoredTestCount());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		TrialMetadataMutant tmm = new TrialMetadataMutant();
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		tmm.toXml(builder);
		String result = builder.toXmlString();
		assertEquals("\t<trialMetadata/>\n", result);
		
		TrialMetadataMutant other = new TrialMetadataMutant(result);
		assertNull(other.getTrialName());
		
		tmm.setAfterTrialMethodName("afterTrialMethodName");
		tmm.setBeforeTrialMethodName("beforeTrialMethodName");
		tmm.setTestedPackage("testedPackageName");
		tmm.setTestedSourceFile("testedSourceFile");
		tmm.setTimeout(13L);
		tmm.setTrialName("someTrialName");
		tmm.setType(TrialType.SourceFileTrial);
		
		UseCaseMetadata ucm = new UseCaseMetadata("nown", "verb");
		tmm.setUseCase(ucm);
		tmm.setSystem("systemName");
		tmm.setIgnored(true);
		
		
		TestMetadataMutant testMm = new TestMetadataMutant();
		testMm.setTestName("aTest");
		tmm.addTest(testMm);
		testMm = new TestMetadataMutant();
		testMm.setTestName("bTest");
		testMm.setIgnored(true);
		tmm.addTest(testMm);
		
		
		builder = new XML_Builder();
		builder.addIndent();
		tmm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("\n\t<trialMetadata name=\"someTrialName\" type=\"SourceFileTrial\" timeout=\"13\"\n" +
				"\t\t beforeTrial=\"beforeTrialMethodName\" ignored=\"true\" afterTrial=\"afterTrialMethodName\"\n" +
				"\t\t testedSourceFile=\"testedSourceFile\" testedPackage=\"testedPackageName\" testedSystem=\"systemName\"\n" +
				"\t\t >\n" +
				"\t\t<useCase nown=\"nown\" verb=\"verb\" />\n" +
				"\t\t<tests>\n" +
				"\t\t\t<testMetadata name=\"aTest\" />\n" +
				"\t\t\t<testMetadata name=\"bTest\" ignored=\"true\" />\n" +
				"\t\t</tests>\n" +
				"\t</trialMetadata>\n", "\n" + result);
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(60.00, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 46;
	}

	@Override
	public int getUniqueAsserts() {
		return 30;
	}
}

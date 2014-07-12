package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCaseMetadata;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=UseCaseMetadata.class)
public class UseCaseMetadataTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UseCaseMetadata.A_USE_CASE_REQUIRES_A_NOWN_AND_A_VERB)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata(null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UseCaseMetadata.A_USE_CASE_REQUIRES_A_NOWN_AND_A_VERB)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("", "");
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UseCaseMetadata.A_USE_CASE_REQUIRES_A_NOWN_AND_A_VERB)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("<useCase nown=\"exception\" />");
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				UseCaseMetadata.A_USE_CASE_REQUIRES_A_NOWN_AND_A_VERB)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("<useCase verb=\"throw\" />");
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() throws Exception {
		UseCaseMetadata a = new UseCaseMetadata("exception", "throw");
		UseCaseMetadata b = new UseCaseMetadata("football", "throw");
		UseCaseMetadata c = new UseCaseMetadata("exception", "throw");
		UseCaseMetadata d = new UseCaseMetadata("exception", "eat");
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, new Object());
	}
	
	@Test
	public void testGettersAndCopyConstructor() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		assertEquals("exception", uc.getNown());
		assertEquals("throw", uc.getVerb());
		
		UseCaseMetadata uc2 = new UseCaseMetadata(uc);
		assertEquals("exception", uc2.getNown());
		assertEquals("throw", uc2.getVerb());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		uc.toXml(builder);
		String result = builder.toXmlString();
		assertEquals("\t<useCase nown=\"exception\" verb=\"throw\" />\n", result);
		assertEquals("throw", uc.getVerb());
		
		UseCaseMetadata uc2 = new UseCaseMetadata(result);
		assertEquals("exception", uc2.getNown());
		assertEquals("throw", uc2.getVerb());
	}
	
	@Test
	public void testToString() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		assertEquals("UseCase [nown=exception, verb=throw]", uc.toString());
	}
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(86.00, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 22;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
}

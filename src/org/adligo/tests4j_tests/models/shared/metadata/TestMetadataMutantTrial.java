package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Metadata_DependencyGroup;

@SourceFileScope (sourceClass=TestMetadataMutant.class, minCoverage=88.0)
@AllowedDependencies (groups=Tests4J_Metadata_DependencyGroup.class)
public class TestMetadataMutantTrial extends SourceFileCountingTrial {

	
	@Test
	public void testCopyConstructor() throws Exception {
		TestMetadataMutant tmm = new TestMetadataMutant();
		TestMetadata tm = new TestMetadata();
		assertFalse(tm.isIgnored());
		assertNull(tm.getTestName());
		assertNull(tm.getTimeout());
		
		tmm.setTestName("testName");
		tmm.setTimeout(10L);
		tmm.setIgnored(true);
		
		tm = new TestMetadata(tmm);
		assertEquals("testName", tm.getTestName());
		assertEquals(10L, tm.getTimeout());
		assertTrue(tm.isIgnored());
	}
	
	@Test
	public void testEqualsHashCode() throws Exception {
		TestMetadataMutant a = new TestMetadataMutant();
		a.setTestName("testName");
		TestMetadata atm = new TestMetadata(a);
		
		TestMetadataMutant b = new TestMetadataMutant();
		b.setTestName("testName2");
		TestMetadata btm = new TestMetadata(b);
		
		TestMetadataMutant c = new TestMetadataMutant();
		c.setTestName("testName");
		TestMetadata ctm = new TestMetadata(c);
		
		assertEquals(atm, atm);
		assertEquals(atm.hashCode(), atm.hashCode());
	
		assertNotEquals(atm, btm);
		assertNotEquals(atm.hashCode(), btm.hashCode());
		
		assertEquals(atm, ctm);
		assertEquals(atm.hashCode(), ctm.hashCode());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		TestMetadataMutant tmm = new TestMetadataMutant();
		tmm.setTestName("testName");
		
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		TestMetadata tm = new TestMetadata(tmm);
		tm.toXml(builder);
		
		String result = builder.toXmlString();
		assertEquals("\t<testMetadata name=\"testName\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertNull(tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		tmm.setTimeout(10L);
		tm = new TestMetadata(tmm);
		tm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" timeout=\"10\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		tmm.setIgnored(true);
		tm = new TestMetadata(tmm);
		tmm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" ignored=\"true\" timeout=\"10\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertTrue(tmm.isIgnored());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 24;
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
		int thisUniqueAsserts = 15;
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

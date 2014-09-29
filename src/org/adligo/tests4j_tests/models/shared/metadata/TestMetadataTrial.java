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

@SourceFileScope (sourceClass=TestMetadata.class, minCoverage=93.0)
@AllowedDependencies (groups=Tests4J_Metadata_DependencyGroup.class)
public class TestMetadataTrial extends SourceFileCountingTrial {

	
	@Test
	public void testGettersAndCopyConstructor() throws Exception {
		TestMetadata tm1 = new TestMetadata();
		assertFalse(tm1.isIgnored());
		assertNull(tm1.getTestName());
		assertNull(tm1.getTimeout());
		
		TestMetadataMutant tmm = new TestMetadataMutant();
		tmm.setTestName("testName");
		tmm.setTimeout(10L);
		tmm.setIgnored(true);
		
		TestMetadata tmm2 = new TestMetadata(tmm);
		
		assertEquals("testName", tmm2.getTestName());
		assertEquals(10L, tmm2.getTimeout());
		assertTrue(tmm2.isIgnored());
	}
	
	@Test
	public void testEqualsHashCode() throws Exception {
		TestMetadataMutant a = new TestMetadataMutant();
		a.setTestName("testName");
		TestMetadata tma = new TestMetadata(a);
		
		TestMetadataMutant b = new TestMetadataMutant();
		b.setTestName("testName2");
		TestMetadata tmb = new TestMetadata(b);
		
		TestMetadataMutant c = new TestMetadataMutant();
		c.setTestName("testName");
		TestMetadata tmc = new TestMetadata(c);
		
		assertEquals(tma, tma);
		assertEquals(tma.hashCode(), tma.hashCode());
	
		assertNotEquals(tma, tmb);
		assertNotEquals(tma.hashCode(), tmb.hashCode());
		
		assertEquals(tma, tmc);
		assertEquals(tma.hashCode(), tmc.hashCode());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		TestMetadataMutant tmm = new TestMetadataMutant();
		tmm.setTestName("testName");
		
		TestMetadata tm = new TestMetadata(tmm);
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		tm.toXml(builder);
		
		String result = builder.toXmlString();
		assertEquals("\t<testMetadata name=\"testName\" />\n", result);
		tm = new TestMetadata(result);
		assertEquals("testName", tmm.getTestName());
		assertNull(tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		tmm.setTimeout(10L);
		tm = new TestMetadata(tmm);
		tm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" timeout=\"10\" />\n", result);
		tm = new TestMetadata(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		result = builder.toXmlString();
		tmm.setIgnored(true);
		tmm.setTimeout(12L);
		tm = new TestMetadata(tmm);
		tm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" ignored=\"true\" timeout=\"12\" />\n", result);
		tm = new TestMetadata(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(12L, tmm.getTimeout());
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
		int thisUniqueAsserts = 16;
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

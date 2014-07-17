package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TestMetadata.class)
public class TestMetadataTrial extends SourceFileCountingTrial {

	
	@Test
	public void testGettersAndSettersAndCopyConstructor() throws Exception {
		TestMetadataMutant tmm = new TestMetadataMutant();
		assertFalse(tmm.isIgnored());
		assertNull(tmm.getTestName());
		assertNull(tmm.getTimeout());
		
		tmm.setTestName("testName");
		tmm.setTimeout(10L);
		tmm.setIgnored(true);
		
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertTrue(tmm.isIgnored());
		
		TestMetadataMutant tmm2 = new TestMetadataMutant(tmm);
		
		assertEquals("testName", tmm2.getTestName());
		assertEquals(10L, tmm2.getTimeout());
		assertTrue(tmm2.isIgnored());
	}
	
	@Test
	public void testEqualsHashCode() throws Exception {
		TestMetadataMutant a = new TestMetadataMutant();
		a.setTestName("testName");
		
		TestMetadataMutant b = new TestMetadataMutant();
		b.setTestName("testName2");
		
		
		TestMetadataMutant c = new TestMetadataMutant();
		c.setTestName("testName");
		TestMetadata tm = new TestMetadata(c);
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
	
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		TestMetadataMutant tmm = new TestMetadataMutant();
		tmm.setTestName("testName");
		
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		tmm.toXml(builder);
		
		String result = builder.toXmlString();
		assertEquals("\t<testMetadata name=\"testName\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertNull(tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		tmm.setTimeout(10L);
		tmm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" timeout=\"10\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertFalse(tmm.isIgnored());
		
		builder = new XML_Builder();
		tmm.setIgnored(true);
		tmm.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<testMetadata name=\"testName\" ignored=\"true\" timeout=\"10\" />\n", result);
		tmm = new TestMetadataMutant(result);
		assertEquals("testName", tmm.getTestName());
		assertEquals(10L, tmm.getTimeout());
		assertTrue(tmm.isIgnored());
		
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 27;
	}

	@Override
	public int getUniqueAsserts() {
		return 15;
	}
}

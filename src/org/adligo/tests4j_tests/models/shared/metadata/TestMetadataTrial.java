package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TestMetadata.class, minCoverage=100.0)
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
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 24;
	}

	@Override
	public int getUniqueAsserts() {
		return 16;
	}
}

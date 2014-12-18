package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Metadata_GwtReferenceGroup;

@SourceFileScope (sourceClass=TestMetadataMutant.class, minCoverage=79.0)
@AllowedReferences (groups=Tests4J_Metadata_GwtReferenceGroup.class)
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
	
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 12;
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
		int thisUniqueAsserts = 7;
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

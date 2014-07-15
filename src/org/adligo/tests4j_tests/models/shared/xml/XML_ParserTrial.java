package org.adligo.tests4j_tests.models.shared.xml;

import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Parser;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Parser.class)
public class XML_ParserTrial extends SourceFileCountingTrial {

	@Test
	public void testGetIndexesSimple() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey/>", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(6, indexes[1]);
		
		indexes = XML_Parser.getIndexes("<hey/>", "hey2");
		assertNull(indexes);
	}
	
	@Test
	public void testGetIndexesSimpleSpaceInStartTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("< hey/>", "hey");
		assertNull(indexes);
		
	}
	
	@Test
	public void testGetIndexesSimpleTabInStartTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<\they/>", "hey");
		assertNull(indexes);
		
	}
	
	@Test
	public void testGetIndexesSimpleTabAndReturnStartTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<\they\n/>", "hey");
		assertNull(indexes);
	}
	
	@Test
	public void testGetIndexesSimpleWithAttributes() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" />", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(18, indexes[1]);
		
	}
	
	@Test
	public void testGetIndexesSimpleWithNestedTags() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" ><he/></hey>", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(28, indexes[1]);
		
	}
	
	@Test
	public void testGetIndexesSimpleWithNestedTagsSpaceInEndTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" ><he/></ hey>", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(29, indexes[1]);
		
	}
	
	@Test
	public void testGetIndexesSimpleWithNestedTagsTagInEndTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" ><he/></\they>", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(29, indexes[1]);
		
	}
	
	@Test
	public void testGetIndexesSimpleWithNestedTagsReturnInEndTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" ><he/></hey\r>", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(29, indexes[1]);
		
	}
	@Test
	public void testGetTagAttributeSimple() throws Exception {
		String value = XML_Parser.getAttributeValue("<hey you=\"guys\" ><he/></hey>", "you");
		assertEquals("guys", value);
		
		value = XML_Parser.getAttributeValue("<hey you\t= \"guys\" ><he/></hey>", "you");
		assertEquals("guys", value);
		
		value = XML_Parser.getAttributeValue("<hey you\r=\n \"guys\" ><he/></hey>", "you");
		assertEquals("guys", value);
	}
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(88.00, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 10;
	}

	@Override
	public int getAsserts() {
		return 19;
	}

	@Override
	public int getUniqueAsserts() {
		return 17;
	}
}

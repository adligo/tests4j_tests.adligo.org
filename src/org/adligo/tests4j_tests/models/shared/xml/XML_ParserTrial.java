package org.adligo.tests4j_tests.models.shared.xml;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_XML_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Parser;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Parser.class, minCoverage=92.0)
@AllowedDependencies (groups=Tests4J_XML_DependencyGroup.class)
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
	public void testGetXmlReadError() throws Exception {
		IllegalArgumentException x = XML_Parser.getReadError("foo");
		assertNotNull(x);
		assertEquals("Tag foo not found in xml!", x.getMessage());
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
	public void testGetIndexesSimpleFastEndingTag() throws Exception {
		int [] indexes = XML_Parser.getIndexes("<hey you=\"guys\" />", "hey");
		assertEquals(0, indexes[0]);
		assertEquals(18, indexes[1]);
		
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
	
	@Test
	public void testGetTagIntegerAttributeSimple() throws Exception {
		Integer you = XML_Parser.getAttributeIntegerValue("<hey you=\"11\" />", "you");
		assertEquals(11, you);
		
		you = XML_Parser.getAttributeIntegerValue("<hey you=\"12\"  ><he/></hey>", "you");
		assertEquals(12, you);
		
		
		you = XML_Parser.getAttributeIntegerValue("<hey />", "you");
		assertNull(you);
		
		you = XML_Parser.getAttributeIntegerValue("<he ><he/></hey>", "you");
		assertNull(you);
	}
	
	@Test
	public void testGetTagDoubleAttributeSimple() throws Exception {
		Double you = XML_Parser.getAttributeDoubleValue("<hey you=\"11.1\" />", "you");
		assertEquals(11.1, you);
		
		you = XML_Parser.getAttributeDoubleValue("<hey you=\"12.2\"  ><he/></hey>", "you");
		assertEquals(12.2, you);
		
		
		you = XML_Parser.getAttributeDoubleValue("<hey />", "you");
		assertNull(you);
		
		you = XML_Parser.getAttributeDoubleValue("<he ><he/></hey>", "you");
		assertNull(you);
	}
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 14);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 31;
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

package org.adligo.tests4j_tests.shared.xml;


import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_XML_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.shared.xml.XML_Chars;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Builder.class, minCoverage=83.0)
@AllowedDependencies (groups=Tests4J_XML_DependencyGroup.class)
public class XML_BuilderTrial extends SourceFileCountingTrial {

	@Test
	public void testBuildingXml() throws Exception {
		XML_Builder builder = new XML_Builder();
		builder.addStartTag("hey");
		builder.append(XML_Chars.END);
		builder.endLine();
		
		builder.addIndent();
		builder.indent();
		builder.addStartTag("you");
		builder.addAttribute("he", "O'Reily");
		builder.append(XML_Chars.END);
		builder.removeIndent();
		builder.endLine();
		
		builder.addEndTag("hey");
		
		assertEquals("<hey>\n" +
				"\t<you he=\"O&apos;Reily\">\n" +
				"</hey>", builder.toXmlString());
	}
	
	@Test
	public void testCustomBuildingXml() throws Exception {
		XML_Builder builder = new XML_Builder(" ", "\n\r");
		builder.addStartTag("hey");
		builder.append(XML_Chars.END);
		builder.endLine();
		
		builder.addIndent();
		builder.indent();
		builder.addStartTag("you");
		builder.addAttribute("he", "O'Reily");
		builder.append(XML_Chars.END);
		builder.removeIndent();
		builder.endLine();
		
		builder.addEndTag("hey");
		
		assertEquals("<hey>\n\r" +
				" <you he=\"O&apos;Reily\">\n\r" +
				"</hey>", builder.toXmlString());
	}
	
	
	@Test
	public void testAttributeWrap() throws Exception {
		XML_Builder builder = new XML_Builder(" ", "\n\r");
		builder.setAttributesPerLine(2);
		builder.addStartTag("hey");
		
		
		builder.addAttribute("1", "1");
		builder.addAttribute("2", "2");
		
		builder.addAttribute("3", "3");
		builder.addAttribute("4", "4");
		
		builder.addAttribute("5", "5");
		builder.append(XML_Chars.END);
		builder.endLine();
		builder.addEndTag("hey");
		
		String result = builder.toXmlString();
		assertEquals("<hey 1=\"1\" 2=\"2\"\n\r" +
				"  3=\"3\" 4=\"4\"\n\r" +
				"  5=\"5\">\n\r" +
				"</hey>", result);
	}
	
	@Test
	public void testNotPretty() throws Exception {
		XML_Builder builder = new XML_Builder(null, null);
		builder.setAttributesPerLine(2);
		builder.addStartTag("hey");
		
		
		builder.addAttribute("1", "1");
		builder.addAttribute("2", "2");
		
		builder.addAttribute("3", "3");
		builder.addAttribute("4", "4");
		
		builder.addAttribute("5", "5");
		builder.append(XML_Chars.END);
		builder.endLine();
		builder.addEndTag("hey");
		
		String result = builder.toXmlString();
		assertEquals("<hey 1=\"1\" 2=\"2\" 3=\"3\" 4=\"4\" 5=\"5\"></hey>", result);
	}
	
	
	@Test
	public void testAddStartTagWithoutAttributes() throws Exception {
		XML_Builder builder = new XML_Builder();
		builder.addStartTagWithoutAttributes("hey", true);
		
		String result = builder.toXmlString();
		assertEquals("<hey>\n", result);
		
		builder = new XML_Builder();
		builder.addStartTagWithoutAttributes("hey", false);
		
		result = builder.toXmlString();
		assertEquals("<hey>", result);
		
		builder = new XML_Builder("","");
		builder.addStartTagWithoutAttributes("hey", true);
		result = builder.toXmlString();
		assertEquals("<hey>", result);
	
		
	}
	
	@Test
	public void testAddList() throws Exception {
		XML_Builder builder = new XML_Builder();
		List<String> names = new ArrayList<String>();
		names.add(null);
		names.add("Joh>n");
		names.add("Do<e");
		builder.addCollection(names, "names", "name");
		
		String result = builder.toXmlString();
		assertEquals("\t<names>\n" +
				"\t\t<name>Joh&gt;n</name>\n" +
				"\t\t<name>Do&lt;e</name>\n" +
				"\t</names>\n", result);
		
	
		builder = new XML_Builder("", "");
		builder.addCollection(names, "names", "name");
		
		result = builder.toXmlString();
		assertEquals("<names>" +
				"<name>Joh&gt;n</name>" +
				"<name>Do&lt;e</name>" +
				"</names>", result);
		
		builder = new XML_Builder("", "\r");
		builder.addCollection(names, "names", "name");
		
		result = builder.toXmlString();
		assertEquals("<names>\r" +
				"<name>Joh&gt;n</name>\r" +
				"<name>Do&lt;e</name>\r" +
				"</names>\r", result);
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 10;
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
		int thisUniqueAsserts = 9;
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

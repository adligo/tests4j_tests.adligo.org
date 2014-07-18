package org.adligo.tests4j_tests.models.shared.xml;


import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j.models.shared.xml.XML_Chars;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Builder.class, minCoverage=83.0)
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
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 4;
	}

	@Override
	public int getUniqueAsserts() {
		return 4;
	}
}

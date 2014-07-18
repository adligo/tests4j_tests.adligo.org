package org.adligo.tests4j_tests.models.shared.xml;

import java.util.Map;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Chars;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Chars.class, minCoverage=55.0)
public class XML_CharsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() throws Exception {
		assertEquals("\"", XML_Chars.QUOTE);
		assertEquals(">", XML_Chars.END);
		assertEquals("</", XML_Chars.END_START);
		
		assertEquals("=\"", XML_Chars.EQUALS_QUOTE);
		assertEquals("\n", XML_Chars.NEW_LINE_UNIX);
		
		assertEquals("<", XML_Chars.START);
		assertEquals("/>", XML_Chars.START_END);
		assertEquals("\t", XML_Chars.TAB);
		
		Map<String,String> xmlChars = XML_Chars.FROM_XML_CHARS;
		assertEquals(5, xmlChars.size());
		assertEquals("&", xmlChars.get("&amp;"));
		assertEquals("<", xmlChars.get("&lt;"));
		assertEquals(">", xmlChars.get("&gt;"));
		assertEquals("'", xmlChars.get("&apos;"));
		assertEquals("\"", xmlChars.get("&quot;"));
		
		Map<Character,String> toXmlChars = XML_Chars.TO_XML_CHARS;
		assertEquals(5, toXmlChars.size());
		assertEquals("&amp;", toXmlChars.get('&'));
		assertEquals("&lt;", toXmlChars.get('<'));
		assertEquals("&gt;", toXmlChars.get('>'));
		assertEquals("&apos;", toXmlChars.get('\''));
		assertEquals("&quot;", toXmlChars.get('\"'));
		
	}
	
	@Test
	public void testToFromXml() throws Exception {
		String result = XML_Chars.toXml("&<>'\"a");
		assertEquals("&amp;&lt;&gt;&apos;&quot;a", result);
		
		result = XML_Chars.fromXml(result);
		assertEquals("&<>'\"a", result);
		
		result = XML_Chars.toXml(null);
		assertEquals("null", result);
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 23;
	}

	@Override
	public int getUniqueAsserts() {
		return 19;
	}
}

package org.adligo.tests4j_tests.shared.xml;

import java.util.Map;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.xml.XML_Chars;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_XML_GwtReferenceGroup;

@SourceFileScope (sourceClass=XML_Chars.class, minCoverage=54.0)
@AllowedReferences (groups=Tests4J_XML_GwtReferenceGroup.class)
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
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 23;
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
		int thisUniqueAsserts = 19;
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

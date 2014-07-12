package org.adligo.tests4j_tests.models.shared.xml;


import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.results.I_SourceFileTrialResult;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j.models.shared.xml.XML_Chars;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=XML_Builder.class)
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
	
	@Override
	public void afterTrialTests(I_SourceFileTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_SourceFileCoverage coverage = p.getSourceFileCoverage();
			assertGreaterThanOrEquals(91.00, coverage.getPercentageCoveredDouble());
		}
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 2;
	}

	@Override
	public int getUniqueAsserts() {
		return 2;
	}
}

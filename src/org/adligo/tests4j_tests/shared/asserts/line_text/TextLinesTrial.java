package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsLineText_GwtReferenceGroup;

@SourceFileScope (sourceClass=TextLines.class,minCoverage=97.0)
@AllowedReferences (groups=Tests4J_AssertsLineText_GwtReferenceGroup.class)
public class TextLinesTrial extends SourceFileCountingTrial {

	
	@SuppressWarnings("boxing")
  @Test
	public void testLinesWithNormalizedLineFeeds() {
		TextLines lines = new TextLines("a\n" +
				"b");
		assertEquals(2, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("b", lines.getLine(1));
		
		
		lines = new TextLines("a\r\n" +
				"\r\n" +
				"b", true);
		assertEquals(3, lines.getLines());
		assertEquals("a", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("b", lines.getLine(2));
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testLinesWithOutNormalizedLineFeeds() {
		TextLines lines = new TextLines("a\n" +
				"b", false);
		assertEquals(2, lines.getLines());
		assertEquals("a\n", lines.getLine(0));
		assertEquals("b", lines.getLine(1));
		
		
		lines = new TextLines("a\r\n" +
				"\r\n" +
				"b", false);
		assertEquals(3, lines.getLines());
		assertEquals("a\r\n", lines.getLine(0));
		assertEquals("\r\n", lines.getLine(1));
		assertEquals("b", lines.getLine(2));
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEmptyLines() {
		TextLines lines = new TextLines("\n\n\n", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
		
		
		lines = new TextLines("\r\r\r", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
		
		lines = new TextLines("\r\n\r\n\r\n", true);
		assertEquals(3, lines.getLines());
		assertEquals("", lines.getLine(0));
		assertEquals("", lines.getLine(1));
		assertEquals("", lines.getLine(3));
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testToString() {
		TextLines lines = new TextLines("a\n" +
				"b", false);
		
		String actual = lines.toString();
		TextLines fromString = new TextLines(actual, false);
		assertEquals(2, fromString.getLines());
		assertEquals("TextLines [lines=[a\n", fromString.getLine(0));
		assertEquals(", b]]", fromString.getLine(1));
		
		assertEquals("TextLines [lines=[a\n, b]]", actual);
	}
	
	@SuppressWarnings("boxing")
  @Test
  public void testTabsInLines() {
    TextLines lines = new TextLines("\t\n\n\t\n", true);
    assertEquals(3, lines.getLines());
    assertEquals("\t", lines.getLine(0));
    assertEquals("", lines.getLine(1));
    assertEquals("\t", lines.getLine(2));
    
    
    lines = new TextLines("a\ta\r\ta\t\r\tb\t\r", true);
    assertEquals(3, lines.getLines());
    assertEquals("a\ta", lines.getLine(0));
    assertEquals("\ta\t", lines.getLine(1));
    assertEquals("\tb\t", lines.getLine(2));
    
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5, true);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 38;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 23;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}

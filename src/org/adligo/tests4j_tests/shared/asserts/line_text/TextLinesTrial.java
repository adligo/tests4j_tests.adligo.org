package org.adligo.tests4j_tests.shared.asserts.line_text;

import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsLineText_DependencyGroup;

@SourceFileScope (sourceClass=TextLines.class,minCoverage=97.0)
@AllowedDependencies (groups=Tests4J_AssertsLineText_DependencyGroup.class)
public class TextLinesTrial extends SourceFileCountingTrial {

	
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
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int asserts = 30;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int uasserts = 17;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}

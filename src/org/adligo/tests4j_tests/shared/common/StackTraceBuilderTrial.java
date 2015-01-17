package org.adligo.tests4j_tests.shared.common;

import org.adligo.tests4j.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.common.StackTraceBuilder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Common_ReferenceGroup;

@SourceFileScope (sourceClass=StackTraceBuilder.class, minCoverage=95.0)
@AllowedReferences (groups=Tests4J_Common_ReferenceGroup.class)
public class StackTraceBuilderTrial extends SourceFileCountingTrial {

	@SuppressWarnings("boxing")
  @Test
	public void testToStringDeep() {
		
		IllegalArgumentException x = getX();
		StackTraceBuilder stb = new StackTraceBuilder();
		String result = stb.toString(x, true);
		TextLines lines = new TextLines(result);
		assertEquals("java.lang.IllegalArgumentException", lines.getLine(0));
		assertEquals("\tat x.Xmethod1(Xfile1:1)", lines.getLine(1));
		assertEquals("\tat x.Xmethod2(Xfile2:2)", lines.getLine(2));
		assertEquals("\tat x.Xmethod3(Xfile3:3)", lines.getLine(3));
		assertEquals("\tjava.lang.IllegalArgumentException", lines.getLine(4));
		assertEquals("\t\tat y.Ymethod1(Yfile1:1)", lines.getLine(5));
		assertEquals("\t\tat y.Ymethod2(Yfile2:2)", lines.getLine(6));
		assertEquals("\t\tjava.lang.IllegalStateException", lines.getLine(7));
		assertEquals("\t\t\tat z.Zmethod1(Zfile1:1)", lines.getLine(8));
		assertEquals("\t\t\tat z.Zmethod2(Zfile2:2)", lines.getLine(9));
		assertEquals(10, lines.getLines());
	}

	private IllegalArgumentException getX() {
		IllegalArgumentException x = new IllegalArgumentException();
		StackTraceElement [] trace = new StackTraceElement[3];
		trace[0] = new StackTraceElement("x", "Xmethod1", "Xfile1", 1);
		trace[1] = new StackTraceElement("x", "Xmethod2", "Xfile2", 2);
		trace[2] = new StackTraceElement("x", "Xmethod3", "Xfile3", 3);
		x.setStackTrace(trace);
		
		IllegalArgumentException y = new IllegalArgumentException();
		trace = new StackTraceElement[2];
		trace[0] = new StackTraceElement("y", "Ymethod1", "Yfile1", 1);
		trace[1] = new StackTraceElement("y", "Ymethod2", "Yfile2", 2);
		y.setStackTrace(trace);
		x.initCause(y);
		
		IllegalStateException z = new IllegalStateException();
		trace = new StackTraceElement[2];
		trace[0] = new StackTraceElement("z", "Zmethod1", "Zfile1", 1);
		trace[1] = new StackTraceElement("z", "Zmethod2", "Zfile2", 2);
		z.setStackTrace(trace);
		y.initCause(z);
		return x;
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testToStringShallow() {
		IllegalArgumentException x = getX();
		StackTraceBuilder stb = new StackTraceBuilder();
		assertEquals("", stb.getInitalIndent());
    assertEquals("\t", stb.getIndent());
    assertTrue(stb.isLeftToRight());
    assertEquals("at", stb.getAt());
    
		String result = stb.toString(x, false);
		TextLines lines = new TextLines(result);
		assertEquals("java.lang.IllegalArgumentException", lines.getLine(0));
		assertEquals("\tat x.Xmethod1(Xfile1:1)", lines.getLine(1));
		assertEquals("\tat x.Xmethod2(Xfile2:2)", lines.getLine(2));
		assertEquals("\tat x.Xmethod3(Xfile3:3)", lines.getLine(3));
		assertEquals(4, lines.getLines());
		
		stb.setInitalIndent("\t");
		assertEquals("\t", stb.getInitalIndent());
		stb.setIndent(" ");
		assertEquals(" ", stb.getIndent());
		stb.setLeftToRight(false);
		assertFalse(stb.isLeftToRight());
		stb.setAt("on");
		assertEquals("on", stb.getAt());
		
		result = stb.toString(x, false);
    lines = new TextLines(result);
    assertEquals("java.lang.IllegalArgumentException\t", lines.getLine(0));
    assertEquals("x.Xmethod1(Xfile1:1) on \t", lines.getLine(1));
    assertEquals("x.Xmethod2(Xfile2:2) on \t", lines.getLine(2));
    assertEquals("x.Xmethod3(Xfile3:3) on \t", lines.getLine(3));
    assertEquals(4, lines.getLines());
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 29;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 2);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uasserts = 27;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uasserts + 2);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}
}

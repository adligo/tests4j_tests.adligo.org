package org.adligo.tests4j_tests.models.shared.common;

import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.common.StackTraceBuilder;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=StackTraceBuilder.class, minCoverage=96.0)
@AllowedDependencies (groups=Tests4J_Common_DependencyGroup.class)
public class StackTraceBuilderTrial extends SourceFileCountingTrial {

	@Test
	public void testToStringDeep() {
		
		IllegalArgumentException x = getX();
		String result = StackTraceBuilder.toString(x, true);
		TextLines lines = new TextLines(result);
		assertEquals("\tjava.lang.IllegalArgumentException", lines.getLine(0));
		assertEquals("\tat x.Xmethod1(Xfile1:1)", lines.getLine(1));
		assertEquals("\tat x.Xmethod2(Xfile2:2)", lines.getLine(2));
		assertEquals("\tat x.Xmethod3(Xfile3:3)", lines.getLine(3));
		assertEquals("\t\tjava.lang.IllegalArgumentException", lines.getLine(4));
		assertEquals("\t\tat y.Ymethod1(Yfile1:1)", lines.getLine(5));
		assertEquals("\t\tat y.Ymethod2(Yfile2:2)", lines.getLine(6));
		assertEquals("\t\t\tjava.lang.IllegalStateException", lines.getLine(7));
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
	
	@Test
	public void testToStringShallow() {
		IllegalArgumentException x = getX();
		String result = StackTraceBuilder.toString(x, false);
		TextLines lines = new TextLines(result);
		assertEquals("\tjava.lang.IllegalArgumentException", lines.getLine(0));
		assertEquals("\tat x.Xmethod1(Xfile1:1)", lines.getLine(1));
		assertEquals("\tat x.Xmethod2(Xfile2:2)", lines.getLine(2));
		assertEquals("\tat x.Xmethod3(Xfile3:3)", lines.getLine(3));
		assertEquals(4, lines.getLines());
		
	}
	

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,19);
		} else {
			return super.getAsserts(type, 16);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, 19);
		} else {
			return super.getUniqueAsserts(type, 16);
		}
	}
}

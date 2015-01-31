package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_7;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_7.I_JSE_1_7_NIO;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_7_GwtReferenceGroup;

@SourceFileScope (sourceClass=I_JSE_1_7_NIO.class)
@AllowedReferences (groups=Tests4J_JSE_v1_7_GwtReferenceGroup.class)
public class I_JSE_1_7_NIOTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
	  assertEquals("java.nio.Buffer",I_JSE_1_7_NIO.BUFFER);
	  assertEquals("java.nio.ByteBuffer",I_JSE_1_7_NIO.BYTE_BUFFER);
	  assertEquals("java.nio.ByteOrder",I_JSE_1_7_NIO.BYTE_ORDER);
	  assertEquals("java.nio.CharBuffer",I_JSE_1_7_NIO.CHAR_BUFFER);
	  assertEquals("java.nio.DoubleBuffer",I_JSE_1_7_NIO.DOUBLE_BUFFER);
	  assertEquals("java.nio.FloatBuffer",I_JSE_1_7_NIO.FLOAT_BUFFER);
	  assertEquals("java.nio.IntBuffer",I_JSE_1_7_NIO.INT_BUFFER);
	  assertEquals("java.nio.LongBuffer",I_JSE_1_7_NIO.LONG_BUFFER);
	  assertEquals("java.nio.MappedByteBuffer",I_JSE_1_7_NIO.MAPPED_BYTE_BUFFER);
	  assertEquals("java.nio.ShortBuffer",I_JSE_1_7_NIO.SHORT_BUFFER);
	  assertEquals("java.nio.BufferOverflowException",I_JSE_1_7_NIO.BUFFER_OVERFLOW_EXCEPTION);
	  assertEquals("java.nio.BufferUnderflowException",I_JSE_1_7_NIO.BUFFER_UNDERFLOW_EXCEPTION);
	  assertEquals("java.nio.InvalidMarkException",I_JSE_1_7_NIO.INVALID_MARK_EXCEPTION);
	  assertEquals("java.nio.ReadOnlyBufferException",I_JSE_1_7_NIO.READ_ONLY_BUFFER_EXCEPTION);
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 14;
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
		int thisUniqueAsserts = 14;
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

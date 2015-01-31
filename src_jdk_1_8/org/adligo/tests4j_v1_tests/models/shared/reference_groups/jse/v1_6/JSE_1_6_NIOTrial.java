package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_NIO;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_NIO.class,minCoverage=88.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_NIOTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_NIO.INSTANCE);
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
	  asserts.assertTrue(dg.isInGroup("java.nio.Buffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.ByteBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.ByteOrder"));
    asserts.assertTrue(dg.isInGroup("java.nio.CharBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.DoubleBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.FloatBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.IntBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.LongBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.MappedByteBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.ShortBuffer"));
    asserts.assertTrue(dg.isInGroup("java.nio.BufferOverflowException"));
    asserts.assertTrue(dg.isInGroup("java.nio.BufferUnderflowException"));
    asserts.assertTrue(dg.isInGroup("java.nio.InvalidMarkException"));
    asserts.assertTrue(dg.isInGroup("java.nio.ReadOnlyBufferException"));
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
		int thisUniqueAsserts = 1;
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

package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Log;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_Log.class,minCoverage=91.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_LogTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Log.INSTANCE);
    assertEquals("FILTER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.Filter"));
    assertEquals("CONSOLE_HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.ConsoleHandler"));
    assertEquals("ERROR_MANAGER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.ErrorManager"));
    assertEquals("FILE_HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.FileHandler"));
    assertEquals("FORMATTER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.Formatter"));
    assertEquals("HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.Handler"));
    assertEquals("LEVEL",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.Level"));
    assertEquals("LOGGER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.Logger"));
    assertEquals("LOGGING_PERMISSION",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.LoggingPermission"));
    assertEquals("LOG_MANAGER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.LogManager"));
    assertEquals("LOG_RECORD",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.LogRecord"));
    assertEquals("MEMORY_HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.MemoryHandler"));
    assertEquals("SIMPLE_FORMATTER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.SimpleFormatter"));
    assertEquals("SOCKET_HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.SocketHandler"));
    assertEquals("STREAM_HANDLER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.StreamHandler"));
    assertEquals("XMLFORMATTER",JSE_1_6_Log.INSTANCE.getConstantName("java.util.logging.XMLFormatter"));
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.util.logging.Filter"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.LoggingMXBean"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.ConsoleHandler"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.ErrorManager"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.FileHandler"));
		asserts.assertTrue(dg.isInGroup("java.util.Formatter"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.Handler"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.Level"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.Logger"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.LoggingPermission"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.LogManager"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.LogRecord"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.MemoryHandler"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.SimpleFormatter"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.SocketHandler"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.StreamHandler"));
		asserts.assertTrue(dg.isInGroup("java.util.logging.XMLFormatter"));

	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 33;
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
		int thisUniqueAsserts = 17;
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

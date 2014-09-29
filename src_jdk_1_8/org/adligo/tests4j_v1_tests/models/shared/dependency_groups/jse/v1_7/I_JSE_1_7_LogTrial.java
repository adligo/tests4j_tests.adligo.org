package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_7;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_7.I_JSE_1_7_Log;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_7_DependencyGroup;

@SourceFileScope (sourceClass=I_JSE_1_7_Log.class)
@AllowedDependencies (groups=Tests4J_JSE_v1_7_DependencyGroup.class)
public class I_JSE_1_7_LogTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.util.logging.Filter",I_JSE_1_7_Log.FILTER);
		assertEquals("java.util.logging.ConsoleHandler",I_JSE_1_7_Log.CONSOLE_HANDLER);
		assertEquals("java.util.logging.ErrorManager",I_JSE_1_7_Log.ERROR_MANAGER);
		assertEquals("java.util.logging.FileHandler",I_JSE_1_7_Log.FILE_HANDLER);
		assertEquals("java.util.logging.Formatter",I_JSE_1_7_Log.FORMATTER);
		assertEquals("java.util.logging.Handler",I_JSE_1_7_Log.HANDLER);
		assertEquals("java.util.logging.Level",I_JSE_1_7_Log.LEVEL);
		assertEquals("java.util.logging.Logger",I_JSE_1_7_Log.LOGGER);
		assertEquals("java.util.logging.LoggingPermission",I_JSE_1_7_Log.LOGGING_PERMISSION);
		assertEquals("java.util.logging.LogManager",I_JSE_1_7_Log.LOG_MANAGER);
		assertEquals("java.util.logging.LogRecord",I_JSE_1_7_Log.LOG_RECORD);
		assertEquals("java.util.logging.MemoryHandler",I_JSE_1_7_Log.MEMORY_HANDLER);
		assertEquals("java.util.logging.SimpleFormatter",I_JSE_1_7_Log.SIMPLE_FORMATTER);
		assertEquals("java.util.logging.SocketHandler",I_JSE_1_7_Log.SOCKET_HANDLER);
		assertEquals("java.util.logging.StreamHandler",I_JSE_1_7_Log.STREAM_HANDLER);
		assertEquals("java.util.logging.XMLFormatter",I_JSE_1_7_Log.XMLFORMATTER);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
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
		int thisUniqueAsserts = 16;
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

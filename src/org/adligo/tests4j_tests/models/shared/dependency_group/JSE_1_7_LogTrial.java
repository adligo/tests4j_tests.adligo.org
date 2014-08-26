package org.adligo.tests4j_tests.models.shared.dependency_group;

import org.adligo.tests4j.models.shared.dependency_groups.JSE_1_7_Log;
import org.adligo.tests4j.models.shared.dependency_groups.JSE_1_7_Math;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_1_7_Log.class)
public class JSE_1_7_LogTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.util.logging.Filter",JSE_1_7_Log.FILTER);
		assertEquals("java.util.logging.ConsoleHandler",JSE_1_7_Log.CONSOLE_HANDLER);
		assertEquals("java.util.logging.ErrorManager",JSE_1_7_Log.ERROR_MANAGER);
		assertEquals("java.util.logging.FileHandler",JSE_1_7_Log.FILE_HANDLER);
		assertEquals("java.util.Formatter",JSE_1_7_Log.FORMATTER);
		assertEquals("java.util.logging.Handler",JSE_1_7_Log.HANDLER);
		assertEquals("java.util.logging.Level",JSE_1_7_Log.LEVEL);
		assertEquals("java.util.logging.Logger",JSE_1_7_Log.LOGGER);
		assertEquals("java.util.logging.LoggingPermission",JSE_1_7_Log.LOGGING_PERMISSION);
		assertEquals("java.util.logging.LogManager",JSE_1_7_Log.LOG_MANAGER);
		assertEquals("java.util.logging.LogRecord",JSE_1_7_Log.LOG_RECORD);
		assertEquals("java.util.logging.MemoryHandler",JSE_1_7_Log.MEMORY_HANDLER);
		assertEquals("java.util.logging.SimpleFormatter",JSE_1_7_Log.SIMPLE_FORMATTER);
		assertEquals("java.util.logging.SocketHandler",JSE_1_7_Log.SOCKET_HANDLER);
		assertEquals("java.util.logging.StreamHandler",JSE_1_7_Log.STREAM_HANDLER);
		assertEquals("java.util.logging.XMLFormatter",JSE_1_7_Log.XMLFORMATTER);
		assertEquals(JSE_1_7_Log.class.getName(), JSE_1_7_Log.INSTANCE.getClass().getName());
	}
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 17;
	}

	@Override
	public int getUniqueAsserts() {
		return 17;
	}

}

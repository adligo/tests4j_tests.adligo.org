package org.adligo.tests4j_tests.models.dependency_groups.jse;

import org.adligo.tests4j.models.dependency_groups.jse.JSE_1_6_Lang;
import org.adligo.tests4j.models.dependency_groups.jse.JSE_1_7_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_1_7_Lang.class)
public class JSE_1_7_LangTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {

		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.lang.Appendable",JSE_1_7_Lang.APPENDABLE);
		assertEquals("java.lang.AutoCloseable",JSE_1_7_Lang.AUTO_CLOSEABLE);
		assertEquals("java.lang.CharSequence",JSE_1_7_Lang.CHAR_SEQUENCE);
		assertEquals("java.lang.Cloneable",JSE_1_7_Lang.CLONEABLE);
		assertEquals("java.lang.Comparable",JSE_1_7_Lang.COMPARABLE);
		assertEquals("java.lang.Iterable",JSE_1_7_Lang.ITERABLE);
		assertEquals("java.lang.Readable",JSE_1_7_Lang.READABLE);
		assertEquals("java.lang.Runnable",JSE_1_7_Lang.RUNNABLE);
		assertEquals("java.lang.Thread$UncaughtExceptionHandler",JSE_1_7_Lang.THREAD_UNCAUGHT_EXCEPTION_HANDLER);
		assertEquals("java.lang.Boolean",JSE_1_7_Lang.BOOLEAN);
		assertEquals("java.lang.Byte",JSE_1_7_Lang.BYTE);
		assertEquals("java.lang.Character",JSE_1_7_Lang.CHARACTER);
		assertEquals("java.lang.Character$Subset",JSE_1_7_Lang.CHARACTER_SUBSET);
		assertEquals("java.lang.Character$UnicodeBlock",JSE_1_7_Lang.CHARACTER_UNICODE_BLOCK);
		assertEquals("java.lang.Class",JSE_1_7_Lang.CLASS);
		assertEquals("java.lang.ClassLoader",JSE_1_7_Lang.CLASS_LOADER);
		assertEquals("java.lang.ClassValue",JSE_1_7_Lang.CLASS_VALUE);
		assertEquals("java.lang.Compiler",JSE_1_7_Lang.COMPILER);
		assertEquals("java.lang.Double",JSE_1_7_Lang.DOUBLE);
		assertEquals("java.lang.Enum",JSE_1_7_Lang.ENUM);
		assertEquals("java.lang.Float",JSE_1_7_Lang.FLOAT);
		assertEquals("java.lang.InheritableThreadLocal",JSE_1_7_Lang.INHERITABLE_THREAD_LOCAL);
		assertEquals("java.lang.Integer",JSE_1_7_Lang.INTEGER);
		assertEquals("java.lang.Long",JSE_1_7_Lang.LONG);
		assertEquals("java.lang.Math",JSE_1_7_Lang.MATH);
		assertEquals("java.lang.Number",JSE_1_7_Lang.NUMBER);
		assertEquals("java.lang.Object",JSE_1_7_Lang.OBJECT);
		assertEquals("java.lang.Package",JSE_1_7_Lang.PACKAGE);
		assertEquals("java.lang.Process",JSE_1_7_Lang.PROCESS);
		assertEquals("java.lang.ProcessBuilder",JSE_1_7_Lang.PROCESS_BUILDER);
		assertEquals("java.lang.ProcessBuilder$Redirect",JSE_1_7_Lang.PROCESS_BUILDER_REDIRECT);
		assertEquals("java.lang.Runtime",JSE_1_7_Lang.RUNTIME);
		assertEquals("java.lang.RuntimePermission",JSE_1_7_Lang.RUNTIME_PERMISSION);
		assertEquals("java.lang.SecurityManager",JSE_1_7_Lang.SECURITY_MANAGER);
		assertEquals("java.lang.Short",JSE_1_7_Lang.SHORT);
		assertEquals("java.lang.StackTraceElement",JSE_1_7_Lang.STACK_TRACE_ELEMENT);
		assertEquals("java.lang.StrictMath",JSE_1_7_Lang.STRICT_MATH);
		assertEquals("java.lang.String",JSE_1_7_Lang.STRING);
		assertEquals("java.lang.StringBuffer",JSE_1_7_Lang.STRING_BUFFER);
		assertEquals("java.lang.StringBuilder",JSE_1_7_Lang.STRING_BUILDER);
		assertEquals("java.lang.System",JSE_1_7_Lang.SYSTEM);
		assertEquals("java.lang.Thread",JSE_1_7_Lang.THREAD);
		assertEquals("java.lang.ThreadGroup",JSE_1_7_Lang.THREAD_GROUP);
		assertEquals("java.lang.ThreadLocal",JSE_1_7_Lang.THREAD_LOCAL);
		assertEquals("java.lang.Throwable",JSE_1_7_Lang.THROWABLE);
		assertEquals("java.lang.Void",JSE_1_7_Lang.VOID);
		assertEquals("java.lang.Character$UnicodeScript",JSE_1_7_Lang.CHARACTER_UNICODE_SCRIPT);
		assertEquals("java.lang.ProcessBuilder$Redirect$Type",JSE_1_7_Lang.PROCESS_BUILDER_REDIRECT_TYPE);
		assertEquals("java.lang.Thread$State",JSE_1_7_Lang.THREAD_STATE);
		assertEquals("java.lang.ArithmeticException",JSE_1_7_Lang.ARITHMETIC_EXCEPTION);
		assertEquals("java.lang.ArrayIndexOutOfBoundsException",JSE_1_7_Lang.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.ArrayStoreException",JSE_1_7_Lang.ARRAY_STORE_EXCEPTION);
		assertEquals("java.lang.ClassCastException",JSE_1_7_Lang.CLASS_CAST_EXCEPTION);
		assertEquals("java.lang.ClassNotFoundException",JSE_1_7_Lang.CLASS_NOT_FOUND_EXCEPTION);
		assertEquals("java.lang.CloneNotSupportedException",JSE_1_7_Lang.CLONE_NOT_SUPPORTED_EXCEPTION);
		assertEquals("java.lang.EnumConstantNotPresentException",JSE_1_7_Lang.ENUM_CONSTANT_NOT_PRESENT_EXCEPTION);
		assertEquals("java.lang.Exception",JSE_1_7_Lang.EXCEPTION);
		assertEquals("java.lang.IllegalAccessException",JSE_1_7_Lang.ILLEGAL_ACCESS_EXCEPTION);
		assertEquals("java.lang.IllegalArgumentException",JSE_1_7_Lang.ILLEGAL_ARGUMENT_EXCEPTION);
		assertEquals("java.lang.IllegalMonitorStateException",JSE_1_7_Lang.ILLEGAL_MONITOR_STATE_EXCEPTION);
		assertEquals("java.lang.IllegalStateException",JSE_1_7_Lang.ILLEGAL_STATE_EXCEPTION);
		assertEquals("java.lang.IllegalThreadStateException",JSE_1_7_Lang.ILLEGAL_THREAD_STATE_EXCEPTION);
		assertEquals("java.lang.IndexOutOfBoundsException",JSE_1_7_Lang.INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.InstantiationException",JSE_1_7_Lang.INSTANTIATION_EXCEPTION);
		assertEquals("java.lang.InterruptedException",JSE_1_7_Lang.INTERRUPTED_EXCEPTION);
		assertEquals("java.lang.NegativeArraySizeException",JSE_1_7_Lang.NEGATIVE_ARRAY_SIZE_EXCEPTION);
		assertEquals("java.lang.NoSuchFieldException",JSE_1_7_Lang.NO_SUCH_FIELD_EXCEPTION);
		assertEquals("java.lang.NoSuchMethodException",JSE_1_7_Lang.NO_SUCH_METHOD_EXCEPTION);
		assertEquals("java.lang.NullPointerException",JSE_1_7_Lang.NULL_POINTER_EXCEPTION);
		assertEquals("java.lang.NumberFormatException",JSE_1_7_Lang.NUMBER_FORMAT_EXCEPTION);
		assertEquals("java.lang.ReflectiveOperationException",JSE_1_7_Lang.REFLECTIVE_OPERATION_EXCEPTION);
		assertEquals("java.lang.RuntimeException",JSE_1_7_Lang.RUNTIME_EXCEPTION);
		assertEquals("java.lang.SecurityException",JSE_1_7_Lang.SECURITY_EXCEPTION);
		assertEquals("java.lang.StringIndexOutOfBoundsException",JSE_1_7_Lang.STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.TypeNotPresentException",JSE_1_7_Lang.TYPE_NOT_PRESENT_EXCEPTION);
		assertEquals("java.lang.UnsupportedOperationException",JSE_1_7_Lang.UNSUPPORTED_OPERATION_EXCEPTION);
		assertEquals("java.lang.AbstractMethodError",JSE_1_7_Lang.ABSTRACT_METHOD_ERROR);
		assertEquals("java.lang.AssertionError",JSE_1_7_Lang.ASSERTION_ERROR);
		assertEquals("java.lang.BootstrapMethodError",JSE_1_7_Lang.BOOTSTRAP_METHOD_ERROR);
		assertEquals("java.lang.ClassCircularityError",JSE_1_7_Lang.CLASS_CIRCULARITY_ERROR);
		assertEquals("java.lang.ClassFormatError",JSE_1_7_Lang.CLASS_FORMAT_ERROR);
		assertEquals("java.lang.Error",JSE_1_7_Lang.ERROR);
		assertEquals("java.lang.ExceptionInInitializerError",JSE_1_7_Lang.EXCEPTION_IN_INITIALIZER_ERROR);
		assertEquals("java.lang.IllegalAccessError",JSE_1_7_Lang.ILLEGAL_ACCESS_ERROR);
		assertEquals("java.lang.IncompatibleClassChangeError",JSE_1_7_Lang.INCOMPATIBLE_CLASS_CHANGE_ERROR);
		assertEquals("java.lang.InstantiationError",JSE_1_7_Lang.INSTANTIATION_ERROR);
		assertEquals("java.lang.InternalError",JSE_1_7_Lang.INTERNAL_ERROR);
		assertEquals("java.lang.LinkageError",JSE_1_7_Lang.LINKAGE_ERROR);
		assertEquals("java.lang.NoClassDefFoundError",JSE_1_7_Lang.NO_CLASS_DEF_FOUND_ERROR);
		assertEquals("java.lang.NoSuchFieldError",JSE_1_7_Lang.NO_SUCH_FIELD_ERROR);
		assertEquals("java.lang.NoSuchMethodError",JSE_1_7_Lang.NO_SUCH_METHOD_ERROR);
		assertEquals("java.lang.OutOfMemoryError",JSE_1_7_Lang.OUT_OF_MEMORY_ERROR);
		assertEquals("java.lang.StackOverflowError",JSE_1_7_Lang.STACK_OVERFLOW_ERROR);
		assertEquals("java.lang.ThreadDeath",JSE_1_7_Lang.THREAD_DEATH);
		assertEquals("java.lang.UnknownError",JSE_1_7_Lang.UNKNOWN_ERROR);
		assertEquals("java.lang.UnsatisfiedLinkError",JSE_1_7_Lang.UNSATISFIED_LINK_ERROR);
		assertEquals("java.lang.UnsupportedClassVersionError",JSE_1_7_Lang.UNSUPPORTED_CLASS_VERSION_ERROR);
		assertEquals("java.lang.VerifyError",JSE_1_7_Lang.VERIFY_ERROR);
		assertEquals("java.lang.VirtualMachineError",JSE_1_7_Lang.VIRTUAL_MACHINE_ERROR);
		
		assertEquals("java.lang.Deprecated", JSE_1_7_Lang.DEPRECATED);
		assertEquals("java.lang.Override", JSE_1_7_Lang.OVERRIDE);		
		assertEquals("java.lang.SuppressWarnings", JSE_1_7_Lang.SUPPRESS_WARNINGS);
		assertEquals("java.lang.SafeVarargs", JSE_1_7_Lang.SAFE_VARARGS);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 103;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 103;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
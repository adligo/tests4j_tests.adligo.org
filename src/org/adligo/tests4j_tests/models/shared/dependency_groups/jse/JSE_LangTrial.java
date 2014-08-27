package org.adligo.tests4j_tests.models.shared.dependency_groups.jse;

import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_Lang.class)
public class JSE_LangTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {

		assertEquals("java.lang.Appendable",JSE_Lang.APPENDABLE);
		assertEquals("java.lang.CharSequence",JSE_Lang.CHAR_SEQUENCE);
		assertEquals("java.lang.Cloneable",JSE_Lang.CLONEABLE);
		assertEquals("java.lang.Comparable",JSE_Lang.COMPARABLE);
		assertEquals("java.lang.Iterable",JSE_Lang.ITERABLE);
		assertEquals("java.lang.Readable",JSE_Lang.READABLE);
		assertEquals("java.lang.Runnable",JSE_Lang.RUNNABLE);
		assertEquals("java.lang.Thread$UncaughtExceptionHandler",JSE_Lang.THREAD_UNCAUGHT_EXCEPTION_HANDLER);
		assertEquals("java.lang.Boolean",JSE_Lang.BOOLEAN);
		assertEquals("java.lang.Byte",JSE_Lang.BYTE);
		assertEquals("java.lang.Character",JSE_Lang.CHARACTER);
		assertEquals("java.lang.Character$Subset",JSE_Lang.CHARACTER_SUBSET);
		assertEquals("java.lang.Character$UnicodeBlock",JSE_Lang.CHARACTER_UNICODE_BLOCK);
		assertEquals("java.lang.Class",JSE_Lang.CLASS);
		assertEquals("java.lang.ClassLoader",JSE_Lang.CLASS_LOADER);
		assertEquals("java.lang.ClassValue",JSE_Lang.CLASS_VALUE);
		assertEquals("java.lang.Compiler",JSE_Lang.COMPILER);
		assertEquals("java.lang.Double",JSE_Lang.DOUBLE);
		assertEquals("java.lang.Enum",JSE_Lang.ENUM);
		assertEquals("java.lang.Float",JSE_Lang.FLOAT);
		assertEquals("java.lang.InheritableThreadLocal",JSE_Lang.INHERITABLE_THREAD_LOCAL);
		assertEquals("java.lang.Integer",JSE_Lang.INTEGER);
		assertEquals("java.lang.Long",JSE_Lang.LONG);
		assertEquals("java.lang.Math",JSE_Lang.MATH);
		assertEquals("java.lang.Number",JSE_Lang.NUMBER);
		assertEquals("java.lang.Object",JSE_Lang.OBJECT);
		assertEquals("java.lang.Package",JSE_Lang.PACKAGE);
		assertEquals("java.lang.Process",JSE_Lang.PROCESS);
		assertEquals("java.lang.ProcessBuilder",JSE_Lang.PROCESS_BUILDER);
		assertEquals("java.lang.Runtime",JSE_Lang.RUNTIME);
		assertEquals("java.lang.RuntimePermission",JSE_Lang.RUNTIME_PERMISSION);
		assertEquals("java.lang.SecurityManager",JSE_Lang.SECURITY_MANAGER);
		assertEquals("java.lang.Short",JSE_Lang.SHORT);
		assertEquals("java.lang.StackTraceElement",JSE_Lang.STACK_TRACE_ELEMENT);
		assertEquals("java.lang.StrictMath",JSE_Lang.STRICT_MATH);
		assertEquals("java.lang.String",JSE_Lang.STRING);
		assertEquals("java.lang.StringBuffer",JSE_Lang.STRING_BUFFER);
		assertEquals("java.lang.StringBuilder",JSE_Lang.STRING_BUILDER);
		assertEquals("java.lang.System",JSE_Lang.SYSTEM);
		assertEquals("java.lang.Thread",JSE_Lang.THREAD);
		assertEquals("java.lang.ThreadGroup",JSE_Lang.THREAD_GROUP);
		assertEquals("java.lang.ThreadLocal",JSE_Lang.THREAD_LOCAL);
		assertEquals("java.lang.Throwable",JSE_Lang.THROWABLE);
		assertEquals("java.lang.Void",JSE_Lang.VOID);
		assertEquals("java.lang.Thread$State",JSE_Lang.THREAD_STATE);
		assertEquals("java.lang.ArithmeticException",JSE_Lang.ARITHMETIC_EXCEPTION);
		assertEquals("java.lang.ArrayIndexOutOfBoundsException",JSE_Lang.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.ArrayStoreException",JSE_Lang.ARRAY_STORE_EXCEPTION);
		assertEquals("java.lang.ClassCastException",JSE_Lang.CLASS_CAST_EXCEPTION);
		assertEquals("java.lang.ClassNotFoundException",JSE_Lang.CLASS_NOT_FOUND_EXCEPTION);
		assertEquals("java.lang.CloneNotSupportedException",JSE_Lang.CLONE_NOT_SUPPORTED_EXCEPTION);
		assertEquals("java.lang.EnumConstantNotPresentException",JSE_Lang.ENUM_CONSTANT_NOT_PRESENT_EXCEPTION);
		assertEquals("java.lang.Exception",JSE_Lang.EXCEPTION);
		assertEquals("java.lang.IllegalAccessException",JSE_Lang.ILLEGAL_ACCESS_EXCEPTION);
		assertEquals("java.lang.IllegalArgumentException",JSE_Lang.ILLEGAL_ARGUMENT_EXCEPTION);
		assertEquals("java.lang.IllegalMonitorStateException",JSE_Lang.ILLEGAL_MONITOR_STATE_EXCEPTION);
		assertEquals("java.lang.IllegalStateException",JSE_Lang.ILLEGAL_STATE_EXCEPTION);
		assertEquals("java.lang.IllegalThreadStateException",JSE_Lang.ILLEGAL_THREAD_STATE_EXCEPTION);
		assertEquals("java.lang.IndexOutOfBoundsException",JSE_Lang.INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.InstantiationException",JSE_Lang.INSTANTIATION_EXCEPTION);
		assertEquals("java.lang.InterruptedException",JSE_Lang.INTERRUPTED_EXCEPTION);
		assertEquals("java.lang.NegativeArraySizeException",JSE_Lang.NEGATIVE_ARRAY_SIZE_EXCEPTION);
		assertEquals("java.lang.NoSuchFieldException",JSE_Lang.NO_SUCH_FIELD_EXCEPTION);
		assertEquals("java.lang.NoSuchMethodException",JSE_Lang.NO_SUCH_METHOD_EXCEPTION);
		assertEquals("java.lang.NullPointerException",JSE_Lang.NULL_POINTER_EXCEPTION);
		assertEquals("java.lang.NumberFormatException",JSE_Lang.NUMBER_FORMAT_EXCEPTION);
		assertEquals("java.lang.ReflectiveOperationException",JSE_Lang.REFLECTIVE_OPERATION_EXCEPTION);
		assertEquals("java.lang.RuntimeException",JSE_Lang.RUNTIME_EXCEPTION);
		assertEquals("java.lang.SecurityException",JSE_Lang.SECURITY_EXCEPTION);
		assertEquals("java.lang.StringIndexOutOfBoundsException",JSE_Lang.STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION);
		assertEquals("java.lang.TypeNotPresentException",JSE_Lang.TYPE_NOT_PRESENT_EXCEPTION);
		assertEquals("java.lang.UnsupportedOperationException",JSE_Lang.UNSUPPORTED_OPERATION_EXCEPTION);
		assertEquals("java.lang.AbstractMethodError",JSE_Lang.ABSTRACT_METHOD_ERROR);
		assertEquals("java.lang.AssertionError",JSE_Lang.ASSERTION_ERROR);
		assertEquals("java.lang.ClassCircularityError",JSE_Lang.CLASS_CIRCULARITY_ERROR);
		assertEquals("java.lang.ClassFormatError",JSE_Lang.CLASS_FORMAT_ERROR);
		assertEquals("java.lang.Error",JSE_Lang.ERROR);
		assertEquals("java.lang.ExceptionInInitializerError",JSE_Lang.EXCEPTION_IN_INITIALIZER_ERROR);
		assertEquals("java.lang.IllegalAccessError",JSE_Lang.ILLEGAL_ACCESS_ERROR);
		assertEquals("java.lang.IncompatibleClassChangeError",JSE_Lang.INCOMPATIBLE_CLASS_CHANGE_ERROR);
		assertEquals("java.lang.InstantiationError",JSE_Lang.INSTANTIATION_ERROR);
		assertEquals("java.lang.InternalError",JSE_Lang.INTERNAL_ERROR);
		assertEquals("java.lang.LinkageError",JSE_Lang.LINKAGE_ERROR);
		assertEquals("java.lang.NoClassDefFoundError",JSE_Lang.NO_CLASS_DEF_FOUND_ERROR);
		assertEquals("java.lang.NoSuchFieldError",JSE_Lang.NO_SUCH_FIELD_ERROR);
		assertEquals("java.lang.NoSuchMethodError",JSE_Lang.NO_SUCH_METHOD_ERROR);
		assertEquals("java.lang.OutOfMemoryError",JSE_Lang.OUT_OF_MEMORY_ERROR);
		assertEquals("java.lang.StackOverflowError",JSE_Lang.STACK_OVERFLOW_ERROR);
		assertEquals("java.lang.ThreadDeath",JSE_Lang.THREAD_DEATH);
		assertEquals("java.lang.UnknownError",JSE_Lang.UNKNOWN_ERROR);
		assertEquals("java.lang.UnsatisfiedLinkError",JSE_Lang.UNSATISFIED_LINK_ERROR);
		assertEquals("java.lang.UnsupportedClassVersionError",JSE_Lang.UNSUPPORTED_CLASS_VERSION_ERROR);
		assertEquals("java.lang.VerifyError",JSE_Lang.VERIFY_ERROR);
		assertEquals("java.lang.VirtualMachineError",JSE_Lang.VIRTUAL_MACHINE_ERROR);
		
		assertEquals("java.lang.Deprecated", JSE_Lang.DEPRICATED);
		assertEquals("java.lang.Override", JSE_Lang.OVERRIDE);
		assertEquals("java.lang.SuppressWarnings", JSE_Lang.SUPRESS_WARNINGS);
	
		assertEquals(JSE_Lang.class.getName(), JSE_Lang.INSTANCE.getClass().getName());
	}
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 98;
	}

	@Override
	public int getUniqueAsserts() {
		return 98;
	}

}

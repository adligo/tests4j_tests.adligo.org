package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse;

import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_Lang.class)
public class JSE_LangTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {

		assertEquals("java.lang.Appendable",JSE_Lang.APPENDABLE);
		assertEquals("java.lang.AutoCloseable",JSE_Lang.AUTO_CLOSEABLE);
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
		assertEquals("java.lang.ProcessBuilder$Redirect",JSE_Lang.PROCESS_BUILDER_REDIRECT);
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
		assertEquals("java.lang.Character$UnicodeScript",JSE_Lang.CHARACTER_UNICODE_SCRIPT);
		assertEquals("java.lang.ProcessBuilder$Redirect$Type",JSE_Lang.PROCESS_BUILDER_REDIRECT_TYPE);
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
		assertEquals("java.lang.BootstrapMethodError",JSE_Lang.BOOTSTRAP_METHOD_ERROR);
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
		
		assertEquals("java.lang.Deprecated",JSE_Lang.DEPRECATED);
		assertEquals("java.lang.FunctionalInterface",JSE_Lang.FUNCTIONAL_INTERFACE);
		assertEquals("java.lang.Override",JSE_Lang.OVERRIDE);
		assertEquals("java.lang.SafeVarargs",JSE_Lang.SAFE_VARARGS);
		assertEquals("java.lang.SuppressWarnings",JSE_Lang.SUPPRESS_WARNINGS);
		assertEquals(JSE_Lang.class.getName(), JSE_Lang.INSTANCE.getClass().getName());
		
		assertEquals("APPENDABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Appendable"));
		assertEquals("AUTO_CLOSEABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.AutoCloseable"));
		assertEquals("CHAR_SEQUENCE",JSE_Lang.INSTANCE.getConstantName("java.lang.CharSequence"));
		assertEquals("CLONEABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Cloneable"));
		assertEquals("COMPARABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Comparable"));
		assertEquals("ITERABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Iterable"));
		assertEquals("READABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Readable"));
		assertEquals("RUNNABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Runnable"));
		assertEquals("THREAD_UNCAUGHT_EXCEPTION_HANDLER",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread$UncaughtExceptionHandler"));
		assertEquals("BOOLEAN",JSE_Lang.INSTANCE.getConstantName("java.lang.Boolean"));
		assertEquals("BYTE",JSE_Lang.INSTANCE.getConstantName("java.lang.Byte"));
		assertEquals("CHARACTER",JSE_Lang.INSTANCE.getConstantName("java.lang.Character"));
		assertEquals("CHARACTER_SUBSET",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$Subset"));
		assertEquals("CHARACTER_UNICODE_BLOCK",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$UnicodeBlock"));
		assertEquals("CLASS",JSE_Lang.INSTANCE.getConstantName("java.lang.Class"));
		assertEquals("CLASS_LOADER",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassLoader"));
		assertEquals("CLASS_VALUE",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassValue"));
		assertEquals("COMPILER",JSE_Lang.INSTANCE.getConstantName("java.lang.Compiler"));
		assertEquals("DOUBLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Double"));
		assertEquals("ENUM",JSE_Lang.INSTANCE.getConstantName("java.lang.Enum"));
		assertEquals("FLOAT",JSE_Lang.INSTANCE.getConstantName("java.lang.Float"));
		assertEquals("INHERITABLE_THREAD_LOCAL",JSE_Lang.INSTANCE.getConstantName("java.lang.InheritableThreadLocal"));
		assertEquals("INTEGER",JSE_Lang.INSTANCE.getConstantName("java.lang.Integer"));
		assertEquals("LONG",JSE_Lang.INSTANCE.getConstantName("java.lang.Long"));
		assertEquals("MATH",JSE_Lang.INSTANCE.getConstantName("java.lang.Math"));
		assertEquals("NUMBER",JSE_Lang.INSTANCE.getConstantName("java.lang.Number"));
		assertEquals("OBJECT",JSE_Lang.INSTANCE.getConstantName("java.lang.Object"));
		assertEquals("PACKAGE",JSE_Lang.INSTANCE.getConstantName("java.lang.Package"));
		assertEquals("PROCESS",JSE_Lang.INSTANCE.getConstantName("java.lang.Process"));
		assertEquals("PROCESS_BUILDER",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder"));
		assertEquals("PROCESS_BUILDER_REDIRECT",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder$Redirect"));
		assertEquals("RUNTIME",JSE_Lang.INSTANCE.getConstantName("java.lang.Runtime"));
		assertEquals("RUNTIME_PERMISSION",JSE_Lang.INSTANCE.getConstantName("java.lang.RuntimePermission"));
		assertEquals("SECURITY_MANAGER",JSE_Lang.INSTANCE.getConstantName("java.lang.SecurityManager"));
		assertEquals("SHORT",JSE_Lang.INSTANCE.getConstantName("java.lang.Short"));
		assertEquals("STACK_TRACE_ELEMENT",JSE_Lang.INSTANCE.getConstantName("java.lang.StackTraceElement"));
		assertEquals("STRICT_MATH",JSE_Lang.INSTANCE.getConstantName("java.lang.StrictMath"));
		assertEquals("STRING",JSE_Lang.INSTANCE.getConstantName("java.lang.String"));
		assertEquals("STRING_BUFFER",JSE_Lang.INSTANCE.getConstantName("java.lang.StringBuffer"));
		assertEquals("STRING_BUILDER",JSE_Lang.INSTANCE.getConstantName("java.lang.StringBuilder"));
		assertEquals("SYSTEM",JSE_Lang.INSTANCE.getConstantName("java.lang.System"));
		assertEquals("THREAD",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread"));
		assertEquals("THREAD_GROUP",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadGroup"));
		assertEquals("THREAD_LOCAL",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadLocal"));
		assertEquals("THROWABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Throwable"));
		assertEquals("VOID",JSE_Lang.INSTANCE.getConstantName("java.lang.Void"));
		assertEquals("CHARACTER_UNICODE_SCRIPT",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$UnicodeScript"));
		assertEquals("PROCESS_BUILDER_REDIRECT_TYPE",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder$Redirect$Type"));
		assertEquals("THREAD_STATE",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread$State"));
		assertEquals("ARITHMETIC_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArithmeticException"));
		assertEquals("ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArrayIndexOutOfBoundsException"));
		assertEquals("ARRAY_STORE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArrayStoreException"));
		assertEquals("CLASS_CAST_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassCastException"));
		assertEquals("CLASS_NOT_FOUND_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassNotFoundException"));
		assertEquals("CLONE_NOT_SUPPORTED_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.CloneNotSupportedException"));
		assertEquals("ENUM_CONSTANT_NOT_PRESENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.EnumConstantNotPresentException"));
		assertEquals("EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.Exception"));
		assertEquals("ILLEGAL_ACCESS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalAccessException"));
		assertEquals("ILLEGAL_ARGUMENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalArgumentException"));
		assertEquals("ILLEGAL_MONITOR_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalMonitorStateException"));
		assertEquals("ILLEGAL_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalStateException"));
		assertEquals("ILLEGAL_THREAD_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalThreadStateException"));
		assertEquals("INDEX_OUT_OF_BOUNDS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IndexOutOfBoundsException"));
		assertEquals("INSTANTIATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.InstantiationException"));
		assertEquals("INTERRUPTED_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.InterruptedException"));
		assertEquals("NEGATIVE_ARRAY_SIZE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NegativeArraySizeException"));
		assertEquals("NO_SUCH_FIELD_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchFieldException"));
		assertEquals("NO_SUCH_METHOD_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchMethodException"));
		assertEquals("NULL_POINTER_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NullPointerException"));
		assertEquals("NUMBER_FORMAT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NumberFormatException"));
		assertEquals("REFLECTIVE_OPERATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ReflectiveOperationException"));
		assertEquals("RUNTIME_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.RuntimeException"));
		assertEquals("SECURITY_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.SecurityException"));
		assertEquals("STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.StringIndexOutOfBoundsException"));
		assertEquals("TYPE_NOT_PRESENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.TypeNotPresentException"));
		assertEquals("UNSUPPORTED_OPERATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsupportedOperationException"));
		assertEquals("ABSTRACT_METHOD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.AbstractMethodError"));
		assertEquals("ASSERTION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.AssertionError"));
		assertEquals("BOOTSTRAP_METHOD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.BootstrapMethodError"));
		assertEquals("CLASS_CIRCULARITY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassCircularityError"));
		assertEquals("CLASS_FORMAT_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassFormatError"));
		assertEquals("ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.Error"));
		assertEquals("EXCEPTION_IN_INITIALIZER_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ExceptionInInitializerError"));
		assertEquals("ILLEGAL_ACCESS_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalAccessError"));
		assertEquals("INCOMPATIBLE_CLASS_CHANGE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.IncompatibleClassChangeError"));
		assertEquals("INSTANTIATION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.InstantiationError"));
		assertEquals("INTERNAL_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.InternalError"));
		assertEquals("LINKAGE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.LinkageError"));
		assertEquals("NO_CLASS_DEF_FOUND_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.NoClassDefFoundError"));
		assertEquals("NO_SUCH_FIELD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchFieldError"));
		assertEquals("NO_SUCH_METHOD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchMethodError"));
		assertEquals("OUT_OF_MEMORY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.OutOfMemoryError"));
		assertEquals("STACK_OVERFLOW_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.StackOverflowError"));
		assertEquals("THREAD_DEATH",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadDeath"));
		assertEquals("UNKNOWN_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnknownError"));
		assertEquals("UNSATISFIED_LINK_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsatisfiedLinkError"));
		assertEquals("UNSUPPORTED_CLASS_VERSION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsupportedClassVersionError"));
		assertEquals("VERIFY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.VerifyError"));
		assertEquals("VIRTUAL_MACHINE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.VirtualMachineError"));
		
		assertEquals("DEPRECATED",JSE_Lang.INSTANCE.getConstantName("java.lang.Deprecated"));
		assertEquals("FUNCTIONAL_INTERFACE",JSE_Lang.INSTANCE.getConstantName("java.lang.FunctionalInterface"));
		assertEquals("OVERRIDE",JSE_Lang.INSTANCE.getConstantName("java.lang.Override"));
		assertEquals("SAFE_VARARGS",JSE_Lang.INSTANCE.getConstantName("java.lang.SafeVarargs"));
		assertEquals("SUPPRESS_WARNINGS",JSE_Lang.INSTANCE.getConstantName("java.lang.SuppressWarnings"));
	}
	
	@Test 
	public void testConstantLookup() {
		assertEquals("java.lang",JSE_Lang.INSTANCE.getPackageName());
		assertEquals("APPENDABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Appendable"));
		assertEquals("AUTO_CLOSEABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.AutoCloseable"));
		assertEquals("CHAR_SEQUENCE",JSE_Lang.INSTANCE.getConstantName("java.lang.CharSequence"));
		assertEquals("CLONEABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Cloneable"));
		assertEquals("ITERABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Iterable"));
		assertEquals("READABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Readable"));
		assertEquals("RUNNABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Runnable"));
		assertEquals("THREAD_UNCAUGHT_EXCEPTION_HANDLER",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread$UncaughtExceptionHandler"));
		assertEquals("BOOLEAN",JSE_Lang.INSTANCE.getConstantName("java.lang.Boolean"));
		assertEquals("BYTE",JSE_Lang.INSTANCE.getConstantName("java.lang.Byte"));
		assertEquals("CHARACTER",JSE_Lang.INSTANCE.getConstantName("java.lang.Character"));
		assertEquals("CHARACTER_SUBSET",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$Subset"));
		assertEquals("CHARACTER_UNICODE_BLOCK",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$UnicodeBlock"));
		assertEquals("CLASS",JSE_Lang.INSTANCE.getConstantName("java.lang.Class"));
		assertEquals("CLASS_LOADER",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassLoader"));
		assertEquals("CLASS_VALUE",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassValue"));
		assertEquals("COMPILER",JSE_Lang.INSTANCE.getConstantName("java.lang.Compiler"));
		assertEquals("DOUBLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Double"));
		assertEquals("ENUM",JSE_Lang.INSTANCE.getConstantName("java.lang.Enum"));
		assertEquals("FLOAT",JSE_Lang.INSTANCE.getConstantName("java.lang.Float"));
		assertEquals("INHERITABLE_THREAD_LOCAL",JSE_Lang.INSTANCE.getConstantName("java.lang.InheritableThreadLocal"));
		assertEquals("INTEGER",JSE_Lang.INSTANCE.getConstantName("java.lang.Integer"));
		assertEquals("LONG",JSE_Lang.INSTANCE.getConstantName("java.lang.Long"));
		assertEquals("MATH",JSE_Lang.INSTANCE.getConstantName("java.lang.Math"));
		assertEquals("NUMBER",JSE_Lang.INSTANCE.getConstantName("java.lang.Number"));
		assertEquals("OBJECT",JSE_Lang.INSTANCE.getConstantName("java.lang.Object"));
		assertEquals("PACKAGE",JSE_Lang.INSTANCE.getConstantName("java.lang.Package"));
		assertEquals("PROCESS",JSE_Lang.INSTANCE.getConstantName("java.lang.Process"));
		assertEquals("PROCESS_BUILDER",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder"));
		assertEquals("PROCESS_BUILDER_REDIRECT",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder$Redirect"));
		assertEquals("RUNTIME",JSE_Lang.INSTANCE.getConstantName("java.lang.Runtime"));
		assertEquals("RUNTIME_PERMISSION",JSE_Lang.INSTANCE.getConstantName("java.lang.RuntimePermission"));
		assertEquals("SECURITY_MANAGER",JSE_Lang.INSTANCE.getConstantName("java.lang.SecurityManager"));
		assertEquals("SHORT",JSE_Lang.INSTANCE.getConstantName("java.lang.Short"));
		assertEquals("STACK_TRACE_ELEMENT",JSE_Lang.INSTANCE.getConstantName("java.lang.StackTraceElement"));
		assertEquals("STRICT_MATH",JSE_Lang.INSTANCE.getConstantName("java.lang.StrictMath"));
		assertEquals("STRING",JSE_Lang.INSTANCE.getConstantName("java.lang.String"));
		assertEquals("STRING_BUILDER",JSE_Lang.INSTANCE.getConstantName("java.lang.StringBuilder"));
		assertEquals("STRING_BUFFER",JSE_Lang.INSTANCE.getConstantName("java.lang.StringBuffer"));
		assertEquals("SYSTEM",JSE_Lang.INSTANCE.getConstantName("java.lang.System"));
		assertEquals("THREAD",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread"));
		assertEquals("THREAD_GROUP",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadGroup"));
		assertEquals("THREAD_LOCAL",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadLocal"));
		assertEquals("THROWABLE",JSE_Lang.INSTANCE.getConstantName("java.lang.Throwable"));
		assertEquals("VOID",JSE_Lang.INSTANCE.getConstantName("java.lang.Void"));
		assertEquals("CHARACTER_UNICODE_SCRIPT",JSE_Lang.INSTANCE.getConstantName("java.lang.Character$UnicodeScript"));
		assertEquals("PROCESS_BUILDER_REDIRECT_TYPE",JSE_Lang.INSTANCE.getConstantName("java.lang.ProcessBuilder$Redirect$Type"));
		assertEquals("THREAD_STATE",JSE_Lang.INSTANCE.getConstantName("java.lang.Thread$State"));
		assertEquals("ARITHMETIC_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArithmeticException"));
		assertEquals("ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArrayIndexOutOfBoundsException"));
		assertEquals("ARRAY_STORE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ArrayStoreException"));
		assertEquals("CLASS_CAST_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassCastException"));
		assertEquals("CLONE_NOT_SUPPORTED_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.CloneNotSupportedException"));
		assertEquals("ENUM_CONSTANT_NOT_PRESENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.EnumConstantNotPresentException"));
		assertEquals("EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.Exception"));
		assertEquals("ILLEGAL_ACCESS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalAccessException"));
		assertEquals("ILLEGAL_ARGUMENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalArgumentException"));
		assertEquals("ILLEGAL_MONITOR_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalMonitorStateException"));
		assertEquals("ILLEGAL_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalStateException"));
		assertEquals("ILLEGAL_THREAD_STATE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalThreadStateException"));
		assertEquals("INSTANTIATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.InstantiationException"));
		assertEquals("INTERRUPTED_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.InterruptedException"));
		assertEquals("NEGATIVE_ARRAY_SIZE_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NegativeArraySizeException"));
		assertEquals("NO_SUCH_FIELD_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchFieldException"));
		assertEquals("NO_SUCH_METHOD_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchMethodException"));
		assertEquals("NULL_POINTER_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NullPointerException"));
		assertEquals("NUMBER_FORMAT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.NumberFormatException"));
		assertEquals("REFLECTIVE_OPERATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.ReflectiveOperationException"));
		assertEquals("RUNTIME_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.RuntimeException"));
		assertEquals("SECURITY_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.SecurityException"));
		assertEquals("STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.StringIndexOutOfBoundsException"));
		assertEquals("TYPE_NOT_PRESENT_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.TypeNotPresentException"));
		assertEquals("UNSUPPORTED_OPERATION_EXCEPTION",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsupportedOperationException"));
		assertEquals("ABSTRACT_METHOD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.AbstractMethodError"));
		assertEquals("ASSERTION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.AssertionError"));
		assertEquals("BOOTSTRAP_METHOD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.BootstrapMethodError"));
		assertEquals("CLASS_CIRCULARITY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassCircularityError"));
		assertEquals("CLASS_FORMAT_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ClassFormatError"));
		assertEquals("ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.Error"));
		assertEquals("EXCEPTION_IN_INITIALIZER_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.ExceptionInInitializerError"));
		assertEquals("ILLEGAL_ACCESS_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.IllegalAccessError"));
		assertEquals("INCOMPATIBLE_CLASS_CHANGE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.IncompatibleClassChangeError"));
		assertEquals("INSTANTIATION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.InstantiationError"));
		assertEquals("INTERNAL_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.InternalError"));
		assertEquals("LINKAGE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.LinkageError"));
		assertEquals("NO_CLASS_DEF_FOUND_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.NoClassDefFoundError"));
		assertEquals("NO_SUCH_FIELD_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.NoSuchFieldError"));
		assertEquals("OUT_OF_MEMORY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.OutOfMemoryError"));
		assertEquals("STACK_OVERFLOW_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.StackOverflowError"));
		assertEquals("THREAD_DEATH",JSE_Lang.INSTANCE.getConstantName("java.lang.ThreadDeath"));
		assertEquals("UNKNOWN_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnknownError"));
		assertEquals("UNSATISFIED_LINK_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsatisfiedLinkError"));
		assertEquals("UNSUPPORTED_CLASS_VERSION_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.UnsupportedClassVersionError"));
		assertEquals("VERIFY_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.VerifyError"));
		assertEquals("VIRTUAL_MACHINE_ERROR",JSE_Lang.INSTANCE.getConstantName("java.lang.VirtualMachineError"));
		assertEquals("DEPRECATED",JSE_Lang.INSTANCE.getConstantName("java.lang.Deprecated"));
		assertEquals("OVERRIDE",JSE_Lang.INSTANCE.getConstantName("java.lang.Override"));
		assertEquals("SAFE_VARARGS",JSE_Lang.INSTANCE.getConstantName("java.lang.SafeVarargs"));
		assertEquals("SUPPRESS_WARNINGS",JSE_Lang.INSTANCE.getConstantName("java.lang.SuppressWarnings"));
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 309;
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
		int thisUniqueAsserts = 309;
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

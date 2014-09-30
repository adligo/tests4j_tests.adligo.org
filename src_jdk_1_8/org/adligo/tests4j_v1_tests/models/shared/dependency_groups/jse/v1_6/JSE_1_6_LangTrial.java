package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Lang;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_6_DependencyGroup;

@SourceFileScope (sourceClass=JSE_1_6_Lang.class,minCoverage=98.0)
@AllowedDependencies (groups={Tests4J_JSE_v1_6_DependencyGroup.class})
public class JSE_1_6_LangTrial extends SourceFileCountingTrial {
	public static final int ASSERTS = 97;
	public static final int UASSERTS = 1;
	
	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Lang.INSTANCE);
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_DependencyGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.lang.Appendable"));
		asserts.assertTrue(dg.isInGroup("java.lang.AutoCloseable"));
		asserts.assertTrue(dg.isInGroup("java.lang.CharSequence"));
		asserts.assertTrue(dg.isInGroup("java.lang.Cloneable"));
		asserts.assertTrue(dg.isInGroup("java.lang.Iterable"));
		asserts.assertTrue(dg.isInGroup("java.lang.Readable"));
		asserts.assertTrue(dg.isInGroup("java.lang.Runnable"));
		asserts.assertTrue(dg.isInGroup("java.lang.Thread$UncaughtExceptionHandler"));
		asserts.assertTrue(dg.isInGroup("java.lang.Boolean"));
		asserts.assertTrue(dg.isInGroup("java.lang.Byte"));
		asserts.assertTrue(dg.isInGroup("java.lang.Character"));
		asserts.assertTrue(dg.isInGroup("java.lang.Character$Subset"));
		asserts.assertTrue(dg.isInGroup("java.lang.Character$UnicodeBlock"));
		asserts.assertTrue(dg.isInGroup("java.lang.Class"));
		asserts.assertTrue(dg.isInGroup("java.lang.ClassLoader"));
		asserts.assertTrue(dg.isInGroup("java.lang.ClassValue"));
		asserts.assertTrue(dg.isInGroup("java.lang.Compiler"));
		asserts.assertTrue(dg.isInGroup("java.lang.Double"));
		asserts.assertTrue(dg.isInGroup("java.lang.Enum"));
		asserts.assertTrue(dg.isInGroup("java.lang.Float"));
		asserts.assertTrue(dg.isInGroup("java.lang.InheritableThreadLocal"));
		asserts.assertTrue(dg.isInGroup("java.lang.Integer"));
		asserts.assertTrue(dg.isInGroup("java.lang.Long"));
		asserts.assertTrue(dg.isInGroup("java.lang.Math"));
		asserts.assertTrue(dg.isInGroup("java.lang.Number"));
		asserts.assertTrue(dg.isInGroup("java.lang.Object"));
		asserts.assertTrue(dg.isInGroup("java.lang.Package"));
		asserts.assertTrue(dg.isInGroup("java.lang.Process"));
		asserts.assertTrue(dg.isInGroup("java.lang.ProcessBuilder"));
		asserts.assertTrue(dg.isInGroup("java.lang.ProcessBuilder$Redirect"));
		asserts.assertTrue(dg.isInGroup("java.lang.Runtime"));
		asserts.assertTrue(dg.isInGroup("java.lang.RuntimePermission"));
		asserts.assertTrue(dg.isInGroup("java.lang.SecurityManager"));
		asserts.assertTrue(dg.isInGroup("java.lang.Short"));
		asserts.assertTrue(dg.isInGroup("java.lang.StackTraceElement"));
		asserts.assertTrue(dg.isInGroup("java.lang.StrictMath"));
		asserts.assertTrue(dg.isInGroup("java.lang.String"));
		asserts.assertTrue(dg.isInGroup("java.lang.StringBuilder"));
		asserts.assertTrue(dg.isInGroup("java.lang.StringBuffer"));
		asserts.assertTrue(dg.isInGroup("java.lang.System"));
		asserts.assertTrue(dg.isInGroup("java.lang.Thread"));
		asserts.assertTrue(dg.isInGroup("java.lang.ThreadGroup"));
		asserts.assertTrue(dg.isInGroup("java.lang.ThreadLocal"));
		asserts.assertTrue(dg.isInGroup("java.lang.Throwable"));
		asserts.assertTrue(dg.isInGroup("java.lang.Void"));
		asserts.assertTrue(dg.isInGroup("java.lang.Thread$State"));
		asserts.assertTrue(dg.isInGroup("java.lang.ArithmeticException"));
		asserts.assertTrue(dg.isInGroup("java.lang.ArrayIndexOutOfBoundsException"));
		asserts.assertTrue(dg.isInGroup("java.lang.ArrayStoreException"));
		asserts.assertTrue(dg.isInGroup("java.lang.ClassCastException"));
		asserts.assertTrue(dg.isInGroup("java.lang.CloneNotSupportedException"));
		asserts.assertTrue(dg.isInGroup("java.lang.EnumConstantNotPresentException"));
		asserts.assertTrue(dg.isInGroup("java.lang.Exception"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalAccessException"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalArgumentException"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalMonitorStateException"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalStateException"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalThreadStateException"));
		asserts.assertTrue(dg.isInGroup("java.lang.InstantiationException"));
		asserts.assertTrue(dg.isInGroup("java.lang.InterruptedException"));
		asserts.assertTrue(dg.isInGroup("java.lang.NegativeArraySizeException"));
		asserts.assertTrue(dg.isInGroup("java.lang.NoSuchFieldException"));
		asserts.assertTrue(dg.isInGroup("java.lang.NoSuchMethodException"));
		asserts.assertTrue(dg.isInGroup("java.lang.NullPointerException"));
		asserts.assertTrue(dg.isInGroup("java.lang.NumberFormatException"));
		asserts.assertTrue(dg.isInGroup("java.lang.ReflectiveOperationException"));
		asserts.assertTrue(dg.isInGroup("java.lang.RuntimeException"));
		asserts.assertTrue(dg.isInGroup("java.lang.SecurityException"));
		asserts.assertTrue(dg.isInGroup("java.lang.StringIndexOutOfBoundsException"));
		asserts.assertTrue(dg.isInGroup("java.lang.TypeNotPresentException"));
		asserts.assertTrue(dg.isInGroup("java.lang.UnsupportedOperationException"));
		asserts.assertTrue(dg.isInGroup("java.lang.AbstractMethodError"));
		asserts.assertTrue(dg.isInGroup("java.lang.AssertionError"));
		asserts.assertTrue(dg.isInGroup("java.lang.BootstrapMethodError"));
		asserts.assertTrue(dg.isInGroup("java.lang.ClassCircularityError"));
		asserts.assertTrue(dg.isInGroup("java.lang.ClassFormatError"));
		asserts.assertTrue(dg.isInGroup("java.lang.Error"));
		asserts.assertTrue(dg.isInGroup("java.lang.ExceptionInInitializerError"));
		asserts.assertTrue(dg.isInGroup("java.lang.IllegalAccessError"));
		asserts.assertTrue(dg.isInGroup("java.lang.IncompatibleClassChangeError"));
		asserts.assertTrue(dg.isInGroup("java.lang.InstantiationError"));
		asserts.assertTrue(dg.isInGroup("java.lang.InternalError"));
		asserts.assertTrue(dg.isInGroup("java.lang.LinkageError"));
		asserts.assertTrue(dg.isInGroup("java.lang.NoClassDefFoundError"));
		asserts.assertTrue(dg.isInGroup("java.lang.NoSuchFieldError"));
		asserts.assertTrue(dg.isInGroup("java.lang.OutOfMemoryError"));
		asserts.assertTrue(dg.isInGroup("java.lang.StackOverflowError"));
		asserts.assertTrue(dg.isInGroup("java.lang.ThreadDeath"));
		asserts.assertTrue(dg.isInGroup("java.lang.UnknownError"));
		asserts.assertTrue(dg.isInGroup("java.lang.UnsatisfiedLinkError"));
		asserts.assertTrue(dg.isInGroup("java.lang.UnsupportedClassVersionError"));
		asserts.assertTrue(dg.isInGroup("java.lang.VerifyError"));
		asserts.assertTrue(dg.isInGroup("java.lang.VirtualMachineError"));
		asserts.assertTrue(dg.isInGroup("java.lang.Deprecated"));
		asserts.assertTrue(dg.isInGroup("java.lang.Override"));
		asserts.assertTrue(dg.isInGroup("java.lang.SafeVarargs"));
		asserts.assertTrue(dg.isInGroup("java.lang.SuppressWarnings"));		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 97;
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

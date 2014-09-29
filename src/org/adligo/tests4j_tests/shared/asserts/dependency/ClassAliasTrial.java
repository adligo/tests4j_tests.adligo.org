package org.adligo.tests4j_tests.shared.asserts.dependency;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.ClassAlias;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsDependency_DependencyGroup;

@SourceFileScope (sourceClass=ClassAlias.class, minCoverage=80.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class ClassAliasTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassAlias((Class<?>) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				new IllegalArgumentException(ClassAlias.NO_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassAlias((String) null);
					}
				});
	}

	@Test
	public void testConstructorGettersAndComparator() {
		ClassAlias ca = new ClassAlias(Object.class);
		assertEquals(Object.class.getName(), ca.getName());
		
		ClassAlias b = new ClassAlias(Class.class);
		assertEquals(12, ca.compareTo(b));
		assertEquals(-12, b.compareTo(ca));
		
		assertEquals(12, ca.compareTo(Class.class));
		assertEquals(12, ca.compareTo(Class.class.getName()));
		assertEquals(-12, b.compareTo(Object.class));
		assertEquals(-12, b.compareTo(Object.class.getName()));
		
		assertEquals(0, ca.compareTo(ca));
		assertEquals(0, ca.compareTo(Object.class));
		assertEquals(0, ca.compareTo(Object.class.getName()));
		assertEquals(0, b.compareTo(b));
		assertEquals(0, b.compareTo(Class.class));
		assertEquals(0, b.compareTo(Class.class.getName()));
	}
	
	
	@Test
	public void testEqualsHashCode_AndToString() {
		ClassAlias a = new ClassAlias(Object.class);
		ClassAlias b = new ClassAlias(Class.class);
		ClassAlias c = new ClassAlias(Object.class);
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		assertEquals(Object.class.getName(), a.toString());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		assertEquals(Class.class.getName(), b.toString());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		assertEquals(Object.class.getName(), c.toString());
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 24;
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
		int thisUniqueAsserts = 9;
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


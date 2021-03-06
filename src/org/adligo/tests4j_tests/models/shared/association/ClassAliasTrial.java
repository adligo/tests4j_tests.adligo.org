package org.adligo.tests4j_tests.models.shared.association;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.ClassAlias;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Association_GwtReferenceGroup;

@SourceFileScope (sourceClass=ClassAlias.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_Association_GwtReferenceGroup.class)
public class ClassAliasTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassAlias((Class<?>) null);
					}
				});
		assertThrown(new ExpectedThrowable(
				IllegalArgumentException.class),
				new I_Thrower() {
					
          @Override
					public void run() throws Throwable {
						new ClassAlias((String) null);
					}
				});
		assertThrown(new ExpectedThrowable(
        new IllegalArgumentException("[B")),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            new ClassAlias("[B");
          }
        });
	}

	@SuppressWarnings("boxing")
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
	
	
	@SuppressWarnings("boxing")
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
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 25;
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
		int thisUniqueAsserts = 10;
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


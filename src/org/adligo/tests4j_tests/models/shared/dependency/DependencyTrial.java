package org.adligo.tests4j_tests.models.shared.dependency;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAlias;
import org.adligo.tests4j.models.shared.dependency.Dependency;
import org.adligo.tests4j.models.shared.dependency.DependencyMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Dependency.class)
public class DependencyTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(DependencyMutant.CLASS_ALIAS_MAY_NOT_BE_SET_TO_A_NULL_VALUE)),
				new I_Thrower() {
					
					@Override
					public void run() {
						DependencyMutant dm = new DependencyMutant();
						new Dependency(dm);
					}
				});
	}
	
	@Test
	public void testCopyConstructor() {
		DependencyMutant dm = new DependencyMutant();
		ClassAlias ca = new ClassAlias("foo");
		dm.setAlias(ca);
		dm.addReference();
		dm.addReference();
		assertEquals(ca, dm.getAlias());
		assertEquals(2, dm.getReferences());
		
		Dependency dep = new Dependency(dm);
		assertEquals(ca, dep.getAlias());
		assertEquals(2, dep.getReferences());
	}
	
	@Test
	public void testComparatorImpl() {
		DependencyMutant dm = new DependencyMutant();
		dm.addReference();
		assertEquals(1, dm.getReferences());
		dm.setAlias(new ClassAlias("someName"));
		
		DependencyMutant dmB = new DependencyMutant();
		dmB.setAlias(new ClassAlias("otherClassName"));
		
		Dependency a = new Dependency(dm);
		Dependency b = new Dependency(dmB);
		
		
		assertEquals(1, b.compareTo(a));
		assertEquals(-1, a.compareTo(b));
	}
	
	@Test
	public void testToString() {
		DependencyMutant dm = new DependencyMutant();
		dm.setAlias(new ClassAlias("foo"));
		dm.addReference();
		dm.addReference();
		assertEquals("Dependency [alias=foo, references=2]", new Dependency(dm).toString());
		
		
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 9;
	}

	@Override
	public int getUniqueAsserts() {
		return 6;
	}

}

package org.adligo.tests4j_tests.run.discovery;

import java.util.Collections;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=ClassFilter.class, minCoverage=40.0)
public class ClassFilterTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassFilter(null);
					}
				});
	}
	
	@Test
	public void testCopyConstructor() throws Exception {
		ClassFilterMutant cfm = new ClassFilterMutant();
		
		cfm.setIgnoredPackageNames(Collections.singleton("java."));
		ClassFilter cf = new ClassFilter(cfm);
		Set<String> pkgNames = cf.getIgnoredPackageNames();
		assertNotNull(pkgNames);
		assertContains(pkgNames, "java.");
		assertEquals(1, pkgNames.size());
		
		Set<String> clazzNames = cf.getIgnoredClassNames();
		assertNotNull(clazzNames);
		assertEquals(0, clazzNames.size());
		
		cfm.setIgnoredPackageNames(Collections.singleton("hey7"));
		cfm.setIgnoredClassNames(Collections.singleton("bar"));
		
		cf = new ClassFilter(cfm);
		pkgNames = cf.getIgnoredPackageNames();
		assertNotNull(pkgNames);
		assertContains(pkgNames, "hey7");
		assertEquals(1, pkgNames.size());
		
		
		clazzNames = cf.getIgnoredClassNames();
		assertNotNull(clazzNames);
		assertContains(clazzNames, "bar");
		assertEquals(1, clazzNames.size());
	}
	
	@Test
	public void testIsFilteredMethod() throws Exception {
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredPackageNames(Collections.singleton("java."));
		ClassFilter cf = new ClassFilter(cfm);
		
		assertTrue(cf.isFiltered((Class<?>) null));
		assertTrue(cf.isFiltered(String.class));
		assertFalse(cf.isFiltered(MockWithNothing.class));
		assertFalse(cf.isFiltered(this.getClass()));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
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
		int thisUniqueAsserts = 12;
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

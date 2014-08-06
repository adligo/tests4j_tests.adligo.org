package org.adligo.tests4j_tests.run.discovery;

import java.util.Collections;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
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
		ClassFilter cfm = new ClassFilter();
		
		assertTrue(cfm.isFiltered((Class<?>) null));
		assertTrue(cfm.isFiltered(String.class));
		assertFalse(cfm.isFiltered(MockWithNothing.class));
		assertFalse(cfm.isFiltered(this.getClass()));
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 16;
	}

	@Override
	public int getUniqueAsserts() {
		return 12;
	}

}

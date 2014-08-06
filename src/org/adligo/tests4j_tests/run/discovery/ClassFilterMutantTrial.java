package org.adligo.tests4j_tests.run.discovery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=ClassFilterMutant.class, minCoverage=40.0)
public class ClassFilterMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassFilterMutant(null);
					}
				});
	}
	
	@Test
	public void testGetsAndSets() throws Exception {
		ClassFilterMutant cfm = new ClassFilterMutant();
		Set<String> pkgNames = cfm.getIgnoredPackageNames();
		assertNotNull(pkgNames);
		assertContains(pkgNames, "java.");
		assertEquals(1, pkgNames.size());
		
		Set<String> clazzNames = cfm.getIgnoredClassNames();
		assertNotNull(clazzNames);
		assertEquals(0, clazzNames.size());
		
		cfm.setIgnoredPackageNames(Collections.singleton("hey7"));
		pkgNames = cfm.getIgnoredPackageNames();
		assertNotNull(pkgNames);
		assertContains(pkgNames, "hey7");
		assertEquals(1, pkgNames.size());
		
		cfm.setIgnoredClassNames(Collections.singleton("bar"));
		clazzNames = cfm.getIgnoredClassNames();
		assertNotNull(clazzNames);
		assertContains(clazzNames, "bar");
		assertEquals(1, clazzNames.size());
	}
	
	@Test
	public void testIsFilteredMethod() throws Exception {
		ClassFilterMutant cfm = new ClassFilterMutant();
		cfm.setIgnoredClassNames(Collections.singleton(MockWithNothing.class.getName()));
		
		assertTrue(cfm.isFiltered((Class<?>) null));
		assertTrue(cfm.isFiltered(String.class));
		assertTrue(cfm.isFiltered(MockWithNothing.class));
		assertFalse(cfm.isFiltered(this.getClass()));
		
		cfm.setIgnoredPackageNames(new HashSet<String>());
		assertFalse(cfm.isFiltered(String.class));
		//I am not sure how to send the primitive Class instance here
		//assertTrue(cfm.isFiltered(Integer.get));
		assertTrue(cfm.isFiltered(Void.TYPE));
		assertTrue(cfm.isFiltered(Void.class));
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 19;
	}

	@Override
	public int getUniqueAsserts() {
		return 12;
	}

}

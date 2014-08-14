package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassDependenciesMutant;
import org.adligo.tests4j.models.shared.dependency.ClassReferencesMutant;
import org.adligo.tests4j.models.shared.dependency.DependencyMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassReferencesMutant.class, minCoverage=90.0)
public class ClassReferencesMutantTrial extends SourceFileCountingTrial {
	
	
	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassReferencesMutant((I_ClassReferences) null);
					}
				});
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassReferencesMutant((I_ClassDependencies) null);
					}
				});
	}
	
	@Test
	public void testCopyConstructor_References() throws Exception {
		ClassReferencesMutant crm = new ClassReferencesMutant();
		crm.setClassName("className");
		crm.addReference("hey");
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		crm.setCircularReferences(circles);
		
		ClassReferencesMutant copy = new ClassReferencesMutant(crm);
		assertEquals("className", copy.getClassName());
		
		Set<String> refs =  copy.getReferences();
		assertNotNull(refs);
		assertContains(refs, "hey");
		assertEquals(1, refs.size());
		
		assertTrue(copy.hasCircularReferences());
		Set<String> copyCircles = crm.getCircularReferences();
		assertContains(copyCircles, "someOtherName");
		assertEquals(1, copyCircles.size());
		
	}
	
	@Test
	public void testCopyConstructor_Dependencies() throws Exception {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClassName("tn");
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClassName("cdn");
		cdm.addDependency(dm);
		
		ClassReferencesMutant copy = new ClassReferencesMutant(cdm);
		assertEquals("tn", copy.getClassName());
		
		Set<String> refs =  copy.getReferences();
		assertNotNull(refs);
		assertContains(refs, "cdn");
		assertEquals(1, refs.size());
	}
	
	@Test
	public void testSetsAndGets() throws Exception {
		ClassReferencesMutant crm = new ClassReferencesMutant();
		Set<String> origNames = crm.getReferences();
		assertNotNull(origNames);
		assertNull(crm.getClassName());
		
		crm.setClassName("className");
		assertEquals("className", crm.getClassName());
		
		crm.addReference(null);
		Set<String> names = crm.getReferences();
		assertNotNull(names);
		assertEquals(0, names.size());
		
		crm.addReference("hey");
		Set<String> refs =  crm.getReferences();
		assertNotNull(refs);
		assertContains(refs, "hey");
		assertEquals(1, refs.size());
		
		crm.setReferences(null);
		refs =  crm.getReferences();
		assertNotNull(refs);
		assertContains(refs, "hey");
		assertEquals(1, refs.size());
		
		crm.setReferences(Collections.singleton("singlton"));
		refs =  crm.getReferences();
		assertNotNull(refs);
		assertContains(refs, "singlton");
		assertEquals(1, refs.size());
		
		assertEquals(HashSet.class,  refs.getClass());
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 28;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}

}

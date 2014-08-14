package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassCircularReferences;
import org.adligo.tests4j.models.shared.dependency.ClassCircularReferencesMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassCircularReferencesMutant.class, minCoverage=71.0)
public class ClassCircularReferencesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassCircularReferences(null);
					}
				});
		assertThrown(new ExpectedThrownData(
				new IllegalArgumentException(ClassCircularReferences.UNKNOWN_CLASS_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassCircularReferencesMutant mut = new ClassCircularReferencesMutant();
						new ClassCircularReferences(mut);
					}
				});
		
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassCircularReferencesMutant ccrm = new ClassCircularReferencesMutant();
		ccrm.setClassName("someName");
		assertEquals("someName", new ClassCircularReferences(ccrm).getClassName());
		
		assertFalse(ccrm.hasCircularReferences());
		
		ccrm.setCircularReferences(new HashSet<String>());
		assertFalse(new ClassCircularReferences(ccrm).hasCircularReferences());
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		ccrm.setCircularReferences(circles);
		ClassCircularReferences ccr = new ClassCircularReferences(ccrm);
		assertTrue(ccr.hasCircularReferences());
		Set<String> instCircles = ccr.getCircularReferences();
		
		assertContains(instCircles, "someOtherName");
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassCircularReferencesMutant ccrm = new ClassCircularReferencesMutant();
		ccrm.setClassName("someName");
		assertEquals("ClassCircularReferences [className=someName]", 
				new ClassCircularReferences(ccrm).toString());
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		ccrm.setCircularReferences(circles);
		assertEquals("ClassCircularReferences [className=someName, circularRefs=[someOtherName]]", 
				new ClassCircularReferences(ccrm).toString());
	}
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 10;
	}

	@Override
	public int getUniqueAsserts() {
		return 9;
	}
}

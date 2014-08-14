package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassCircularReferencesMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassCircularReferencesMutant.class, minCoverage=77.0)
public class ClassCircularReferencesMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						new ClassCircularReferencesMutant(null);
					}
				});
	}
	
	@Test
	public void testGetsSetsAndConstructor() {
		ClassCircularReferencesMutant ccrm = new ClassCircularReferencesMutant();
		ccrm.setClassName("someName");
		assertEquals("someName", ccrm.getClassName());
		
		assertFalse(ccrm.hasCircularReferences());
		
		ccrm.setCircularReferences(new HashSet<String>());
		assertFalse(ccrm.hasCircularReferences());
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		ccrm.setCircularReferences(circles);
		assertTrue(ccrm.hasCircularReferences());
		Set<String> instCircles = ccrm.getCircularReferences();
		
		assertContains(instCircles, "someOtherName");
		assertEquals(1, instCircles.size());
	}
	
	
	@Test
	public void testToString() {
		ClassCircularReferencesMutant ccrm = new ClassCircularReferencesMutant();
		ccrm.setClassName("someName");
		assertEquals("ClassCircularReferencesMutant [className=someName]", ccrm.toString());
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		ccrm.setCircularReferences(circles);
		assertEquals("ClassCircularReferencesMutant [className=someName, circularRefs=[someOtherName]]", ccrm.toString());
	}
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 9;
	}

	@Override
	public int getUniqueAsserts() {
		return 8;
	}
}

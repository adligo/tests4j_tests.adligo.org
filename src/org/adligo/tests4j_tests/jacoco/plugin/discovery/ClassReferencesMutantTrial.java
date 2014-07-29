package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Set;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesMutant;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;

@SourceFileScope (sourceClass=ClassReferencesMutant.class, minCoverage=90.0)
public class ClassReferencesMutantTrial extends SourceFileCountingTrial {
	ClassReferencesMutant crm = new ClassReferencesMutant();

	
	
	@Test
	public void testReferenceCounting_BasicExecution() throws Exception {
		crm.onLocalVariableClassName(null);
		Set<String> names = crm.getClassNames();
		assertEquals(0, names.size());
		
		//void
		crm.onLocalVariableClassName("()V");
		assertEquals(0, names.size());
		
		crm.onLocalVariableClassName(
				"Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ClassReferencesMutantTrial;");
		assertEquals(1, names.size());
		assertContains(names, ClassReferencesMutantTrial.class.getName());
		
		crm.onLocalVariableClassName("Lorg/adligo/tests4j_4jacoco/plugin/discovery/ClassReferencesMutant;");
		assertEquals(2, names.size());
		assertContains(names, ClassReferencesMutant.class.getName());
		assertContains(names, ClassReferencesMutantTrial.class.getName());
		
		//.java package is blocked by default
		crm.onLocalVariableClassName("Ljava/lang/String;");
		assertEquals(2, names.size());
		assertContains(names, ClassReferencesMutant.class.getName());
		assertContains(names, ClassReferencesMutantTrial.class.getName());
		
		crm.setIgnoredPackageNames(null);
		assertNull(crm.getIgnoredPackageNames());
		crm.onLocalVariableClassName("Ljava/lang/String;");
		
		assertContains(names, ClassReferencesMutant.class.getName());
		assertContains(names, ClassReferencesMutantTrial.class.getName());
		assertContains(names, String.class.getName());
		assertEquals(3, names.size());
		
		//lead with a [ for a array
		crm.onLocalVariableClassName("[Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithArray;");
		assertContains(names, ClassReferencesMutant.class.getName());
		assertContains(names, ClassReferencesMutantTrial.class.getName());
		assertContains(names, String.class.getName());
		assertContains(names, MockWithArray.class.getName());
		assertEquals(4, names.size());
	}
	

	
	
	
	@Override
	public int getTests() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAsserts() {
		return 20;
	}

	@Override
	public int getUniqueAsserts() {
		return 16;
	}

}

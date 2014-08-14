package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.ClassDependenciesMutant;
import org.adligo.tests4j.models.shared.dependency.DependencyMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependencies;
import org.adligo.tests4j.models.shared.dependency.I_Dependency;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;


@SourceFileScope (sourceClass=ClassDependenciesMutant.class, minCoverage=65.0)
public class ClassDependenciesMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testMethodsAndCopyConstructor() {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClassName("calzzzName2z");
		
		Set<String> circles = new HashSet<String>();
		circles.add("someOtherName");
		cdm.setCircularReferences(circles);
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClassName("otherClazzName1");
		dm.addReference();
		cdm.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("3rdName3");
		dm.addReference();
		dm.addReference();
		cdm.putDependency(dm);
		
		ClassDependencies cdm2 = new ClassDependencies(cdm);
		assertEquals("calzzzName2z",cdm2.getClassName());
		assertDependencies(cdm);
		
		assertTrue(cdm2.hasCircularReferences());
		Set<String> copyCircles = cdm2.getCircularReferences();
		assertContains(copyCircles, "someOtherName");
		assertEquals(1, copyCircles.size());
	}

	protected void assertDependencies(I_ClassDependencies cdm) {
		List<I_Dependency> deps =  cdm.getDependencies();
		assertNotNull(deps);
		I_Dependency dep =  deps.get(0);
		assertEquals("3rdName3", dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep =  deps.get(1);
		assertEquals("otherClazzName1", dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
	}
	
	@Test
	public void testAddSimple() {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClassName("calzzzName2z");
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClassName("otherClazzName1");
		dm.addReference();
		cdm.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("3rdName3");
		dm.addReference();
		dm.addReference();
		cdm.putDependency(dm);
		
		ClassDependenciesMutant cdm2 = new ClassDependenciesMutant();
		cdm2.add(cdm);
		assertDependencies(cdm);
	}
	
	@Test
	public void testAddInnerClassOntoSourceFileClass() {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClassName("calzzzName2z$1");
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClassName("calzzzName2z");
		cdm.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z$1");
		cdm.putDependency(dm);
		
		ClassDependenciesMutant cdm2 = new ClassDependenciesMutant();
		cdm2.setClassName("calzzzName2z");
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z");
		cdm2.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z$1");
		cdm2.putDependency(dm);
		
		cdm2.add(cdm);
		List<I_Dependency> deps = cdm2.getDependencies();
		Map<String, I_Dependency> md = new HashMap<String, I_Dependency>();
		for (int i = 0; i < deps.size(); i++) {
			I_Dependency dep = deps.get(i);
			md.put(dep.getClassName(), dep);
		}
		I_Dependency dep =  md.get("calzzzName2z");
		assertNotNull(dep);
		assertEquals("calzzzName2z",dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		dep =  md.get("calzzzName2z$1");
		assertNotNull(dep);
		assertEquals("calzzzName2z$1",dep.getClassName());
		assertEquals(0, dep.getReferences());
	}
	
	@Test
	public void testAddSourceFileClassOntoInnerClass() {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClassName("calzzzName2z");
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClassName("calzzzName2z");
		cdm.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z$1");
		cdm.putDependency(dm);
		
		ClassDependenciesMutant cdm2 = new ClassDependenciesMutant();
		cdm2.setClassName("calzzzName2z$1");
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z");
		cdm2.putDependency(dm);
		
		dm = new DependencyMutant();
		dm.setClassName("calzzzName2z$1");
		cdm2.putDependency(dm);
		
		cdm2.add(cdm);
		List<I_Dependency> deps = cdm2.getDependencies();
		Map<String, I_Dependency> md = new HashMap<String, I_Dependency>();
		for (int i = 0; i < deps.size(); i++) {
			I_Dependency dep = deps.get(i);
			md.put(dep.getClassName(), dep);
		}
		I_Dependency dep =  md.get("calzzzName2z");
		assertNotNull(dep);
		assertEquals("calzzzName2z",dep.getClassName());
		assertEquals(0, dep.getReferences());
		
		dep =  md.get("calzzzName2z$1");
		assertNotNull(dep);
		assertEquals("calzzzName2z$1",dep.getClassName());
		assertEquals(0, dep.getReferences());
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
		return 23;
	}
}

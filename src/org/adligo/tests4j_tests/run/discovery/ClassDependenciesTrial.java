package org.adligo.tests4j_tests.run.discovery;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassDependencies;
import org.adligo.tests4j.run.discovery.ClassDependenciesMutant;
import org.adligo.tests4j.run.discovery.DependencyMutant;
import org.adligo.tests4j.run.discovery.I_Dependency;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;


@SourceFileScope (sourceClass=ClassDependencies.class, minCoverage=50.0)
public class ClassDependenciesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						// TODO Auto-generated method stub
						new ClassDependencies(null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(ClassDependencies.NO_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassDependencies(new ClassDependenciesMutant());
					}
				});
	}
	@Test
	public void testMethodsAndCopyConstructor() {
		ClassDependenciesMutant cdm = new ClassDependenciesMutant();
		cdm.setClazzName("calzzzNamez");
		assertEquals("calzzzNamez", cdm.getClassName());
		
		DependencyMutant dm = new DependencyMutant();
		dm.setClazzName("otherClazzName");
		dm.addReference();
		cdm.putDependency(dm);
		DependencyMutant dmFrom = cdm.getDependency("otherClazzName");
		assertSame(dm, dmFrom);
		
		dm = new DependencyMutant();
		dm.setClazzName("3rdName");
		dm.addReference();
		dm.addReference();
		cdm.putDependency(dm);
		dmFrom = cdm.getDependency("3rdName");
		assertSame(dm, dmFrom);
	
		assertDependencies(new ClassDependencies(cdm));
		
		ClassDependencies cdm2 = new ClassDependencies(cdm);
		assertEquals("calzzzNamez",cdm2.getClassName());
		assertDependencies(cdm2);
	}

	protected void assertDependencies(ClassDependencies cdm) {
		List<I_Dependency> deps =  cdm.getDependencies();
		assertNotNull(deps);
		I_Dependency dep =  deps.get(0);
		assertEquals("3rdName", dep.getClassName());
		assertEquals(2, dep.getReferences());
		
		dep =  deps.get(1);
		assertEquals("otherClazzName", dep.getClassName());
		assertEquals(1, dep.getReferences());
		
		assertEquals(2, deps.size());
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 18;
	}

	@Override
	public int getUniqueAsserts() {
		return 11;
	}
}

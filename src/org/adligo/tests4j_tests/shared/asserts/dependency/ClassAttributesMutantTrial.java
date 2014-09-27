package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Dependency_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.ClassAttributesMutant;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassAttributesMutant.class, minCoverage=62.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class ClassAttributesMutantTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassAttributesMutant ms = null;
						new ClassAttributesMutant(ms);
					}
				});
	}
	
	@Test
	public void testCopyConstructorAndGetters() {
		ClassAttributesMutant cmm = new ClassAttributesMutant();
		cmm.setName("className");
		assertEquals("className", cmm.getName());
		
		MethodSignature ms = new MethodSignature("foo", null, null);
		cmm.addMethod(ms);
		Set<I_MethodSignature> sigs = cmm.getMethods();
		assertContains(sigs, ms);
		assertEquals(1, sigs.size());
		
		
		MethodSignature bar = new MethodSignature("bar", null, null);
		MethodSignature nill = null;
		List<I_MethodSignature> items = new ArrayList<I_MethodSignature>();
		items.add(bar);
		items.add(nill);
		
		cmm.setMethods(items);
		sigs = cmm.getMethods();
		assertContains(sigs, bar);
		assertEquals(1, sigs.size());
	}
	
	
	@Test
	public void testToString() {
		ClassAttributesMutant cmm = new ClassAttributesMutant();
		cmm.setName("className");
		assertEquals("ClassAttributesMutant [name=className]", cmm.toString());
	
		cmm.addMethod(new MethodSignature("foo", null, null));
		cmm.addMethod(new MethodSignature("bar", null, null));
		assertEquals("ClassAttributesMutant [name=className, methods=[void bar(), void foo()]]", cmm.toString());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 8;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 7;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

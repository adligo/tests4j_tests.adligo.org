package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassAttributesMutant.class, minCoverage=62.0)
public class ClassAttributesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassAttributesMutant ms = null;
						new ClassAttributes(ms);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(ClassAttributes.REQUIRES_A_CLASS_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassAttributesMutant ms = new ClassAttributesMutant();
						ms.setName(null);
						new ClassAttributes(ms);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(ClassAttributes.REQUIRES_A_CLASS_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassAttributesMutant ms = new ClassAttributesMutant();
						ms.setName("");
						new ClassAttributes(ms);
					}
				});
	}
	
	@Test
	public void testCopyConstructorAndGetters() {
		ClassAttributesMutant cmm = new ClassAttributesMutant();
		cmm.setName("className");
		
		MethodSignature ms = new MethodSignature("foo", null, null);
		cmm.addMethod(ms);
		
		ClassAttributes copy = new ClassAttributes(cmm);
		assertEquals("className", copy.getName());
		
		Set<I_MethodSignature> sigs = copy.getMethods();
		assertEquals("java.util.Collections$UnmodifiableSet", sigs.getClass().getName());
		assertContains(sigs, ms);
		assertEquals(1, sigs.size());
		
		cmm.setName("2");
		MethodSignature bar = new MethodSignature("bar", null, null);
		cmm.addMethod(bar);
		cmm.addMethod(null);
		
		copy = new ClassAttributes(cmm);
		assertEquals("2", copy.getName());
		
		sigs = copy.getMethods();
		assertEquals("java.util.Collections$UnmodifiableSet", sigs.getClass().getName());
		assertContains(sigs, bar);
		assertContains(sigs, ms);
		assertEquals(2, sigs.size());
		
	}
	
	
	@Test
	public void testToString() {
		ClassAttributesMutant cmm = new ClassAttributesMutant();
		cmm.setName("className");
		assertEquals("ClassAttributes [name=className]", new ClassAttributes(cmm).toString());
	
		cmm.addMethod(new MethodSignature("foo", null, null));
		cmm.addMethod(new MethodSignature("bar", null, null));
		assertEquals("ClassAttributes [name=className, methods=[void bar(), void foo()]]", 
				new ClassAttributes(cmm).toString());
		
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 14;
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
		int thisUniqueAsserts = 13;
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

package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.ClassMethodsMutant;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassMethodsMutant.class, minCoverage=84.0)
public class ClassMethodsTrial extends SourceFileCountingTrial {

	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassMethodsMutant ms = null;
						new ClassMethods(ms);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(ClassMethods.REQUIRES_A_CLASS_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassMethodsMutant ms = new ClassMethodsMutant();
						ms.setClassName(null);
						new ClassMethods(ms);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(ClassMethods.REQUIRES_A_CLASS_NAME)),
				new I_Thrower() {
					
					@Override
					public void run() {
						ClassMethodsMutant ms = new ClassMethodsMutant();
						ms.setClassName("");
						new ClassMethods(ms);
					}
				});
	}
	
	@Test
	public void testCopyConstructorAndGetters() {
		ClassMethodsMutant cmm = new ClassMethodsMutant();
		cmm.setClassName("className");
		
		MethodSignature ms = new MethodSignature("foo", null);
		cmm.addMethod(ms);
		
		ClassMethods copy = new ClassMethods(cmm);
		assertEquals("className", copy.getClassName());
		
		Set<I_MethodSignature> sigs = copy.getMethods();
		assertEquals("java.util.Collections$UnmodifiableSet", sigs.getClass().getName());
		assertContains(sigs, ms);
		assertEquals(1, sigs.size());
		
		cmm.setClassName("2");
		MethodSignature bar = new MethodSignature("bar", null);
		cmm.addMethod(bar);
		cmm.addMethod(null);
		
		copy = new ClassMethods(cmm);
		assertEquals("2", copy.getClassName());
		
		sigs = copy.getMethods();
		assertEquals("java.util.Collections$UnmodifiableSet", sigs.getClass().getName());
		assertContains(sigs, bar);
		assertContains(sigs, ms);
		assertEquals(2, sigs.size());
		
	}
	
	
	@Test
	public void testToString() {
		ClassMethodsMutant cmm = new ClassMethodsMutant();
		cmm.setClassName("className");
		assertEquals("ClassMethods [className=className]", new ClassMethods(cmm).toString());
	
		cmm.addMethod(new MethodSignature("foo", null));
		cmm.addMethod(new MethodSignature("bar", null));
		assertEquals("ClassMethods [className=className, methods=[foo(), bar()]]", 
				new ClassMethods(cmm).toString());
		
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 14;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}

}

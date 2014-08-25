package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ClassAttributesMutant.class, minCoverage=62.0)
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
		cmm.setClassName("className");
		assertEquals("className", cmm.getClassName());
		
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
		cmm.setClassName("className");
		assertEquals("ClassAttributesMutant [className=className]", cmm.toString());
	
		cmm.addMethod(new MethodSignature("foo", null, null));
		cmm.addMethod(new MethodSignature("bar", null, null));
		assertEquals("ClassAttributesMutant [className=className, methods=[void bar(), void foo()]]", cmm.toString());
		
	}
	
	@Override
	public int getTests() {
		return 3;
	}

	@Override
	public int getAsserts() {
		return 8;
	}

	@Override
	public int getUniqueAsserts() {
		return 7;
	}

}

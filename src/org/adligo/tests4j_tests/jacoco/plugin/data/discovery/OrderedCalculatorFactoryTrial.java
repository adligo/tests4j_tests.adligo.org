package org.adligo.tests4j_tests.jacoco.plugin.data.discovery;

import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.run.helpers.I_ClassFilter;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedCalculatorFactory;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.HashMap;

@SourceFileScope (sourceClass=OrderedCalculatorFactory.class)
public class OrderedCalculatorFactoryTrial extends SourceFileCountingTrial {

	@Test
	public void testMethodsCreate() {
		OrderedCalculatorFactory factory = new OrderedCalculatorFactory();
		assertNotNull(factory.createOrderedDependenciesCalculator());
		assertNotNull(factory.createReferenceOrderCalculator(mock(I_ClassFilter.class),
		    mock(I_Tests4J_Log.class), Tests4J_EnglishConstants.ENGLISH,
		    new HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>(), String.class));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 2;
		//code coverage and circular dependencies 
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 2;
		//code coverage and circular dependencies 
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies 
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

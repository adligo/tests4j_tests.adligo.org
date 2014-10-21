package org.adligo.tests4j_tests.shared.en;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_EN_GwtReferenceGroup;
import org.adligo.tests4j_tests.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_AnnotationMessages.class)
@AllowedReferences (groups=Tests4J_EN_GwtReferenceGroup.class)
public class Tests4J_AnnotationMessagesTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		I18N_Asserter asserter = new I18N_Asserter(this);
		I_Tests4J_AnnotationMessages messages = Tests4J_EnglishConstants.ENGLISH.getAnnotationMessages();
		
		
		asserter.assertConstant("Methods annotated with @AfterTrial must NOT take any parameters.",
				messages.getAfterTrialHasParams());
		asserter.assertConstant("Methods annotated with @AfterTrial must be public.", 
				messages.getAfterTrialNotPublic());
		asserter.assertConstant("Methods annotated with @AfterTrial must be static.", 
				messages.getAfterTrialNotStatic());
		
		
		asserter.assertConstant("Methods annotated with @BeforeTrial must NOT take any parameters.", 
				messages.getBeforeTrialHasParams());
		asserter.assertConstant("Methods annotated with @BeforeTrial must be public.", 
				messages.getBeforeTrialNotPublic());
		asserter.assertConstant("Methods annotated with @BeforeTrial must be static.", 
				messages.getBeforeTrialNotStatic());
		
		asserter.assertConstant("Methods annotated with @Test may not have a negative timeout.",
			messages.getHasNegativeTimeout());
		asserter.assertConstant("Methods annotated with @Test must not take any parameters.",
			messages.getHasParams());
		asserter.assertConstant("Methods annotated with @Test must NOT be abstract.",
			messages.getIsAbstract());
		
		asserter.assertConstant("Methods annotated with @Test must be public.",
			messages.getIsNotPublic());
		asserter.assertConstant("Methods annotated with @Test must NOT be static.",
			messages.getIsStatic());
		asserter.assertConstant("The minCoverage must be between 0.0 and 100.0 percent.",
			messages.getMinCoverageMustBeBetweenZeroAndOneHundred());
		
		asserter.assertConstant("Trials may only have one method annotated with @AfterTrial.",
			messages.getMultipleAfterTrial());
		asserter.assertConstant("Trials may only have one method annotated with @BeforeTrial.",
			messages.getMultipleBeforeTrial());
		asserter.assertConstant("ApiTrials must be annotated with a @PackageScope annotation.",
			messages.getNoPackageScope());
		
		asserter.assertConstant("SourceFileTrials must be annotated with @SourceFileScope.",
			messages.getNoSourceFileScope());
		asserter.assertConstant("UseCaseTrials must be annotated with @UseCaseScope.",
				messages.getNoUseCaseScope());
		asserter.assertConstant("@PackageScope annotations must contain a non empty packageName.",
				messages.getPackageScopeEmptyName());

		asserter.assertConstant("@SourceFileScope annotations must contain a non empty sourceClass.",
				messages.getSourceFileScopeEmptyClass());
		asserter.assertConstant("The trial is missing a @TrialType annotation.",
				messages.getTrialTypeMissing());
		asserter.assertConstant("@UseCaseScope annotations must contain a non empty nown.",
				messages.getUseCaseScopeEmptyNown());
		
		asserter.assertConstant("@UseCaseScope annotations must contain a non empty system.",
				messages.getUseCaseScopeEmptySystem());
		asserter.assertConstant("@UseCaseScope annotations must contain a non empty verb.",
				messages.getUseCaseScopeEmptyVerb());
		asserter.assertConstant(" was not annotated correctly.",
				messages.getWasAnnotatedIncorrectly());
		asserter.assertConstant("The @AllowedDependencies group is not a singleton (add a INSTANCE field for better memory usage)",
				messages.getAllowedDependenciesIsNotASingletonWarning());

		
		asserter.assertConstantsMatchMethods(Tests4J_AnnotationMessages.class);
		
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 76;
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
		int thisUniqueAsserts = 76;
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

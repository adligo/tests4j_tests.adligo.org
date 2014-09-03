package org.adligo.tests4j_tests.models.shared.en;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.en.Tests4J_AnnotationErrors;
import org.adligo.tests4j.models.shared.en.Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_ResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EclipseErrors;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.en.Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_ReportMessages;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.i18n.I18N_Asserter;

@SourceFileScope (sourceClass=Tests4J_EnglishConstants.class, minCoverage=93.0)
public class Tests4J_EnglishConstants_Trial extends SourceFileCountingTrial {

	@Test
	public void testMessages() {
		I_Tests4J_Constants messages = Tests4J_EnglishConstants.ENGLISH;
		I18N_Asserter asserter = new I18N_Asserter(this);
		
		asserter.assertConstant("Classes which implement I_AbstractTrial must have a zero argument constructor.", 
				messages.getBadConstuctor());
		asserter.assertConstant("Null I_TrialRunListener parameter not allowed.", 
				messages.getNullListenerExceptionMessage());
		asserter.assertConstant("Null I_Tests4J_Params parameter not allowed.", 
				messages.getNullParamsExceptionMessage());
		asserter.assertConstant("The Method ", 
				messages.getTheMethodCanOnlyBeCalledBy_PartOne());
		asserter.assertConstant(" may only be called by ", 
				messages.getTheMethodCanOnlyBeCalledBy_PartTwo());
		asserter.assertConstant("MethodBlocker requires at least one allowed caller class name.", 
				messages.getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames());
		
		asserter.assertConstant("MethodBlocker requires a blocking method name.", 
				messages.getMethodBlockerRequiresABlockingMethod());
		
		asserter.assertConstant("MethodBlocker requires a blocking class.", 
				messages.getMethodBlockerRequiresABlockingClass());
		List<String> okFields= new ArrayList<String>();
		okFields.add(I18N_Asserter.JACOCO_DATA);
		okFields.add("ENGLISH");
		asserter.assertConstantsMatchMethods(Tests4J_EnglishConstants.class, okFields);
		
	}

	
	@Test
	public void testGetters() {
		I_Tests4J_Constants messages = Tests4J_EnglishConstants.ENGLISH;
		
		assertEquals(Tests4J_AnnotationErrors.class.getName(),  
				messages.getAnnotationErrors().getClass().getName());
		assertEquals(Tests4J_AssertionInputMessages.class.getName(),  
				messages.getAssertionInputMessages().getClass().getName());
		assertEquals(Tests4J_ResultMessages.class.getName(),  
				messages.getResultMessages().getClass().getName());
		
		assertEquals(Tests4J_EclipseErrors.class.getName(),  
				messages.getEclipseErrors().getClass().getName());
		
		assertEquals(Tests4J_LineDiffTextDisplayMessages.class.getName(),  
				messages.getLineDiffTextDisplayMessages().getClass().getName());
		
		assertEquals(Tests4J_ParamsReaderMessages.class.getName(),  
				messages.getParamReaderMessages().getClass().getName());
		assertEquals(Tests4J_ReportMessages.class.getName(),  
				messages.getReportMessages().getClass().getName());
		
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 32;
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
		int thisUniqueAsserts = 32;
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

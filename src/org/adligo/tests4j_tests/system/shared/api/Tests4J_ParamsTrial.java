package org.adligo.tests4j_tests.system.shared.api;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_SystemApi_GwtReferenceGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@SourceFileScope(sourceClass=Tests4J_Params.class,minCoverage=6.0)
@AllowedReferences (groups=Tests4J_SystemApi_GwtReferenceGroup.class)
public class Tests4J_ParamsTrial extends SourceFileCountingTrial {
	
	@SuppressWarnings("unused") //this fixes a issue 
	// in our security manager which blocks thread creation during tests
	private static final Logger log = LogManager.getLogManager().getLogger(Tests4J_ParamsTrial.class.getName());
	
	@SuppressWarnings("boxing")
  @Test
	public void testConstructorAndDefaults() {
		Tests4J_Params params = new Tests4J_Params();
		List<Class<? extends I_Trial>> trials = params.getTrials();
		assertNotNull(trials);
		assertEquals(0, trials.size());
		assertNull( params.getRecommendedTrialThreadCount());
		List<String> additionalNonInstrumentedPackages = params.getAdditionalNonInstrumentedPackages();
		assertNotNull(additionalNonInstrumentedPackages);
		assertEquals(0, additionalNonInstrumentedPackages.size());
		
		List<String> additionalNonInstrumentedClasses = params.getAdditionalNonInstrumentedClasses();
    assertNotNull(additionalNonInstrumentedClasses);
    assertEquals(0, additionalNonInstrumentedClasses.size());
	}
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodsAdditionalNonInstrumentedClasses() {
	  Tests4J_Params params = new Tests4J_Params();
	  params.addAdditionalNonInstrumentedClass(null);
	  List<String> additionalNonInstrumentedClasses = params.getAdditionalNonInstrumentedClasses();
    assertNotNull(additionalNonInstrumentedClasses);
    assertEquals(0, additionalNonInstrumentedClasses.size());
    
    params.addAdditionalNonInstrumentedClass("clazz");
    additionalNonInstrumentedClasses = params.getAdditionalNonInstrumentedClasses();
    assertNotNull(additionalNonInstrumentedClasses);
    assertContains(additionalNonInstrumentedClasses, "clazz");
    assertEquals(1, additionalNonInstrumentedClasses.size());
    
    params.setAdditionalNonInstrumentedClasses(null);
    additionalNonInstrumentedClasses = params.getAdditionalNonInstrumentedClasses();
    assertNotNull(additionalNonInstrumentedClasses);
    assertEquals(0, additionalNonInstrumentedClasses.size());
    
    List<String> vals = new ArrayList<String>();
    vals.add("clazz2");
    vals.add(null);
    params.setAdditionalNonInstrumentedClasses(vals);
    additionalNonInstrumentedClasses = params.getAdditionalNonInstrumentedClasses();
    assertContains(additionalNonInstrumentedClasses, "clazz2");
    assertEquals(1, additionalNonInstrumentedClasses.size());
  }
	
	@SuppressWarnings("boxing")
  @Test
  public void testMethodsAdditionalNonInstrumentedPackages() {
	  Tests4J_Params params = new Tests4J_Params();
    params.addAdditionalNonInstrumentedPackage(null);
    List<String> additionalNonInstrumentedPackages = params.getAdditionalNonInstrumentedPackages();
    assertNotNull(additionalNonInstrumentedPackages);
    assertEquals(0, additionalNonInstrumentedPackages.size());
    
    params.addAdditionalNonInstrumentedPackage("clazz");
    additionalNonInstrumentedPackages = params.getAdditionalNonInstrumentedPackages();
    assertNotNull(additionalNonInstrumentedPackages);
    assertContains(additionalNonInstrumentedPackages, "clazz");
    assertEquals(1, additionalNonInstrumentedPackages.size());
    
    params.setAdditionalNonInstrumentedPackages(null);
    additionalNonInstrumentedPackages = params.getAdditionalNonInstrumentedPackages();
    assertNotNull(additionalNonInstrumentedPackages);
    assertEquals(0, additionalNonInstrumentedPackages.size());
    
    List<String> vals = new ArrayList<String>();
    vals.add("clazz2");
    vals.add(null);
    params.setAdditionalNonInstrumentedPackages(vals);
    additionalNonInstrumentedPackages = params.getAdditionalNonInstrumentedPackages();
    assertContains(additionalNonInstrumentedPackages, "clazz2");
    assertEquals(1, additionalNonInstrumentedPackages.size());
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testMethodsTrialsOneTrialRunParams() {
    Tests4J_Params params = new Tests4J_Params();
    params.addTrial(Tests4J_ParamsTrial.class);
    List<Class<? extends I_Trial>> trials = params.getTrials();
    assertNotNull(trials);
    assertEquals(1, trials.size());
    assertEquals(Tests4J_ParamsTrial.class, trials.get(0));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 28;
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
		int thisUniqueAsserts = 18;
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

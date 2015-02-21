package org.adligo.tests4j_tests.run.helpers;

import org.adligo.tests4j.run.helpers.ClassFilterMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.shared.common.SpecialClasses;

@SourceFileScope (sourceClass=ClassFilterMutant.class, minCoverage=38.0)
public class ClassFilterMutantTrial extends SourceFileCountingTrial {


  @Test
  public void testFilterPrimitiveClassesAndArraysOfPrimitiveClasses() throws Exception {
    ClassFilterMutant cfm = new ClassFilterMutant();
    
    assertFalse(cfm.isFiltered(Boolean.class));
    assertFalse(cfm.isFiltered(Byte.class));
    assertFalse(cfm.isFiltered(Character.class));
    assertFalse(cfm.isFiltered(Double.class));
    assertFalse(cfm.isFiltered(Float.class));
    assertFalse(cfm.isFiltered(Integer.class));
    assertFalse(cfm.isFiltered(Long.class));
    assertFalse(cfm.isFiltered(Short.class));
    //cfm.isFiltered(Class.forName("B"));
    //cfm.isFiltered(Class.forName(ClassMethods.));
  }
  
  @Test
  public void testFilterPrimitivesAndArraysOfPrimitives() throws Exception {
    ClassFilterMutant cfm = new ClassFilterMutant();
    
    Class<?> booleanClass = SpecialClasses.getBooleanClass();
    assertTrue(cfm.isFiltered(booleanClass));
    assertTrue(cfm.isFiltered(SpecialClasses.getBooleanArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getByteClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getByteArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getCharClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getCharArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getDoubleClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getDoubleArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getFloatClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getFloatArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getIntClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getIntArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getLongClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getLongArrayClass()));
    
    assertTrue(cfm.isFiltered(SpecialClasses.getShortClass()));
    assertTrue(cfm.isFiltered(SpecialClasses.getShortArrayClass()));
    /*
    assertFalse(cfm.isFiltered(Byte.class));
    assertFalse(cfm.isFiltered(Character.class));
    assertFalse(cfm.isFiltered(Double.class));
    assertFalse(cfm.isFiltered(Float.class));
    assertFalse(cfm.isFiltered(Integer.class));
    assertFalse(cfm.isFiltered(Long.class));
    assertFalse(cfm.isFiltered(Short.class));
    */
    //cfm.isFiltered(Class.forName("B"));
    //cfm.isFiltered(Class.forName(ClassMethods.));
  }
  
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 2, false);
  }

  @Override
  public int getAsserts(I_CountType type) {
    int thisAsserts = 24;
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
    int thisUniqueAsserts = 2;
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

package org.adligo.tests4j_tests.system.shared.mocks;

import org.adligo.tests4j.run.common.MockThreadGroupLocalDelegate;
import org.adligo.tests4j.shared.common.Tests4J_Constants;
import org.adligo.tests4j.shared.common.Tests4J_ConstantsWrapper;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_EclipseErrors;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LineDiffTextDisplayMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_LogMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ResultMessages;

/**
 * This is a example of a static stub (interface)
 * which is swapped out with a thread local. 
 * Use with Tests4J_ConstantsMock
 * 
 * @author scott
 *
 */
public class Tests4J_ConstantsMockDelegate implements I_Tests4J_Constants {
  private static final Tests4J_ConstantsMockDelegate INSTANCE = new Tests4J_ConstantsMockDelegate();
  private static final MockThreadGroupLocalDelegate<I_Tests4J_Constants> SWAPIN = 
      new MockThreadGroupLocalDelegate<I_Tests4J_Constants>(Tests4J_EnglishConstants.ENGLISH);
  
  /**
   * This method changes the wrapped reference in
   * Tests4J_Constants.INSTANCE to this (and it is never changed back!).
   * Then for this thread group, the instance is changed to the constants parameter.
   * All other thread groups should continue to operate as usual
   * since the initial value factory is set to Tests4J_EnglishConstants.ENGLISH.
   * @param constants
   */
  public static void setup(I_Tests4J_Constants constants) {
    Tests4J_ConstantsWrapper wrapper = (Tests4J_ConstantsWrapper) Tests4J_Constants.CONSTANTS;
    if (!wrapper.getDelegate().getClass().getName().equals(Tests4J_ConstantsMockDelegate.class.getName())) {
      wrapper.setDelegate(INSTANCE);
    }
    SWAPIN.set(constants);
  }
  
  /**
   * This sets the thread group local back to Tests4J_EnglishConstants.ENGLISH
   * so that subsequent tests on this test/trial thread will operate normally.
   */
  public static void reset() {
    SWAPIN.set(Tests4J_EnglishConstants.ENGLISH);
  }
  
  private static I_Tests4J_Constants get() {
    return SWAPIN.getValue();
  }
  
  private Tests4J_ConstantsMockDelegate() {
    //singleton
  }
  
  
  @Override
  public boolean isLeftToRight() {
    return get().isLeftToRight();
  }

  @Override
  public String getPrefix() {
    return get().getPrefix();
  }

  @Override
  public String getHeader() {
    return get().getHeader();
  }

  @Override
  public I_Tests4J_AnnotationMessages getAnnotationMessages() {
    return get().getAnnotationMessages();
  }

  @Override
  public I_Tests4J_AssertionInputMessages getAssertionInputMessages() {
    return get().getAssertionInputMessages();
  }

  @Override
  public I_Tests4J_ResultMessages getResultMessages() {
    return get().getResultMessages();
  }

  @Override
  public I_Tests4J_EclipseErrors getEclipseErrors() {
    return get().getEclipseErrors();
  }

  @Override
  public I_Tests4J_LineDiffTextDisplayMessages getLineDiffTextDisplayMessages() {
    return get().getLineDiffTextDisplayMessages();
  }

  @Override
  public I_Tests4J_LogMessages getLogMessages() {
    return get().getLogMessages();
  }

  @Override
  public I_Tests4J_ParamsReaderMessages getParamReaderMessages() {
    return get().getParamReaderMessages();
  }

  @Override
  public I_Tests4J_ReportMessages getReportMessages() {
    return get().getReportMessages();
  }

  @Override
  public String getBadConstuctor() {
    return get().getBadConstuctor();
  }

  @Override
  public String getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames() {
    return get().getMethodBlockerRequiresAtLeastOneAllowedCallerClassNames();
  }

  @Override
  public String getMethodBlockerRequiresABlockingClass() {
    return get().getMethodBlockerRequiresABlockingClass();
  }

  @Override
  public String getMethodBlockerRequiresABlockingMethod() {
    return get().getMethodBlockerRequiresABlockingMethod();
  }

  @Override
  public String getNullParamsExceptionMessage() {
    return get().getNullParamsExceptionMessage();
  }

  @Override
  public String getNullListenerExceptionMessage() {
    return get().getNullListenerExceptionMessage();
  }

  @Override
  public String getTheMethodCanOnlyBeCalledBy_PartOne() {
    return get().getTheMethodCanOnlyBeCalledBy_PartOne();
  }

  @Override
  public String getTheMethodCanOnlyBeCalledBy_PartTwo() {
    return get().getTheMethodCanOnlyBeCalledBy_PartTwo();
  }

  @Override
  public String getAnotherTests4J_InstanceIsRunningHere() {
    return get().getAnotherTests4J_InstanceIsRunningHere();
  }

}

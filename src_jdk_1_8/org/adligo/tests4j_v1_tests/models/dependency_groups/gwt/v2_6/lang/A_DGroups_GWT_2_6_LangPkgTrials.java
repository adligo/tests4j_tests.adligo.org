package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.lang;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroups_GWT_2_6_LangPkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DGroups_GWT_2_6_LangPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroups_GWT_2_6_LangPkgTrials me = new A_DGroups_GWT_2_6_LangPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
		
			//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception{
		//in alpha dependency order
		
		add(Appendable_2_6_UseTrial.class);
		add(Object_2_6_UseTrial.class);
		add(StackTraceElement_2_6_UseTrial.class);
		add(Throwable_2_6_UseTrial.class);
		add(Exception_2_6_UseTrial.class);
		add(RuntimeException_2_6_UseTrial.class);
		add(ArithmeticException_2_6_UseTrial.class);
		add(AutoCloseable_2_6_UseTrial.class);
		
		add(CharSequence_2_6_UseTrial.class);
		add(IndexOutOfBoundsException_2_6_UseTrial.class);
		add(ArrayIndexOutOfBoundsException_2_6_UseTrial.class);
		add(ArrayStoreException_2_6_UseTrial.class);
		add(Error_2_6_UseTrial.class);
		add(AssertionError_2_6_UseTrial.class);
		add(ClassCastException_2_6_UseTrial.class);
		add(IllegalArgumentException_2_6_UseTrial.class);
		add(IllegalStateException_2_6_UseTrial.class);
		add(NegativeArraySizeException_2_6_UseTrial.class);
		add(NoSuchMethodException_2_6_UseTrial.class);
		add(NullPointerException_2_6_UseTrial.class);
		add(NumberFormatException_2_6_UseTrial.class);
		add(StringIndexOutOfBoundsException_2_6_UseTrial.class);
		add(UnsupportedOperationException_2_6_UseTrial.class);

		add(Boolean_2_6_UseTrial.class);
		add(Cloneable_2_6_UseTrial.class);
		add(Comparable_2_6_UseTrial.class);
		add(Deprecated_2_6_UseTrial.class);
		add(Override_2_6_UseTrial.class);
		
		add(Enum_2_6_UseTrial.class);
		
		add(Number_2_6_UseTrial.class);
		add(Byte_2_6_UseTrial.class);
		add(Character_2_6_UseTrial.class);
		add(Class_2_6_UseTrial.class);
		
		add(Double_2_6_UseTrial.class);
		add(Float_2_6_UseTrial.class);
		add(Integer_2_6_UseTrial.class);
		add(Iterable_2_6_UseTrial.class);
		add(Long_2_6_UseTrial.class);
		add(Math_2_6_UseTrial.class);
		add(Short_2_6_UseTrial.class);
		
		add(String_2_6_UseTrial.class);
		
	}

	@Override
	public A_DGroups_GWT_2_6_LangPkgTrials getTrialParams() {
		return this;
	}
}

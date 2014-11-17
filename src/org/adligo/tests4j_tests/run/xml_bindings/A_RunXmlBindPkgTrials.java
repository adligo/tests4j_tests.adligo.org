package org.adligo.tests4j_tests.run.xml_bindings;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.run.xml_bindings.conversion.A_RunXmlBindConPkgTrials;

public class A_RunXmlBindPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunXmlBindPkgTrials>, I_CountingPackageTrials {
  private static A_RunXmlBindConPkgTrials con = new A_RunXmlBindConPkgTrials();
  
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_RunXmlBindPkgTrials me = new A_RunXmlBindPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
			
			//TieredJacocoPlugin covargePlugin =new TieredJacocoPlugin();
			
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		con.addTrials();
		add(con.getCountingTrials());
	}

	@Override
	public A_RunXmlBindPkgTrials getTrialParams() {
		return this;
	}
	
	@Override
  public void setParams(Tests4J_Params params) {
    super.setParams(params);
    con.setParams(params);
	}
}

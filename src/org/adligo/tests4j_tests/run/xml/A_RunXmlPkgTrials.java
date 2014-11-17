package org.adligo.tests4j_tests.run.xml;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.run.xml.io.A_RunXmlIOPkgTrials;
import org.adligo.tests4j_tests.run.xml_bindings.A_RunXmlBindPkgTrials;

public class A_RunXmlPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunXmlPkgTrials>, I_CountingPackageTrials {
  private static A_RunXmlBindPkgTrials bind = new A_RunXmlBindPkgTrials();
  private static A_RunXmlIOPkgTrials io = new A_RunXmlIOPkgTrials();
  
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_RunXmlPkgTrials me = new A_RunXmlPkgTrials();
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
		bind.addTrials();
		add(bind.getCountingTrials());
		
		io.addTrials();
    add(io.getCountingTrials());
	}

	@Override
	public A_RunXmlPkgTrials getTrialParams() {
		return this;
	}
	
	@Override
  public void setParams(Tests4J_Params params) {
    super.setParams(params);
    bind.setParams(params);
    io.setParams(params);
	}
}

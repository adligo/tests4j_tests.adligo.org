package org.adligo.tests4j_tests.run;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.run.api.A_RunApiPkgTrials;
import org.adligo.tests4j_tests.run.common.A_RunCommonPkgTrials;
import org.adligo.tests4j_tests.run.discovery.A_RunDiscPkgTrials;
import org.adligo.tests4j_tests.run.helpers.A_RunHelpPkgTrials;
import org.adligo.tests4j_tests.run.io.A_RunIOPkgTrials;
import org.adligo.tests4j_tests.run.memory.A_RunMemoryPkgTrials;
import org.adligo.tests4j_tests.run.remote.socket_api.A_SocApiPkgTrials;
import org.adligo.tests4j_tests.run.xml.A_RunXmlPkgTrials;

public class A_RunPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_RunPkgTrials>, I_CountingPackageTrials {
	private static A_RunDiscPkgTrials runDisc = new A_RunDiscPkgTrials();
	private static A_RunHelpPkgTrials runHelp = new A_RunHelpPkgTrials();
	private static A_RunIOPkgTrials remoteIo = new A_RunIOPkgTrials();
	private static A_SocApiPkgTrials soc = new A_SocApiPkgTrials();
	private static A_RunApiPkgTrials api = new A_RunApiPkgTrials();
	private static A_RunCommonPkgTrials common = new A_RunCommonPkgTrials();
	private static A_RunMemoryPkgTrials memory = new A_RunMemoryPkgTrials();
	private static A_RunXmlPkgTrials xml = new A_RunXmlPkgTrials();
  
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			

			
			A_RunPkgTrials me = new A_RunPkgTrials();
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

	public void addTrials()  throws Exception {
		
	  common.addTrials();
    add(common.getCountingTrials());
    
		runDisc.addTrials();
		add(runDisc.getCountingTrials());
		
		runHelp.addTrials();
		add(runHelp.getCountingTrials());
		
		remoteIo.addTrials();
		add(remoteIo.getCountingTrials());
		
		soc.addTrials();
		add(soc.getCountingTrials());
		
		api.addTrials();
		add(api.getCountingTrials());
		
		memory.addTrials();
		add(memory.getCountingTrials());
		
		xml.addTrials();
		add(xml.getCountingTrials());
	}

	@Override
	public A_RunPkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		runDisc.setParams(params);
		runHelp.setParams(params);
		remoteIo.setParams(params);
		soc.setParams(params);
		api.setParams(params);
		common.setParams(params);
		memory.setParams(params);
		xml.setParams(params);
	}
}

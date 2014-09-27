package org.adligo.tests4j_tests.shared.output;

import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_OutPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_OutPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_OutPkgTrials me = new A_OutPkgTrials();
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
		add(ByteListOutputStreamTrial.class);
		add(DefaultLogTrial.class);
		add(DelegatingLogTrial.class);
		
		add(I_ConcurrentOutputDelegatorTrial.class);
		add(I_OutputBufferTrial.class);
		add(I_OutputDelegateorTrial.class);
		add(I_Tests4J_LogTrial.class);
		add(I_ToggleOutputBufferTrial.class);
		
		add(ListDelegateOutputBufferTrial.class);
		add(PrintStreamOutputBufferTrial.class);
		add(SafeOutputStreamBufferTrial.class);
	}

	@Override
	public A_OutPkgTrials getTrialParams() {
		return this;
	}
}

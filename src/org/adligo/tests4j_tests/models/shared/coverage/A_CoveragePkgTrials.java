package org.adligo.tests4j_tests.models.shared.coverage;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.factories.MockitoPluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_CoveragePkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_CoveragePkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(MockitoPluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_CoveragePkgTrials me = new A_CoveragePkgTrials();
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
		add(I_CoverageUnitsTrial.class);
		add(I_CoverageUnitsContainerTrial.class);
		add(I_LineCoverageSegmentTrial.class);
		add(I_LineCoverageTrial.class);
		add(I_PackageBriefTrial.class);
		add(I_ProbesTrial.class);
		add(I_ProbesCoverageContainerTrial.class);
		add(I_SourceFileBriefTrial.class);
		add(I_SourceFileCoverageTrial.class);
		
    add(ProbesTrial.class);
    add(ProbesMutantTrial.class);
    
    add(ClassProbesMutantTrial.class);
    add(ClassProbesTrial.class);
    
		add(CoverageUnitsTrial.class);
		add(CoverageUnitContinerMutantTrial.class);
		
		add(LineCoverageSegmentMutantTrial.class);
		add(LineCoverageSegmentTrial.class);
		
		add(LineCoverageMutantTrial.class);
		add(LineCoverageTrial.class);
		
		add(SourceFileCoverageMutantTrial.class);
		add(SourceFileCoverageTrial.class);
		add(SourceFileCoverageDelegatorTrial.class);
		
		add(PackageBriefMutantTrial.class);
		add(PackageBriefTrial.class);
		add(PackageBriefDelegatorTrial.class);
		
		add(SourceFileBriefMutantTrial.class);
		add(SourceFileBriefTrial.class);
	}

	@Override
	public A_CoveragePkgTrials getTrialParams() {
		return this;
	}

}

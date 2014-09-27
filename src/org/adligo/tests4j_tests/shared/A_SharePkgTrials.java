package org.adligo.tests4j_tests.shared;

import org.adligo.tests4j.models.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;
import org.adligo.tests4j_tests.shared.asserts.A_AssertsPkgTrials;
import org.adligo.tests4j_tests.shared.common.A_CmnPkgTrials;
import org.adligo.tests4j_tests.shared.en.A_EnPkgTrials;
import org.adligo.tests4j_tests.shared.i18n.A_I18nPkgTrials;
import org.adligo.tests4j_tests.shared.output.A_OutPkgTrials;
import org.adligo.tests4j_tests.shared.report.summary.A_SummPkgTrials;
import org.adligo.tests4j_tests.shared.xml.A_XmlPkgTrials;

public class A_SharePkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_SharePkgTrials>, I_CountingPackageTrials {
	private A_I18nPkgTrials i18n = new A_I18nPkgTrials();
	private A_EnPkgTrials en = new A_EnPkgTrials();
	private A_CmnPkgTrials cmn = new A_CmnPkgTrials();
	private A_XmlPkgTrials xml = new A_XmlPkgTrials();

	
	private A_AssertsPkgTrials asserts = new A_AssertsPkgTrials();
	private A_OutPkgTrials out = new A_OutPkgTrials();
	private A_SummPkgTrials sum = new A_SummPkgTrials();
	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_SharePkgTrials me = new A_SharePkgTrials();
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
		i18n.addTrials();
		add(i18n.getCountingTrials());
		
		en.addTrials();
		add(en.getCountingTrials());
		
		cmn.addTrials();
		add(cmn.getCountingTrials());
		
		xml.addTrials();
		add(xml.getCountingTrials());
		
		asserts.addTrials();
		add(asserts.getCountingTrials());
		
		out.addTrials();
		add(out.getCountingTrials());
		
		sum.addTrials();
		add(sum.getCountingTrials());
	}

	@Override
	public A_SharePkgTrials getTrialParams() {
		return this;
	}

	@Override
	public void setParams(Tests4J_Params params) {
		super.setParams(params);
		i18n.setParams(params);
		en.setParams(params);
		cmn.setParams(params);
		xml.setParams(params);
		asserts.setParams(params);
		
		out.setParams(params);
		sum.setParams(params);
	}
}

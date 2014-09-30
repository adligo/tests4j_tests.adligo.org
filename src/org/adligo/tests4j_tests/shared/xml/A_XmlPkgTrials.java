package org.adligo.tests4j_tests.shared.xml;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_MetaTrialParams;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_XmlPkgTrials extends SimplePackageTrials 
implements I_MetaTrialParams<A_XmlPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			
			A_XmlPkgTrials me = new A_XmlPkgTrials();
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
		add(I_XML_ConsumerTrial.class);
		add(I_XML_BuilderTrial.class);
		add(I_XML_ProducerTrial.class);
		
		add(XML_BuilderTrial.class);
		add(XML_CharsTrial.class);
		add(XML_ParserTrial.class);
	}
	
	@Override
	public A_XmlPkgTrials getTrialParams() {
		return this;
	}
}

package org.adligo.tests4j_tests;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.adligo.tests4j.models.shared.system.I_Tests4J_Controls;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Reporter;
import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.system.Tests4J_RemoteInfo;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j.run.remote.Tests4J_RemoteRunner;
import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;

public class RunAllRemote {

	public static void main(String [] args) {
		Tests4J_Params remoteParams = RunAllTrials.getTests(ScopedJacocoPlugin.class);
		
		Tests4J_Params params = new Tests4J_Params();
		I_Tests4J_Reporter reporter =  params.getReporter();
		reporter.setLogOn(Tests4J_RemoteRunner.class);
		
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			params.putRemoteParams(new Tests4J_RemoteInfo(localhost.getHostName(), 9999, "8675309abc"), remoteParams);
			I_Tests4J_Controls controls = Tests4J.run(params);
			controls.shutdown();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

package org.adligo.tests4j_tests;

import org.adligo.tests4j.run.remote.Tests4J_SocketServerRunner;

public class RunServer {

	public static void main(String [] args) {
		Tests4J_SocketServerRunner.main(new String[] {"-port","9999","-authCode","8675309abc"});
	}
}

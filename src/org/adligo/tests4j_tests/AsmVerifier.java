package org.adligo.tests4j_tests;

import org.adligo.tests4j_4jacoco.plugin.ScopedJacocoPlugin;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.ASMifier;

/**
 * run this to have the ASMifier veify your ASM code if your 
 * working on this project.
 * 
 * @author scott
 *
 */
public class AsmVerifier {

	public static void main(String [] args) {
		try {
			String internalName = Type.getInternalName(ScopedJacocoPlugin.class);
			//internalName = "./org.adligo.tests4j_tests.models.shared.system.Tests4J_ParamsTrial.class";
			//internalName = "./classes_e/org/adligo/tests4j_tests/TheMetaTrial.class";
			internalName = "./classes_e/org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithArray.class";
			
			ASMifier.main(new String[]{
					internalName});
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}

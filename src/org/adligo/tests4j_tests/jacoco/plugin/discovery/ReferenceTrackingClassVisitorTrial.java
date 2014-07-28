package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.io.InputStream;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

@SourceFileScope (sourceClass=ReferenceTrackingClassVisitor.class)
public class ReferenceTrackingClassVisitorTrial extends SourceFileCountingTrial {

	@Test
	public void testReferenceCounting() throws Exception {
		ClassVisitor cv = new ReferenceTrackingClassVisitor(super.getLog());
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				"/org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing.class");
		ClassReader classReader=new ClassReader(in);
		classReader.accept(cv, 0);

	}
	
	@Override
	public int getTests() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAsserts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUniqueAsserts() {
		// TODO Auto-generated method stub
		return 0;
	}

}

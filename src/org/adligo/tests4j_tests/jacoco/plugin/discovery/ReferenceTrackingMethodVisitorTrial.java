package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Set;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesMutant;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@SourceFileScope (sourceClass=ReferenceTrackingMethodVisitor.class, minCoverage=50.0)
public class ReferenceTrackingMethodVisitorTrial extends SourceFileCountingTrial {
	ReferenceTrackingMethodVisitor rtcv;
	ClassReferencesMutant crm = new ClassReferencesMutant();
	Set<String> names = crm.getClassNames();
	
	public void beforeTests() {
		if (rtcv == null) {
			rtcv = new ReferenceTrackingMethodVisitor(Opcodes.ASM5, super.getLog());
		}
		rtcv.setClassReferences(crm);
		names.clear();
	}
	
	
	@Test
	public void testReferenceCounting_BasicExecution() throws Exception {
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ReferenceTrackingMethodVisitorTrial;", "signature", new Label(), new Label(), 1);
		assertEquals(1, names.size());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_4jacoco/plugin/discovery/ReferenceTrackingMethodVisitor;", "signature", new Label(), new Label(), 1);
		assertEquals(2, names.size());
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		rtcv.visitLocalVariable("name", "Ljava/lang/String;", "signature", new Label(), new Label(), 1);
		assertEquals(2, names.size());
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "foo", "()V", true);
		
		assertContains(names, MockWithNothing.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		assertEquals(3, names.size());
		
		names.clear();
		rtcv.visitFieldInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "name", "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodReturn;");
		assertContains(names, MockWithNothing.class.getName());
		assertContains(names, MockWithMethodReturn.class.getName());
		assertEquals(2, names.size());
	
	
		names.clear();
		rtcv.visitLdcInsn("Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing;");
		assertContains(names, MockWithNothing.class.getName());
		assertEquals(1, names.size());
		
		
		names.clear();
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				"org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockException");
		assertContains(names, MockException.class.getName());
		assertEquals(1, names.size());
	}
	

	
	
	
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 19;
	}

	@Override
	public int getUniqueAsserts() {
		return 13;
	}

}

package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.ClassReferencesLocalMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.map.MapInstrConstants;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

@SourceFileScope (sourceClass=ReferenceTrackingMethodVisitor.class, minCoverage=64.0)
public class ReferenceTrackingMethodVisitorTrial extends SourceFileCountingTrial {
	ReferenceTrackingMethodVisitor rtcv;
	Set<String> names = new HashSet<String>();
	
	public void beforeTests() {
		if (rtcv == null) {
			rtcv = new ReferenceTrackingMethodVisitor(Opcodes.ASM5, super.getLog());
			
			ClassFilterMutant cfm = new ClassFilterMutant();
			cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
			rtcv.setClassFilter(new ClassFilter(cfm));
		}
		rtcv.setClassReferences(names);
		names.clear();
	}
	
	
	@Test
	public void testReferenceCounting_BasicExecution() throws Exception {
		rtcv.setCurrentMethodName("<init>");
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ReferenceTrackingMethodVisitorTrial;", "signature", new Label(), new Label(), 1);
		assertEquals(1, names.size());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_4jacoco/plugin/discovery/ReferenceTrackingMethodVisitor;", "signature", new Label(), new Label(), 1);
		assertEquals(2, names.size());
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		rtcv.visitLocalVariable("name", "Ljava/lang/String;", "signature", new Label(), new Label(), 1);
		
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		assertContains(names, String.class.getName());
		assertEquals(3, names.size());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "foo", "()V", true);
		
		assertContains(names, MockWithNothing.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitor.class.getName());
		assertContains(names, ReferenceTrackingMethodVisitorTrial.class.getName());
		assertContains(names, String.class.getName());
		assertEquals(4, names.size());
		
		names.clear();
		rtcv.visitFieldInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "name", "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodReturn;");
		assertContains(names, MockWithNothing.class.getName());
		assertContains(names, MockWithMethodReturn.class.getName());
		assertEquals(2, names.size());
	
	
		names.clear();
		rtcv.visitLdcInsn(Type.getType("Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing;"));
		assertContains(names, MockWithNothing.class.getName());
		assertEquals(1, names.size());
		
		
		names.clear();
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				"org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockException");
		assertContains(names, MockException.class.getName());
		assertEquals(1, names.size());
	}
	

	@Test
	public void testReferenceCounting_JacocoInit() throws Exception {
		rtcv.setCurrentMethodName(MapInstrConstants.METHOD_NAME);
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ReferenceTrackingMethodVisitorTrial;", "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		
		rtcv.visitLocalVariable("name", "Lorg/adligo/tests4j_4jacoco/plugin/discovery/ReferenceTrackingMethodVisitor;", "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		rtcv.visitLocalVariable("name", "Ljava/lang/String;", "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "foo", "()V", true);
		assertEquals(0, names.size());
		
		rtcv.visitFieldInsn(Opcodes.AALOAD, "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing", "name", "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodReturn;");
		assertEquals(0, names.size());
	
	
		rtcv.visitLdcInsn(Type.getType("Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing;"));
		assertEquals(0, names.size());
		
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				"org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockException");
		assertEquals(0, names.size());
	}
	
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 28;
	}

	@Override
	public int getUniqueAsserts() {
		return 19;
	}

}

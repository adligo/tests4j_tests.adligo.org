package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.map.MapInstrConstants;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

@SourceFileScope (sourceClass=ReferenceTrackingMethodVisitor.class, minCoverage=64.0)
public class ReferenceTrackingMethodVisitorTrial extends SourceFileCountingTrial {
	private static final String REF_TRACK_METHOD = "Lorg/adligo/tests4j_4jacoco/plugin/discovery/ReferenceTrackingMethodVisitor;";
	private static final String REF_TRACK_METHOD_TRIAL = "Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ReferenceTrackingMethodVisitorTrial;";
	ReferenceTrackingMethodVisitor rtcv;
	Set<String> names = new HashSet<String>();
	
	public void beforeTests() {
		if (rtcv == null) {
			rtcv = new ReferenceTrackingMethodVisitor(Opcodes.ASM5, super.getLog());
			
			ClassFilterMutant cfm = new ClassFilterMutant();
			cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
		}
		rtcv.setClassReferences(names);
		names.clear();
	}
	
	
	@Test
	public void testReferenceCounting_BasicExecution() throws Exception {
		rtcv.setCurrentMethodName("<init>");
		rtcv.visitLocalVariable("name", REF_TRACK_METHOD_TRIAL, "signature", new Label(), new Label(), 1);
		assertEquals(1, names.size());
		assertContains(names, REF_TRACK_METHOD_TRIAL);
		
		rtcv.visitLocalVariable("name", REF_TRACK_METHOD, "signature", new Label(), new Label(), 1);
		assertEquals(2, names.size());
		assertContains(names, REF_TRACK_METHOD);
		assertContains(names, REF_TRACK_METHOD_TRIAL);
		rtcv.visitLocalVariable("name", ReferenceTrackingClassVisitorTrial.STRING, "signature", new Label(), new Label(), 1);
		
		assertContains(names, REF_TRACK_METHOD);
		assertContains(names, REF_TRACK_METHOD_TRIAL);
		assertContains(names, ReferenceTrackingClassVisitorTrial.STRING);
		assertEquals(3, names.size());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD, ReferenceTrackingClassVisitorTrial.MW_NOTHING_BARE, "foo", "()V", true);
		
		assertContains(names, ReferenceTrackingClassVisitorTrial.MW_NOTHING);
		assertContains(names, REF_TRACK_METHOD);
		assertContains(names, REF_TRACK_METHOD_TRIAL);
		assertContains(names,  ReferenceTrackingClassVisitorTrial.STRING);
		assertEquals(4, names.size());
		
		names.clear();
		rtcv.visitFieldInsn(Opcodes.AALOAD, ReferenceTrackingClassVisitorTrial.MW_NOTHING_BARE, "name", ReferenceTrackingClassVisitorTrial.MW_METHOD_RETURN);
		assertContains(names, ReferenceTrackingClassVisitorTrial.MW_NOTHING);
		assertContains(names, ReferenceTrackingClassVisitorTrial.MW_METHOD_RETURN);
		assertEquals(2, names.size());
	
	
		names.clear();
		rtcv.visitLdcInsn(Type.getType(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		assertContains(names, ReferenceTrackingClassVisitorTrial.MW_NOTHING);
		assertEquals(1, names.size());
		
		
		names.clear();
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				ReferenceTrackingClassVisitorTrial.M_EXCEPTION_BARE);
		assertContains(names, ReferenceTrackingClassVisitorTrial.M_EXCEPTION);
		assertEquals(1, names.size());
	}
	

	@Test
	public void testReferenceCounting_JacocoInit() throws Exception {
		rtcv.setCurrentMethodName(MapInstrConstants.METHOD_NAME);
		rtcv.visitLocalVariable("name", REF_TRACK_METHOD_TRIAL, "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		
		rtcv.visitLocalVariable("name", REF_TRACK_METHOD, "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		rtcv.visitLocalVariable("name", ReferenceTrackingClassVisitorTrial.STRING, "signature", new Label(), new Label(), 1);
		assertEquals(0, names.size());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD,ReferenceTrackingClassVisitorTrial.MW_NOTHING, "foo", "()V", true);
		assertEquals(0, names.size());
		
		rtcv.visitFieldInsn(Opcodes.AALOAD, ReferenceTrackingClassVisitorTrial.MW_NOTHING, "name", ReferenceTrackingClassVisitorTrial.MW_METHOD_RETURN);
		assertEquals(0, names.size());
	
	
		rtcv.visitLdcInsn(Type.getType(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		assertEquals(0, names.size());
		
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				ReferenceTrackingClassVisitorTrial.M_EXCEPTION);
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

package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.ClassAttributesMutant;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.map.MapInstrConstants;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

@SourceFileScope (sourceClass=ReferenceTrackingMethodVisitor.class, minCoverage=64.0)
public class ReferenceTrackingMethodVisitorTrial extends SourceFileCountingTrial {
	private static final String REF_TRACK_METHOD = "Lorg/adligo/tests4j_4jacoco/plugin/discovery/ReferenceTrackingMethodVisitor;";
	private static final String REF_TRACK_METHOD_TRIAL = "Lorg/adligo/tests4j_tests/jacoco/plugin/discovery/ReferenceTrackingMethodVisitorTrial;";
	ReferenceTrackingMethodVisitor rtcv;
	Map<String, ClassAttributesMutant> names = new HashMap<String, ClassAttributesMutant>();
	
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
		assertTrue(names.containsKey(REF_TRACK_METHOD_TRIAL));
		
		rtcv.visitLocalVariable("name", REF_TRACK_METHOD, "signature", new Label(), new Label(), 1);
		assertEquals(2, names.size());
		assertTrue(names.containsKey(REF_TRACK_METHOD));
		assertTrue(names.containsKey(REF_TRACK_METHOD_TRIAL));
		rtcv.visitLocalVariable("name", ReferenceTrackingClassVisitorTrial.STRING, "signature", new Label(), new Label(), 1);
		
		assertTrue(names.containsKey(REF_TRACK_METHOD));
		assertTrue(names.containsKey(REF_TRACK_METHOD_TRIAL));
		assertTrue(names.containsKey(ReferenceTrackingClassVisitorTrial.STRING));
		assertEquals(3, names.size());
		
		rtcv.visitMethodInsn(Opcodes.AALOAD, ReferenceTrackingClassVisitorTrial.MW_NOTHING_BARE, "foo", "()V", true);
		
		assertTrue(names.containsKey(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		assertTrue(names.containsKey(REF_TRACK_METHOD));
		assertTrue(names.containsKey(REF_TRACK_METHOD_TRIAL));
		assertTrue(names.containsKey( ReferenceTrackingClassVisitorTrial.STRING));
		assertEquals(4, names.size());
		
		names.clear();
		rtcv.visitFieldInsn(Opcodes.AALOAD, ReferenceTrackingClassVisitorTrial.MW_NOTHING_BARE, "name", ReferenceTrackingClassVisitorTrial.MW_METHOD_RETURN);
		assertTrue(names.containsKey(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		ClassAttributesMutant cam = names.get(ReferenceTrackingClassVisitorTrial.MW_NOTHING);
		assertEquals(ReferenceTrackingClassVisitorTrial.MW_NOTHING, cam.getName());
		Set<I_FieldSignature> fields = cam.getFields();
		assertContains(fields, new FieldSignature("name", ReferenceTrackingClassVisitorTrial.MW_METHOD_RETURN));
		assertEquals(1, fields.size());
		assertEquals(1, names.size());
	
	
		names.clear();
		rtcv.visitLdcInsn(Type.getType(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		assertTrue(names.containsKey(ReferenceTrackingClassVisitorTrial.MW_NOTHING));
		assertEquals(1, names.size());
		
		
		names.clear();
		rtcv.visitTryCatchBlock(new Label(), new Label(), new Label(), 
				ReferenceTrackingClassVisitorTrial.M_EXCEPTION_BARE);
		assertTrue(names.containsKey(ReferenceTrackingClassVisitorTrial.M_EXCEPTION));
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
	
	@Test
	public void testParseAsmMethodSigParams() throws Exception {
		String [] params = ReferenceTrackingMethodVisitor.parseAsmMethodSigParams("()V");
		assertNull(params);
		
		params = ReferenceTrackingMethodVisitor.parseAsmMethodSigParams("(Ljava/lang/Byte;)V");
		assertEquals("Ljava/lang/Byte;", params[0]);
		assertEquals(1, params.length);
		
		params = ReferenceTrackingMethodVisitor.parseAsmMethodSigParams("(Lorg/adligo/tests4j/run/remote/"
				+ "Tests4J_SocketServerRunner;Lorg/adligo/tests4j/run/remote/RemoteMessageReader;)V");
		assertEquals("Lorg/adligo/tests4j/run/remote/Tests4J_SocketServerRunner;", params[0]);
		assertEquals("Lorg/adligo/tests4j/run/remote/RemoteMessageReader;", params[1]);
		assertEquals(2, params.length);
		
		params = ReferenceTrackingMethodVisitor.parseAsmMethodSigParams("([BLjava/lang/String;)V");
		assertEquals("[B", params[0]);
		assertEquals("Ljava/lang/String;", params[1]);
		assertEquals(2, params.length);
	}
	
	@Test
	public void testParseAsmMethodSigReturn() throws Exception {
		String ret = ReferenceTrackingMethodVisitor.parseAsmMethodSigReturn("()V");
		assertNull(ret);
		
		ret = ReferenceTrackingMethodVisitor.parseAsmMethodSigReturn("()Lorg/adligo/tests4j/run/remote/RemoteMessageReader;");
		assertEquals("Lorg/adligo/tests4j/run/remote/RemoteMessageReader;", ret);
	}
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 41;
	}

	@Override
	public int getUniqueAsserts() {
		return 18;
	}

}

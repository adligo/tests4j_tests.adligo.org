package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.dependency.ClassFilter;
import org.adligo.tests4j.models.shared.dependency.ClassFilterMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferences;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.map.MapInstrConstants;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_OtherStringAndLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithBidirectionalA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithEverything;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithImportOnlyInMethod;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodExceptionBlock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodParams;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithMethodReturn;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticField;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithStaticInitalizer;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithTriangleC;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

@SourceFileScope (sourceClass=ReferenceTrackingClassVisitor.class, minCoverage=36.0)
public class ReferenceTrackingClassVisitorTrial extends SourceFileCountingTrial {
	ReferenceTrackingClassVisitor rtcv;
	
	Set<String> names = new HashSet<String>();
	
	public void beforeTests() {
		if (rtcv == null) {
			rtcv = new ReferenceTrackingClassVisitor(Opcodes.ASM5, super.getLog());
			rtcv.setInstrumentClassFilter(new ClassFilter());
			
			ClassFilterMutant cfm = new ClassFilterMutant();
			cfm.setIgnoredPackageNames(Collections.unmodifiableSet(new HashSet<String>()));
			rtcv.setBasicClassFilter(new ClassFilter(cfm));
		}
		rtcv.reset();
	}
	
	@Test
	public void testFindReferences_001_MockWithNothing() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithNothing.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		assertEquals(MockWithNothing.class.getName(), rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_002_MockWithMethodReturn() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodReturn.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithMethodReturn.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithMethodReturn.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_003_MockWithField() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithField.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithField.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithField.class.getName());
		assertContains(classNames, I_System.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_004_MockWithMethodParams() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodParams.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithMethodParams.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithMethodParams.class.getName());
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_005_MockWithImportOnlyInMethod() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithImportOnlyInMethod.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithImportOnlyInMethod.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithImportOnlyInMethod.class.getName());
		assertContains(classNames, I_System.class.getName());
		assertEquals(3, classNames.size());
	}
	
	
	@Test
	public void testFindReferences_006_MockWithStaticField() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithStaticField.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithStaticField.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithStaticField.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_007_MockWithStaticInitalizer() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithStaticInitalizer.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithStaticInitalizer.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithStaticInitalizer.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(3, classNames.size());
	}
	

	
	@Test
	public void testFindReferences_008_MockWithArray() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithArray.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithArray.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithArray.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_009_MockWithMethodException() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodException.class.getName()));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithMethodException.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithMethodException.class.getName());
		assertContains(classNames, MockException.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_010_MockWithMethodExceptionBlock() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodExceptionBlock.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithMethodExceptionBlock.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithMethodExceptionBlock.class.getName());
		assertContains(classNames, MockWithMethodException.class.getName());
		assertContains(classNames, MockException.class.getName());
		assertEquals(4, classNames.size());
	}
	
	
	/**
	 * Note it seems from this test that 
	 * reflection, not ASM is required to 
	 * get the method return type MockWithNothing
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindReferences_011_MockWithAbstractMethodReturn() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithAbstractMethodReturn.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithAbstractMethodReturn.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithAbstractMethodReturn.class.getName());
		assertEquals(2, classNames.size());
	}
	
	/**
	 * Note it seems from this test that 
	 * reflection, not ASM is required to 
	 * get the method return type MockWithNothing
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindReferences_012_MockWithAbstractMethodParam() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithAbstractMethodParam.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithAbstractMethodParam.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithAbstractMethodParam.class.getName());
		assertEquals(2, classNames.size());
	}
	
	/**
	 * Note it seems from this test that 
	 * reflection, not ASM is required to 
	 * get the method return type MockWithNothing
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindReferences_013_MockWithAbstractMethodParam() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithAbstractMethodException.class.getName()));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithAbstractMethodException.class.getName(),  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, MockWithAbstractMethodException.class.getName());
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_014_JacocoInitAndData() throws Exception {
		rtcv.reset();
		rtcv.visit(51, MapInstrConstants.DATAFIELD_ACC, "MockMock", 
				"", "Ljava.lang.Object", new String [] {});
		
		rtcv.visitField(MapInstrConstants.DATAFIELD_ACC, "field1", 
				"Ljava.lang.Object;", "", null);
		rtcv.visitField(MapInstrConstants.DATAFIELD_ACC, MapInstrConstants.FIELD_NAME, 
				"Ljava.util.Map;", "", null);
		
		ReferenceTrackingMethodVisitor methodVisitor = (ReferenceTrackingMethodVisitor)
				rtcv.visitMethod(MapInstrConstants.DATAFIELD_ACC, "<init>", 
						"", "", new String []{});
		assertEquals("<init>", methodVisitor.getCurrentMethodName());
		
		
		assertEquals("MockMock",  rtcv.getClassName());
		Set<String> crefs = rtcv.getClassReferences();
		assertContains(crefs, Object.class.getName());
		assertEquals(1, crefs.size());
	}
	
	@Test
	public void testFindReferences_100_MockWithEverything() throws Exception {
		//it probably wouln't get to 100
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithEverything.class.getName()));
		ClassReader classReader = new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithEverything.class.getName(), rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Class.class.getName());
		assertContains(classNames, Math.class.getName());
		assertContains(classNames, Object.class.getName());
		
		assertContains(classNames, PrintStream.class.getName());
		assertContains(classNames, String.class.getName());
		assertContains(classNames, StringBuilder.class.getName());
		assertContains(classNames, System.class.getName());
		
		assertContains(classNames, MockI_OtherStringAndLong.class.getName());
		
		assertContains(classNames, MockWithAbstractMethodException.class.getName());
		assertContains(classNames, MockWithAbstractMethodReturn.class.getName());
		assertContains(classNames, MockWithAbstractMethodParam.class.getName());
		
		assertContains(classNames, MockWithEverything.class.getName());
		assertContains(classNames, MockWithEverything.class.getName() + "$1"); 
		assertContains(classNames, MockWithArray.class.getName());
		
		assertContains(classNames, MockWithField.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertContains(classNames, MockWithImportOnlyInMethod.class.getName());
		
		assertContains(classNames, MockWithMethodReturn.class.getName());
		assertContains(classNames, MockWithMethodParams.class.getName());
		assertContains(classNames, MockWithStaticField.class.getName());
		
		assertContains(classNames, MockWithStaticInitalizer.class.getName());
		assertContains(classNames, MockWithBidirectionalA.class.getName());
		assertContains(classNames, MockWithTriangleC.class.getName());
		assertFalse(classNames.contains("."));
		
		assertEquals(25, classNames.size());
		
		in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithEverything.class.getName() + "$1"));
		classReader = new ClassReader(in);
		rtcv.reset();
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithEverything.class.getName() + "$1", rtcv.getClassName());
		classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, Object.class.getName());
		assertContains(classNames, PrintStream.class.getName());
		assertContains(classNames, String.class.getName());
		assertContains(classNames, StringBuilder.class.getName());
		assertContains(classNames, System.class.getName());
		
		assertContains(classNames, MockWithEverything.class.getName()); 
		assertContains(classNames, MockWithEverything.class.getName() + "$1"); 
		assertContains(classNames, MockWithMethodException.class.getName());
		assertContains(classNames, MockException.class.getName());
		
		assertContains(classNames, MockWithMethodExceptionBlock.class.getName());
		assertContains(classNames, MockWithMethodReturn.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertContains(classNames,MockWithStaticField.class.getName());
		assertEquals(13, classNames.size());
	}
	
	@Override
	public int getTests() {
		return 15;
	}

	@Override
	public int getAsserts() {
		return 106;
	}

	@Override
	public int getUniqueAsserts() {
		return 106;
	}

}

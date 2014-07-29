package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.system.I_Tests4J_System;
import org.adligo.tests4j.models.shared.trials.IgnoreTest;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ClassReferencesMutant;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithArray;
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
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

@SourceFileScope (sourceClass=ReferenceTrackingClassVisitor.class, minCoverage=50.0)
public class ReferenceTrackingClassVisitorTrial extends SourceFileCountingTrial {
	ReferenceTrackingClassVisitor rtcv;
	ClassReferencesMutant crm;
	Set<String> names = new HashSet<String>();
	public void beforeTests() {
		if (crm == null) {
			rtcv = new ReferenceTrackingClassVisitor(Opcodes.ASM5, super.getLog());
		}
		crm = rtcv.getClassReferences();
		crm.clearClassNames();
	}
	@Test
	public void testReferenceCounting_01_MockWithNothing() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithNothing.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(1, classNames.size());
	}
	
	@Test
	public void testReferenceCounting_02_MockWithMethodReturn() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodReturn.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		assertEquals(1, classNames.size());
		assertContains(classNames, MockWithMethodReturn.class.getName());
	}
	
	@Test
	public void testReferenceCounting_03_MockWithField() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithField.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		assertEquals(2, classNames.size());
		assertContains(classNames, MockWithField.class.getName());
		assertContains(classNames, I_Tests4J_System.class.getName());
	}
	
	@Test
	public void testReferenceCounting_04_MockWithMethodParams() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodParams.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		assertEquals(1, classNames.size());
		assertContains(classNames, MockWithMethodParams.class.getName());
	}
	
	@Test
	public void testReferenceCounting_05_MockWithImportOnlyInMethod() throws Exception {
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithImportOnlyInMethod.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		assertEquals(2, classNames.size());
		assertContains(classNames, MockWithImportOnlyInMethod.class.getName());
		assertContains(classNames, I_Tests4J_System.class.getName());
	}
	
	
	@Test
	@IgnoreTest
	public void testReferenceCounting_06_MockWithStaticField() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithStaticField.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		assertEquals(1, classNames.size());
		assertContains(classNames, MockWithStaticField.class.getName());
	}
	
	@Test
	public void testReferenceCounting_07_MockWithStaticInitalizer() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithStaticInitalizer.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		
		assertContains(classNames, MockWithStaticInitalizer.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(2, classNames.size());
	}
	
	
	@Test
	public void testReferenceCounting_08_MockWithArray() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithArray.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		
		assertContains(classNames, MockWithArray.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testReferenceCounting_09_MockWithMethodException() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodException.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		
		assertContains(classNames, MockWithMethodException.class.getName());
		assertContains(classNames, MockException.class.getName());
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testReferenceCounting_10_MockWithMethodExceptionBlock() throws Exception {
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithMethodExceptionBlock.class.getName()));
		ClassReader classReader=new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
		
		assertContains(classNames, MockWithMethodExceptionBlock.class.getName());
		assertContains(classNames, MockWithMethodException.class.getName());
		assertContains(classNames, MockException.class.getName());
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testReferenceCounting_80_MockWithEverything() throws Exception {
		//it probably wouln't get to 80
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithEverything.class.getName()));
		ClassReader classReader = new ClassReader(in);
		crm.clearClassNames();
		classReader.accept(rtcv, 0);

		Set<String> classNames =  crm.getClassNames();
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
		assertFalse(classNames.contains("."));
		
		assertEquals(10, classNames.size());
		
		in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassMethods.toResource(MockWithEverything.class.getName() + "$1"));
		classReader = new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertContains(classNames, MockWithEverything.class.getName()); 
		assertContains(classNames, MockWithEverything.class.getName() + "$1"); 
		assertContains(classNames, MockException.class.getName());
		assertContains(classNames, MockWithMethodException.class.getName());
		
		assertContains(classNames, MockWithMethodExceptionBlock.class.getName());
		assertContains(classNames, MockWithMethodReturn.class.getName());
		assertContains(classNames, MockWithNothing.class.getName());
		assertContains(classNames,MockWithStaticField.class.getName());
		assertEquals(8, classNames.size());
	}
	
	@Override
	public int getTests() {
		return 11;
	}

	@Override
	public int getAsserts() {
		return 46;
	}

	@Override
	public int getUniqueAsserts() {
		return 46;
	}

}

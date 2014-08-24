package org.adligo.tests4j_tests.jacoco.plugin.discovery;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassRoutines;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingClassVisitor;
import org.adligo.tests4j_4jacoco.plugin.discovery.ReferenceTrackingMethodVisitor;
import org.adligo.tests4j_4jacoco.plugin.instrumentation.map.MapInstrConstants;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodException;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodParam;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithAbstractMethodReturn;
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

import com.sun.org.apache.regexp.internal.recompile;

@SourceFileScope (sourceClass=ReferenceTrackingClassVisitor.class, minCoverage=36.0)
public class ReferenceTrackingClassVisitorTrial extends SourceFileCountingTrial {
	public static final String PRINT_STREAM = "Ljava/io/PrintStream;";
	
	public static final String CLASS = "Ljava/lang/Class;";
	public static final String OBJ = "Ljava/lang/Object;";
	public static final String MATH = "Ljava/lang/Math;";
	public static final String STRING = "Ljava/lang/String;";
	public static final String STRING_BUILDER = "Ljava/lang/StringBuilder;";
	public static final String SYSTEM = "Ljava/lang/System;";
	
	public static final String I_SYSTEM = "Lorg/adligo/tests4j/models/shared/common/I_System;";
	public static final String M_EXCEPTION = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockException;";
	public static final String M_EXCEPTION_BARE = "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockException";
	
	public static final String MI_OTHER_STRING_AND_LONG = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockI_OtherStringAndLong;";
	
	public static final String MW_ARRAY = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithArray;";
	public static final String MW_BI_A = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithBidirectionalA;";
	
	public static final String MW_EVERYTHING = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithEverything;";
	public static final String MW_EVERYTHING_1 = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithEverything$1;";
	public static final String MW_EXT_B = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithExtensionB;";
	
	public static final String MW_ABS_METHOD_EXCEPTION = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithAbstractMethodException;";
	public static final String MW_ABS_METHOD_PARAM = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithAbstractMethodParam;";
	public static final String MW_ABS_METHOD_RETURN = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithAbstractMethodReturn;";
	
	public static final String MW_FIELD = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithField;";
	
	public static final String MW_IMPORT_ONLY_IN_METHOD = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithImportOnlyInMethod;";
	
	public static final String MW_METHOD_EXCEPTION = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodException;";
	public static final String MW_METHOD_EXCEPTION_BLOCK = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodExceptionBlock;";
	public static final String MW_METHOD_PARAMS = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodParams;";
	
	public static final String MW_METHOD_RETURN = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithMethodReturn;";
	
	public static final String MW_NOTHING = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing;";
	public static final String MW_NOTHING_BARE = "org/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithNothing";
	
	public static final String MW_STATIC_FIELD = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithStaticField;";
	public static final String MW_STATIC_INIT = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithStaticInitalizer;";
	
	public static final String MW_STRING = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithString;";
	public static final String MW_TRI_C = "Lorg/adligo/tests4j_tests/run/helpers/class_loading_mocks/MockWithTriangleC;";
	
	
	ReferenceTrackingClassVisitor rtcv;
	
	Set<String> names = new HashSet<String>();
	
	public void beforeTests() {
		if (rtcv == null) {
			rtcv = new ReferenceTrackingClassVisitor(Opcodes.ASM5, super.getLog());
		}
		rtcv.reset();
	}
	
	@Test
	public void testFindReferences_001_MockWithNothing() throws Exception {
		Class<?> clazz = MockWithNothing.class;
		String className = clazz.getName();
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		assertEquals(className, rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_NOTHING);
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_002_MockWithMethodReturn() throws Exception {
		Class<?> clazz = MockWithMethodReturn.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_METHOD_RETURN);
		assertContains(classNames, MW_NOTHING);
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_003_MockWithField() throws Exception {
		Class<?> clazz = MockWithField.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_FIELD);
		assertContains(classNames, I_SYSTEM);
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_004_MockWithMethodParams() throws Exception {
		Class<?> clazz = MockWithMethodParams.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_METHOD_PARAMS);
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_005_MockWithImportOnlyInMethod() throws Exception {
		Class<?> clazz = MockWithImportOnlyInMethod.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_IMPORT_ONLY_IN_METHOD);
		assertContains(classNames, I_SYSTEM);
		assertEquals(3, classNames.size());
	}
	
	
	@Test
	public void testFindReferences_006_MockWithStaticField() throws Exception {
		Class<?> clazz = MockWithStaticField.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_STATIC_FIELD);
		assertContains(classNames, MW_NOTHING);
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_007_MockWithStaticInitalizer() throws Exception {
		Class<?> clazz = MockWithStaticInitalizer.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_STATIC_INIT);
		assertContains(classNames, MW_NOTHING);
		assertEquals(3, classNames.size());
	}
	

	
	@Test
	public void testFindReferences_008_MockWithArray() throws Exception {
		Class<?> clazz = MockWithArray.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_ARRAY);
		assertContains(classNames, "[" + MW_NOTHING);
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_009_MockWithMethodException() throws Exception {
		Class<?> clazz = MockWithMethodException.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_METHOD_EXCEPTION);
		assertContains(classNames, M_EXCEPTION);
		assertEquals(3, classNames.size());
	}
	
	@Test
	public void testFindReferences_010_MockWithMethodExceptionBlock() throws Exception {
		Class<?> clazz = MockWithMethodExceptionBlock.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_METHOD_EXCEPTION_BLOCK);
		assertContains(classNames, MW_METHOD_EXCEPTION);
		assertContains(classNames, M_EXCEPTION);
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
		Class<?> clazz = MockWithAbstractMethodReturn.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_ABS_METHOD_RETURN);
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
		Class<?> clazz = MockWithAbstractMethodParam.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_ABS_METHOD_PARAM);
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
	public void testFindReferences_013_MockWithAbstractMethodException() throws Exception {
		Class<?> clazz = MockWithAbstractMethodException.class;
		String className = clazz.getName();
		
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader=new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className,  rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		assertContains(classNames, OBJ);
		assertContains(classNames, MW_ABS_METHOD_EXCEPTION);
		assertEquals(2, classNames.size());
	}
	
	@Test
	public void testFindReferences_014_JacocoInitAndData() throws Exception {
		
		rtcv.reset();
		rtcv.visit(51, MapInstrConstants.DATAFIELD_ACC, "MockMock", 
				"", OBJ, new String [] {});
		
		rtcv.visitField(MapInstrConstants.DATAFIELD_ACC, "field1", 
				OBJ, "", null);
		rtcv.visitField(MapInstrConstants.DATAFIELD_ACC, MapInstrConstants.FIELD_NAME, 
				"Ljava/util/Map;", "", null);
		
		ReferenceTrackingMethodVisitor methodVisitor = (ReferenceTrackingMethodVisitor)
				rtcv.visitMethod(MapInstrConstants.DATAFIELD_ACC, "<init>", 
						"", "", new String []{});
		assertEquals("<init>", methodVisitor.getCurrentMethodName());
		
		
		assertEquals("MockMock",  rtcv.getClassName());
		Set<String> crefs = rtcv.getClassReferences();
		assertContains(crefs, OBJ);
		assertEquals(1, crefs.size());
	}
	
	@Test
	public void testFindReferences_100_MockWithEverything() throws Exception {
		Class<?> clazz = MockWithEverything.class;
		String className = clazz.getName();
		
		//it probably wouln't get to 100
		InputStream in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(className));
		ClassReader classReader = new ClassReader(in);
		
		classReader.accept(rtcv, 0);
		
		assertEquals(className, rtcv.getClassName());
		
		Set<String> classNames =  rtcv.getClassReferences();
		
		Set<String> expected = getEverything();
		for (String e: expected) {
			assertContains(classNames, e);
		}
		assertFalse(classNames.contains("."));
		
		Set<String> left = new HashSet<String>(classNames);
		left.removeAll(expected);
		assertEquals(0, left.size());
		
		assertEquals(26, classNames.size());
		assertEquals(classNames.size(), expected.size());
		
		in= ReferenceTrackingClassVisitorTrial.class.getResourceAsStream(
				ClassRoutines.toResource(MockWithEverything.class.getName() + "$1"));
		classReader = new ClassReader(in);
		rtcv.reset();
		classReader.accept(rtcv, 0);
		
		assertEquals(MockWithEverything.class.getName() + "$1", rtcv.getClassName());
		classNames =  rtcv.getClassReferences();
		
		expected = getEverything_1();
		for (String e: expected) {
			assertContains(classNames, e);
		}
		left = new HashSet<String>(classNames);
		left.removeAll(expected);
		assertEquals(0, left.size());
		
		assertEquals(13, classNames.size());
		assertEquals(classNames.size(), expected.size());
		
	}

	private Set<String> getEverything() {
		Set<String> expected = new HashSet<String>();
		expected.add( CLASS);
		expected.add( MATH);
		expected.add( OBJ);
		
		expected.add( PRINT_STREAM);
		expected.add( STRING);
		expected.add( STRING_BUILDER);
		expected.add( SYSTEM);
		
		expected.add( MI_OTHER_STRING_AND_LONG);
		
		expected.add( MW_ABS_METHOD_EXCEPTION);
		expected.add( MW_ABS_METHOD_RETURN);
		expected.add( MW_ABS_METHOD_PARAM);
		
		expected.add( MW_EVERYTHING);
		expected.add( MW_EVERYTHING_1); 
		expected.add( MW_ARRAY);
		
		expected.add( MW_FIELD);
		expected.add( MW_NOTHING);
		expected.add( MW_IMPORT_ONLY_IN_METHOD);
		
		expected.add( MW_METHOD_RETURN);
		expected.add( MW_METHOD_PARAMS);
		expected.add( MW_STATIC_FIELD);
		
		expected.add( MW_STATIC_INIT);
		expected.add( MW_BI_A);
		expected.add( MW_TRI_C);
		expected.add( "D");
		expected.add(MW_EXT_B);
		expected.add(MW_STRING);
		return expected;
	}

	private Set<String> getEverything_1() {
		Set<String> expected = new HashSet<String>();
		expected.add( OBJ);
		expected.add( PRINT_STREAM);
		expected.add( STRING);
		expected.add( STRING_BUILDER);
		expected.add( SYSTEM);
		
		expected.add( MW_EVERYTHING); 
		expected.add( MW_EVERYTHING_1); 
		expected.add( MW_METHOD_EXCEPTION);
		expected.add( M_EXCEPTION);
		
		expected.add( MW_METHOD_EXCEPTION_BLOCK);
		expected.add( MW_METHOD_RETURN);
		expected.add( MW_NOTHING);
		expected.add(MW_STATIC_FIELD);
		return expected;
	}
	
	@Override
	public int getTests() {
		return 15;
	}

	@Override
	public int getAsserts() {
		return 113;
	}

	@Override
	public int getUniqueAsserts() {
		return 110;
	}

}

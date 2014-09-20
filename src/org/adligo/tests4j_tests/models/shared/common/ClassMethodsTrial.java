package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.AllowedDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassMethods.class, minCoverage=87.0)
@AllowedDependencies (groups=Tests4J_Common_DependencyGroup.class)
public class ClassMethodsTrial extends SourceFileCountingTrial {

	private static final String CLASS_METHODS_TYPE = "Lorg/adligo/tests4j/models/shared/common/ClassMethods;";

	@Test
	public void testCreateArrays() {
		assertEquals("", ClassMethods.createArrayChars(0));
		assertEquals("[", ClassMethods.createArrayChars(1));
		assertEquals("[[", ClassMethods.createArrayChars(2));
		assertEquals("[[[", ClassMethods.createArrayChars(3));
		assertEquals("[[[[", ClassMethods.createArrayChars(4));
		assertEquals("[[[[[", ClassMethods.createArrayChars(5));
	}
	
	@Test
	public void testIsSubType() {
		assertTrue(ClassMethods.isSubType(ChildMockClass.class, BaseMockClass.class));
		assertFalse(ClassMethods.isSubType(BaseMockClass.class, ChildMockClass.class));
	}

	@Test
	public void testGetSimpleName() {
		assertEquals("ChildMockClass", ClassMethods.getSimpleName(ChildMockClass.class));
		assertEquals("ClassMethodsTrial", ClassMethods.getSimpleName(this));
	}
	
	@Test
	public void testToNames() {
		
		List<String> names = ClassMethods.toNames(null);
		assertNotNull(names);
		assertEquals(0, names.size());
		
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		clazzes.add(null);
		clazzes.add(ClassMethodsTrial.class);
		
		names = ClassMethods.toNames(clazzes);
		assertNotNull(names);
		assertEquals(1, names.size());
		assertContains(names, ClassMethodsTrial.class.getName());
	}
	
	@Test
	public void testToResource() {
		assertEquals("/org/adligo/tests4j/models/shared/common/ClassMethods.class",
				ClassMethods.toResource(ClassMethods.class.getName()));
		assertEquals("/org/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial.class",
				ClassMethods.toResource(ClassMethodsTrial.class.getName()));
	}
	
	@Test
	public void testFromTypeDescription() {
		
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						ClassMethods.fromTypeDescription(null);
					}
				});
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						ClassMethods.fromTypeDescription("");
					}
				});
		assertEquals(ClassMethods.class.getName(),
				ClassMethods.fromTypeDescription(CLASS_METHODS_TYPE));
		assertEquals(ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		assertEquals("[" + ClassMethods.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j/models/shared/common/ClassMethods;"));
		assertEquals("[" + ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		assertEquals("[" + StackTraceElement.class.getName(),
				ClassMethods.fromTypeDescription("[Ljava/lang/StackTraceElement;"));
		
		
		assertEquals("byte",
				ClassMethods.fromTypeDescription("B"));
		assertEquals("char",
				ClassMethods.fromTypeDescription("C"));
		assertEquals("double",
				ClassMethods.fromTypeDescription("D"));
		assertEquals("float",
				ClassMethods.fromTypeDescription("F"));
		assertEquals("int",
				ClassMethods.fromTypeDescription("I"));
		assertEquals("long",
				ClassMethods.fromTypeDescription("J"));
		assertEquals("short",
				ClassMethods.fromTypeDescription("S"));
		assertEquals("boolean",
				ClassMethods.fromTypeDescription("Z"));
		
		//there could be a lot of ways to make arrays of arrays;
		assertPrimitiveArrays("[");
		assertPrimitiveArrays("[[");
		assertPrimitiveArrays("[[[");
		assertPrimitiveArrays("[[[[");
		assertPrimitiveArrays("[[[[[");
	}

	public void assertPrimitiveArrays(String prefix) {
		//arrays
		assertEquals(prefix + "byte",
				ClassMethods.fromTypeDescription(prefix +"B"));
		assertEquals(prefix + "char",
				ClassMethods.fromTypeDescription(prefix +"C"));
		assertEquals(prefix + "double",
				ClassMethods.fromTypeDescription(prefix +"D"));
		assertEquals(prefix + "float",
				ClassMethods.fromTypeDescription(prefix +"F"));
		assertEquals(prefix + "int",
				ClassMethods.fromTypeDescription(prefix +"I"));
		assertEquals(prefix + "long",
				ClassMethods.fromTypeDescription(prefix +"J"));
		assertEquals(prefix + "short",
				ClassMethods.fromTypeDescription(prefix +"S"));
		assertEquals(prefix + "boolean",
				ClassMethods.fromTypeDescription(prefix +"Z"));
	}
	
	@Test
	public void testGetArrayType() {
			assertGetArrayType("[");
			assertGetArrayType("[[");
			assertGetArrayType("[[[");
			assertGetArrayType("[[[[");
			assertGetArrayType("[[[[[");
	}

	public void assertGetArrayType(String prefix) {
		assertEquals(CLASS_METHODS_TYPE,
				ClassMethods.getArrayType(prefix + CLASS_METHODS_TYPE));
		assertEquals(ClassMethods.BOOLEAN,
				ClassMethods.getArrayType(prefix + ClassMethods.BOOLEAN));
		assertEquals(ClassMethods.BYTE,
				ClassMethods.getArrayType(prefix + ClassMethods.BYTE));
		assertEquals(ClassMethods.class.getName(),
				ClassMethods.getArrayType(prefix + ClassMethods.class.getName()));
	}
	
	@Test
	public void testCountArrays() {
		assertGetArrays(0, "");
		assertGetArrays(1, "[");
		assertGetArrays(2, "[[");
		assertGetArrays(3, "[[[");
		assertGetArrays(4, "[[[[");
		assertGetArrays(5, "[[[[[");
	}
	
	public void assertGetArrays(int count, String prefix) {
		assertEquals(count,
				ClassMethods.getArrays(prefix + CLASS_METHODS_TYPE));
		assertEquals(count,
				ClassMethods.getArrays(prefix + ClassMethods.BOOLEAN));
		assertEquals(count,
				ClassMethods.getArrays(prefix + ClassMethods.BYTE));
		assertEquals(count,
				ClassMethods.getArrays(prefix + ClassMethods.class.getName()));
	}
	
	
	
	@Test
	public void testIsClassOrArray() {
		assertTrue(ClassMethods.isClass('L'));
		assertFalse(ClassMethods.isClass('['));
		assertFalse(ClassMethods.isClass('B'));
		
		assertTrue(ClassMethods.isArray('['));
		assertFalse(ClassMethods.isArray(']'));
		assertFalse(ClassMethods.isArray('B'));
	}
	
	@Test
	public void testIsPrimitive() {
		assertTrue(ClassMethods.isPrimitiveClassChar('B'));
		assertTrue(ClassMethods.isPrimitiveClassChar('C'));
		assertTrue(ClassMethods.isPrimitiveClassChar('D'));
		assertTrue(ClassMethods.isPrimitiveClassChar('F'));
		
		assertTrue(ClassMethods.isPrimitiveClassChar('I'));
		assertTrue(ClassMethods.isPrimitiveClassChar('J'));
		assertTrue(ClassMethods.isPrimitiveClassChar('S'));
		assertTrue(ClassMethods.isPrimitiveClassChar('Z'));
		
		assertFalse(ClassMethods.isPrimitiveClassChar('L'));
		assertFalse(ClassMethods.isPrimitiveClassChar('['));
	}
	
	@Test
	public void testIsClass() {
		assertTrue(ClassMethods.isClass('L'));
		assertFalse(ClassMethods.isClass('C'));
	}
	
	@Test
	public void testGetPrimitive() {
		assertEquals("byte", ClassMethods.getPrimitive('B'));
		assertEquals("char",ClassMethods.getPrimitive('C'));
		assertEquals("double", ClassMethods.getPrimitive('D'));
		assertEquals("float", ClassMethods.getPrimitive('F'));
		
		assertEquals("int", ClassMethods.getPrimitive('I'));
		assertEquals("long", ClassMethods.getPrimitive('J'));
		assertEquals("short", ClassMethods.getPrimitive('S'));
		assertEquals("boolean", ClassMethods.getPrimitive('Z'));
		
		assertNull(ClassMethods.getPrimitive('L'));
		assertNull(ClassMethods.getPrimitive('['));
	}
	
	@Test
	public void testGetSourceFileName() {
		List<String> umList = Collections.unmodifiableList(new ArrayList<String>());
		assertEquals("java.util.Collections", 
				ClassMethods.getSourceClassName(
						umList.getClass().getName()
				));
		assertEquals("java.util.Collections", 
				ClassMethods.getSourceClassName(
					Collections.class.getName()
				));
	}
	
	@Test
	public void testPackageName() {
		List<String> umList = Collections.unmodifiableList(new ArrayList<String>());
		
		assertEquals("java.util", 
				ClassMethods.getPackageName(
						umList.getClass().getName()
				));
		assertEquals("java.util", 
				ClassMethods.getPackageName(
					Collections.class.getName()
				));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 14);
	}
	
	@Override
	public int getAsserts(I_CountType type) {
		int tests = 148;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,tests + 3);
		} else {
			return super.getAsserts(type, tests);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int utests = 99;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, utests + 3);
		} else {
			return super.getUniqueAsserts(type, utests);
		}
	}
}

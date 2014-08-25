package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassMethods.class, minCoverage=84.0)
public class ClassMethodsTrial extends SourceFileCountingTrial {

	@Test
	public void testIsSubType() {
		assertTrue(ClassMethods.isSubType(ChildMockClass.class, BaseMockClass.class));
		assertFalse(ClassMethods.isSubType(BaseMockClass.class, ChildMockClass.class));
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
				ClassMethods.fromTypeDescription("Lorg/adligo/tests4j/models/shared/common/ClassMethods;"));
		assertEquals(ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		assertEquals(ClassMethods.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j/models/shared/common/ClassMethods;"));
		assertEquals(ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		
		assertEquals(Byte.class.getName(),
				ClassMethods.fromTypeDescription("B"));
		assertEquals(Character.class.getName(),
				ClassMethods.fromTypeDescription("C"));
		assertEquals(Double.class.getName(),
				ClassMethods.fromTypeDescription("D"));
		assertEquals(Float.class.getName(),
				ClassMethods.fromTypeDescription("F"));
		assertEquals(Integer.class.getName(),
				ClassMethods.fromTypeDescription("I"));
		assertEquals(Long.class.getName(),
				ClassMethods.fromTypeDescription("J"));
		assertEquals(Short.class.getName(),
				ClassMethods.fromTypeDescription("S"));
		assertEquals(Boolean.class.getName(),
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
		assertEquals(Byte.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"B"));
		assertEquals(Character.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"C"));
		assertEquals(Double.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"D"));
		assertEquals(Float.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"F"));
		assertEquals(Integer.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"I"));
		assertEquals(Long.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"J"));
		assertEquals(Short.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"S"));
		assertEquals(Boolean.class.getName(),
				ClassMethods.fromTypeDescription(prefix +"Z"));
	}
	
	@Test
	public void testIsClassOrArray() {
		assertTrue(ClassMethods.isClass('L'));
		assertFalse(ClassMethods.isClass('['));
		assertTrue(ClassMethods.isArray('['));
		assertFalse(ClassMethods.isArray(']'));
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
	}
	
	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 75;
	}

	@Override
	public int getUniqueAsserts() {
		return 24;
	}
	
}

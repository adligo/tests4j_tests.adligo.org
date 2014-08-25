package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.ClassRoutines;
import org.adligo.tests4j.models.shared.common.StringRoutines;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassRoutines.class, minCoverage=84.0)
public class ClassRoutinesTrial extends SourceFileCountingTrial {

	@Test
	public void testIsSubType() {
		assertTrue(ClassRoutines.isSubType(ChildMockClass.class, BaseMockClass.class));
		assertFalse(ClassRoutines.isSubType(BaseMockClass.class, ChildMockClass.class));
	}

	@Test
	public void testToNames() {
		
		List<String> names = ClassRoutines.toNames(null);
		assertNotNull(names);
		assertEquals(0, names.size());
		
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		clazzes.add(null);
		clazzes.add(ClassRoutinesTrial.class);
		
		names = ClassRoutines.toNames(clazzes);
		assertNotNull(names);
		assertEquals(1, names.size());
		assertContains(names, ClassRoutinesTrial.class.getName());
	}
	
	@Test
	public void testToResource() {
		assertEquals("/org/adligo/tests4j/models/shared/common/ClassRoutines.class",
				ClassRoutines.toResource(ClassRoutines.class.getName()));
		assertEquals("/org/adligo/tests4j_tests/models/shared/common/ClassRoutinesTrial.class",
				ClassRoutines.toResource(ClassRoutinesTrial.class.getName()));
	}
	
	@Test
	public void testFromTypeDescription() {
		
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						ClassRoutines.fromTypeDescription(null);
					}
				});
		assertThrown(new ExpectedThrownData(IllegalArgumentException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						ClassRoutines.fromTypeDescription("");
					}
				});
		assertEquals(ClassRoutines.class.getName(),
				ClassRoutines.fromTypeDescription("Lorg/adligo/tests4j/models/shared/common/ClassRoutines;"));
		assertEquals(ClassRoutinesTrial.class.getName(),
				ClassRoutines.fromTypeDescription("Lorg/adligo/tests4j_tests/models/shared/common/ClassRoutinesTrial;"));
		assertEquals(ClassRoutines.class.getName(),
				ClassRoutines.fromTypeDescription("[Lorg/adligo/tests4j/models/shared/common/ClassRoutines;"));
		assertEquals(ClassRoutinesTrial.class.getName(),
				ClassRoutines.fromTypeDescription("[Lorg/adligo/tests4j_tests/models/shared/common/ClassRoutinesTrial;"));
		
		assertEquals(Byte.class.getName(),
				ClassRoutines.fromTypeDescription("B"));
		assertEquals(Character.class.getName(),
				ClassRoutines.fromTypeDescription("C"));
		assertEquals(Double.class.getName(),
				ClassRoutines.fromTypeDescription("D"));
		assertEquals(Float.class.getName(),
				ClassRoutines.fromTypeDescription("F"));
		assertEquals(Integer.class.getName(),
				ClassRoutines.fromTypeDescription("I"));
		assertEquals(Long.class.getName(),
				ClassRoutines.fromTypeDescription("J"));
		assertEquals(Short.class.getName(),
				ClassRoutines.fromTypeDescription("S"));
		assertEquals(Boolean.class.getName(),
				ClassRoutines.fromTypeDescription("Z"));
		
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
				ClassRoutines.fromTypeDescription(prefix +"B"));
		assertEquals(Character.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"C"));
		assertEquals(Double.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"D"));
		assertEquals(Float.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"F"));
		assertEquals(Integer.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"I"));
		assertEquals(Long.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"J"));
		assertEquals(Short.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"S"));
		assertEquals(Boolean.class.getName(),
				ClassRoutines.fromTypeDescription(prefix +"Z"));
	}
	
	@Test
	public void testIsClassOrArray() {
		assertTrue(ClassRoutines.isClass('L'));
		assertFalse(ClassRoutines.isClass('['));
		assertTrue(ClassRoutines.isArray('['));
		assertFalse(ClassRoutines.isArray(']'));
	}
	
	@Test
	public void testIsPrimitive() {
		assertTrue(ClassRoutines.isPrimitiveClassChar('B'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('C'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('D'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('F'));
		
		assertTrue(ClassRoutines.isPrimitiveClassChar('I'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('J'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('S'));
		assertTrue(ClassRoutines.isPrimitiveClassChar('Z'));
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

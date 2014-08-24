package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.common.ClassRoutines;
import org.adligo.tests4j.models.shared.common.StringRoutines;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassRoutines.class, minCoverage=92.0)
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
		assertEquals(ClassRoutines.class.getName(),
				ClassRoutines.fromTypeDescription("Lorg/adligo/tests4j/models/shared/common/ClassRoutines;"));
		assertEquals(ClassRoutinesTrial.class.getName(),
				ClassRoutines.fromTypeDescription("Lorg/adligo/tests4j_tests/models/shared/common/ClassRoutinesTrial;"));
		assertEquals(ClassRoutines.class.getName(),
				ClassRoutines.fromTypeDescription("[Lorg/adligo/tests4j/models/shared/common/ClassRoutines;"));
		assertEquals(ClassRoutinesTrial.class.getName(),
				ClassRoutines.fromTypeDescription("[Lorg/adligo/tests4j_tests/models/shared/common/ClassRoutinesTrial;"));
		
		assertEquals("",
				ClassRoutines.fromTypeDescription(null));
		assertEquals("",
				ClassRoutines.fromTypeDescription(""));
		assertEquals("1",
				ClassRoutines.fromTypeDescription("1"));
		assertEquals("12",
				ClassRoutines.fromTypeDescription("12"));
	}
	
	@Override
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 17;
	}

	@Override
	public int getUniqueAsserts() {
		return 14;
	}
	
}

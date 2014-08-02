package org.adligo.tests4j_tests.models.shared.common;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.common.mocks.BaseMockClass;
import org.adligo.tests4j_tests.models.shared.common.mocks.ChildMockClass;

@SourceFileScope (sourceClass=ClassMethods.class, minCoverage=92.0)
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
		assertEquals(ClassMethods.class.getName(),
				ClassMethods.fromTypeDescription("Lorg/adligo/tests4j/models/shared/common/ClassMethods;"));
		assertEquals(ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		assertEquals(ClassMethods.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j/models/shared/common/ClassMethods;"));
		assertEquals(ClassMethodsTrial.class.getName(),
				ClassMethods.fromTypeDescription("[Lorg/adligo/tests4j_tests/models/shared/common/ClassMethodsTrial;"));
		
		assertEquals("",
				ClassMethods.fromTypeDescription(null));
		assertEquals("",
				ClassMethods.fromTypeDescription(""));
		assertEquals("1",
				ClassMethods.fromTypeDescription("1"));
		assertEquals("12",
				ClassMethods.fromTypeDescription("12"));
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

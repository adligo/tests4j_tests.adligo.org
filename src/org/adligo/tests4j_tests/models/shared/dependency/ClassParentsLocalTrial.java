package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.List;

import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.CircularDependencies;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=ClassParentsLocal.class, minCoverage=80.0,
	allowedCircularDependencies=CircularDependencies.AllowInPackage)
public class ClassParentsLocalTrial extends SourceFileCountingTrial {
	
	
	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassParentsLocal((Class<?>) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassParentsLocal(new ClassParentsLocalNullMock());
					}
				});
	}
	



	@Test
	public void testCopyConstructor() throws Exception {
		ClassParentsLocal cpm = new ClassParentsLocal(Object.class);
		assertSimpleObject(cpm);
	
		ClassParentsLocalMutant cpmC = new ClassParentsLocalMutant(Class.class);
		cpmC.addParent(cpm);
		ClassParentsLocal cpmC2 = new ClassParentsLocal(cpmC);
		assertSimpleClass(cpmC2);
		
		ClassParentsLocalMutant cpmN = new ClassParentsLocalMutant(MockWithNothing.class);
		cpmN.addParent(cpm);
		ClassParentsLocal cpmN2 = new ClassParentsLocal(cpmN);
		assertMockWithNothing(cpmN2);
		
		ClassParentsLocalMutant cpmA = new ClassParentsLocalMutant(MockWithExtensionA.class);
		cpmA.addParent(cpm);
		cpmA.addParent(cpmN);
		ClassParentsLocal cpmA2 = new ClassParentsLocal(cpmA);
		assertMockWithExtensionA(cpmA2);
	}
	
	private void assertSimpleObject(I_ClassParentsLocal cpm) {
		assertEquals(Object.class, cpm.getTarget());
		assertEquals(Object.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		assertEquals("java.util.Collections$EmptyList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
		assertEquals("java.util.Collections$EmptyList", parentNames.getClass().getName());
	}
	
	private void assertSimpleClass(I_ClassParentsLocal cpm) {
		assertEquals(Class.class, cpm.getTarget());
		assertEquals(Class.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		I_ClassParents parent = parents.get(0);
		assertNotNull(parents);
		assertSimpleObject((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		assertEquals(1, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(1, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	private void assertMockWithNothing(I_ClassParentsLocal cpm) {
		assertEquals(MockWithNothing.class, cpm.getTarget());
		assertEquals(MockWithNothing.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		I_ClassParents parent = parents.get(0);
		assertNotNull(parents);
		assertSimpleObject((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		assertEquals(1, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(1, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	private void assertMockWithExtensionA(I_ClassParentsLocal cpm) {
		assertEquals(MockWithExtensionA.class, cpm.getTarget());
		assertEquals(MockWithExtensionA.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		I_ClassParents parent = parents.get(0);
		assertSimpleObject((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		parent = parents.get(1);
		assertMockWithNothing((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(MockWithNothing.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	@Test
	public void testAdvancedUsage() throws Exception {
		ClassParentsLocalMutant cpm = new ClassParentsLocalMutant(Object.class);
		
		ClassParentsLocal cpmIGL = new ClassParentsLocal(MockI_GetLong.class);
		assertMockI_GetLong(cpmIGL);
		
		ClassParentsLocal cpmISL = new ClassParentsLocal(MockI_SetLong.class);
		assertMockI_SetLong(cpmISL);
		
		ClassParentsLocalMutant cpmGSL = new ClassParentsLocalMutant(MockI_GetAndSetLong.class);
		cpmGSL.addParent(cpmIGL);
		cpmGSL.addParent(cpmISL);
		ClassParentsLocal cpmGSL2 = new ClassParentsLocal(cpmGSL);
		assertMockI_GetAndSetLong(cpmGSL2);
		
		cpm.addParent(cpmGSL);
		ClassParentsLocal cpm2 = new ClassParentsLocal(cpm);
		assertObjectMockI_GetAndSetLongInterface(cpm2);
	}
	
	private void assertMockI_GetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_GetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		assertEquals("java.util.Collections$EmptyList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
		assertEquals("java.util.Collections$EmptyList", parentNames.getClass().getName());
	}
	
	private void assertMockI_SetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_SetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		assertEquals("java.util.Collections$EmptyList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
		assertEquals("java.util.Collections$EmptyList", parentNames.getClass().getName());
	}
	
	private void assertMockI_GetAndSetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_GetAndSetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParentsLocal> parents = cpm.getParentsLocal();
		assertNotNull(parents);
		assertMockI_GetLong(parents.get(0));
		assertMockI_SetLong(parents.get(1));
		assertEquals(2, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	
	private void assertObjectMockI_GetAndSetLongInterface(I_ClassParentsLocal cpm) {
		Class<?> clazz = Object.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertMockI_GetLong((I_ClassParentsLocal) parents.get(0));
		assertMockI_SetLong((I_ClassParentsLocal) parents.get(1));
		assertMockI_GetAndSetLong((I_ClassParentsLocal) parents.get(2));
		assertEquals(3, parents.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parents.getClass().getName());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(MockI_GetAndSetLong.class.getName(), parentNames.get(2));
		assertEquals(3, parentNames.size());
		assertEquals("java.util.Collections$UnmodifiableRandomAccessList", parentNames.getClass().getName());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 179;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 35;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

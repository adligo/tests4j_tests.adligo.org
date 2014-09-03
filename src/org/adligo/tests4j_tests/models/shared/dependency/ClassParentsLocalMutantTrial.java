package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.dependency.ClassAlias;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetAndSetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_GetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockI_SetLong;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithExtensionA;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=ClassParentsLocalMutant.class, minCoverage=60.0)
public class ClassParentsLocalMutantTrial extends SourceFileCountingTrial {
	
	
	@Test
	public void testConstructorExceptions() throws Exception {
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassParentsLocalMutant((Class<?>) null);
					}
				});
		assertThrown(new ExpectedThrownData(
				NullPointerException.class),
				new I_Thrower() {
					
					@Override
					public void run() throws Throwable {
						new ClassParentsLocalMutant(new ClassParentsLocalNullMock());
					}
				});
	}
	
	@Test
	public void testBasicUsage() throws Exception {
		ClassParentsLocalMutant cpm = new ClassParentsLocalMutant(Object.class);
		assertSimpleObject(cpm);
		
		ClassParentsLocalMutant cpmC = new ClassParentsLocalMutant(Class.class);
		cpmC.addParent(cpm);
		assertSimpleClass(cpmC);
		
		ClassParentsLocalMutant cpmN = new ClassParentsLocalMutant(MockWithNothing.class);
		cpmN.addParent(cpm);
		assertMockWithNothing(cpmN);
		
		ClassParentsLocalMutant cpmA = new ClassParentsLocalMutant(MockWithExtensionA.class);
		cpmA.addParent(cpm);
		cpmA.addParent(cpmN);
		assertMockWithExtensionA(cpmA);
	}


	@Test
	public void testCopyConstructor() throws Exception {
		ClassParentsLocalMutant cpm = new ClassParentsLocalMutant(Object.class);
		ClassParentsLocalMutant cpm2 = new ClassParentsLocalMutant(cpm);
		assertSimpleObject(cpm2);
	
		ClassParentsLocalMutant cpmC = new ClassParentsLocalMutant(Class.class);
		cpmC.addParent(cpm);
		ClassParentsLocalMutant cpmC2 = new ClassParentsLocalMutant(cpmC);
		assertSimpleClass(cpmC2);
		
		ClassParentsLocalMutant cpmN = new ClassParentsLocalMutant(MockWithNothing.class);
		cpmN.addParent(cpm);
		ClassParentsLocalMutant cpmN2 = new ClassParentsLocalMutant(cpmN);
		assertMockWithNothing(cpmN2);
		
		ClassParentsLocalMutant cpmA = new ClassParentsLocalMutant(MockWithExtensionA.class);
		cpmA.addParent(cpm);
		cpmA.addParent(cpmN);
		ClassParentsLocalMutant cpmA2 = new ClassParentsLocalMutant(cpmA);
		assertMockWithExtensionA(cpmA2);
	}
	
	@Test
	public void testEncapsulation() throws Exception {
		ClassParentsLocalMutant cpm = new ClassParentsLocalMutant(Object.class);
		ClassParentsLocalMutant cpm2 = new ClassParentsLocalMutant(cpm);
		assertSimpleObject(cpm2);
	
		ClassParentsLocalMutant cpmC = new ClassParentsLocalMutant(Class.class);
		cpmC.addParent(cpm);
		ClassParentsLocalMutant cpmC2 = new ClassParentsLocalMutant(cpmC);
		assertSimpleClass(cpmC2);
		
		ClassParentsLocalMutant cpmN = new ClassParentsLocalMutant(MockWithNothing.class);
		
		cpmC.addParent(cpmN);
		List<I_ClassParents> parents =  cpmC.getParents();
		assertEquals(2, parents.size());
		
		parents =  cpmC2.getParents();
		assertEquals(1, parents.size());
		
		
	}
	
	

	private void assertSimpleObject(I_ClassParentsLocal cpm) {
		assertEquals(Object.class, cpm.getTarget());
		assertEquals(Object.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
	}
	
	private void assertSimpleClass(I_ClassParentsLocal cpm) {
		assertEquals(Class.class, cpm.getTarget());
		assertEquals(Class.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		I_ClassParents parent = parents.get(0);
		assertSimpleObject((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		assertEquals(1, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(1, parentNames.size());
	}
	
	private void assertMockWithNothing(I_ClassParentsLocal cpm) {
		assertEquals(MockWithNothing.class, cpm.getTarget());
		assertEquals(MockWithNothing.class.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		I_ClassParents parent = parents.get(0);
		assertSimpleObject((I_ClassParentsLocal) parent);
		assertEquals(ClassParentsLocal.class.getName(), parent.getClass().getName());
		assertEquals(1, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(1, parentNames.size());
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
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(Object.class.getName(), parentNames.get(0));
		assertEquals(MockWithNothing.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
	}
	
	@Test
	public void testAdvancedUsage() throws Exception {
		ClassParentsLocalMutant cpm = new ClassParentsLocalMutant(Object.class);
		assertSimpleObject(cpm);
		
		ClassParentsLocalMutant cpmIGL = new ClassParentsLocalMutant(MockI_GetLong.class);
		assertMockI_GetLong(cpmIGL);
		
		ClassParentsLocalMutant cpmISL = new ClassParentsLocalMutant(MockI_SetLong.class);
		assertMockI_SetLong(cpmISL);
		
		ClassParentsLocalMutant cpmGSL = new ClassParentsLocalMutant(MockI_GetAndSetLong.class);
		cpmGSL.addParent(cpmIGL);
		cpmGSL.addParent(cpmISL);
		assertMockI_GetAndSetLong(cpmGSL);
		
		cpm.addParent(cpmGSL);
		assertObjectMockI_GetAndSetLongInterface(cpm);
	}
	
	private void assertMockI_GetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_GetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
	}
	
	private void assertMockI_SetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_SetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertEquals(0, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(0, parentNames.size());
	}
	
	private void assertMockI_GetAndSetLong(I_ClassParentsLocal cpm) {
		Class<?> clazz = MockI_GetAndSetLong.class;
		assertEquals(clazz, cpm.getTarget());
		assertEquals(clazz.getName(), cpm.getName());
		List<I_ClassParents> parents = cpm.getParents();
		assertNotNull(parents);
		assertMockI_GetLong((I_ClassParentsLocal) parents.get(0));
		assertMockI_SetLong((I_ClassParentsLocal) parents.get(1));
		assertEquals(2, parents.size());
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(2, parentNames.size());
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
		
		List<String> parentNames = cpm.getParentNames();
		assertNotNull(parentNames);
		assertEquals(MockI_GetLong.class.getName(), parentNames.get(0));
		assertEquals(MockI_SetLong.class.getName(), parentNames.get(1));
		assertEquals(MockI_GetAndSetLong.class.getName(), parentNames.get(2));
		assertEquals(3, parentNames.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 231;
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
		int thisUniqueAsserts = 56;
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

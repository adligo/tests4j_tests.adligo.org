package org.adligo.tests4j_tests.shared.asserts.dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.ClassAttributesMutant;
import org.adligo.tests4j.shared.asserts.dependency.DependencyGroup;
import org.adligo.tests4j.shared.asserts.dependency.DependencyGroupMutant;
import org.adligo.tests4j.shared.asserts.dependency.FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.dependency.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.dependency.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.dependency.MethodSignature;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_AssertsDependency_DependencyGroup;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Dependency_DependencyGroup;

@SourceFileScope (sourceClass=DependencyGroup.class, minCoverage=74.0)
@AllowedDependencies (groups=Tests4J_AssertsDependency_DependencyGroup.class)
public class DependencyGroupTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultConstructorMutators() {
		DependencyGroupMutant dgm = new DependencyGroupMutant();
		
		Set<String> names = dgm.getClassNames();
		assertEquals(0, names.size());
		List<I_ClassAttributes> cas = dgm.getClassAttributes();
		assertEquals(0, cas.size());
		
		ClassAttributesMutant cam = new ClassAttributesMutant();
		cam.setName("foo");
		List<I_FieldSignature> fields = new ArrayList<I_FieldSignature>();
		fields.add(new FieldSignature("name", "fclazz"));
		cam.setFields(fields);
		
		List<I_MethodSignature> methods = new ArrayList<I_MethodSignature>();
		methods.add(new MethodSignature("name"));
		cam.setMethods(methods);
		
		dgm.addClassMethods(cam);
		
		assertBasic(new DependencyGroup(dgm));
		dgm = new DependencyGroupMutant();
		dgm.setClassMethods(Collections.singletonList(cam));
		assertBasic(new DependencyGroup(dgm));
	}


	public void assertBasic(DependencyGroup dgm) {
		
		assertFalse(dgm.isInGroup("foo"));
		assertBasicMethod(dgm);
		assertBasicField(dgm);
	}
	

	public void assertBasicMethod(DependencyGroup dgm) {
		
		Set<I_MethodSignature> ms = dgm.getMethods("foo");
		assertContains(ms, new MethodSignature("name"));
		assertEquals(1, ms.size());
		
		assertTrue(dgm.isInGroup("foo",new MethodSignature("name")));
	}
	
	public void assertBasicField(DependencyGroup dgm) {
		Set<I_FieldSignature> fs = dgm.getFields("foo");
		assertContains(fs, new FieldSignature("name", "fclazz"));
		assertEquals(1, fs.size());
		
		assertFalse(dgm.isInGroup("foo"));
		assertTrue(dgm.isInGroup("foo",new FieldSignature("name", "fclazz")));
	}
	
	@Test
	public void testCopyConstructor() {
		DependencyGroupMutant dgm = new DependencyGroupMutant();
		
		Set<String> names = dgm.getClassNames();
		assertEquals(0, names.size());
		List<I_ClassAttributes> cas = dgm.getClassAttributes();
		assertEquals(0, cas.size());
		
		ClassAttributesMutant cam = new ClassAttributesMutant();
		cam.setName("foo");
		List<I_FieldSignature> fields = new ArrayList<I_FieldSignature>();
		fields.add(new FieldSignature("name", "fclazz"));
		cam.setFields(fields);
		
		List<I_MethodSignature> methods = new ArrayList<I_MethodSignature>();
		methods.add(new MethodSignature("name"));
		cam.setMethods(methods);
		
		dgm.addClassMethods(cam);
		dgm = new DependencyGroupMutant(dgm);
		
		assertBasic(new DependencyGroup(dgm));
	}
	
	
	@Test
	public void testIntersection() {
		DependencyGroupMutant dgm = new DependencyGroupMutant();
		
		Set<String> names = dgm.getClassNames();
		assertEquals(0, names.size());
		List<I_ClassAttributes> cas = dgm.getClassAttributes();
		assertEquals(0, cas.size());
		
		ClassAttributesMutant cam = new ClassAttributesMutant();
		cam.setName("foo");
		List<I_FieldSignature> fields = new ArrayList<I_FieldSignature>();
		fields.add(new FieldSignature("name", "fclazz"));
		cam.setFields(fields);
		
		List<I_MethodSignature> methods = new ArrayList<I_MethodSignature>();
		methods.add(new MethodSignature("name"));
		cam.setMethods(methods);
		
		dgm.addClassMethods(cam);
		assertBasic(new DependencyGroup(dgm));
		
		dgm.intersect(dgm);
		assertBasic(new DependencyGroup(dgm));
		
		DependencyGroupMutant dgm2 = new DependencyGroupMutant();
		
		
		ClassAttributesMutant cam2 = new ClassAttributesMutant();
		cam2.setName("foo");
		List<I_FieldSignature> fields2 = new ArrayList<I_FieldSignature>();
		fields2.add(new FieldSignature("name", "fclazz"));
		cam2.setFields(fields2);
		
		dgm2.addClassMethods(cam2);
		assertBasicField(new DependencyGroup(dgm2));
		dgm.intersect(dgm2);
		assertBasicField(new DependencyGroup(dgm2));
		assertBasicField(new DependencyGroup(dgm));
		Set<I_MethodSignature> dgmMethods = dgm.getMethods("foo");
		assertEquals(0, dgmMethods.size());
		
		DependencyGroupMutant dgm3 = new DependencyGroupMutant();
		ClassAttributesMutant cam3 = new ClassAttributesMutant();
		cam3.setName("foo");
		dgm3.addClassMethods(cam3);
		dgm.intersect(dgm3);
		dgmMethods = dgm.getMethods("foo");
		assertEquals(0, dgmMethods.size());
		
		Set<I_FieldSignature> dgmFields = dgm.getFields("foo");
		assertEquals(0, dgmFields.size());
		
		List<I_ClassAttributes> cas3 = dgm.getClassAttributes();
		assertEquals("foo",cas3.get(0).getName());
		assertEquals(1, cas3.size());
		
		DependencyGroupMutant dgm4 = new DependencyGroupMutant();
		dgm.intersect(dgm4);
		List<I_ClassAttributes> cas4 = dgm.getClassAttributes();
		assertEquals(0, cas4.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 64;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 19;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}
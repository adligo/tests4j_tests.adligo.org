package org.adligo.tests4j_tests.shared.asserts.reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.ClassAttributesMutant;
import org.adligo.tests4j.shared.asserts.reference.FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroup;
import org.adligo.tests4j.shared.asserts.reference.ReferenceGroupMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsReference_GwtReferenceGroup;

@SourceFileScope (sourceClass=ReferenceGroup.class, minCoverage=74.0)
@AllowedReferences (groups=Tests4J_AssertsReference_GwtReferenceGroup.class)
public class ReferenceGroupTrial extends SourceFileCountingTrial {

	@Test
	public void testDefaultConstructorMutators() {
		ReferenceGroupMutant dgm = new ReferenceGroupMutant();
		
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
		
		assertBasic(new ReferenceGroup(dgm));
		dgm = new ReferenceGroupMutant();
		dgm.setClassMethods(Collections.singletonList(cam));
		assertBasic(new ReferenceGroup(dgm));
	}


	public void assertBasic(ReferenceGroup dgm) {
		
		assertTrue(dgm.isInGroup("foo"));
		assertBasicMethod(dgm);
		assertBasicField(dgm);
	}
	

	public void assertBasicMethod(ReferenceGroup dgm) {
		
		Set<I_MethodSignature> ms = dgm.getMethods("foo");
		assertContains(ms, new MethodSignature("name"));
		assertEquals(1, ms.size());
		
		assertTrue(dgm.isInGroup("foo",new MethodSignature("name")));
	}
	
	public void assertBasicField(ReferenceGroup dgm) {
		Set<I_FieldSignature> fs = dgm.getFields("foo");
		assertContains(fs, new FieldSignature("name", "fclazz"));
		assertEquals(1, fs.size());
		
		assertTrue(dgm.isInGroup("foo"));
		assertTrue(dgm.isInGroup("foo",new FieldSignature("name", "fclazz")));
	}
	
	@Test
	public void testCopyConstructor() {
		ReferenceGroupMutant dgm = new ReferenceGroupMutant();
		
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
		dgm = new ReferenceGroupMutant(dgm);
		
		assertBasic(new ReferenceGroup(dgm));
	}
	
	
	@Test
	public void testIntersection() {
		ReferenceGroupMutant dgm = new ReferenceGroupMutant();
		
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
		assertBasic(new ReferenceGroup(dgm));
		
		dgm.intersect(dgm);
		assertBasic(new ReferenceGroup(dgm));
		
		ReferenceGroupMutant dgm2 = new ReferenceGroupMutant();
		
		
		ClassAttributesMutant cam2 = new ClassAttributesMutant();
		cam2.setName("foo");
		List<I_FieldSignature> fields2 = new ArrayList<I_FieldSignature>();
		fields2.add(new FieldSignature("name", "fclazz"));
		cam2.setFields(fields2);
		
		dgm2.addClassMethods(cam2);
		assertBasicField(new ReferenceGroup(dgm2));
		dgm.intersect(dgm2);
		assertBasicField(new ReferenceGroup(dgm2));
		assertBasicField(new ReferenceGroup(dgm));
		Set<I_MethodSignature> dgmMethods = dgm.getMethods("foo");
		assertEquals(0, dgmMethods.size());
		
		ReferenceGroupMutant dgm3 = new ReferenceGroupMutant();
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
		
		ReferenceGroupMutant dgm4 = new ReferenceGroupMutant();
		dgm.intersect(dgm4);
		List<I_ClassAttributes> cas4 = dgm.getClassAttributes();
		assertEquals(0, cas4.size());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
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
		int thisUniqueAsserts = 16;
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

package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.I_JavaPackageNode;
import org.adligo.tests4j.run.common.JavaPackageNodeMutant;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author scott
 * 
 */
@SourceFileScope (sourceClass=JavaPackageNodeMutant.class, minCoverage=100.0)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class JavaPackageNodeMutantTrial extends SourceFileCountingTrial {
  
  @SuppressWarnings("boxing")
  @Test 
  public void testConstructorGettersAndSetters() throws Exception {
    JavaPackageNodeMutant jpnm = new JavaPackageNodeMutant();
    assertNull(jpnm.getName());
    jpnm = new JavaPackageNodeMutant("hey");
    assertEquals("hey", jpnm.getName());
    jpnm.setName("foo");
    assertEquals("foo", jpnm.getName());
    
    JavaPackageNodeMutant jpnmA = new JavaPackageNodeMutant("hey.a");
    JavaPackageNodeMutant jpnmB = new JavaPackageNodeMutant("hey.b");
    List<JavaPackageNodeMutant> nodeList = new ArrayList<JavaPackageNodeMutant>();
    nodeList.add(jpnmA);
    nodeList.add(jpnmB);
    
    jpnm.setChildNodes(nodeList);
    List<I_JavaPackageNode> nodes = jpnm.getChildNodes();
    I_JavaPackageNode za = nodes.get(0);
    assertNotNull(za);
    assertEquals("hey.a", za.getName());
    I_JavaPackageNode zb = nodes.get(1);
    assertNotNull(zb);
    assertEquals("hey.b", zb.getName());
    assertEquals(2, nodes.size());
    
    jpnm.setChildNodes(null);
    nodeList = new ArrayList<JavaPackageNodeMutant>();
    assertEquals(0, nodeList.size());
    
    Set<String> classNames = new HashSet<String>();
    classNames.add("c");
    classNames.add("d");
    jpnm.setClassNames(classNames);
    
    List<String> names = jpnm.getClassNames();
    assertContains(names, "c");
    assertContains(names, "d");
    assertEquals(2, names.size());
    assertEquals(2, jpnm.countClasses());
    
    jpnm.setClassNames(null);
    classNames = new HashSet<String>();
    assertEquals(0, classNames.size());
    assertEquals(0, jpnm.countClasses());
  }
  
  
  @SuppressWarnings("boxing")
  @Test 
  public void testParentChildClassCount() throws Exception {
    JavaPackageNodeMutant jpnm = new JavaPackageNodeMutant();
    assertNull(jpnm.getName());
    jpnm = new JavaPackageNodeMutant("hey");
    jpnm.setClassNames(Collections.singleton("1"));
    JavaPackageNodeMutant jpnmA = new JavaPackageNodeMutant("hey.a");
    List<String> classNames = new ArrayList<String>();
    classNames.add("3");
    classNames.add("4");
    jpnmA.setClassNames(classNames);
    
    JavaPackageNodeMutant jpnmB = new JavaPackageNodeMutant("hey.b");
    List<String> classNames2 = new ArrayList<String>();
    classNames2.add("5");
    classNames2.add("6");
    classNames2.add("7");
    jpnmB.setClassNames(classNames2);
    
    List<JavaPackageNodeMutant> nodeList = new ArrayList<JavaPackageNodeMutant>();
    nodeList.add(jpnmA);
    nodeList.add(jpnmB);
    
    jpnm.setChildNodes(nodeList);
    assertEquals(6, jpnm.countClasses());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 17;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 13;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}

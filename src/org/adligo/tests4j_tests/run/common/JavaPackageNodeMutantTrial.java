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
    jpnm.setClassName(classNames);
    
    List<String> names = jpnm.getClassNames();
    assertContains(names, "c");
    assertContains(names, "d");
    assertEquals(2, names.size());
    
    jpnm.setClassName(null);
    classNames = new HashSet<String>();
    assertEquals(0, classNames.size());
  }
  
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 13;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 11;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}

package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.I_JavaPackageNode;
import org.adligo.tests4j.run.common.JavaTree;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.I_FieldMock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.sub.MockWithPkgBidirctionalB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author scott
 * 
 */
@SourceFileScope (sourceClass=JavaTree.class, minCoverage=87.0, 
allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class JavaTreeTrial extends SourceFileCountingTrial {
  
  @SuppressWarnings("boxing")
  @Test 
  public void testSimpleSinglePackageParams() throws Exception {
    JavaTree jt = new JavaTree(Collections.singleton("org.adligo.tests4j"));
    List<I_JavaPackageNode> nodes = jt.getNodes();
    assertEquals(1, nodes.size());
    I_JavaPackageNode node = nodes.get(0);
    assertEquals("org.adligo.tests4j", node.getName());
    assertEquals(0, node.getChildNodes().size());
    assertEquals(0, node.getClassNames().size());
  }
  
  @SuppressWarnings("boxing")
  @Test 
  public void testSimpleSingleClassParams() throws Exception {
    JavaTree jt = new JavaTree(Collections.singleton(I_FieldMock.class.getName()));
    List<I_JavaPackageNode> nodes = jt.getNodes();
    assertEquals(1, nodes.size());
    I_JavaPackageNode node = nodes.get(0);
    assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks", node.getName());
    assertEquals(0, node.getChildNodes().size());
    List<String> classNames = node.getClassNames();
    assertEquals(1, classNames.size());
    assertContains(classNames, "I_FieldMock");
  }
  
  
  @SuppressWarnings("boxing")
  @Test 
  public void testComplex4UniquePackageParams() throws Exception {
    List<String> filters = new ArrayList<String>();
    filters.add("org.adligo.tests4j.asserts.common");
    filters.add("org.adligo.tests4j.asserts.line_text");
    filters.add("org.adligo.tests4j.asserts.reference");
    filters.add("org.adligo.tests4j.asserts.uniform");
    JavaTree jt = new JavaTree(filters);
    List<I_JavaPackageNode> nodes = jt.getNodes();
    
    Set<String> names = new HashSet<String>();
    names.add(verifyNoChildren(nodes.get(0)).getName());
    names.add(verifyNoChildren(nodes.get(1)).getName());
    names.add(verifyNoChildren(nodes.get(2)).getName());
    names.add(verifyNoChildren(nodes.get(3)).getName());
    
    assertContains(names, "org.adligo.tests4j.asserts.common");
    assertContains(names, "org.adligo.tests4j.asserts.line_text");
    assertContains(names, "org.adligo.tests4j.asserts.reference");
    assertContains(names, "org.adligo.tests4j.asserts.uniform");
   
    assertEquals(4, nodes.size());
  }
  
  @SuppressWarnings("boxing")
  @Test 
  public void testComplexAllTypesParams() throws Exception {
    List<String> filters = new ArrayList<String>();
    filters.add(I_FieldMock.class.getName());
    filters.add(MockWithPkgBidirctionalB.class.getName());
    filters.add("org.adligo.tests4j.asserts");
    filters.add("org.adligo.tests4j.asserts.common");
    filters.add("org.adligo.tests4j.asserts.line_text");
    filters.add("org.adligo.tests4j.asserts.reference");
    filters.add("org.adligo.tests4j.asserts.uniform");
    JavaTree jt = new JavaTree(filters);
    List<I_JavaPackageNode> nodes = jt.getNodes();
    
    I_JavaPackageNode node = nodes.get(0);
    assertNotNull(node);
    assertEquals("org.adligo.tests4j.asserts",node.getName());
    assertEquals(0, node.getClassNames().size());
    List<I_JavaPackageNode> node1children = node.getChildNodes();
    verifySimplePackageNode(node1children.get(0), "common");
    verifySimplePackageNode(node1children.get(1), "line_text");
    verifySimplePackageNode(node1children.get(2), "reference");
    verifySimplePackageNode(node1children.get(3), "uniform");
    
    node = nodes.get(1);
    assertNotNull(node);
    assertEquals("org.adligo.tests4j_tests.run.helpers.class_loading_mocks", node.getName());
    List<String> classNames = node.getClassNames();
    assertContains(classNames, "I_FieldMock");
    List<I_JavaPackageNode> node0children = node.getChildNodes();
    I_JavaPackageNode child0 = node0children.get(0);
    assertNotNull(child0);
    assertEquals("sub", child0.getName());
    List<String> child0classes = child0.getClassNames();
    assertContains(child0classes, "MockWithPkgBidirctionalB");
    assertEquals(1, child0classes.size());
    
    assertEquals(2, nodes.size());
  }

  @SuppressWarnings("boxing")
  public void verifySimplePackageNode(I_JavaPackageNode child1a, String name) {
    verifyNoChildren(child1a);
    assertEquals(name, child1a.getName());
  }
  
  @SuppressWarnings("boxing")
  public I_JavaPackageNode verifyNoChildren(I_JavaPackageNode child1a) {
    assertNotNull(child1a);
    assertEquals(0, child1a.getClassNames().size());
    assertEquals(0, child1a.getChildNodes().size());
    return child1a;
  }
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 53;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type, asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uAsserts = 36;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, uAsserts+ 3);
		} else {
			return super.getUniqueAsserts(type, uAsserts);
		}
	}
}

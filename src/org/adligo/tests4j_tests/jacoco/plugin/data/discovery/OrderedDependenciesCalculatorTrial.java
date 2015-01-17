package org.adligo.tests4j_tests.jacoco.plugin.data.discovery;

import org.adligo.tests4j.models.shared.association.ClassAssociationsLocalMutant;
import org.adligo.tests4j.models.shared.association.ClassParentsLocal;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.shared.asserts.reference.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_Dependency;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedDependenciesCalculator;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

@SourceFileScope (sourceClass=OrderedDependenciesCalculator.class,minCoverage=96.0)
public class OrderedDependenciesCalculatorTrial extends SourceFileCountingTrial {
  private static final Runnable RA = new Runnable() {
    
    @Override
    public void run() {
    }
  };
  private static final Runnable RA2 = new Runnable() {
    
    @Override
    public void run() {
    }
  };
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodCountSimpleSingle() {
    OrderedDependenciesCalculator odc = new OrderedDependenciesCalculator();
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    
    ClassAssociationsLocalMutant mut = new ClassAssociationsLocalMutant(String.class);
    mut.addDependency(new ClassParentsLocal(Long.class));
    refMap.put(new ClassAliasLocal(RA.getClass()), mut);
    String name = String.class.getName();
    TreeSet<I_Dependency> deps = odc.count(name, refMap);
    
    Iterator<I_Dependency> dit = deps.iterator();
    I_Dependency dep = dit.next();
    I_ClassAlias ca = dep.getAlias();
    assertEquals(Long.class.getName(), ca.getName());
    assertEquals(1, dep.getReferences());
    assertEquals(1, deps.size());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodCountSimpleDouble() {
    OrderedDependenciesCalculator odc = new OrderedDependenciesCalculator();
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    
    ClassAssociationsLocalMutant mut = new ClassAssociationsLocalMutant(String.class);
    mut.addDependency(new ClassParentsLocal(Long.class));
    mut.addDependency(new ClassParentsLocal(RA2.getClass()));
    refMap.put(new ClassAliasLocal(RA.getClass()), mut);
    String name = String.class.getName();
    TreeSet<I_Dependency> deps = odc.count(name, refMap);
    
    Iterator<I_Dependency> dit = deps.iterator();
    I_Dependency dep = dit.next();
    I_ClassAlias ca = dep.getAlias();
    assertEquals(Long.class.getName(), ca.getName());
    assertEquals(1, dep.getReferences());
    
    
    dep = dit.next();
    ca = dep.getAlias();
    assertEquals(RA2.getClass().getName(), ca.getName());
    assertEquals(1, dep.getReferences());
    assertEquals(2, deps.size());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodCountSimpleDoubleSingle() {
    OrderedDependenciesCalculator odc = new OrderedDependenciesCalculator();
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    
    ClassAssociationsLocalMutant mut = new ClassAssociationsLocalMutant(String.class);
    mut.addDependency(new ClassParentsLocal(Long.class));
    mut.addDependency(new ClassParentsLocal(RA2.getClass()));
    refMap.put(new ClassAliasLocal(RA.getClass()), mut);
    
    ClassAssociationsLocalMutant mut2 = new ClassAssociationsLocalMutant(RA2.getClass());
    mut2.addDependency(new ClassParentsLocal(Long.class));
    refMap.put(new ClassAliasLocal(RA2.getClass()), mut2);
    String name = String.class.getName();
    TreeSet<I_Dependency> deps = odc.count(name, refMap);
    
    Iterator<I_Dependency> dit = deps.iterator();
    I_Dependency dep = dit.next();
    I_ClassAlias ca = dep.getAlias();
    assertEquals(Long.class.getName(), ca.getName());
    assertEquals(2, dep.getReferences());
    
    
    dep = dit.next();
    ca = dep.getAlias();
    assertEquals(RA2.getClass().getName(), ca.getName());
    assertEquals(1, dep.getReferences());
    assertEquals(2, deps.size());
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 13;
		//code coverage and circular dependencies 
		int thisAfterAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 10;
		//code coverage and circular dependencies 
		int thisAfterUniqueAsserts = 2;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies 
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

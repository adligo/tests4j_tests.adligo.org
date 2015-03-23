package org.adligo.tests4j_tests.jacoco.plugin.data.discovery;

import org.adligo.tests4j.models.shared.association.ClassAssociationsLocalMutant;
import org.adligo.tests4j.models.shared.association.ClassParentsLocalMutant;
import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.run.helpers.I_ClassFilter;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.DependencyMutant;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_Dependency;
import org.adligo.tests4j.shared.en.Tests4J_CoveragePluginMessages;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_Constants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ReportMessages;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4jacoco.plugin.discovery.OrderedReferenceCalculator;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@SourceFileScope (sourceClass=OrderedReferenceCalculator.class,minCoverage=83.0)
public class OrderedReferenceCalculatorTrial extends SourceFileCountingTrial {

  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrowable(NullPointerException.class),
				new I_Thrower() {
					
					
          @Override
					public void run() {
						new OrderedReferenceCalculator(null, null, null, null, null);
					}
				});
		assertThrown(new ExpectedThrowable(NullPointerException.class),
        new I_Thrower() {
          
          
          @Override
          public void run() {
            new OrderedReferenceCalculator(mock(I_ClassFilter.class), null, null, null, null);
          }
        });
		assertThrown(new ExpectedThrowable(NullPointerException.class),
        new I_Thrower() {
          
          
          @Override
          public void run() {
            HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
                HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
            new OrderedReferenceCalculator(mock(I_ClassFilter.class), null,  null,
                null, null);
          }
        });
		assertThrown(new ExpectedThrowable(NullPointerException.class),
        new I_Thrower() {
          
          
          @Override
          public void run() {
            HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
                HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
            new OrderedReferenceCalculator(mock(I_ClassFilter.class), mock(I_Tests4J_Log.class), 
                Tests4J_EnglishConstants.ENGLISH,
                null, null);
          }
        });
		assertThrown(new ExpectedThrowable(NullPointerException.class),
        new I_Thrower() {
          
          
          @Override
          public void run() {
            HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
                HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
            new OrderedReferenceCalculator(mock(I_ClassFilter.class), mock(I_Tests4J_Log.class), 
                Tests4J_EnglishConstants.ENGLISH,
                refMap, null);
          }
        });
	}
	
  @Test
  public void testMethodCalculateThree() {
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    when(logMock.lineSeparator()).thenReturn("\n");

    Map<String,Set<String>> lastMissing = new HashMap<String,Set<String>>();
    lastMissing.put(Long.class.getName(), Collections.singleton("haa"));
    Set<String> intVals = new HashSet<String>();
    intVals.add("haa");
    intVals.add("hin");
    lastMissing.put(Integer.class.getName(), intVals);
    
    OrderedReferenceCalculator calculator = new OrderedReferenceCalculator(mock(I_ClassFilter.class), 
        logMock, Tests4J_EnglishConstants.ENGLISH, refMap, String.class);
    
    TreeSet<I_Dependency> deps = new TreeSet<I_Dependency>();
    addDependency(deps, refMap, Long.class, 3);
    addDependency(deps, refMap, Integer.class, 2);
    addDependency(deps, refMap, Short.class, 1);
    
    
    List<String> depOrder = calculator.calculateOrder(deps);
    assertEquals(Long.class.getName(), depOrder.get(0));
    assertEquals(Integer.class.getName(), depOrder.get(1));
    assertEquals(Short.class.getName(), depOrder.get(2));
  }
  
  private void addDependency(TreeSet<I_Dependency> deps, 
      HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap, Class<?> clazz, int count) {
    DependencyMutant dm = new DependencyMutant();
    dm.setAlias(new ClassParentsLocalMutant(clazz));
    refMap.put( (I_ClassAliasLocal) dm.getAlias(), new ClassAssociationsLocalMutant(clazz));
    for (int i = 0; i < count; i++) {
      dm.addReference();
    }
    deps.add(dm);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodCalculateThreeFiltered() {
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    when(logMock.lineSeparator()).thenReturn("\n");

    Map<String,Set<String>> lastMissing = new HashMap<String,Set<String>>();
    lastMissing.put(Long.class.getName(), Collections.singleton("haa"));
    Set<String> intVals = new HashSet<String>();
    intVals.add("haa");
    intVals.add("hin");
    lastMissing.put(Integer.class.getName(), intVals);
    
    I_ClassFilter filter = mock(I_ClassFilter.class);
    when(filter.isFiltered(any(String.class))).thenReturn(true);
    when(filter.isFiltered(any(Class.class))).thenReturn(true);
    
    OrderedReferenceCalculator calculator = new OrderedReferenceCalculator(filter, 
        logMock, Tests4J_EnglishConstants.ENGLISH, refMap, String.class);
    
    TreeSet<I_Dependency> deps = new TreeSet<I_Dependency>();
    addDependency(deps, refMap, Long.class, 3);
    addDependency(deps, refMap, Integer.class, 2);
    addDependency(deps, refMap, Short.class, 1);
    
    
    List<String> depOrder = calculator.calculateOrder(deps);
    assertEquals(Long.class.getName(), depOrder.get(0));
    assertEquals(Integer.class.getName(), depOrder.get(1));
    assertEquals(Short.class.getName(), depOrder.get(2));
  }
  
  @Test
  public void testMethodCalculateFiveParent() {
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    when(logMock.lineSeparator()).thenReturn("\n");

    Map<String,Set<String>> lastMissing = new HashMap<String,Set<String>>();
    lastMissing.put(Long.class.getName(), Collections.singleton("haa"));
    Set<String> intVals = new HashSet<String>();
    intVals.add("haa");
    intVals.add("hin");
    lastMissing.put(Integer.class.getName(), intVals);
    
    OrderedReferenceCalculator calculator = new OrderedReferenceCalculator(mock(I_ClassFilter.class), 
        logMock, Tests4J_EnglishConstants.ENGLISH, refMap, String.class);
    
    TreeSet<I_Dependency> deps = new TreeSet<I_Dependency>();
    addDependency(deps, refMap, Long.class, 3);
    addDependency(deps, refMap, Integer.class, 2);
    addDependency(deps, refMap, Short.class, 1);
    
    
    DependencyMutant dm = new DependencyMutant();
    ClassParentsLocalMutant cp = new ClassParentsLocalMutant(Boolean.class);
    cp.addParent(new ClassParentsLocalMutant(String.class));
    dm.setAlias(cp);
    refMap.put( (I_ClassAliasLocal) dm.getAlias(), new ClassAssociationsLocalMutant(Boolean.class));
    dm.addReference();
    deps.add(dm);
    
    dm = new DependencyMutant();
    cp = new ClassParentsLocalMutant(String.class);
    cp.addParent(new ClassParentsLocalMutant(Integer.class));
    dm.setAlias(cp);
    refMap.put( (I_ClassAliasLocal) dm.getAlias(), new ClassAssociationsLocalMutant(String.class));
    dm.addReference();
    deps.add(dm);
    
    List<String> depOrder = calculator.calculateOrder(deps);
    assertEquals(Long.class.getName(), depOrder.get(0));
    assertEquals(Integer.class.getName(), depOrder.get(1));
    assertEquals(String.class.getName(), depOrder.get(2));
    assertEquals(Short.class.getName(), depOrder.get(3));
    assertEquals(Boolean.class.getName(), depOrder.get(4));
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodCalculateFiveParentFiltered() {
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    when(logMock.lineSeparator()).thenReturn("\n");

    Map<String,Set<String>> lastMissing = new HashMap<String,Set<String>>();
    lastMissing.put(Long.class.getName(), Collections.singleton("haa"));
    Set<String> intVals = new HashSet<String>();
    intVals.add("haa");
    intVals.add("hin");
    lastMissing.put(Integer.class.getName(), intVals);
    
    I_ClassFilter filter = mock(I_ClassFilter.class);
    when(filter.isFiltered(any(String.class))).thenReturn(true);
    when(filter.isFiltered(any(Class.class))).thenReturn(true);
    
    OrderedReferenceCalculator calculator = new OrderedReferenceCalculator(filter, 
        logMock, Tests4J_EnglishConstants.ENGLISH, refMap, String.class);
    
    TreeSet<I_Dependency> deps = new TreeSet<I_Dependency>();
    addDependency(deps, refMap, Long.class, 3);
    addDependency(deps, refMap, Integer.class, 2);
    addDependency(deps, refMap, Short.class, 1);
    
    
    DependencyMutant dm = new DependencyMutant();
    ClassParentsLocalMutant cp = new ClassParentsLocalMutant(Boolean.class);
    cp.addParent(new ClassParentsLocalMutant(String.class));
    dm.setAlias(cp);
    refMap.put( (I_ClassAliasLocal) dm.getAlias(), new ClassAssociationsLocalMutant(Boolean.class));
    dm.addReference();
    deps.add(dm);
    
    dm = new DependencyMutant();
    cp = new ClassParentsLocalMutant(String.class);
    cp.addParent(new ClassParentsLocalMutant(Integer.class));
    dm.setAlias(cp);
    refMap.put( (I_ClassAliasLocal) dm.getAlias(), new ClassAssociationsLocalMutant(String.class));
    dm.addReference();
    deps.add(dm);
    
    List<String> depOrder = calculator.calculateOrder(deps);
    assertEquals(Long.class.getName(), depOrder.get(0));
    assertEquals(Integer.class.getName(), depOrder.get(1));
    assertEquals(String.class.getName(), depOrder.get(2));
    assertEquals(Short.class.getName(), depOrder.get(3));
    assertEquals(Boolean.class.getName(), depOrder.get(4));  
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testMethodThrowUnableToCalculateOrderException() {
    HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal> refMap = new
        HashMap<I_ClassAliasLocal, I_ClassAssociationsLocal>();
    I_Tests4J_Log logMock = mock(I_Tests4J_Log.class);
    when(logMock.lineSeparator()).thenReturn("\n");
    
    
    DependencyMutant dm = new DependencyMutant();
    dm.setAlias(new ClassAliasLocal(Long.class));
    
    DependencyMutant dm2 = new DependencyMutant();
    dm2.setAlias(new ClassAliasLocal(Integer.class));
    
    Set<I_Dependency> deps = new HashSet<I_Dependency>();
    deps.add(dm);
    deps.add(dm2);
    
    Map<String,Set<String>> lastMissing = new HashMap<String,Set<String>>();
    lastMissing.put(Long.class.getName(), Collections.singleton("haa"));
    Set<String> intVals = new HashSet<String>();
    intVals.add("haa");
    intVals.add("hin");
    lastMissing.put(Integer.class.getName(), intVals);
    
    OrderedReferenceCalculator calculator = new OrderedReferenceCalculator(mock(I_ClassFilter.class), 
        logMock, Tests4J_EnglishConstants.ENGLISH, refMap, String.class);
    
    assertThrown(new ExpectedThrowable(new IllegalStateException(
      "Unable to find dependency order for the following class;\n" +
      "java.lang.String\n" +
      "The dependencies are as follows;\n" +
      "\t[ahh]\n" +
      "\tThe following dependencies could NOT be ordered;\n" +
      "\tjava.lang.Integer   [haa, hin]\n" +
      "\tjava.lang.Long   [haa]\n" +
      "\tThe following dependencies were ordered successfully;\n" +
      "\t[hey]\n")), new I_Thrower() {
      
      @Override
      public void run() throws Throwable {
        calculator.throwUnableToCalculateOrderException(Collections.singletonList("hey"), 
            deps, lastMissing, Collections.singleton("ahh"));
      }
    });
    when(logMock.lineSeparator()).thenReturn("\r");
    I_Tests4J_Constants constants = mock(I_Tests4J_Constants.class);
    when(constants.isLeftToRight()).thenReturn(false);
    I_Tests4J_ReportMessages reportMessages = mock(I_Tests4J_ReportMessages.class);
    when(reportMessages.getIndent()).thenReturn(" ");
    when(constants.getReportMessages()).thenReturn(reportMessages);
    when(constants.getCoveragePluginMessages()).thenReturn(Tests4J_CoveragePluginMessages.INSTANCE);
    
    OrderedReferenceCalculator calculator2 = new OrderedReferenceCalculator(mock(I_ClassFilter.class), 
        logMock, constants, refMap, String.class);
    
    assertThrown(new ExpectedThrowable(new IllegalStateException(
        "Unable to find dependency order for the following class;\r" +
        "java.lang.String\r" +
        "The dependencies are as follows;\r" +
        "[ahh] \r" +
        "The following dependencies could NOT be ordered; \r" +
        "[haa, hin]   java.lang.Integer \r" +
        "[haa]   java.lang.Long \r" +
        "The following dependencies were ordered successfully; \r" +
        "[hey] \r")), new I_Thrower() {
        
        @Override
        public void run() throws Throwable {
          calculator2.throwUnableToCalculateOrderException(Collections.singletonList("hey"), 
              deps, lastMissing, Collections.singleton("ahh"));
        }
      });
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 23;
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
		int thisUniqueAsserts = 23;
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

package org.adligo.tests4j_tests.mockito;

import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.ArgMap;
import org.adligo.tests4j_4mockito.I_ReturnFactory;
import org.adligo.tests4j_4mockito.ObjParams;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=ArgMap.class, minCoverage=22.0)
public class ArgMapTrial extends SourceFileCountingTrial {

  @SuppressWarnings("boxing")
	@Test
	public void testConstructorsNoArgt() {
	  ArgMap<String> map = new ArgMap<String>();
    assertNull(map.getVar(1));
    
	}

	@SuppressWarnings("boxing")
  @Test
  public void testConstructorsDefault() {
    ArgMap<String> map = new ArgMap<String>("hmm");
    assertEquals("hmm",map.getVar(1));
    assertEquals("hmm",map.getVar(2));
    assertEquals("hmm",map.getVar(3));
  }
	
	@SuppressWarnings("boxing")
	@Test
  public void testConstructorsFactory() {
    ArgMap<String> map = new ArgMap<String>(new I_ReturnFactory<String>() {

      @Override
      public String create(Object[] keys) {
        return "1" + keys[0];
      }
    });
    String resultOne = map.getVar(1);
    assertEquals("11", resultOne);
    assertSame(resultOne, map.getVar(1));
    
    String resultTwo = map.getVar(2);
    assertEquals("12", resultTwo);
    assertSame(resultTwo, map.getVar(2));
    
    String resultThree = map.getVar(3);
    assertEquals("13", resultThree);
    assertSame(resultThree, map.getVar(3));
  }
	
	@SuppressWarnings("boxing")
	@Test
  public void testConstructorsFactoryAndDefault() {
     ArgMap<String> map = new ArgMap<String>("hey", new I_ReturnFactory<String>() {

       @Override
       public String create(Object[] keys) {
         return "1" + keys[0];
       }
     });
     assertEquals("11", map.getVar(1));
     
   }
	
	@SuppressWarnings("boxing")
	@Test
	public void testPutAndGet() {
	   ArgMap<String> map = new ArgMap<String>();
	   Object [] a = new Object[] {1};
	   map.put(a, "1");
	   assertEquals("1", map.get(a));
	   assertEquals("1", map.get(new ObjParams(a)));
	   assertEquals("1", map.getVar(1));
	   Object o = a;
	   assertEquals("1", map.get(o));
	   
	   a = new Object[] {1,2};
	   map.put(new ObjParams(a), "12");
	   assertEquals("12", map.get(a));
     assertEquals("12", map.get(new ObjParams(a)));
     assertEquals("12", map.getVar(1,2));
     o = a;
     assertEquals("12", map.get(o));
     
     a = new Object[] {1,2, 3};
     map.putVal("value", 1, 2,3);
     assertEquals("value", map.get(a));
     assertEquals("value", map.get(new ObjParams(a)));
     assertEquals("value", map.getVar(1,2,3));
     o = a;
     assertEquals("value", map.get(o));
	}
	
	@SuppressWarnings("boxing")
	@Test
	public void testEqualsHashCode_AndToString() {
	  ObjParams a = new ObjParams(new Object[]{"ObjectA"});
	  ObjParams a1 = new ObjParams(new Object[]{"ObjectA"});
	  ObjParams b = new ObjParams(new Object[]{"ObjectB"});
	  ObjParams b1 = new ObjParams(new Object[]{"ObjectA","ObjectB"});
	  ObjParams c = new ObjParams(new Object[]{"ObjectA","ObjectC"});
	  
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		assertEquals("ObjParams [delegate_=[ObjectA]]", a.toString());
		
		assertEquals(a, a1);
    assertEquals(a.hashCode(), a1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA]]", a1.toString());
    
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		assertEquals("ObjParams [delegate_=[ObjectB]]", b.toString());
		
		assertNotEquals(a, b1);
    assertNotEquals(a.hashCode(), b1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA, ObjectB]]", b1.toString());
    
    assertNotEquals(b1, a);
    assertNotEquals(b1.hashCode(), a.hashCode());
    
    assertNotEquals(c, b1);
    assertNotEquals(c.hashCode(), b1.hashCode());
    assertEquals("ObjParams [delegate_=[ObjectA, ObjectC]]", c.toString());
    
    assertNotEquals(b1, c);
    assertNotEquals(b1.hashCode(), c.hashCode());
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 6, false);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 42;
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
		int thisUniqueAsserts = 22;
		//code coverage and circular dependencies 
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


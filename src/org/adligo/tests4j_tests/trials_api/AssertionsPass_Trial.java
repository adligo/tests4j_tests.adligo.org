package org.adligo.tests4j_tests.trials_api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.results.I_ApiTrialResult;
import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.ApiCountingTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertContainsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertFalseWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleDoubleWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleFloatWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleIntWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleLongWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertGreaterThanOrEqualsDoubleShortWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotEqualsWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformNoEvaluatorWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNotUniformWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertNullWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertSameWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownUniformWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertThrownWithMessageFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsMessageTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertTrueFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformFailsTrial;
import org.adligo.tests4j_tests.trials_api.assert_fails_trials.AssertUniformWithMessageFailsTrial;

@PackageScope (packageName = "org.adligo.tests4j")
public class AssertionsPass_Trial extends ApiCountingTrial {

	@Test
	public void testContains() {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		
		assertContains(set, "a");
		assertContains("testing assertContains", set, "a");
		assertContains(set, "b");
		assertContains("testing assertContains", set, "b");
	}
	
	@Test
	public void testGreaterThanOrEquals() {
		//doubles
		assertGreaterThanOrEquals(0.0, 0.0);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 0.0);
		assertGreaterThanOrEquals(0.0, 0.01);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 0.01);
		
		//floats
		assertGreaterThanOrEquals(0.0, (float) 0.0);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, (float) 0.0);
		assertGreaterThanOrEquals(0.0,(float)  0.01);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, (float) 0.01);
				
		//ints
		assertGreaterThanOrEquals(0.0, 0);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 0);
		assertGreaterThanOrEquals(0.0, 1);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 1);
		
		//longs
		assertGreaterThanOrEquals(0.0, 0L);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 0L);
		assertGreaterThanOrEquals(0.0, 1L);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, 1L);
		
		//shorts
		assertGreaterThanOrEquals(0.0, (short) 0);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, (short) 0);
		assertGreaterThanOrEquals(0.0,(short) 1);
		assertGreaterThanOrEquals("testing assertGreaterThanOrEquals", 0.0, (short) 1);
						
	}
	
	@Test
	public void testTrueFalse() {
		assertTrue(true);
		
		assertTrue("it's true", true);
		assertFalse(false);
		assertFalse("it's false", false);
		
	}
	
	@Test
	public void testEquals() {
		assertEquals(new BigDecimal("0.00"), new BigDecimal("0.00"));
		assertEquals("testing equals", new BigDecimal("0.00"), new BigDecimal("0.00"));
		
		assertEquals(new BigInteger("0"), new BigInteger("0"));
		assertEquals("testing equals",new BigInteger("0"), new BigInteger("0"));
		
		assertEquals(1, 1);
		assertEquals("testing equals",1, 1);
		assertEquals(1L, 1L);
		assertEquals("testing equals",1L, 1L);
		assertEquals((short) 1,(short) 1);
		assertEquals("testing equals",(short) 1,(short) 1);
		assertEquals(0.1, 0.1);
		assertEquals("testing equals",0.1, 0.1);
		assertEquals((float) 0.1,(float) 0.1);
		assertEquals("testing equals",(float) 0.1,(float) 0.1);
		
		assertEquals("a", "a");
		assertEquals("testing equals","a","a");
		assertEquals((byte) 1, (byte) 1);
		assertEquals("testing equals", (byte) 1, (byte) 1);
		
	}
	
	@Test
	public void testNotEquals() {
		assertNotEquals(new BigDecimal("0.00"), new BigDecimal("0.01"));
		assertNotEquals("testing not equals",new BigDecimal("0.00"), new BigDecimal("0.01"));
		
		assertNotEquals(new BigInteger("0"), new BigInteger("2"));
		assertNotEquals("testing not equals",new BigInteger("0"), new BigInteger("2"));
		assertNotEquals(1, 2);
		assertNotEquals("testing not equals",1, 2);
		assertNotEquals(1L, 2L);
		assertNotEquals("testing not equals",1L, 2L);
		assertNotEquals((short) 1,(short) 2);
		assertNotEquals("testing not equals",(short) 1,(short) 2);
		assertNotEquals(0.1, 1.1);
		assertNotEquals("testing not equals",0.1, 1.1);
		assertNotEquals((float) 0.1,(float) 0.2);
		assertNotEquals("testing not equals",(float) 0.1,(float) 0.2);
		
		assertNotEquals("a", "b");
		assertNotEquals("testing not equals","a","b");
		assertNotEquals((byte) 1, (byte)2);
		assertNotEquals("testing not equals", (byte) 1, (byte) 2);
	}
	
	@Test
	public void testSame() {
		Object a = new Object();
		assertSame(a, a);
		assertSame("testing same", a, a);
		
	}
	
	@Test
	public void testNotSame() {
		Object a = new Object();
		Object b = new Object();
		assertNotSame(a, b);
		assertNotSame("testing not same", a, b);
		
		assertNotSame(b, a);
		assertNotSame("testing not same", b, a);
	}
	
	@Test
	public void testNull() {
		assertNull(null);
		assertNull("testing assertNull", null);
	}
	
	@Test
	public void testNotNull() {
		assertNotNull(1);
		assertNotNull("testing assertNotNull",1);
	}
	
	@Test
	public void testNotUniform() {
		assertNotUniform("a","b");
		assertNotUniform("testing assertNotUniform","a","b");
	}
	
	
	@Test
	public void testThrown() {
		assertThrown(new ExpectedThrownData(new IllegalStateException("exception message")), new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("exception message");
			}
		}) ;
	}
	
	
	@Test
	public void testThrownUniform() {
		assertThrownUniform(new ExpectedThrownData(new IllegalStateException("exception message\nline2")), 
			new I_Thrower() {
			
			@Override
			public void run() {
				throw new IllegalStateException("exception message\rline2");
			}
		}) ;
	}
	
	@Test
	public void testUniform() {
		assertUniform("a","a");
		assertUniform("testing assertUniform","a","a");
		
		assertUniform("a\nb","a\r\nb");
		assertUniform("testing assertUniform","a\nb","a\r\nb");
		
		assertUniform("a\r\nb","a\r\nb");
		assertUniform("testing assertUniform","a\r\nb","a\r\nb");
		
		assertUniform("a\r\nb","a\rb");
		assertUniform("testing assertUniform","a\r\nb","a\rb");
		
		assertUniform("a\rb","a\nb");
		assertUniform("testing assertUniform","a\rb","a\nb");
	}
	
	
	@Override
	public void afterTrialTests(I_ApiTrialResult p) {
		assertCounts(p);
		if (p.hasRecordedCoverage()) {
			I_PackageCoverage coverage = p.getPackageCoverage();
			//TODO this should be something not zero
			assertGreaterThanOrEquals(0.0, coverage.getPercentageCoveredDouble());
		}
	}
	

	@Override
	public int getTests() {
		return 13;
	}

	@Override
	public int getAsserts() {
		return 88;
	}

	@Override
	public int getUniqueAsserts() {
		return 56;
	}
}

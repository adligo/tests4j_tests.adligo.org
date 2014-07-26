package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.IdenticalStringAssertCommand;
import org.adligo.tests4j.models.shared.asserts.StringCompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.en.Tests4J_AssertionResultMessages;
import org.adligo.tests4j.models.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.models.shared.i18n.I_Tests4J_AssertionInputMessages;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=IdenticalStringAssertCommand.class, minCoverage=80.0)
public class IdenticalStringAssertCommandTrial extends SourceFileCountingTrial {
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				IdenticalStringAssertCommand.BAD_TYPE)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new IdenticalStringAssertCommand(AssertType.AssertTrue , "exceptionMessage",
								new CompareAssertionData<String>("hey", "you"));
					}
				});
		
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new IdenticalStringAssertCommand(AssertType.AssertEquals , "exceptionMessage",
								new CompareAssertionData<String>(null, "you"));
					}
				});
	}
	
	@Test
	public void testConstructorAndGetters() {
		IdenticalStringAssertCommand cmd = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		assertEquals(AssertType.AssertNotEquals, cmd.getType());
		assertEquals("hey", cmd.getExpected());
		assertEquals("you", cmd.getActual());
		assertEquals("exceptionMessage", cmd.getFailureMessage());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you2"));
		
		IdenticalStringAssertCommand c = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		
		IdenticalStringAssertCommand d = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage2",
				new CompareAssertionData<String>("hey", "you"));
		
		IdenticalStringAssertCommand e = new IdenticalStringAssertCommand(AssertType.AssertEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
		
		assertNotEquals(a, new Object());
	}
	
	@Test
	public void testEvaluateEquals() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(AssertType.AssertEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		
		assertFalse(a.evaluate());
		I_AssertionData data = a.getData();
		assertTrue(data instanceof StringCompareAssertionData);
		StringCompareAssertionData scad = (StringCompareAssertionData) data;
		assertEquals("hey", scad.getExpected());
		assertEquals("you", scad.getActual());
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand(AssertType.AssertEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "hey"));
		assertTrue(b.evaluate());	
		data = a.getData();
		assertTrue(data instanceof CompareAssertionData);
		CompareAssertionData<String> cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("you", cad.getActual());
	}
	
	
	@Test
	public void testEvaluateNotEquals() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you"));
		
		assertTrue(a.evaluate());
		I_AssertionData data = a.getData();
		assertTrue(data instanceof CompareAssertionData);
		CompareAssertionData<String> cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("you", cad.getActual());
		
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand(AssertType.AssertNotEquals , 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "hey"));
		assertFalse(b.evaluate());	
		data = b.getData();
		assertTrue(data instanceof StringCompareAssertionData);
		StringCompareAssertionData scad = (StringCompareAssertionData) data;
		assertEquals("hey", scad.getExpected());
		assertEquals("hey", scad.getActual());
	}
	
	@Test
	public void testToString() {
		
	}
	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 33;
	}

	@Override
	public int getUniqueAsserts() {
		return 19;
	}
}

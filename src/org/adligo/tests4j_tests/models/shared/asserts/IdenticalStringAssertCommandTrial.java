package org.adligo.tests4j_tests.models.shared.asserts;

import org.adligo.tests4j.models.shared.asserts.IdenticalStringAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.common.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
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
						new IdenticalStringAssertCommand( "exceptionMessage",
								new CompareAssertionData<String>("hey", "you", AssertType.AssertTrue ));
					}
				});
		
		I_Tests4J_AssertionInputMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAssertionInputMessages();
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getTheExpectedValueShouldNeverBeNull())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new IdenticalStringAssertCommand("exceptionMessage",
								new CompareAssertionData<String>(null, "you", AssertType.AssertEquals));
					}
				});
	}
	
	@Test
	public void testConstructorAndGetters() {
		IdenticalStringAssertCommand cmd = new IdenticalStringAssertCommand(
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertNotEquals));
		assertEquals(AssertType.AssertNotEquals, cmd.getType());
		assertEquals("hey", cmd.getExpected());
		assertEquals("you", cmd.getActual());
		assertEquals("exceptionMessage", cmd.getFailureMessage());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertNotEquals));
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand( 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you2", AssertType.AssertNotEquals));
		
		IdenticalStringAssertCommand c = new IdenticalStringAssertCommand( 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertNotEquals));
		
		IdenticalStringAssertCommand d = new IdenticalStringAssertCommand(
				"exceptionMessage2",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertNotEquals));
		
		IdenticalStringAssertCommand e = new IdenticalStringAssertCommand(
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertEquals));
		
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
	
	@SuppressWarnings("unchecked")
	@Test
	public void testEvaluateEquals() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(
				"failureMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertEquals));
		
		assertFalse(a.evaluate());
		assertEquals("failureMessage", a.getFailureMessage());
		I_AssertionData data = a.getData();
		assertTrue(data instanceof CompareAssertionData);
		@SuppressWarnings("unchecked")
		CompareAssertionData<String> cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("you", cad.getActual());
		assertEquals(AssertType.AssertEquals, cad.getType());
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand( 
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "hey", AssertType.AssertEquals));
		assertTrue(b.evaluate());	
		data = a.getData();
		assertTrue(data instanceof CompareAssertionData);
		cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("you", cad.getActual());
		assertEquals(AssertType.AssertEquals, cad.getType());
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testEvaluateNotEquals() {
		IdenticalStringAssertCommand a = new IdenticalStringAssertCommand(
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "you", AssertType.AssertNotEquals));
		
		assertTrue(a.evaluate());
		I_AssertionData data = a.getData();
		assertTrue(data instanceof CompareAssertionData);
		CompareAssertionData<String> cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("you", cad.getActual());
		
		
		IdenticalStringAssertCommand b = new IdenticalStringAssertCommand(
				"exceptionMessage",
				new CompareAssertionData<String>("hey", "hey", AssertType.AssertNotEquals));
		assertFalse(b.evaluate());	
		data = b.getData();
		assertTrue(data instanceof CompareAssertionData);
		cad = (CompareAssertionData<String>) data;
		assertEquals("hey", cad.getExpected());
		assertEquals("hey", cad.getActual());
		assertEquals(AssertType.AssertNotEquals, cad.getType());
	}
	

	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 37;
	}

	@Override
	public int getUniqueAsserts() {
		return 22;
	}
}

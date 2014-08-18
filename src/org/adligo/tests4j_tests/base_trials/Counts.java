package org.adligo.tests4j_tests.base_trials;

public class Counts {
	/**
	 * from the regular test run of @Test methods
	 */
	private int tests;
	private int asserts;
	private int uniqueAsserts;
	
	/**
	 * the regular test run of @Test methods
	 * and the afterTrialTests method
	 */
	private int afterTests;
	private int afterAsserts;
	private int afterUniqueAsserts;
	public int getTests() {
		return tests;
	}
	public int getAsserts() {
		return asserts;
	}
	public int getUniqueAsserts() {
		return uniqueAsserts;
	}
	public int getAfterTests() {
		return afterTests;
	}
	public int getAfterAsserts() {
		return afterAsserts;
	}
	public int getAfterUniqueAsserts() {
		return afterUniqueAsserts;
	}
	public void setTests(int tests) {
		this.tests = tests;
	}
	public void setAsserts(int asserts) {
		this.asserts = asserts;
	}
	public void setUniqueAsserts(int uniqueAsserts) {
		this.uniqueAsserts = uniqueAsserts;
	}
	public void setAfterTests(int afterTests) {
		this.afterTests = afterTests;
	}
	public void setAfterAsserts(int afterAsserts) {
		this.afterAsserts = afterAsserts;
	}
	public void setAfterUniqueAsserts(int afterUniqueAsserts) {
		this.afterUniqueAsserts = afterUniqueAsserts;
	}
}

package org.adligo.tests4j_tests.base_trials;

/**
 * This interface was added because I was
 * seeing random issues in the counts of things.
 * So each Trial in this project now has counts
 * which are added up on a single thread before the test run
 * begins, to make dam sure there always correct.
 * 
 * @author scott
 *
 */
public interface I_CountingTrial {
	public int getTests();
	public int getAsserts();
	public int getUniqueAsserts();
	
	public int getATests();
	public int getAAsserts(boolean coverage);
	public int getAUniqueAsserts(boolean coverage);
}

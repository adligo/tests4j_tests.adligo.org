package org.adligo.tests4j_tests.base_trials;

import org.adligo.tests4j.models.shared.trials.I_Trial;

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
public interface I_CountingTrial extends I_Trial {
	public int getTests(I_CountType type);
	public int getAsserts(I_CountType type);
	public int getUniqueAsserts(I_CountType type);
}

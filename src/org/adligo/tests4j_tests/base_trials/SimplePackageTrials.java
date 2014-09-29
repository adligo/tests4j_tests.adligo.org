package org.adligo.tests4j_tests.base_trials;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.adligo.tests4j.shared.asserts.dependency.CircularDependencies;
import org.adligo.tests4j.system.shared.I_Tests4J_TrialList;
import org.adligo.tests4j.system.shared.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.SourceFileTrial;

/**
 * a base class for running the trials in a package,
 * and aggregating trials in packages.  This should not
 * contain a metaTrial, since those are specific to the package.
 * 
 * @author scott
 *
 */
public class SimplePackageTrials implements I_Tests4J_TrialList, I_CountingPackageTrials {
	/**
	 * the initial unmodified ERR stream for 
	 * printing non captured output
	 */
	protected static final PrintStream ERR = System.err;
	
	private List<Class<? extends I_CountingTrial>> trials_ = new ArrayList<Class<? extends I_CountingTrial>>();
	private Tests4J_Params params = new Tests4J_Params();
	
	private int tests_;
	private long asserts;
	private long uniqueAsserts;
	//private int nonRunnableTrials_;
	private CountType act;
	
	protected void add(Class<? extends I_CountingTrial> ct) throws Exception {
		I_CountingTrial ctInst = ct.newInstance();
		trials_.add(ct);
		int testsI = ctInst.getTests(act);
		if (testsI == 0) {
			//nonRunnableTrials_++;
		} else {
			tests_ = tests_ + testsI;
			asserts = asserts + ctInst.getAsserts(act);
			uniqueAsserts = uniqueAsserts + ctInst.getUniqueAsserts(act);
		}
	}
	
	protected void add(Collection<Class<? extends I_CountingTrial>> trials) throws Exception {
		for (Class<? extends I_CountingTrial> ct: trials) {
			add(ct);
		}
	}
	
	@Override
	public List<Class<? extends I_Trial>> getTrials() {
		List<Class<? extends I_Trial>> toRet = new ArrayList<Class<? extends I_Trial>>(trials_);
		return toRet;
	}

	public List<Class<? extends I_CountingTrial>> getCountingTrials() {
		return new ArrayList<Class<? extends I_CountingTrial>>(trials_);
	}
	
	public int getTrialCount() {
		if (params.hasMetaTrial()) {
			return trials_.size() + 1;
		}
		return trials_.size();
	}
	
	@Override
	public int getTestCount() {
		return tests_;
	}

	@Override
	public long getAssertCount() {
		return asserts;
	}

	@Override
	public long getUniqueAssertCount() {
		return uniqueAsserts;
	}

	public Tests4J_Params getParams() {
		return params;
	}

	public void setParams(Tests4J_Params params) {
		this.params = params;
		CountTypeMutant actm = new CountTypeMutant();
		actm.setCoverage(params.hasCodeCoverageFactory());
		actm.setFinishedAfterTrialTests(true);
		act = new CountType(actm);
	}
}

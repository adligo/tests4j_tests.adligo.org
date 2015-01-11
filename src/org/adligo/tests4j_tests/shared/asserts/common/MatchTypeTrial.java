package org.adligo.tests4j_tests.shared.asserts.common;

import org.adligo.tests4j.shared.asserts.common.MatchType;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_AssertsCommon_GwtReferenceGroup;

//TODO look at code coverage, it should be 100%
@SourceFileScope (sourceClass=MatchType.class, minCoverage=80.0)
@AllowedReferences (groups=Tests4J_AssertsCommon_GwtReferenceGroup.class)
public class MatchTypeTrial extends SourceFileCountingTrial {

  @Test
  public void testGet() {
    assertSame(MatchType.ANY, MatchType.get(MatchType.ANY));
    assertSame(MatchType.CONTAINS, MatchType.get(MatchType.CONTAINS));
    assertSame(MatchType.EQUALS, MatchType.get(MatchType.EQUALS));
    assertSame(MatchType.NULL, MatchType.get(MatchType.NULL));
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 4;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int asserts = 4;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, asserts + 3);
		} else {
			return super.getUniqueAsserts(type, asserts);
		}
	}

}

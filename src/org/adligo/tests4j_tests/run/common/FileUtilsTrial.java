package org.adligo.tests4j_tests.run.common;

import org.adligo.tests4j.run.common.FileUtils;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.CircularDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_RunCommon_ReferenceGroup;

import java.io.File;

/**
 * @author scott
 *
 */
@SourceFileScope (sourceClass=FileUtils.class,minCoverage=41.0, 
  allowedCircularDependencies=CircularDependencies.AllowInnerOuterClasses)
@AllowedReferences (groups=Tests4J_RunCommon_ReferenceGroup.class)
public class FileUtilsTrial extends SourceFileCountingTrial {

  @SuppressWarnings("boxing")
  @Test
  public void testMethodGetRunDir() {
    File file = new File(".");
    String dir = FileUtils.getRunDir();
    assertTrue(file.getAbsolutePath().indexOf(dir) == 0);
    int idx = dir.lastIndexOf(".");
    assertFalse(idx == dir.length() - 1);
    assertEquals(File.separatorChar, dir.charAt(dir.length() - 1));
  }
  
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}
	@Override
	public int getAsserts(I_CountType type) {
	  int asserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies
			return super.getAsserts(type,asserts + 3);
		} else {
			return super.getAsserts(type, asserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
	  int uasserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type,uasserts + 3);
		} else {
			return super.getUniqueAsserts(type, uasserts);
		}
	}

}

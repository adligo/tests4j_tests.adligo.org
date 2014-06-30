package org.adligo.tests4j_tests.eclipse;

import org.adligo.tests4j.models.shared.trials.ApiTrial;
import org.adligo.tests4j.models.shared.trials.PackageScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_4eclipse.launcher.RightClickShortcut;

@PackageScope (packageName="org.adligo.tests4j_4eclipse")
public class LaunchShortcutTrial extends ApiTrial {

	@Test
	public void testSingleProjectSelection() {
		RightClickShortcut shortcut = new RightClickShortcut();
	}
}

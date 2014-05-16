package org.adligo.tests4j_tests.eclipse;

import org.adligo.tests4j.models.shared.ApiTrial;
import org.adligo.tests4j.models.shared.PackageScope;
import org.adligo.tests4j.models.shared.Test;
import org.adligo.tests4j_4eclipse.launcher.Tests4jLaunchShortcut;

@PackageScope (packageName="org.adligo.tests4j_4eclipse")
public class LaunchShortcutTrial extends ApiTrial {

	@Test
	public void testSingleProjectSelection() {
		Tests4jLaunchShortcut shortcut = new Tests4jLaunchShortcut();
	}
}

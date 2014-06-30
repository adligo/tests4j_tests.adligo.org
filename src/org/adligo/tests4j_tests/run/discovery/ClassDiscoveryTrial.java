package org.adligo.tests4j_tests.run.discovery;

import java.util.List;

import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.SourceFileTrial;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.ClassDiscovery;

@SourceFileScope (sourceClass=ClassDiscovery.class)
public class ClassDiscoveryTrial extends SourceFileTrial {

	@Test
	public void testDiscoveryPackage() throws Exception {
		ClassDiscovery cd = new ClassDiscovery("org.adligo.tests4j.run.discovery");
		List<String> clazzNames = cd.getClassNames();
		assertNotNull(clazzNames);
		assertEquals(2, clazzNames.size());
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.ClassDiscovery"));
		assertTrue(clazzNames.contains("org.adligo.tests4j.run.discovery.TopPackageSet"));
		List<ClassDiscovery>  subs = cd.getSubPackages();
		assertNotNull(subs);
		assertEquals(0, subs.size());
	}
}

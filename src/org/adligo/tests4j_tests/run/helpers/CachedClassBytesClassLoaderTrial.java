package org.adligo.tests4j_tests.run.helpers;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=CachedClassBytesClassLoader.class, minCoverage=56.0)
public class CachedClassBytesClassLoaderTrial extends SourceFileCountingTrial {
	private static final String MOCK_PACKAGE_NAME = MockWithNothing.class.getPackage().getName();
	
	private static final String MOCK_WITH_NOTHING_NAME = MockWithNothing.class.getName();
	private static final String MOCK_WITH_NOTHING_RESOURCE_NAME = StringMethods.toResource(MOCK_WITH_NOTHING_NAME);
	
	@Test
	public void testClassNotCachedState() throws Exception {
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		Class.forName(MOCK_WITH_NOTHING_NAME, false, cl);
		assertFalse(cl.hasCache(MOCK_WITH_NOTHING_NAME));
		Class<?> c = cl.getCachedClass(MOCK_WITH_NOTHING_NAME);
		assertNull(c);
		c = cl.getLoadedClass(MOCK_WITH_NOTHING_NAME);
		assertNotNull(c);
		
		List<String> cachedClasses = cl.getAllCachedClasses();
		assertEquals(0, cachedClasses.size());
		List<String> classesInPackage = cl.getCachedClassesInPackage(MOCK_PACKAGE_NAME);
		assertEquals(0, classesInPackage.size());
	}
	
	@Test
	public void testClassCachedState() throws Exception {
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		
		InputStream in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		cl.addCache(in, MOCK_WITH_NOTHING_NAME);
		Class<?> c = cl.getCachedClass(MOCK_WITH_NOTHING_NAME);
		assertNotNull(c);
		assertSame(c, cl.getLoadedClass(MOCK_WITH_NOTHING_NAME));
	}
	
	@Override
	public int getTests() {
		return 2;
	}

	@Override
	public int getAsserts() {
		return 7;
	}

	@Override
	public int getUniqueAsserts() {
		return 6;
	}

}

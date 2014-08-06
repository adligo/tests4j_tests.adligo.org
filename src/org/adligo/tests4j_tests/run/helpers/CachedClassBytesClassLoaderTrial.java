package org.adligo.tests4j_tests.run.helpers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.helpers.CachedClassBytesClassLoader;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_LogMock;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockCachedClassBytesClassLoader;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockInputStream;
import org.adligo.tests4j_tests.run.helpers.class_loading_mocks.MockWithNothing;

@SourceFileScope (sourceClass=CachedClassBytesClassLoader.class, minCoverage=84.0)
public class CachedClassBytesClassLoaderTrial extends SourceFileCountingTrial {
	private static final String MOCK_PACKAGE_NAME = MockWithNothing.class.getPackage().getName();
	
	private static final String MOCK_WITH_NOTHING_NAME = MockWithNothing.class.getName();
	private static final String MOCK_WITH_NOTHING_RESOURCE_NAME = ClassMethods.toResource(MOCK_WITH_NOTHING_NAME);

	
	@Test
	public void testNullListsLog() throws Exception {
		Tests4J_LogMock lm = new Tests4J_LogMock();
		lm.setState(CachedClassBytesClassLoader.class, true);
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(lm,
				null,
				null);
		assertSame(lm, cl.getLog());
		Set<String> pkgsWithOutWarn = cl.getPackagesWithoutWarning();
		assertNotNull(pkgsWithOutWarn);
		assertEquals(Collections.singleton("java.").getClass().getName(), pkgsWithOutWarn.getClass().getName() );
		assertContains(pkgsWithOutWarn, "java.");
		assertEquals(1, pkgsWithOutWarn.size());
		assertEquals(Collections.emptySet(), cl.getClassesWithoutWarning());
		
		cl = new CachedClassBytesClassLoader(lm,
				new HashSet<String>(),
				new HashSet<String>());
		InputStream in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		cl.addCache(in, MOCK_WITH_NOTHING_NAME);
		assertEquals(1, lm.getLogMessagesSize());
		String message = lm.getLogMessage(0);
		assertTrue(message, message.contains(" using parent class loader for the following class;" + lm.getLineSeperator() +
				"java.lang.Object"));
		
		List<String> cachedClasses = cl.getAllCachedClasses();
		assertEquals(1, cachedClasses.size());
		assertContains(cachedClasses, MOCK_WITH_NOTHING_NAME);
		List<String> classesInPackage = cl.getCachedClassesInPackage(MOCK_PACKAGE_NAME);
		assertEquals(1, classesInPackage.size());
		assertContains(classesInPackage, MOCK_WITH_NOTHING_NAME);
		
		assertNotNull(cl.getLoadedClass(Object.class.getName()));
		assertNotNull(cl.getLoadedClass(MOCK_WITH_NOTHING_NAME));
		
		assertFalse(cl.hasCache(Object.class.getName()));
		assertTrue(cl.hasCache(MOCK_WITH_NOTHING_NAME));
		InputStream bs = cl.getCachedBytesStream(MOCK_WITH_NOTHING_NAME); 
		assertNotNull(bs);
		bs.close();
		
	}
	
	@Test
	public void testClassNotCachedState() throws Exception {
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		Set<String> pkgs = cl.getPackagesWithoutWarning();
		assertEquals(1, pkgs.size());
		assertContains(pkgs, "java.");
		Set<String> classes = cl.getClassesWithoutWarning();
		assertEquals(1, classes.size());
		assertContains(classes, "");
		
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
	public void testCreateCachedState() throws Exception {
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		
		InputStream in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		cl.addCache(in, MOCK_WITH_NOTHING_NAME);
		Class<?> c = cl.getCachedClass(MOCK_WITH_NOTHING_NAME);
		assertNotNull(c);
		assertSame(c, cl.getLoadedClass(MOCK_WITH_NOTHING_NAME));
	}
	
	@Test
	public void testAddCacheTwice() throws Exception {
		CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		
		InputStream in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		Class<?> a = cl.addCache(in, MOCK_WITH_NOTHING_NAME);
		in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		Class<?> b = cl.addCache(in, MOCK_WITH_NOTHING_NAME);
		assertSame(a, b);
		Class<?> c = cl.getCachedClass(MOCK_WITH_NOTHING_NAME);
		assertSame(a, c);
		assertSame(a, cl.getLoadedClass(MOCK_WITH_NOTHING_NAME));
	}
	
	@Test
	public void testMapReCheck() throws Exception {
		MockCachedClassBytesClassLoader cl = new MockCachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		
		InputStream in = this.getClass().getResourceAsStream(MOCK_WITH_NOTHING_RESOURCE_NAME);
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte [] bytes = new byte[1];
			while(in.read(bytes) != -1) {
				baos.write(bytes);
			}
			bytes = baos.toByteArray();
			cl.putBytes(MOCK_WITH_NOTHING_NAME, bytes);
			cl.loadClassInternal(MOCK_WITH_NOTHING_NAME);
			Class<?> c = cl.getCachedClass(MOCK_WITH_NOTHING_NAME);
			assertNotNull(c);
			assertSame(c, cl.getLoadedClass(MOCK_WITH_NOTHING_NAME));
		} catch (IOException x) {
			throw x;
		} finally {
			in.close();
		}
	}
	
	@Test
	public void testInputStreamGetsClosed() throws Exception {
		final CachedClassBytesClassLoader cl = new CachedClassBytesClassLoader(super.getLog(),
				Collections.singleton("java."),
				Collections.singleton(""));
		
		IOException ioX =new IOException("testException");
		final MockInputStream mis = new MockInputStream(ioX);
		assertThrown(new ExpectedThrownData(ioX), new I_Thrower() {
			
			@Override
			public void run() throws Exception {
				cl.addCache(mis, "foo");
			}
		});
		assertTrue(mis.isClosed());
	}
	
	@Override
	public int getTests() {
		return 6;
	}

	@Override
	public int getAsserts() {
		return 35;
	}

	@Override
	public int getUniqueAsserts() {
		return 27;
	}

}

package org.adligo.tests4j_tests.run.discovery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.asserts.common.AssertType;
import org.adligo.tests4j.models.shared.asserts.line_text.TextLinesCompareResult;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.run.discovery.TopPackageSet;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=TopPackageSet.class, minCoverage=62.0)
public class TopPackageSetTrial extends SourceFileCountingTrial {


	@Test
	public void testBasicInstance5SubsFromTopToChildren() {
		TopPackageSet tps = new TopPackageSet();
		Set<String> empty = tps.get();
		assertNotNull(empty);
		assertEquals(0, empty.size());
		assertEquals("java.util.Collections$UnmodifiableSet", empty.getClass().getName());
		
		tps.add("gs");
		Set<String> results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
		
		tps.add("gs.whips");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
		
		tps.add("gs.whips.example");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example");
		
		tps.add("gs.whips.example.a");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a");
		
		tps.add("gs.whips.example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs.whips.example.a.b.c");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs.whips.example.a.d");
		results = tps.get();
		assertNotNull(results);
		assertEquals(2, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.d");
		
		tps.add("gs.whips.example.a.e");
		results = tps.get();
		assertNotNull(results);
		assertEquals(3, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.d");
		assertContains(results, "gs.whips.example.a.e");
		
		tps.add("gs.whips.example.a.f");
		results = tps.get();
		assertNotNull(results);
		assertEquals(4, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.d");
		assertContains(results, "gs.whips.example.a.e");
		assertContains(results, "gs.whips.example.a.f");
		
		tps.add("gs.whips.example.a.h");
		results = tps.get();
		assertNotNull(results);
		assertEquals(5, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.d");
		assertContains(results, "gs.whips.example.a.e");
		assertContains(results, "gs.whips.example.a.f");
		assertContains(results, "gs.whips.example.a.h");
	}
	
	@Test
	public void testBasicInstance5SubsFromChildrenToTop() {
		TopPackageSet tps = new TopPackageSet();
		Set<String> empty = tps.get();
		assertNotNull(empty);
		assertEquals(0, empty.size());
		assertEquals("java.util.Collections$UnmodifiableSet", empty.getClass().getName());
		
		tps.add("gs.whips.example.a.b");
		Set<String> results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
		
		tps.add("gs.whips.example.a");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
		
		tps.add("gs.whips.example");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs.whips");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs.whips.example.a.b.c");
		results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, "gs.whips.example.a.b");
		
		tps.add("gs.whips.example.a.b2");
		results = tps.get();
		assertNotNull(results);
		assertEquals(2, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		
		tps.add("gs.whips.example.a2.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(3, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		
		tps.add("gs.whips.example2.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(4, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		
		tps.add("gs.whips2.example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(5, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		
		tps.add("gs2.whips.example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(6, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		
		tps.add("3gs.whips.example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(7, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		assertContains(results, "3gs.whips.example.a.b");
		
		tps.add("gs.3whips.example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(8, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		assertContains(results, "3gs.whips.example.a.b");
		assertContains(results, "gs.3whips.example.a.b");
		
		tps.add("gs.whips.3example.a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(9, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		assertContains(results, "3gs.whips.example.a.b");
		assertContains(results, "gs.3whips.example.a.b");
		assertContains(results, "gs.whips.3example.a.b");
		
		
		tps.add("gs.whips.example.3a.b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(10, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		assertContains(results, "3gs.whips.example.a.b");
		assertContains(results, "gs.3whips.example.a.b");
		assertContains(results, "gs.whips.3example.a.b");
		assertContains(results, "gs.whips.example.3a.b");
		
		tps.add("gs.whips.example.a.3b");
		results = tps.get();
		assertNotNull(results);
		assertEquals(11, results.size());
		assertContains(results, "gs.whips.example.a.b");
		assertContains(results, "gs.whips.example.a.b2");
		assertContains(results, "gs.whips.example.a2.b");
		assertContains(results, "gs.whips.example2.a.b");
		assertContains(results, "gs.whips2.example.a.b");
		assertContains(results, "gs2.whips.example.a.b");
		assertContains(results, "3gs.whips.example.a.b");
		assertContains(results, "gs.3whips.example.a.b");
		assertContains(results, "gs.whips.3example.a.b");
		assertContains(results, "gs.whips.example.3a.b");
		assertContains(results, "gs.whips.example.a.3b");
	}
	
	
	@Test
	public void testGetClassPackages1() {
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		clazzes.add(StringMethods.class);
		
		TopPackageSet tps = TopPackageSet.getPackages(clazzes);
		
		Set<String> results = tps.get();
		assertNotNull(results);
		assertEquals(1, results.size());
		assertContains(results, StringMethods.class.getPackage().getName());
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
	}
	
	@Test
	public void testGetClassPackages2NoOverlap() {
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		clazzes.add(StringMethods.class);
		clazzes.add(TextLinesCompareResult.class);
		TopPackageSet tps = TopPackageSet.getPackages(clazzes);
		
		Set<String> results = tps.get();
		assertNotNull(results);
		assertEquals(2, results.size());
		assertContains(results, "org.adligo.tests4j.models.shared.common");
		assertContains(results, "org.adligo.tests4j.models.shared.asserts.line_text");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
	}
	
	
	@Test
	public void testGetClassPackages3Overlap() {
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		clazzes.add(StringMethods.class);
		clazzes.add(TextLinesCompareResult.class);
		clazzes.add(AssertType.class);
		TopPackageSet tps = TopPackageSet.getPackages(clazzes);
		
		Set<String> results = tps.get();
		assertNotNull(results);
		assertEquals(2, results.size());
		assertContains(results, "org.adligo.tests4j.models.shared.common");
		assertContains(results, "org.adligo.tests4j.models.shared.asserts");
		assertEquals("java.util.Collections$UnmodifiableSet", results.getClass().getName());
	}
	
	@Override
	public int getTests() {
		return 5;
	}

	@Override
	public int getAsserts() {
		return 167;
	}

	@Override
	public int getUniqueAsserts() {
		return 141;
	}
}

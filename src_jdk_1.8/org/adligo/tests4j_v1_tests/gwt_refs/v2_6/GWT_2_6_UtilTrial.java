package org.adligo.tests4j_v1_tests.gwt_refs.v2_6;

import java.util.Set;

import org.adligo.gwt_refs.v2_6.GWT_2_6_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;
import org.adligo.tests4j.shared.asserts.reference.I_FieldSignature;
import org.adligo.tests4j.shared.asserts.reference.I_MethodSignature;
import org.adligo.tests4j.shared.asserts.reference.MethodSignature;
import org.adligo.tests4j.shared.common.ClassMethods;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Gwt_v2_6_GwtReferenceGroup;

//try to keep coverage above 10 for the 0.1 release
@SourceFileScope (sourceClass=GWT_2_6_Util.class, minCoverage=92.0)
@AllowedReferences (groups=Tests4J_Gwt_v2_6_GwtReferenceGroup.class)
public class GWT_2_6_UtilTrial extends SourceFileCountingTrial {
	private GWT_2_6_UtilDelegates delegates;
	
	public GWT_2_6_UtilTrial() {
		delegates = new GWT_2_6_UtilDelegates(this);
	}
	
	@Test
	public void testConcurrentModificationException() {
		I_ClassAttributes result = GWT_2_6_Util.getConcurrentModificationException();
		assertEquals("java.util.ConcurrentModificationException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.THROWABLE}));
		delegates.delegateConcurrentModificationExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testEmptyStackException() {
		I_ClassAttributes result = GWT_2_6_Util.getEmptyStackException();
		assertEquals("java.util.EmptyStackException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		delegates.delegateEmptyStackExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(16, ms.size());
	}

	@Test
	public void testMissingResourceException() {
		I_ClassAttributes result = GWT_2_6_Util.getMissingResourceException();
		assertEquals("java.util.MissingResourceException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING, JSE_Lang.STRING, JSE_Lang.STRING}));
		delegates.delegateMissingResourceExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(19, ms.size());
	}

	@Test
	public void testNoSuchElementException() {
		I_ClassAttributes result = GWT_2_6_Util.getNoSuchElementException();
		assertEquals("java.util.NoSuchElementException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateNoSuchElementExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testTooManyListenersException() {
		I_ClassAttributes result = GWT_2_6_Util.getTooManyListenersException();
		assertEquals("java.util.TooManyListenersException", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		delegates.delegateTooManyListenersExceptionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testDate() {
		I_ClassAttributes result = GWT_2_6_Util.getDate();
		assertEquals(JSE_Util.DATE, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateDateMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(34, ms.size());
	}

	@Test
	public void testAbstractCollection() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractCollection();
		assertEquals("java.util.AbstractCollection", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractCollectionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testAbstractList() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractList();
		assertEquals("java.util.AbstractList", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractListMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(27, ms.size());
	}

	@Test
	public void testAbstractMap() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractMap();
		assertEquals("java.util.AbstractMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractMapMemberAsserts(result, true);
		assertEquals(0, fs.size());
		assertEquals(16, ms.size());
	}

	@Test
	public void testAbstractQueue() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractQueue();
		assertEquals("java.util.AbstractQueue", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractQueueMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(22, ms.size());
	}

	@Test
	public void testAbstractSequentialList() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractSequentialList();
		assertEquals("java.util.AbstractSequentialList", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractSequentialListMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(27, ms.size());
	}

	@Test
	public void testAbstractSet() {
		I_ClassAttributes result = GWT_2_6_Util.getAbstractSet();
		assertEquals("java.util.AbstractSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateAbstractSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(17, ms.size());
	}

	@Test
	public void testArrayList() {
		I_ClassAttributes result = GWT_2_6_Util.getArrayList();
		assertEquals("java.util.ArrayList", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {"java.util.Collection"}));
		delegates.delegateArrayListMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(33, ms.size());
	}


	@Test
	public void testArrays() {
		I_ClassAttributes result = GWT_2_6_Util.getArrays();
		assertEquals(JSE_Util.ARRAYS, result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateArraysMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(76, ms.size());
	}


	@Test
	public void testCollections() {
		I_ClassAttributes result = GWT_2_6_Util.getCollections();
		assertEquals("java.util.Collections", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateCollectionsMemberAsserts(result);
		assertEquals(3, fs.size());
		assertEquals(34, ms.size());
	}

	@Test
	public void testCollection() {
		I_ClassAttributes result = GWT_2_6_Util.getCollection();
		assertEquals("java.util.Collection", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateCollectionMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(15, ms.size());
	}
	


	@Test
	public void testComparator() {
		I_ClassAttributes result = GWT_2_6_Util.getComparator();
		assertEquals("java.util.Comparator", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateComparatorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(2, ms.size());
	}

	@Test
	public void testEnumMap() {
		I_ClassAttributes result = GWT_2_6_Util.getEnumMap();
		assertEquals("java.util.EnumMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.CLASS}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.ENUM_MAP}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.MAP}));
		delegates.delegateEnumMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(20, ms.size());
	}

	@Test
	public void testEnumSet() {
		I_ClassAttributes result = GWT_2_6_Util.getEnumSet();
		assertEquals("java.util.EnumSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateEnumSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(26, ms.size());
	}

	@Test
	public void testEnumeration() {
		I_ClassAttributes result = GWT_2_6_Util.getEnumeration();
		assertEquals("java.util.Enumeration", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateEnumerationMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(2, ms.size());
	}

	@Test
	public void testEventListener() {
		I_ClassAttributes result = GWT_2_6_Util.getEventListener();
		assertEquals("java.util.EventListener", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}
	
	@Test
	public void testEventObject() {
		I_ClassAttributes result = GWT_2_6_Util.getEventObject();
		assertEquals("java.util.EventObject", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Lang.OBJECT}));
		delegates.delegateEventObjectMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(6, ms.size());
	}

	@Test
	public void testHashMap() {
		I_ClassAttributes result = GWT_2_6_Util.getHashMap();
		assertEquals("java.util.HashMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.MAP}));
		delegates.delegateHashMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(21, ms.size());
	}

	
	@Test
	public void testHashSet() {
		I_ClassAttributes result = GWT_2_6_Util.getHashSet();
		assertEquals("java.util.HashSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		delegates.delegateHashSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(22, ms.size());
	}

	@Test
	public void testIdentityHashMap() {
		I_ClassAttributes result = GWT_2_6_Util.getIdentityHashMap();
		assertEquals("java.util.IdentityHashMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.MAP}));
		delegates.delegateIdentityHashMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(20, ms.size());
	}

	@Test
	public void testIterator() {
		I_ClassAttributes result = GWT_2_6_Util.getIterator();
		assertEquals("java.util.Iterator", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateIteratorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(3, ms.size());
	}

	@Test
	public void testLinkedHashMap() {
		I_ClassAttributes result = GWT_2_6_Util.getLinkedHashMap();
		assertEquals("java.util.LinkedHashMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT, ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.MAP}));
		delegates.delegateLinkedHashMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(22, ms.size());
	}

	@Test
	public void testLinkedHashSet() {
		I_ClassAttributes result = GWT_2_6_Util.getLinkedHashSet();
		assertEquals("java.util.LinkedHashSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.FLOAT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		delegates.delegateLinkedHashSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(22, ms.size());
	}

	@Test
	public void testLinkedList() {
		I_ClassAttributes result = GWT_2_6_Util.getLinkedList();
		assertEquals("java.util.LinkedList", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		delegates.delegateLinkedListMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(39, ms.size());
	}

	@Test
	public void testList() {
		I_ClassAttributes result = GWT_2_6_Util.getList();
		assertEquals("java.util.List", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateListMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(25, ms.size());
	}

	@Test
	public void testListIterator() {
		I_ClassAttributes result = GWT_2_6_Util.getListIterator();
		assertEquals("java.util.ListIterator", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateListIteratorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(9, ms.size());
	}


	@Test
	public void testMap() {
		I_ClassAttributes result = GWT_2_6_Util.getMap();
		assertEquals("java.util.Map", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(14, ms.size());
	}

	@Test
	public void testEntry() {
		I_ClassAttributes result = GWT_2_6_Util.getMapEntry();
		assertEquals("java.util.Map$Entry", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateEntryMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(5, ms.size());
	}

	@Test
	public void testObjects() {
		I_ClassAttributes result = GWT_2_6_Util.getObjects();
		assertEquals("java.util.Objects", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateObjectsMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(9, ms.size());
	}


	@Test
	public void testPriorityQueue() {
		I_ClassAttributes result = GWT_2_6_Util.getPriorityQueue();
		assertEquals("java.util.PriorityQueue", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.PRIORITY_QUEUE}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.SORTED_SET}));
		delegates.delegatePriorityQueueMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(29, ms.size());
	}

	@Test
	public void testQueue() {
		I_ClassAttributes result = GWT_2_6_Util.getQueue();
		assertEquals("java.util.Queue", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateQueueMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(6, ms.size());
	}

	@Test
	public void testRandom() {
		I_ClassAttributes result = GWT_2_6_Util.getRandom();
		assertEquals("java.util.Random", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.LONG}));
		delegates.delegateRandomMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(15, ms.size());
	}

	@Test
	public void testRandomAccess() {
		I_ClassAttributes result = GWT_2_6_Util.getRandomAccess();
		assertEquals("java.util.RandomAccess", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateRandomAccessMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(0, ms.size());
	}

	@Test
	public void testSet() {
		I_ClassAttributes result = GWT_2_6_Util.getSet();
		assertEquals("java.util.Set", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(15, ms.size());
	}

	@Test
	public void testSortedMap() {
		I_ClassAttributes result = GWT_2_6_Util.getSortedMap();
		assertEquals("java.util.SortedMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateSortedMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(20, ms.size());
	}

	@Test
	public void testVector() {
		I_ClassAttributes result = GWT_2_6_Util.getVector();
		assertEquals("java.util.Vector", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {ClassMethods.INT, ClassMethods.INT}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		delegates.delegateVectorMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(49, ms.size());
	}

	@Test
	public void testSortedSet() {
		I_ClassAttributes result = GWT_2_6_Util.getSortedSet();
		assertEquals("java.util.SortedSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		delegates.delegateSortedSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(6, ms.size());
	}

	@Test
	public void testStack() {
		I_ClassAttributes result = GWT_2_6_Util.getStack();
		assertEquals("java.util.Stack", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		delegates.delegateStackMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(51, ms.size());
	}

	@Test
	public void testTreeMap() {
		I_ClassAttributes result = GWT_2_6_Util.getTreeMap();
		assertEquals("java.util.TreeMap", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.MAP}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.SORTED_MAP}));
		delegates.delegateTreeMapMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(27, ms.size());
	}

	@Test
	public void testTreeSet() {
		I_ClassAttributes result = GWT_2_6_Util.getTreeSet();
		assertEquals("java.util.TreeSet", result.getName());
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("<init>"));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COLLECTION}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.COMPARATOR}));
		assertContains(ms, new MethodSignature("<init>", 
			new String[] {JSE_Util.SORTED_SET}));
		delegates.delegateTreeSetMemberAsserts(result);
		assertEquals(0, fs.size());
		assertEquals(28, ms.size());
	}


	//keep at bottom
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 45, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 1177;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 1094;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}

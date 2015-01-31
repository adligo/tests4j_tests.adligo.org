package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Util;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_Util.class,minCoverage=91.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_UtilTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Util.INSTANCE);
	}
			
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.util.Collection"));
		asserts.assertTrue(dg.isInGroup("java.util.Comparator"));
		asserts.assertTrue(dg.isInGroup("java.util.Deque"));
		asserts.assertTrue(dg.isInGroup("java.util.Enumeration"));
		asserts.assertTrue(dg.isInGroup("java.util.EventListener"));
		asserts.assertTrue(dg.isInGroup("java.util.Formattable"));
		asserts.assertTrue(dg.isInGroup("java.util.Iterator"));
		asserts.assertTrue(dg.isInGroup("java.util.List"));
		asserts.assertTrue(dg.isInGroup("java.util.ListIterator"));
		asserts.assertTrue(dg.isInGroup("java.util.Map"));
		asserts.assertTrue(dg.isInGroup("java.util.Map$Entry"));
		asserts.assertTrue(dg.isInGroup("java.util.NavigableMap"));
		asserts.assertTrue(dg.isInGroup("java.util.NavigableSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Observer"));
		asserts.assertTrue(dg.isInGroup("java.util.Queue"));
		asserts.assertTrue(dg.isInGroup("java.util.RandomAccess"));
		asserts.assertTrue(dg.isInGroup("java.util.Set"));
		asserts.assertTrue(dg.isInGroup("java.util.SortedMap"));
		asserts.assertTrue(dg.isInGroup("java.util.SortedSet"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractCollection"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractList"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap$SimpleEntry"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap$SimpleImmutableEntry"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractQueue"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractSequentialList"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractSet"));
		asserts.assertTrue(dg.isInGroup("java.util.ArrayDeque"));
		asserts.assertTrue(dg.isInGroup("java.util.ArrayList"));
		asserts.assertTrue(dg.isInGroup("java.util.Arrays"));
		asserts.assertTrue(dg.isInGroup("java.util.BitSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Calendar"));
		asserts.assertTrue(dg.isInGroup("java.util.Collections"));
		asserts.assertTrue(dg.isInGroup("java.util.Currency"));
		asserts.assertTrue(dg.isInGroup("java.util.Date"));
		asserts.assertTrue(dg.isInGroup("java.util.Dictionary"));
		asserts.assertTrue(dg.isInGroup("java.util.EnumMap"));
		asserts.assertTrue(dg.isInGroup("java.util.EnumSet"));
		asserts.assertTrue(dg.isInGroup("java.util.EventListenerProxy"));
		asserts.assertTrue(dg.isInGroup("java.util.EventObject"));
		asserts.assertTrue(dg.isInGroup("java.util.FormattableFlags"));
		asserts.assertTrue(dg.isInGroup("java.util.Formatter"));
		asserts.assertTrue(dg.isInGroup("java.util.GregorianCalendar"));
		asserts.assertTrue(dg.isInGroup("java.util.HashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.HashSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Hashtable"));
		asserts.assertTrue(dg.isInGroup("java.util.IdentityHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.LinkedHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.LinkedHashSet"));
		asserts.assertTrue(dg.isInGroup("java.util.ListResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale$Builder"));
		asserts.assertTrue(dg.isInGroup("java.util.Objects"));
		asserts.assertTrue(dg.isInGroup("java.util.Observable"));
		asserts.assertTrue(dg.isInGroup("java.util.PriorityQueue"));
		asserts.assertTrue(dg.isInGroup("java.util.Properties"));
		asserts.assertTrue(dg.isInGroup("java.util.PropertyPermission"));
		asserts.assertTrue(dg.isInGroup("java.util.PropertyResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.Random"));
		asserts.assertTrue(dg.isInGroup("java.util.ResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.ResourceBundle$Control"));
		asserts.assertTrue(dg.isInGroup("java.util.Scanner"));
		asserts.assertTrue(dg.isInGroup("java.util.ServiceLoader"));
		asserts.assertTrue(dg.isInGroup("java.util.SimpleTimeZone"));
		asserts.assertTrue(dg.isInGroup("java.util.Stack"));
		asserts.assertTrue(dg.isInGroup("java.util.StringTokenizer"));
		asserts.assertTrue(dg.isInGroup("java.util.Timer"));
		asserts.assertTrue(dg.isInGroup("java.util.TimerTask"));
		asserts.assertTrue(dg.isInGroup("java.util.TimeZone"));
		asserts.assertTrue(dg.isInGroup("java.util.TreeMap"));
		asserts.assertTrue(dg.isInGroup("java.util.TreeSet"));
		asserts.assertTrue(dg.isInGroup("java.util.UUID"));
		asserts.assertTrue(dg.isInGroup("java.util.Vector"));
		asserts.assertTrue(dg.isInGroup("java.util.WeakHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.Formatter$BigDecimalLayoutForm"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale$Category"));
		asserts.assertTrue(dg.isInGroup("java.util.ConcurrentModificationException"));
		asserts.assertTrue(dg.isInGroup("java.util.DuplicateFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.EmptyStackException"));
		asserts.assertTrue(dg.isInGroup("java.util.FormatFlagsConversionMismatchException"));
		asserts.assertTrue(dg.isInGroup("java.util.FormatterClosedException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatCodePointException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatConversionException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatPrecisionException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatWidthException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllformedLocaleException"));
		asserts.assertTrue(dg.isInGroup("java.util.InputMismatchException"));
		asserts.assertTrue(dg.isInGroup("java.util.InvalidPropertiesFormatException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingFormatArgumentException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingFormatWidthException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingResourceException"));
		asserts.assertTrue(dg.isInGroup("java.util.NoSuchElementException"));
		asserts.assertTrue(dg.isInGroup("java.util.TooManyListenersException"));
		asserts.assertTrue(dg.isInGroup("java.util.UnknownFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.ServiceConfigurationError"));


	}

	@Test
  public void testConstantLookup() {
    assertEquals("java.util",JSE_Util.INSTANCE.getPackageName());
    
    assertEquals("COLLECTION",JSE_Util.INSTANCE.getConstantName("java.util.Collection"));
    assertEquals("COMPARATOR",JSE_Util.INSTANCE.getConstantName("java.util.Comparator"));
    assertEquals("DEQUE",JSE_Util.INSTANCE.getConstantName("java.util.Deque"));
    assertEquals("ENUMERATION",JSE_Util.INSTANCE.getConstantName("java.util.Enumeration"));
    assertEquals("EVENT_LISTENER",JSE_Util.INSTANCE.getConstantName("java.util.EventListener"));
    assertEquals("FORMATTABLE",JSE_Util.INSTANCE.getConstantName("java.util.Formattable"));
    assertEquals("ITERATOR",JSE_Util.INSTANCE.getConstantName("java.util.Iterator"));
    assertEquals("LIST",JSE_Util.INSTANCE.getConstantName("java.util.List"));
    assertEquals("LIST_ITERATOR",JSE_Util.INSTANCE.getConstantName("java.util.ListIterator"));
    assertEquals("MAP",JSE_Util.INSTANCE.getConstantName("java.util.Map"));
    assertEquals("ENTRY",JSE_Util.INSTANCE.getConstantName("java.util.Map$Entry"));
    assertEquals("NAVIGABLE_MAP",JSE_Util.INSTANCE.getConstantName("java.util.NavigableMap"));
    assertEquals("NAVIGABLE_SET",JSE_Util.INSTANCE.getConstantName("java.util.NavigableSet"));
    assertEquals("OBSERVER",JSE_Util.INSTANCE.getConstantName("java.util.Observer"));
    assertEquals("QUEUE",JSE_Util.INSTANCE.getConstantName("java.util.Queue"));
    assertEquals("RANDOM_ACCESS",JSE_Util.INSTANCE.getConstantName("java.util.RandomAccess"));
    assertEquals("SET",JSE_Util.INSTANCE.getConstantName("java.util.Set"));
    assertEquals("SORTED_MAP",JSE_Util.INSTANCE.getConstantName("java.util.SortedMap"));
    assertEquals("SORTED_SET",JSE_Util.INSTANCE.getConstantName("java.util.SortedSet"));
    assertEquals("ABSTRACT_COLLECTION",JSE_Util.INSTANCE.getConstantName("java.util.AbstractCollection"));
    assertEquals("ABSTRACT_LIST",JSE_Util.INSTANCE.getConstantName("java.util.AbstractList"));
    assertEquals("ABSTRACT_MAP",JSE_Util.INSTANCE.getConstantName("java.util.AbstractMap"));
    assertEquals("SIMPLE_ENTRY",JSE_Util.INSTANCE.getConstantName("java.util.AbstractMap$SimpleEntry"));
    assertEquals("SIMPLE_IMMUTABLE_ENTRY",JSE_Util.INSTANCE.getConstantName("java.util.AbstractMap$SimpleImmutableEntry"));
    assertEquals("ABSTRACT_QUEUE",JSE_Util.INSTANCE.getConstantName("java.util.AbstractQueue"));
    assertEquals("ABSTRACT_SEQUENTIAL_LIST",JSE_Util.INSTANCE.getConstantName("java.util.AbstractSequentialList"));
    assertEquals("ABSTRACT_SET",JSE_Util.INSTANCE.getConstantName("java.util.AbstractSet"));
    assertEquals("ARRAY_DEQUE",JSE_Util.INSTANCE.getConstantName("java.util.ArrayDeque"));
    assertEquals("ARRAY_LIST",JSE_Util.INSTANCE.getConstantName("java.util.ArrayList"));
    assertEquals("ARRAYS",JSE_Util.INSTANCE.getConstantName("java.util.Arrays"));
    assertEquals("BIT_SET",JSE_Util.INSTANCE.getConstantName("java.util.BitSet"));
    assertEquals("CALENDAR",JSE_Util.INSTANCE.getConstantName("java.util.Calendar"));
    assertEquals("COLLECTIONS",JSE_Util.INSTANCE.getConstantName("java.util.Collections"));
    assertEquals("CURRENCY",JSE_Util.INSTANCE.getConstantName("java.util.Currency"));
    assertEquals("DATE",JSE_Util.INSTANCE.getConstantName("java.util.Date"));
    assertEquals("DICTIONARY",JSE_Util.INSTANCE.getConstantName("java.util.Dictionary"));
    assertEquals("ENUM_MAP",JSE_Util.INSTANCE.getConstantName("java.util.EnumMap"));
    assertEquals("ENUM_SET",JSE_Util.INSTANCE.getConstantName("java.util.EnumSet"));
    assertEquals("EVENT_LISTENER_PROXY",JSE_Util.INSTANCE.getConstantName("java.util.EventListenerProxy"));
    assertEquals("EVENT_OBJECT",JSE_Util.INSTANCE.getConstantName("java.util.EventObject"));
    assertEquals("FORMATTABLE_FLAGS",JSE_Util.INSTANCE.getConstantName("java.util.FormattableFlags"));
    assertEquals("FORMATTER",JSE_Util.INSTANCE.getConstantName("java.util.Formatter"));
    assertEquals("GREGORIAN_CALENDAR",JSE_Util.INSTANCE.getConstantName("java.util.GregorianCalendar"));
    assertEquals("HASH_MAP",JSE_Util.INSTANCE.getConstantName("java.util.HashMap"));
    assertEquals("HASH_SET",JSE_Util.INSTANCE.getConstantName("java.util.HashSet"));
    assertEquals("HASHTABLE",JSE_Util.INSTANCE.getConstantName("java.util.Hashtable"));
    assertEquals("IDENTITY_HASH_MAP",JSE_Util.INSTANCE.getConstantName("java.util.IdentityHashMap"));
    assertEquals("LINKED_HASH_MAP",JSE_Util.INSTANCE.getConstantName("java.util.LinkedHashMap"));
    assertEquals("LINKED_HASH_SET",JSE_Util.INSTANCE.getConstantName("java.util.LinkedHashSet"));
    assertEquals("LIST_RESOURCE_BUNDLE",JSE_Util.INSTANCE.getConstantName("java.util.ListResourceBundle"));
    assertEquals("LOCALE",JSE_Util.INSTANCE.getConstantName("java.util.Locale"));
    assertEquals("BUILDER",JSE_Util.INSTANCE.getConstantName("java.util.Locale$Builder"));
    assertEquals("OBJECTS",JSE_Util.INSTANCE.getConstantName("java.util.Objects"));
    assertEquals("OBSERVABLE",JSE_Util.INSTANCE.getConstantName("java.util.Observable"));
    assertEquals("PRIORITY_QUEUE",JSE_Util.INSTANCE.getConstantName("java.util.PriorityQueue"));
    assertEquals("PROPERTIES",JSE_Util.INSTANCE.getConstantName("java.util.Properties"));
    assertEquals("PROPERTY_PERMISSION",JSE_Util.INSTANCE.getConstantName("java.util.PropertyPermission"));
    assertEquals("PROPERTY_RESOURCE_BUNDLE",JSE_Util.INSTANCE.getConstantName("java.util.PropertyResourceBundle"));
    assertEquals("RANDOM",JSE_Util.INSTANCE.getConstantName("java.util.Random"));
    assertEquals("RESOURCE_BUNDLE",JSE_Util.INSTANCE.getConstantName("java.util.ResourceBundle"));
    assertEquals("CONTROL",JSE_Util.INSTANCE.getConstantName("java.util.ResourceBundle$Control"));
    assertEquals("SCANNER",JSE_Util.INSTANCE.getConstantName("java.util.Scanner"));
    assertEquals("SERVICE_LOADER",JSE_Util.INSTANCE.getConstantName("java.util.ServiceLoader"));
    assertEquals("SIMPLE_TIME_ZONE",JSE_Util.INSTANCE.getConstantName("java.util.SimpleTimeZone"));
    assertEquals("STACK",JSE_Util.INSTANCE.getConstantName("java.util.Stack"));
    assertEquals("STRING_TOKENIZER",JSE_Util.INSTANCE.getConstantName("java.util.StringTokenizer"));
    assertEquals("TIMER",JSE_Util.INSTANCE.getConstantName("java.util.Timer"));
    assertEquals("TIMER_TASK",JSE_Util.INSTANCE.getConstantName("java.util.TimerTask"));
    assertEquals("TIME_ZONE",JSE_Util.INSTANCE.getConstantName("java.util.TimeZone"));
    assertEquals("TREE_MAP",JSE_Util.INSTANCE.getConstantName("java.util.TreeMap"));
    assertEquals("TREE_SET",JSE_Util.INSTANCE.getConstantName("java.util.TreeSet"));
    assertEquals("UUID",JSE_Util.INSTANCE.getConstantName("java.util.UUID"));
    assertEquals("VECTOR",JSE_Util.INSTANCE.getConstantName("java.util.Vector"));
    assertEquals("WEAK_HASH_MAP",JSE_Util.INSTANCE.getConstantName("java.util.WeakHashMap"));
    assertEquals("BIG_DECIMAL_LAYOUT_FORM",JSE_Util.INSTANCE.getConstantName("java.util.Formatter$BigDecimalLayoutForm"));
    assertEquals("CATEGORY",JSE_Util.INSTANCE.getConstantName("java.util.Locale$Category"));
    assertEquals("CONCURRENT_MODIFICATION_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.ConcurrentModificationException"));
    assertEquals("DUPLICATE_FORMAT_FLAGS_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.DuplicateFormatFlagsException"));
    assertEquals("EMPTY_STACK_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.EmptyStackException"));
    assertEquals("FORMAT_FLAGS_CONVERSION_MISMATCH_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.FormatFlagsConversionMismatchException"));
    assertEquals("FORMATTER_CLOSED_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.FormatterClosedException"));
    assertEquals("ILLEGAL_FORMAT_CODE_POINT_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatCodePointException"));
    assertEquals("ILLEGAL_FORMAT_CONVERSION_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatConversionException"));
    assertEquals("ILLEGAL_FORMAT_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatException"));
    assertEquals("ILLEGAL_FORMAT_FLAGS_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatFlagsException"));
    assertEquals("ILLEGAL_FORMAT_PRECISION_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatPrecisionException"));
    assertEquals("ILLEGAL_FORMAT_WIDTH_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllegalFormatWidthException"));
    assertEquals("ILLFORMED_LOCALE_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.IllformedLocaleException"));
    assertEquals("INPUT_MISMATCH_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.InputMismatchException"));
    assertEquals("INVALID_PROPERTIES_FORMAT_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.InvalidPropertiesFormatException"));
    assertEquals("MISSING_FORMAT_ARGUMENT_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.MissingFormatArgumentException"));
    assertEquals("MISSING_FORMAT_WIDTH_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.MissingFormatWidthException"));
    assertEquals("MISSING_RESOURCE_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.MissingResourceException"));
    assertEquals("NO_SUCH_ELEMENT_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.NoSuchElementException"));
    assertEquals("TOO_MANY_LISTENERS_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.TooManyListenersException"));
    assertEquals("UNKNOWN_FORMAT_FLAGS_EXCEPTION",JSE_Util.INSTANCE.getConstantName("java.util.UnknownFormatFlagsException"));
    assertEquals("SERVICE_CONFIGURATION_ERROR",JSE_Util.INSTANCE.getConstantName("java.util.ServiceConfigurationError"));
  }
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 2, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 195;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 99;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}

}

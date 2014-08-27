package org.adligo.tests4j_tests.models.shared.dependency_groups.jse;

import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_1_7_Util;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=JSE_1_7_Util.class)
public class JSE_1_7_UtilTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.util.Collection",JSE_1_7_Util.COLLECTION);
		assertEquals("java.util.Comparator",JSE_1_7_Util.COMPARATOR);
		assertEquals("java.util.Deque",JSE_1_7_Util.DEQUE);
		assertEquals("java.util.Enumeration",JSE_1_7_Util.ENUMERATION);
		assertEquals("java.util.EventListener",JSE_1_7_Util.EVENT_LISTENER);
		assertEquals("java.util.Formattable",JSE_1_7_Util.FORMATTABLE);
		assertEquals("java.util.Iterator",JSE_1_7_Util.ITERATOR);
		assertEquals("java.util.List",JSE_1_7_Util.LIST);
		assertEquals("java.util.ListIterator",JSE_1_7_Util.LIST_ITERATOR);
		assertEquals("java.util.Map",JSE_1_7_Util.MAP);
		assertEquals("java.util.Map$Entry",JSE_1_7_Util.MAP_ENTRY);
		assertEquals("java.util.NavigableMap",JSE_1_7_Util.NAVIGABLE_MAP);
		assertEquals("java.util.NavigableSet",JSE_1_7_Util.NAVIGABLE_SET);
		assertEquals("java.util.Observer",JSE_1_7_Util.OBSERVER);
		assertEquals("java.util.Queue",JSE_1_7_Util.QUEUE);
		assertEquals("java.util.RandomAccess",JSE_1_7_Util.RANDOM_ACCESS);
		assertEquals("java.util.Set",JSE_1_7_Util.SET);
		assertEquals("java.util.SortedMap",JSE_1_7_Util.SORTED_MAP);
		assertEquals("java.util.SortedSet",JSE_1_7_Util.SORTED_SET);
		assertEquals("java.util.AbstractCollection",JSE_1_7_Util.ABSTRACT_COLLECTION);
		assertEquals("java.util.AbstractList",JSE_1_7_Util.ABSTRACT_LIST);
		assertEquals("java.util.AbstractMap",JSE_1_7_Util.ABSTRACT_MAP);
		assertEquals("java.util.AbstractMap$SimpleEntry",JSE_1_7_Util.ABSTRACT_MAP_SIMPLE_ENTRY);
		assertEquals("java.util.AbstractMap$SimpleImmutableEntry",JSE_1_7_Util.ABSTRACT_MAP_SIMPLE_IMMUTABLE_ENTRY);
		assertEquals("java.util.AbstractQueue",JSE_1_7_Util.ABSTRACT_QUEUE);
		assertEquals("java.util.AbstractSequentialList",JSE_1_7_Util.ABSTRACT_SEQUENTIAL_LIST);
		assertEquals("java.util.AbstractSet",JSE_1_7_Util.ABSTRACT_SET);
		assertEquals("java.util.ArrayQueue",JSE_1_7_Util.ARRAY_QUEUE);
		assertEquals("java.util.ArrayList",JSE_1_7_Util.ARRAY_LIST);
		assertEquals("java.util.Arrays",JSE_1_7_Util.ARRAYS);
		assertEquals("java.util.BitSet",JSE_1_7_Util.BIT_SET);
		assertEquals("java.util.Calendar",JSE_1_7_Util.CALENDAR);
		assertEquals("java.util.Collections",JSE_1_7_Util.COLLECTIONS);
		assertEquals("java.util.Currency",JSE_1_7_Util.CURRENCY);
		assertEquals("java.util.Date",JSE_1_7_Util.DATE);
		assertEquals("java.util.Dictionary",JSE_1_7_Util.DICTIONARY);
		assertEquals("java.util.EnumMap",JSE_1_7_Util.ENUM_MAP);
		assertEquals("java.util.EnumSet",JSE_1_7_Util.ENUM_SET);
		assertEquals("java.util.EventListenerProxy",JSE_1_7_Util.EVENT_LISTENER_PROXY);
		assertEquals("java.util.EventObject",JSE_1_7_Util.EVENT_OBJECT);
		assertEquals("java.util.FormattableFlags",JSE_1_7_Util.FORMATTABLE_FLAGS);
		assertEquals("java.util.Formatter",JSE_1_7_Util.FORMATTER);
		assertEquals("java.util.GregorianCalendar",JSE_1_7_Util.GREGORIAN_CALENDAR);
		assertEquals("java.util.HashMap",JSE_1_7_Util.HASH_MAP);
		assertEquals("java.util.HashSet",JSE_1_7_Util.HASH_SET);
		assertEquals("java.util.Hashtable",JSE_1_7_Util.HASHTABLE);
		assertEquals("java.util.IdentityHashMap",JSE_1_7_Util.IDENTITY_HASH_MAP);
		assertEquals("java.util.LinkedHashMap",JSE_1_7_Util.LINKED_HASH_MAP);
		assertEquals("java.util.LinkedHashSet",JSE_1_7_Util.LINKED_HASH_SET);
		assertEquals("java.util.LinkedList",JSE_1_7_Util.LINKED_LIST);
		assertEquals("java.util.ListResourceBundle",JSE_1_7_Util.LIST_RESOURCE_BUNDLE);
		assertEquals("java.util.Locale",JSE_1_7_Util.LOCALE);
		assertEquals("java.util.Locale$Builder",JSE_1_7_Util.LOCALE_BUILDER);
		assertEquals("java.util.Objects",JSE_1_7_Util.OBJECTS);
		assertEquals("java.util.Observable",JSE_1_7_Util.OBSERVABLE);
		assertEquals("java.util.PriorityQueue",JSE_1_7_Util.PRIORITY_QUEUE);
		assertEquals("java.util.Properties",JSE_1_7_Util.PROPERTIES);
		assertEquals("java.util.PropertyPermission",JSE_1_7_Util.PROPERTY_PERMISSION);
		assertEquals("java.util.PropertyResourceBundle",JSE_1_7_Util.PROPERTY_RESOURCE_BUNDLE);
		assertEquals("java.util.Random",JSE_1_7_Util.RANDOM);
		assertEquals("java.util.ResourceBundle",JSE_1_7_Util.RESOURCE_BUNDLE);
		assertEquals("java.util.ResourceBundle$Control",JSE_1_7_Util.RESOURCE_BUNDLE_CONTROL);
		assertEquals("java.util.Scanner",JSE_1_7_Util.SCANNER);
		assertEquals("java.util.ServiceLoader",JSE_1_7_Util.SERVICE_LOADER);
		assertEquals("java.util.SimpleTimeZone",JSE_1_7_Util.SIMPLE_TIME_ZONE);
		assertEquals("java.util.Stack",JSE_1_7_Util.STACK);
		assertEquals("java.util.StringTokenizer",JSE_1_7_Util.STRING_TOKENIZER);
		assertEquals("java.util.Timer",JSE_1_7_Util.TIMER);
		assertEquals("java.util.TimerTask",JSE_1_7_Util.TIMER_TASK);
		assertEquals("java.util.TimeZone",JSE_1_7_Util.TIME_ZONE);
		assertEquals("java.util.TreeMap",JSE_1_7_Util.TREE_MAP);
		assertEquals("java.util.TreeSet",JSE_1_7_Util.TREE_SET);
		assertEquals("java.util.UUID",JSE_1_7_Util.UUID);
		assertEquals("java.util.Vector",JSE_1_7_Util.VECTOR);
		assertEquals("java.util.WeakHashMap",JSE_1_7_Util.WEAK_HASH_MAP);
		assertEquals("java.util.Formatter$BigDecimalLayoutForm",JSE_1_7_Util.FORMATTER_BIG_DECIMAL_LAYOUT_FORM);
		assertEquals("java.util.Locale$Category",JSE_1_7_Util.LOCALE_CATEGORY);
		assertEquals("java.util.ConcurrentModificationException",JSE_1_7_Util.CONCURRENT_MODIFICATION_EXCEPTION);
		assertEquals("java.util.DuplicateFormatFlagsException",JSE_1_7_Util.DUPLICATE_FORMAT_FLAGS_EXCEPTION);
		assertEquals("java.util.EmptyStackException",JSE_1_7_Util.EMPTY_STACK_EXCEPTION);
		assertEquals("java.util.FormatFlagsConversionMismatchException",JSE_1_7_Util.FORMAT_FLAGS_CONVERSION_MISMATCH_EXCEPTION);
		assertEquals("java.util.FormatterClosedException",JSE_1_7_Util.FORMATTER_CLOSED_EXCEPTION);
		assertEquals("java.util.IllegalFormatCodePointException",JSE_1_7_Util.ILLEGAL_FORMAT_CODE_POINT_EXCEPTION);
		assertEquals("java.util.IllegalFormatConversionException",JSE_1_7_Util.ILLEGAL_FORMAT_CONVERSION_EXCEPTION);
		assertEquals("java.util.IllegalFormatException",JSE_1_7_Util.ILLEGAL_FORMAT_EXCEPTION);
		assertEquals("java.util.IllegalFormatFlagsException",JSE_1_7_Util.ILLEGAL_FORMAT_FLAGS_EXCEPTION);
		assertEquals("java.util.IllegalFormatPrecisionException",JSE_1_7_Util.ILLEGAL_FORMAT_PRECISION_EXCEPTION);
		assertEquals("java.util.IllegalFormatWidthException",JSE_1_7_Util.ILLEGAL_FORMAT_WIDTH_EXCEPTION);
		assertEquals("java.util.IllformedLocaleException",JSE_1_7_Util.ILLFORMED_LOCALE_EXCEPTION);
		assertEquals("java.util.InputMismatchException",JSE_1_7_Util.INPUT_MISMATCH_EXCEPTION);
		assertEquals("java.util.InvalidPropertiesFormatException",JSE_1_7_Util.INVALID_PROPERTIES_FORMAT_EXCEPTION);
		assertEquals("java.util.MissingFormatArgumentException",JSE_1_7_Util.MISSING_FORMAT_ARGUMENT_EXCEPTION);
		assertEquals("java.util.MissingFormatWidthException",JSE_1_7_Util.MISSING_FORMAT_WIDTH_EXCEPTION);
		assertEquals("java.util.MissingResourceException",JSE_1_7_Util.MISSING_RESOURCE_EXCEPTION);
		assertEquals("java.util.NoSuchElementException",JSE_1_7_Util.NO_SUCH_ELEMENT_EXCEPTION);
		assertEquals("java.util.TooManyListenersException",JSE_1_7_Util.TOO_MANY_LISTENERS_EXCEPTION);
		assertEquals("java.util.UnknownFormatConversionException",JSE_1_7_Util.UNKNOWN_FORMAT_CONVERSION_EXCEPTION);
		assertEquals("java.util.UnknownFormatFlagsException",JSE_1_7_Util.UNKNOWN_FORMAT_FLAGS_EXCEPTION);
		assertEquals("java.util.ServiceConfigurationError",JSE_1_7_Util.SERVICE_CONFIGURATION_ERROR);
	}
	@Override
	public int getTests() {
		return 1;
	}

	@Override
	public int getAsserts() {
		return 99;
	}

	@Override
	public int getUniqueAsserts() {
		return 99;
	}

}